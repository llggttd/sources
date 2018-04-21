package top.crazyman.common.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     * 获取当前日期
     *
     * @return Date
     */
    public static Date now() {
        return new Date();
    }


    public static Date getFutureDateByDays(Date now, Integer days) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(now);
        instance.add(Calendar.DAY_OF_MONTH, days);
        return instance.getTime();
    }

    public static Date getFutureDateByHours(Date now, Integer hours) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(now);
        instance.add(Calendar.HOUR_OF_DAY, hours);
        return instance.getTime();
    }
}
