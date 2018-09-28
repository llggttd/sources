local cjson = require("cjson")
local store = ngx.shared.store

local response = {
    status = 0,
    result = {},
	msg = "success"
}

output = function(response)
    ngx.header.content_type = "application/json"
	ngx.say(cjson.encode(response))
end

recordCount = function(store)
    local count = store:get("count")
    if not count then
        count = 0
    end
    count = count + 1
    store:set("count", count)
    return count
end

response.result = recordCount(store)

output(response)
