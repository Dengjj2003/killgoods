package com.zking.killgoods.util;

import lombok.Data;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
@Data
public class MobileValidatorUtil implements ConstraintValidator<IsMobile,String> {

    private boolean required=false;

    @Override
    public void initialize(IsMobile isMobile) {
        this.required=isMobile.required();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(!required)
            return false;
        boolean mobile = ValidatorUtils.isMobile(s);
        return mobile;
    }
}
