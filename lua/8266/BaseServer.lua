
local _M = {}

function _M.create()
	local object = {}
	object._R = {}
  object._server = net.createServer(net.TCP, 15)
  setmetatable(object, mt)
  return object
end

function _M:clean()
	self._skt:on('sent', function() end)
	self._skt:on('receive', function() end)
	self._skt:close()
	self._skt = nil
end

function _M:close()
	self._server:close()
	self._R = nil
end

function _M:listen(port)
  return self._server:listen(port, function(connect)
		connect:on('receive', function(skt, msg)	
			local request = { source = msg, path = '', ip = skt:getpeer() }
			local response = Res:new(skt)
			
			for i = 1, #self._Midwares do
				if string.find(request.path, '^' .. self._Midwares[i].p .. '$') then
					self._Midwares[i].c(request, response)
				end
			end

			collectgarbage()
			
		end)
	end)
end

function _M:use(pattern, callback)
	table.insert(self._Midwares, #self._Midwares, {
		p = pattern,
		c = callback
	})
end

function parseHeader(req, res)
	local _, _, method, path, vars = string.find(req.source, '([A-Z]+) (.+)?(.+) HTTP')
	if method == nil then
		_, _, method, path = string.find(req.source, '([A-Z]+) (.+) HTTP')
	end
	local _GET = {}
	if vars ~= nil then
		vars = urlDecode(vars)
		for k, v in string.gmatch(vars, '([^&]+)=([^&]*)&*') do
			_GET[k] = v
		end
	end
	
	req.method = method
	req.query = _GET
	req.path = path
	
	return true
end

function Res:sendFile(filename)
	if file.exists(filename .. '.gz') then
		filename = filename .. '.gz'
	elseif not file.exists(filename) then
		self:status(404)
		if filename == '404.html' then
			self:send(404)
		else
			self:sendFile('404.html')
		end
		return
	end

	self._status = self._status or 200
	local header = 'HTTP/1.1 ' .. self._status .. '\r\n'
	
	self._type = self._type or guessType(filename)

	header = header .. 'Content-Type: ' .. self._type .. '\r\n'
	if string.sub(filename, -3) == '.gz' then
		header = header .. 'Content-Encoding: gzip\r\n'
	end
	header = header .. '\r\n'

	print('* Sending ', filename)
	local pos = 0
	local function doSend()
		file.open(filename, 'r')
		if file.seek('set', pos) == nil then
			self:close()
			print('* Finished ', filename)
		else
			local buf = file.read(512)
			pos = pos + 512
			self._skt:send(buf)
		end
		file.close()
	end
	self._skt:on('sent', doSend)
	
	self._skt:send(header)
end

function Res:send(body)
	self._status = self._status or 200
	self._type = self._type or 'text/html'

	local buf = 'HTTP/1.1 ' .. self._status .. '\r\n'
		.. 'Content-Type: ' .. self._type .. '\r\n'
		.. 'Content-Length:' .. string.len(body) .. '\r\n'
	if self._redirectUrl ~= nil then
		buf = buf .. 'Location: ' .. self._redirectUrl .. '\r\n'
	end
	buf = buf .. '\r\n' .. body

	local function doSend()
		if buf == '' then 
			self:close()
		else
			self._skt:send(string.sub(buf, 1, 512))
			buf = string.sub(buf, 513)
		end
	end
	self._skt:on('sent', doSend)

	doSend()
end

function staticFile(request, response)
	local filename
	if request.path == '/' then
		filename = 'index.html'
	else
		filename = string.gsub(string.sub(request.path, 2), '/', '_')
	end
	request:sendFile(filename)
end

return _M
