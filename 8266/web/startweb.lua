local HttpServer = require("httpserver")
local server = HttpServer:create()

for k, v in pairs(server) do
    print(k, v)
end
server:listen(80)
