function led(on)
	pin = 0
	gpio.mode(pin, gpio.OUTPUT)
	if on then
		gpio.write(pin, gpio.LOW)
	else
		gpio.write(pin, gpio.HIGH)
	end
end

function led_flash()
	pin = 0
	gpio.mode(pin, gpio.OUTPUT)
	timer =
		tmr.create():alarm(
		2000,
		tmr.ALARM_AUTO,
		function()
			gpio.write(pin, 1 - gpio.read(pin))
		end
	)
	if not timer then
		print("start timer failed.")
	end
end

led(false)
-- led_flash()
