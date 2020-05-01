-- 存在问题
-- 无法处理请求报文内容超过1460字节的情况
-- 请求报文体类型为非x-www-form-urlencoded类型时，请求体没有处理，原样返回

local _M = {_VERSION = "0.1"}

function createRequest(sck, data)
	return {
		method = "GET",
		path = "/",
		query = {},
		headers = {},
		body = {},
		_data = data,
		_sck = sck
	}
end

function createResponse(sck)
	local rsp = {
		status = 200,
		type = nil,
		_sck = sck
	}

	rsp.redirect = function(self, url, status)
		self.status = status or 302
		self._redirectUrl = url
		self:send()
	end

	rsp.clean = function(self)
		self._sck:on(
			"sent",
			function()
			end
		)
		self._sck:on(
			"receive",
			function()
			end
		)
		self._sck:close()
	end

	return rsp
end

function initHandle(request, response)
	local _METHOD, _PATH
	local _HEADER = {}
	local _QUERY = {}
	local _BODY = {}
	while #request._data > 0 do
		local start = request._data:find("\r\n", 1, true)
		if not start then
			break
		end
		local line = request._data:sub(1, start - 1)
		request._data = request._data:sub(start + 2)
		if #line > 0 then
			if _METHOD == nil then
				-- 请求行解析
				local _, _, method, path, vars = line:find("([A-Z]+) (.-)?(.-) HTTP")
				if method == nil then
					_, _, method, path = line:find("([A-Z]+) (.-) HTTP")
				end
				if vars ~= nil then
					vars = urlDecode(vars)
					for k, v in string.gmatch(vars, "([^&]+)=([^&]*)&*") do
						_QUERY[k] = v
					end
				end
				_METHOD = method or "GET"
				_PATH = path or "/"
			else
				-- 请求头解析
				local _, _, k, v = line:find("^([%w-]+):%s*(.+)")
				if k then
					_HEADER[k:lower()] = v
				end
			end
		else
			-- 遇到空行时可能进入到请求体
			break
		end
	end

	request.method = _METHOD
	request.path = _PATH
	request.query = _QUERY
	request.headers = _HEADER

	-- 请求体解析
	if request._data ~= nil and _HEADER["content-type"] ~= nil then
		if string.find(_HEADER["content-type"], "x-www-form-urlencoded", 1, true) then
			body = urlDecode(request._data)
			for k, v in string.gmatch(body, "([^&]+)=([^&]*)&*") do
				_BODY[k] = v
			end
		else
			_BODY = request._data
		end
	end

	request.body = _BODY
	request.data = nil
	return true
end

function logHandle(request, response)
	for k, v in pairs(request) do
		if k == "query" then
			for iv, ik in pairs(v) do
				print("request.query." .. iv, ik)
			end
		elseif k == "headers" then
			for iv, ik in pairs(v) do
				print("request.headers." .. iv, ik)
			end
		else
			print("request." .. k, v)
		end
	end
	print("--------------------------")
end

function sendHandle(request, response)
	response.send = function(self, data)
		local buf = "HTTP/1.1 " .. self.status .. "\r\n"
		buf = buf .. "Content-Type: " .. (self.type or "text/plain") .. "\r\n"
		buf = buf .. "Content-Length:" .. string.len(data) .. "\r\n"
		if self._redirectUrl ~= nil then
			buf = buf .. "Location: " .. self._redirectUrl .. "\r\n"
		end
		buf = buf .. "\r\n" .. data
		local function send()
			if buf == nil or buf == "" then
				self:clean()
			else
				self._sck:send(string.sub(buf, 1, 512))
				buf = string.sub(buf, 513)
			end
		end
		self._sck:on("sent", send)
		send()
	end
end

function sendFileHandle(request, response)
	response.sendFile = function(self, filename)
		if not file.exists(filename) then
			self.status = 404
			self:send(404)
			return
		end

		local header = "HTTP/1.1 " .. self.status .. "\r\n"
		local type = self.type or guessType(filename)
		header = header .. "Content-Type: " .. type .. "\r\n"
		header = header .. "\r\n"

		local pos = 0
		local function send()
			file.open(filename, "r")
			if file.seek("set", pos) == nil then
				self:clean()
			else
				local buf = file.read(512)
				pos = pos + 512
				self._sck:send(buf)
			end
			file.close()
		end
		self._sck:on("sent", send)
		self._sck:send(header)
	end
end

function indexHandle(request, response)
	local filename
	if request.path == "/" then
		filename = "index.html"
		response:sendFile(filename)
	end
end

function urlEncode(input)
	input =
		string.gsub(
		input,
		"([^%w%.%- ])",
		function(c)
			return string.format("%%%02X", string.byte(c))
		end
	)
	return string.gsub(input, " ", "+")
end

function urlDecode(input)
	input =
		string.gsub(
		input,
		"%%(%x%x)",
		function(h)
			return string.char(tonumber(h, 16))
		end
	)
	return input
end

function guessType(filename)
	local types = {
		[".css"] = "text/css",
		[".js"] = "application/javascript",
		[".html"] = "text/html",
		[".png"] = "image/png",
		[".jpg"] = "image/jpeg"
	}
	for ext, type in pairs(types) do
		if string.sub(filename, -string.len(ext)) == ext then
			return type
		end
	end
	return "text/plain"
end

function _M.close(self)
	self._server:close()
	self._handlers = nil
end

function _M.listen(self, port)
	return self._server:listen(
		port,
		function(connect)
			connect:on(
				"receive",
				function(sck, msg)
					local request = createRequest(sck, msg)
					local response = createResponse(sck)
					for i = 1, #self._handlers do
						if string.find(request.path, "^" .. self._handlers[i].p .. "$") then
							self._handlers[i].c(request, response)
						end
					end
					collectgarbage()
				end
			)
		end
	)
end

function _M.use(self, pattern, callback)
	table.insert(
		self._handlers,
		#self._handlers,
		{
			p = pattern,
			c = callback
		}
	)
end

local mt = {__index = _M}

function _M.create(self)
	local object = {}
	object._handlers = {
		{p = ".*", c = initHandle},
		{p = ".*", c = logHandle},
		{p = ".*", c = sendHandle},
		{p = ".*", c = sendFileHandle},
		{p = ".*", c = indexHandle}
	}
	object._server = net.createServer(net.TCP, 15)
	return setmetatable(object, mt)
end

return _M
