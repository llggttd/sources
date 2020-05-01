local MAIN = "app.lua"

function boot_check()
	_, reason = node.bootreason()
	if reason == 0 then
		print("Boot[power on]")
	elseif reason == 1 then
		print("Boot[watchdog reset hardware]")
	elseif reason == 2 then
		print("Boot[exception reset]")
	elseif reason == 3 then
		print("Boot[watchdog reset software]")
	elseif reason == 4 then
		print("Boot[software restart]")
	elseif reason == 5 then
		print("Boot[wake up]")
	elseif reason == 6 then
		print("Boot[external reset]")
	end
end

function run()
	if file.exists(MAIN) == true then
		dofile(MAIN)
	else
		print("nothing to do")
	end
end

boot_check()
run()
