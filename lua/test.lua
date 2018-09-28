local HttpUtil = require('HttpUtil')
local Config = require('Config')



HttpUtil.response(HttpUtil.createSuccessResult(Config.set('key', 'value')))