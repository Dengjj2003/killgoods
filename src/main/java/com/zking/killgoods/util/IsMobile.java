package com.zking.killgoods.util;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = {MobileValidatorUtil.class}
)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsMobile {
    String message() default "手机号码格式错误";
    boolean required() default  true;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
