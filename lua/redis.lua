local HttpUtil = require('HttpUtil')
local Redis = require("resty.redis")

local function recordCount()
    redis = Redis:new()
    redis:set_timeout(1500)
    local ok, err = redis:connect("127.0.0.1", 6379)
    if not ok then
        local result = HttpUtil.createFailureResult('redis connect fail')
        HttpUtil.response(result)
        return
    end
    local count = redis:get("count")
    if not count or count == ngx.null then
        count = 0
    end
    count = count + 1
    redis:set("count", count)
    redis:set_keepalive(300000, 20)
    return count
end

local result = HttpUtil.createSuccessResult({
    count = recordCount()
})

HttpUtil.response(result)