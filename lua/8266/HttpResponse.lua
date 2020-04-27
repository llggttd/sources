local _M = {}
local mt = { __index = _M }

function sendHeader(self)
  for k, v in pairs(self.header()) do
    self.csend(k)
    self.csend(": ")
    self.csend(v)
    self.csend("\r\n")
  end
end

function cleanUp(self)
  self.connect:on("receive", nil)
  self.connect:on("disconnection", nil)
  self.connect:on("sent", nil)
  self.connect:close()
end

function _M:header(name, value)
  if name == nil and value == nil then
    return self.headers
  elseif value == nil then
    return self.headers[name]
  else
    self.headers[name] = value
  end
end

function _M:send(data, status)
  if not self.headerSent then
    self.csend("HTTP/1.1 ")
    self.csend(tostring(status or 200))
    self.csend(" OK\r\n")
    -- self:send_header("Transfer-Encoding", "chunked")
    sendHeader(self)
    self.headerSent = true
  end

  if data then
    csend(("%X\r\n"):format(#data))
    csend(data)
    csend("\r\n")
  end
end


function _M:finish(data, status)
  if data then
    self:send(data, status)
  end
  csend("0\r\n\r\n")
  cleanUp(self)
end

function _M.create(csend, cfinish)
  local object = {}
  object.csend = csend
  object.cfinish = cfinish
  object.headers = {}
  object.headerSent = false
  setmetatable(object, mt)
  return object
end

return _M