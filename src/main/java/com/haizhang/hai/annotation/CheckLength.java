package com.haizhang.hai.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author admin_z by 2020/7/3
 * @ClassName StringLengVaildator
 */
@Target(value = { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckLengthConstraintValidator.class)
public @interface CheckLength {

    String message() default "长度不合法";
    String typeMsg() default "长度不合法";

    /**
     * 最小长度
     * @return
     */
    int min() default 0;

    /**
     * 最大长度
     * @return
     */
    int max() default Integer.MAX_VALUE;

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
