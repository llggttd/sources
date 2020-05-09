local PIN = 4
gpio.mode(PIN, gpio.OUTPUT, gpio.PULLUP)


i = 0

function ligth(i)
	if i > 100000 then
		i = 0
	end
	local finish = i / 100
	local start = 1000 - finish
	gpio.serout(PIN, gpio.HIGH, {start, finish}, 10, function()
		i = i + 1
		ligth(i)
		-- print(i)
	end)
end

ligth(i)