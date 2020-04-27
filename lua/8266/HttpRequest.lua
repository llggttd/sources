local _M = {}
local mt = { __index = _M }

function _M:header(name, value)
  if name == nil and value == nil then
    return self.headers
  elseif value == nil then
    return self.headers[name]
  else
    self.headers[name] = value
  end
end

function _M:getMethod()
  return self.method
end

function _M:getUrl()
  return self.url
end

function _M.create(connect, method, url)
    local object = {}
    object.connect = connect
    object.method = method
    object.url = url
    object.headers = {}
    setmetatable(object, mt)
    return object
end

return _M