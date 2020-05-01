local PIN = 0

function led_status()
	if gpio.read(PIN) > 0 then
		return 0
	else
		return 1
	end
end

function led_light(on)
	gpio.mode(PIN, gpio.OUTPUT)
	if on then
		gpio.write(PIN, gpio.LOW)
	else
		gpio.write(PIN, gpio.HIGH)
	end
end

function config_wifi()
	cfg = {}
	cfg.ssid = "OZONE"
	cfg.pwd = "9338447550"
	cfg.auto = true
	cfg.save = true
	wifi.sta.config(cfg)
end

function start_web()
	local HttpServer = require("httpserver")
	local server = HttpServer:create()
	server:use(
		"/led/status",
		function(req, rsp)
			rsp.type = "application/json"
			result = {
				status = led_status()
			}
			data = sjson.encode(result)
			rsp:send(data)
		end
	)

	server:use(
		"/led/switch",
		function(req, rsp)
			if req.query.status ~= nil then
				on = tonumber(req.query.status)
				if on and on == 1 then
					print("led on")
					led_light(true)
				else
					print("led off")
					led_light(false)
				end
			end

			rsp.type = "application/json"
			result = {
				status = led_status()
			}
			data = sjson.encode(result)
			rsp:send(data)
		end
	)
	server:listen(80)
end

led_light(true)

config_wifi()

timer = tmr.create()
start =
	timer:alarm(
	200,
	tmr.ALARM_AUTO,
	function()
		ip = wifi.sta.getip()
		if ip ~= nil then
			print("wifi connect, ip =" .. ip)
			print("led status " .. led_status())
			start_web()
			timer:unregister()
		end
	end
)

if not start then
	print("start task failed.")
end
