package com.haizhang.hai.annotation;

import com.haizhang.hai.annotation.impl.IdentityCardNumberValidator;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author admin_z by 2020/6/30
 * @ClassName MethodPrint
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdentityCardNumberValidator.class)
public @interface MethodPrint {

}
