package com.czxy.health.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by xiongqi.
 */
public class CreateMPNumber {
    /**
     * 生成档案号
     *
     * @return
     */
    public static String getMPNumber() {
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return format;
    }
}
