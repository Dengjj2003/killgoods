package com.zking.killgoods.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则校验工具类
 * @author 刘开宇
 */
public class ValidatorUtils {

    private static final Pattern mobile_pattern=Pattern.compile("[1]([0-9])[0-9]{9}$");

    public static boolean isMobile(String mobile){
        if(StringUtils.isEmpty(mobile))
            return false;
        Matcher matcher = mobile_pattern.matcher(mobile);
        return matcher.matches();
    }
}
