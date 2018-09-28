local _M = { _VERSION = '0.1' }

local mt = { __index = _M }

_M.SUCCESS = 0

_M.FAILURE = 1

_M.MSG_SUCCESS = 'success'

_M.MSG_FAILURE = 'failure'

local payload = {
    code = _M.SUCCESS,
    data = {},
    message = _M.MSG_SUCCESS
}

function _M.getCode()
    return payload['code']
end

function _M.setCode(code)
    payload['code'] = code
end

function _M.getData()
    return payload['data']
end

function _M.setData(data)
    payload['data'] = data
end

function _M.getMessage()
    return payload['message']
end

function _M.setMessage(message)
    payload['message'] = message
end

function _M.getResult()
    return payload
end

function _M.create(self)
    local object = {}
    setmetatable(object, mt)
    return object
end

return _M