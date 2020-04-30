
-- 存在问题
-- 无法处理请求报文内容超过1460字节的情况
-- 请求报文体类型为非x-www-form-urlencoded类型时，请求体没有处理，原样返回

local _M = {}

function _M.create()
	local object = {}
	object._handlers = {
		{ p: '.*', c: initHandle },
		{ p: '.*', c: cleanHandle },
		{ p: '.*', c: redirectHandle },
		{ p: '.*', c: statusHandle },
		{ p: '.*', c: typeHandle },
		{ p: '.*', c: sendHandle },
		{ p: '.*', c: sendFileHandle }
	}
  object._server = net.createServer(net.TCP, 15)
  setmetatable(object, mt)
  return object
end

function _M:close()
	self._server:close()
	self._handlers = nil
end

function _M:listen(port)
  return self._server:listen(port, function(connect)
		connect:on('receive', function(sck, msg)	
			local request = { data = msg, path = '', _sck = sck }
			local response = { _sck = sck }
			for i = 1, #self._handlers do
				if string.find(request.path, '^' .. self._handlers[i].p .. '$') then
					self._handlers[i].c(request, response)
				end
			end
			request:clean()
			collectgarbage()
		end)
	end)
end

function _M:use(pattern, callback)
	table.insert(self._handlers, #self._handlers, {
		p = pattern,
		c = callback
	})
end

function initHandle(request, response)
  local _HEADER = {}
  local _QUERY = {}
  local _BODY = {}
  while #request.data > 0 do
    local start = request.data:find("\r\n", 1, true)
    if not start then break end
    local line = request.data:sub(1, start - 1)
    request.data = request.data:sub(start + 2)
    if #line > 0 then
      -- 请求行解析
      if request.method == nil then
        local _, _, method, path, vars = line:find('([A-Z]+) (.-)?(.-) HTTP')
        if method == nil then
          _, _, method, path = line:find('([A-Z]+) (.-) HTTP')
        end
        if vars ~= nil then
          vars = urlDecode(vars)
          for k, v in string.gmatch(vars, '([^&]+)=([^&]*)&*') do
            _QUERY[k] = v
          end
        end
      end
      -- 请求头解析
      local _, _, k, v = line:find("^([%w-]+):%s*(.+)")
      if k then
        k = k:lower()
        _HEADER[k] = v
      end
    else
      -- 遇到空行时可能进入到请求体
      break
    end
  end

  request.method = method or "GET"
  request.path= path or "/"
  request.query = _QUERY
  request.headers = _HEADER

  -- 请求体解析
  if request.data ~= nil then
    if string.find(_HEADER['content-type'], "x-www-form-urlencoded", 1, true) then
      body = urlDecode(request.data)
      for k, v in string.gmatch(body, '([^&]+)=([^&]*)&*') do
        _BODY[k] = v
      end
    else
      _BODY = request.data
    end
  end

  request.body = _BODY
  request.data = nil
	return true
end

function cleanHandle(request, response)
	request.clean = function ()
		for k, v in pairs(self) do
			self[k] = nil
		end
	end
	response.clean = function ()
		self._skt:on('sent', function() end)
		self._skt:on('receive', function() end)
		self._skt:close()
		for k, v in pairs(self) do
			self[k] = nil
		end
	end
end

function redirectHandle(request, response)
	response.redirect = function (url, status)
		status = status or 302
		self:status(status)
		self._redirectUrl = url
		self:send()
	end
end

function typeHandle(request, response)
	response.type = function (type)
		if type == nil then
			return self._type
		else
			self._type = type
		end
	end
end

function statusHandle(request, response)
	response.status = function (status)
		if status == nil then
			return self._status or 200
		else
			self._status = status
		end
	end
end

function sendHandle(request, response)
	response.send = function (data)
		local buf = 'HTTP/1.1 ' .. self:status() .. '\r\n'
			.. 'Content-Type: ' .. self.type() .. '\r\n'
			.. 'Content-Length:' .. string.len(data) .. '\r\n'
		if self._redirectUrl ~= nil then
			buf = buf .. 'Location: ' .. self._redirectUrl .. '\r\n'
		end
		buf = buf .. '\r\n' .. data
	
		local function send()
			if buf == '' then 
				self:clean()
			else
				self._sck:send(string.sub(buf, 1, 512))
				buf = string.sub(buf, 513)
			end
		end
		self._sck:on('sent', send)
		send()
	end
end

function sendFileHandle(request, response)
	response.sendFile = function (filename)
		if not file.exists(filename) then
			self:status(404)
			self:send(404)
			return
		end
	
		local header = 'HTTP/1.1 ' .. self:status() .. '\r\n'
		local type = self:type() or guessType(filename)
		header = header .. 'Content-Type: ' .. type .. '\r\n'
		header = header .. '\r\n'
	
		local pos = 0
		local function send()
			file.open(filename, 'r')
			if file.seek('set', pos) == nil then
				self:clean()
			else
				local buf = file.read(512)
				pos = pos + 512
				self._sck:send(buf)
			end
			file.close()
		end
		self._sck:on('sent', send)
		self._sck:send(header)
	end
end

function indexHandle(request, response)
	local filename
	if request.path == '/' then
		filename = 'index.html'
		response:sendFile(filename)
end

local function urlEncode(input)  
	input = string.gsub(input, "([^%w%.%- ])", function(c)
		return string.format("%%%02X", string.byte(c))
	end)  
 return string.gsub(input, " ", "+")  
end  

local function urlDecode(input)  
	input = string.gsub(input, '%%(%x%x)',function(h)
		return string.char(tonumber(h, 16))
	end)
	return input 
end

function guessType(filename)
	local types = {
		['.css'] = 'text/css', 
		['.js'] = 'application/javascript', 
		['.html'] = 'text/html',
		['.png'] = 'image/png',
		['.jpg'] = 'image/jpeg'
	}
	for ext, type in pairs(types) do
		if string.sub(filename, -string.len(ext)) == ext then
			return type
		end
	end
	return 'text/plain'
end

return _M
