package com.haizhang.hai.utils;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
public class LeoUtil {
    private LeoUtil() {
    }

    //判断两个类属性值是否相同
    public static <T> boolean isSameWhitComparison(T obj1, T obj2,List<String> list) throws IllegalAccessException {
        boolean flag = true;
        if (!Objects.equals(obj1.getClass().getName(), obj2.getClass().getName())){
            return false;
        }
        Field[] fields = obj1.getClass().getDeclaredFields();
        Field[] supperfields = obj1.getClass().getSuperclass().getDeclaredFields();
        Field[] result = Arrays.copyOf(fields, fields.length + supperfields.length);
        System.arraycopy(supperfields, 0, result, fields.length, supperfields.length);
        for (Field field : result) {
            field.setAccessible(true);
            if (!list.contains(field.getName())){
                continue;
            }
            if (field.getType().toString().contains("List")) {
                flag = ListEqualsUtils.equalLists((List) field.get(obj1), (List) field.get(obj2));
            } else if (field.getType().toString().contains("Date")) {
                flag = compareWithDate(((Date) field.get(obj1)), (Date) field.get(obj2));
            } else if (!Objects.equals(field.get(obj1), field.get(obj2))) {
                flag = false;
            }
            if (!flag) {
                log.info("比较结果[{}]值不同", field.getName());
                return false;
            }
        }
        log.info("属性值相同,无需修改");
        return true;
    }

    private static boolean compareWithDate(Date oldDate, Date newDate) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date old = null;
        Date fresh = null;
        try {
            old = df.parse(df.format(oldDate));
            fresh = df.parse(df.format(newDate));
        } catch (ParseException e) {
            log.info("日期比较异常");
            e.printStackTrace();
        }
        if (old != null && fresh != null) {
            return old.compareTo(fresh) == 0;
        }
        return false;
    }
}
