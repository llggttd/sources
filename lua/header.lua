local HttpUtil = require('HttpUtil')

local result = HttpUtil.createSuccessResult(ngx.req.get_headers())
HttpUtil.response(result)
