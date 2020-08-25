package com.czxy.health.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xiongqi.
 */
public class Test1 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s1 = sdf.format(date);
        System.out.println(s1);
        Date s2 = sdf2.parse(s1);
        System.out.println(s2);
    }
}
