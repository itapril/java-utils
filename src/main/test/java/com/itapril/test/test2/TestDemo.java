package com.itapril.test.test2;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.round;

public class TestDemo {

    @Test
    public void test1() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(9223372036854775807L + 1);
        System.out.println(2147483647 + 1);
        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(Integer.MIN_VALUE);
    }

    @Test
    public void test2() {
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(7, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                flatMap(childList -> childList.stream());
        System.out.println(outputStream.collect(Collectors.toList()));
    }

    /**
     * https://blog.csdn.net/oYeYuanXinZhiZhu1/article/details/79952592
     */
    @Test
    public void test3 () {
        List<Integer> oldList = Arrays.asList(7, 5, 6);
        // oldList.add(6);

        List<Integer> newList = Arrays.asList(1, 2, 4, 7, 5, 6);

        List<Integer> list1 = new ArrayList<>(oldList);
        List<Integer> list2 = new ArrayList<>(newList);
        // System.out.println(list1);

        /*List<Integer> oldList = new ArrayList();
        oldList.add(7);
        oldList.add(5);
        oldList.add(6);

        List<Integer> newList = new ArrayList();+4
        newList.add(1);
        newList.add(2);
        newList.add(7);
        newList.add(5);*/

        // newList.retainAll(oldList);
        // 交集
        list1.retainAll(list2);
        System.out.println(list1);
    }

    @Test
    public void test4() {
        BigDecimal bigDecimal = new BigDecimal(2445500000.00);

        JSONObject test = new JSONObject();
        test.put("feeValue", bigDecimal);
        System.out.println(test);

        BigDecimal feeValue = test.getBigDecimal("feeValue");

        System.out.println(feeValue);

        System.out.println(round(feeValue.doubleValue() * 10000) / 10000);

        long l = round(feeValue.doubleValue() * 10000) / 10000;





        System.out.println(bigDecimal + "");
        System.out.println(Float.valueOf(bigDecimal + ""));

        System.out.println(feeValue.setScale(2).floatValue());

        System.out.println(test.getBigInteger("feeValue"));



        // Double i = Math.round(feeValue.doubleValue() * 100) / 100;
        //
        // System.out.println(i);

   }

}
