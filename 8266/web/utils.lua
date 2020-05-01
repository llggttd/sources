function node_info()
    for k, v in pairs(node.info("hw")) do
        print(k, v)
    end

    for k, v in pairs(node.info("sw_version")) do
        print(k, v)
    end

    for k, v in pairs(node.info("build_config")) do
        print(k, v)
    end
end

function listap(t)
    print("\n\t\t\tSSID\t\t\t\t\tBSSID\t\t\t  RSSI\t\tAUTHMODE\t\tCHANNEL")
    for bssid, v in pairs(t) do
        local ssid, rssi, authmode, channel = string.match(v, "([^,]+),([^,]+),([^,]+),([^,]*)")
        print(
            string.format("%32s", ssid) .. "\t" .. bssid .. "\t  " .. rssi .. "\t\t" .. authmode .. "\t\t\t" .. channel
        )
    end
end

function wifi_list()
    wifi.setmode(wifi.STATION, true)
    scan_cfg = {}
    scan_cfg.channel = 0
    wifi.sta.getap(scan_cfg, 1, listap)
end

function wifi_connect()
    station_cfg = {}
    station_cfg.ssid = "OZONE"
    station_cfg.pwd = "9338447550"
    station_cfg.auto = true
    station_cfg.save = true
    wifi.sta.config(station_cfg)
end

function web_server()
    local HttpServer = require("httpserver")
    local server = HttpServer.create()
    server:listen(80)
end

function light_led(on)
    pin = 0
    gpio.mode(pin, gpio.OUTPUT)
    if on then
        gpio.write(pin, gpio.LOW)
    else
        gpio.write(pin, gpio.HIGH)
    end
end

-- function led_flash()
--     pin = 0
--     gpio.mode(pin, gpio.OUTPUT)
--     timer = tmr.create():alarm(2000, tmr.ALARM_AUTO,
--         function()
--             gpio.write(pin, 1 - gpio.read(pin))
--         end
--     )
--     if not timer then
--         print("start timer failed.")
--     end
-- end

function led_flash()
    pin = 0
    gpio.mode(pin, gpio.OUTPUT)
    count = 0
    timer = tmr.create():alarm(500, tmr.ALARM_AUTO,
        function()
            low = count * 1000
            high = 10000 - low
            gpio.serout(pin, gpio.HIGH, { high, low }, 50)
            count = count + 1
            print(count)
            if count > 9 then
                count = 0
            end
        end
    )
    if not timer then
        print("start timer failed.")
    end
end

-- led(true)
-- led_flash()
-- wifi_connect()
web_server()
-- light_led(false)
-- node_info()
-- wifi_list()
-- wifi_connect()
