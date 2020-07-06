package com.haizhang.hai.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author admin_z by 2020/5/15
 * @ClassName Test
 */
public class UniqueCodeUtils {

    /**
     * YYYYMMDDHHMMSS
     * 要求 时间戳 精确到毫秒 加随机数字字母 加类型 加id
     *
     * @return
     */
    private static synchronized String getLocalTrmSeqNum(Date date) {
        String formatData = null;
        if (date == null) {
            formatData = new SimpleDateFormat("yyyyMMddHHmmss")
                    .format(new Date());
        } else {
            formatData = new SimpleDateFormat("yyyyMMddHHmmss")
                    .format(date);
        }
        return formatData;
    }

    private static synchronized String getLocalTime(Date date) {
        String formatData = null;
        if (date == null) {
            formatData = new SimpleDateFormat("HHmmss")
                    .format(new Date());
        } else {
            formatData = new SimpleDateFormat("HHmmss")
                    .format(date);
        }
        return formatData;
    }

    //生成随机数字和字母,
    public static String getStringRandom(int length) {

        StringBuilder val = new StringBuilder();
        Random random = new Random();
        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {
            //1 char 0 int
            int charOrNum = random.nextInt(2) % 2 == 0 ? 1 : 0;
            //输出字母还是数字
            if (charOrNum == 1) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val.append((char) (random.nextInt(26) + temp));
            } else {
                val.append(random.nextInt(10));
            }
        }
        return val.toString();
    }

    public static String generateUniqueCode(int length) {
        return getLocalTrmSeqNum(null) + getStringRandom(length);
    }

    public static String generateCompanyCode(int length, Date date) {
        return getLocalTrmSeqNum(date) + getStringRandom(length);
    }

    //生成随机数字,
    private static String getIntegerNum(int length) {

        StringBuilder val = new StringBuilder();
        Random random = new Random();
        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {
            //1 char 0 int
            int charOrNum = 0;
            //输出字母
            val.append(random.nextInt(10));
        }
        return val.toString();
    }

    public static String generateIntegerNum(int length){
        return getLocalTime(new Date()) + getIntegerNum(length);
    }
//
//    public static void main(String[] args) {
//        System.out.println(generateIntegerNum(4));
//    }

}
