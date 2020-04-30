local request = {
  data = "POST /service/echo HTTP/1.1\r\nContent-Type: application/x-www-form-urlencoded\r\nUser-Agent: PostmanRuntime/7.24.1\r\nAccept: */*\r\nCache-Control: no-cache\r\nHost: localhost:9000\r\nAccept-Encoding: gzip, deflate, br\r\nConnection: keep-alive\r\nContent-Length: 7\r\n\r\na=1&b=2\r\n"
}

local response = {}

local function urlEncode(input)  
	input = string.gsub(input, "([^%w%.%- ])", function(c)
		return string.format("%%%02X", string.byte(c))
	end)  
 return string.gsub(input, " ", "+")  
end  

local function urlDecode(input)  
	input = string.gsub(input, '%%(%x%x)',function(h)
		return string.char(tonumber(h, 16))
	end)
	return input 
end

function initHandle(request, response)
  local _HEADER = {}
  local _QUERY = {}
  local _BODY = {}
  while #request.data > 0 do
    local start = request.data:find("\r\n", 1, true)
    if not start then break end
    local line = request.data:sub(1, start - 1)
    request.data = request.data:sub(start + 2)
    if #line > 0 then
      -- 请求行解析
      if request.method == nil then
        local _, _, method, path, vars = line:find('([A-Z]+) (.-)?(.-) HTTP')
        if method == nil then
          _, _, method, path = line:find('([A-Z]+) (.-) HTTP')
        end
        if vars ~= nil then
          vars = urlDecode(vars)
          for k, v in string.gmatch(vars, '([^&]+)=([^&]*)&*') do
            _QUERY[k] = v
          end
        end
      end
      -- 请求头解析
      local _, _, k, v = line:find("^([%w-]+):%s*(.+)")
      if k then
        k = k:lower()
        _HEADER[k] = v
      end
    else
      -- 遇到空行时可能进入到请求体
      break
    end
  end

  request.method = method or "GET"
  request.path= path or "/"
  request.query = _QUERY
  request.headers = _HEADER

  -- 请求体解析
  if request.data ~= nil then
    if string.find(_HEADER['content-type'], "x-www-form-urlencoded", 1, true) then
      body = urlDecode(request.data)
      for k, v in string.gmatch(body, '([^&]+)=([^&]*)&*') do
        _BODY[k] = v
      end
    else
      _BODY = request.data
    end
  end

  request.body = _BODY
  request.data = nil
	return true
end

initHandle(request, response)

for k, v in pairs(request) do
  if k == "query" then
    for ik, iv in pairs(v) do
      print("request.query." .. ik, iv)
    end
  elseif k == "headers" then
    for ik, iv in pairs(v) do
      print("request.header." .. ik, iv)
    end
  elseif k == "body" then
    for ik, iv in pairs(v) do
      print("request.body." .. ik, iv)
    end
  else
    print('request.' .. k, v)
  end
end