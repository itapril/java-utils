package com.itapril.test.json;

import com.itapril.utils.date.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import java.util.Date;

/**
 * Created by itapril on 2018/7/17 15:24.
 */
public class DateTest {

    @Test
    public void testDate(){
        DateTime dateTime = new DateTime(new Date()); //2017.06.21 18:00:00
//        System.out.println(dateTime.toString("yyyy-MM-dd"));

//        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd");
//        dateTime = DateTime.parse("2017-06-21", format);

        System.out.println(dateTime.toString());



        DateTime dateTime1 = dateTime.plusDays(1) // 增加天
                .plusYears(1)// 增加年
                .plusMonths(1)// 增加月
                .plusWeeks(1)// 增加星期
                .minusMillis(1)// 减分钟
                .minusHours(1)// 减小时
                .minusSeconds(1);// 减秒数

        System.out.println( "--> " + dateTime1);
        dateTime = new DateTime(new Date());
        System.out.println( "--> " + dateTime);

        DateUtils.getFutureMinutesTime(0,1);

    }

}
