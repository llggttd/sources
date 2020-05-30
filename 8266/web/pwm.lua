local PIN = 4
count = 2500
up = false

function getDuty(input)
    if input < 1000 then
        return 0
    elseif input > 2023 then
        return 1023
    else
        return input - 1000
    end
end


pwm.setup(PIN, 500, getDuty(count))
pwm.start(PIN)

if not tmr.create():alarm(2, tmr.ALARM_AUTO, function()
    if up then
        count = count + 1
    else
        count = count - 1
    end
    if count >= 3000 then
        up = false
    elseif count <=0 then
        up = true
    end
    pwm.setduty(PIN, getDuty(count))
  end)
then
    print("whoopsie")
end