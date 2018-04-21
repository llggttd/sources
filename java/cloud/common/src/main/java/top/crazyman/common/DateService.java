package top.crazyman.common;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.crazyman.common.entities.DateEntity;
import top.crazyman.common.utils.DateUtil;

import java.util.Date;

@RestController
@RequestMapping("/date")
public class DateService {

    @RequestMapping("/current")
    public DateEntity getCurrentDate() {
        Date current = DateUtil.now();
        DateEntity result = new DateEntity();
        result.setDate(current);
        result.setTime(current);
        result.setDatetime(current);
        return result;
    }

    @RequestMapping("/future/days/{days}")
    public DateEntity getFutureDateByDays(@PathVariable("days") Integer days) {
        Date future = DateUtil.getFutureDateByDays(DateUtil.now(), days);
        DateEntity result = new DateEntity();
        result.setDate(future);
        result.setTime(future);
        result.setDatetime(future);
        return result;
    }

    @RequestMapping("/future/hours/{hours}")
    public DateEntity getFutureDateByHours(@PathVariable("hours") Integer hours) {
        Date future = DateUtil.getFutureDateByHours(DateUtil.now(), hours);
        DateEntity result = new DateEntity();
        result.setDate(future);
        result.setTime(future);
        result.setDatetime(future);
        return result;
    }
}
