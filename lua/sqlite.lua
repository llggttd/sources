local HttpUtil = require('HttpUtil')
local Config = require('Config')

local config = Config.create()

HttpUtil.response(HttpUtil.createSuccessResult(config:get('key', 'xx')))