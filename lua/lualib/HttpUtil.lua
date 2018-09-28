local cjson = require("cjson")
local Result = require('Result')

local _M = {}

function _M.response(response, contentType)
    ngx.header.content_type = contentType or "application/json"
	ngx.say(cjson.encode(response.getResult()))
end

function _M.createResult(code, data, message)
    local result = Result:create()
    result.setCode(code)
    result.setData(data)
    result.setMessage(message)
    return result
end

function _M.createSuccessResult(data, message)
    return _M.createResult(Result.SUCCESS, data, message or Result.MSG_SUCCESS)
end

function _M.createFailureResult(data, message)
    return _M.createResult(Result.FAILURE, data or {}, message or Result.MSG_FAILURE)
end

return _M