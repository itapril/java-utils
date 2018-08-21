package com.itapril.utils.date;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by itapril on 2018/7/17 15:30.
 */
public class DateUtils {

    /**
     * 获取某分钟之后的时间戳
     * @param hours 小时(0 < hours <= 24)
     * @param minutes 分钟(0 < minutes <= 60)
     * @return Long
     */
    public static long getFutureMinutesTime(int hours, int minutes){
        if(hours < 0 || hours > 24){
            throw new IllegalArgumentException("hours < 0 or hours > 24");
        }
        if(minutes < 0 || minutes > 60){
            throw new IllegalArgumentException("minutes < 0 or minutes > 24");
        }
        DateTime nowDate = new DateTime(new Date());
        System.out.println(nowDate);
        System.out.println(nowDate.getMillis());
        DateTime afterDate = nowDate.plusHours(hours)
                                    .plusMinutes(minutes);
        System.out.println(afterDate);
        System.out.println(afterDate.getMillis());

        return afterDate.getMillis();
    }

}
