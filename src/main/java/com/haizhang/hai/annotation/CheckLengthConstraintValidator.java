package com.haizhang.hai.annotation;

import lombok.extern.log4j.Log4j2;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author admin_z by 2020/7/3
 * @ClassName CheckLengthConstraintValidator
 */
@Log4j2
public class CheckLengthConstraintValidator implements ConstraintValidator<CheckLength, String> {

    private int max;
    private int min;
    private String message;

    @Override
    public void initialize(CheckLength constraintAnnotation) {
        max = constraintAnnotation.max();
        min = constraintAnnotation.min();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext context) {
        int length = getLength(object);
        if (length > min && length < max) {
            return true;
        }
        return false;
    }

    private int getLength(String s) {
        int valueLength = 0;
        String chinese = "[\u4e00-\u9fa5]";
        // 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1
        for (int i = 0; i < s.length(); i++) {
            // 获取一个字符
            String temp = s.substring(i, i + 1);
            // 判断是否为中文字符
            if (temp.matches(chinese)) {
                // 中文字符长度为1
                valueLength += 2;
            } else {
                // 其他字符长度为0.5
                valueLength += 1;
            }
        }
        //进位取整
        return valueLength;
    }
}
