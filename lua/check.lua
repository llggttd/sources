local HttpUtil = require('HttpUtil')
local Config = require('Config')
local COUNT = 'checkCount'

local record = function()
    local config = Config.create()
    local count = config:get(COUNT, 0)
    count = count + 1
    config:set(COUNT, count)
    return count
end

local result = HttpUtil.createSuccessResult({
    count = record()
})
HttpUtil.response(result)