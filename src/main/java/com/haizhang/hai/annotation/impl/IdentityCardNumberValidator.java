package com.haizhang.hai.annotation.impl;


import com.haizhang.hai.annotation.IdentityCardNumber;
import com.haizhang.hai.utils.IdCardValidatorUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**IdCardValidatorUtils
 * @author LiJing
 * @version 1.0
 * @Title: IdentityCardNumber
 * @Package com.cn.alasga.common.annotation
 * @Description: 自定义注解
 * @date 2019.2.12
 */
public class IdentityCardNumberValidator implements ConstraintValidator<IdentityCardNumber, Object> {

    @Override
    public void initialize(IdentityCardNumber identityCardNumber) {
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return IdCardValidatorUtils.isValidate18Idcard(o.toString());
    }
}
