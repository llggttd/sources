local body = [[
Host: www.baidu.com
Connection: keep-alive
DNT: 1
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.122 Safari/537.36 Edg/81.0.416.64
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
Sec-Fetch-Site: none
Sec-Fetch-Mode: navigate
Sec-Fetch-User: ?1
Sec-Fetch-Dest: document
Accept-Encoding: gzip, deflate, br
Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6,zh-TW;q=0.5
Cookie: BAIDUID=8A7CE7ECA701D9DAFA12E3D266297761:FG=1; BIDUPSID=8A7CE7ECA701D9DAFA12E3D266297761; PSTM=1547890740; BD_UPN=12314753; BD_HOME=1; H_PS_PSSID=30970_1463_21115_31253_31424_31341_31464_31228_30824_26350_31164_22157
]]

-- ^([A-Z]+) (.-) HTTP/1.1$
-- print(string.find(body, '([A-Z]+) (.-)?(.-) HTTP'))
-- print(string.find(body, '([A-Z]+) (.+) HTTP'))
-- print(string.find(body, '^([%w-]+):%s*(.+)'))



while #body > 0 do
  local e = body:find("\r\n", 1, true)
  if not e then break end
  local line = body:sub(1, e - 1)
  print(line:find("^([%w-]+):%s*(.+)"))
  body = body:sub(e + 2)
end