local BaseServer = require("BaseServer")

local server = BaseServer.create()

server:use('/led/status', function (req, rsp)
	rsp:type('application/json')
	rsp:send('{"status":0')
end)

server:use('/uart/status', function (req, rsp)

end)

server:listen(80)