local HttpRequest = require('HttpRequest')
local r1 = HttpRequest.create({}, 'POST', '/test')
r1:header('Content-Type', 'text/plan')
print(r1:header('Content-Type'))
r1:header('Length', 240)
for k, v in pairs(r1:header()) do
  print('header', k, v)
end
