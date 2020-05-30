function config_wifi()
	cfg = {}
	cfg.ssid = "OZONE"
	cfg.pwd = "9338447550"
	cfg.auto = true
    cfg.save = true
    cfg.connected_cb = function()
        print("wifi connected")
    end
    cfg.disconnected_cb = function()
        print("wifi disconnected")
    end
    cfg.got_ip_cb = function(ip, netmask, gateway)
        print(ip)
    end
    cfg.dhcp_timeout_cb = function()
        print("timeout")
    end
	wifi.sta.config(cfg)
end

config_wifi()