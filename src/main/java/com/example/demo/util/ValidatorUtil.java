package com.example.demo.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtil {
    /**
     * 手机号正则
     */
    private static final String MOBILE_REG = "^(0|86|17951)?(13[0-9]|15[012356789]|166|17[3678]|18[0-9]|14[57])[0-9]{8}$";

    public static boolean isMobileNum(String mobileNum){
        if (StringUtils.isBlank(mobileNum)) {
            return false;
        }
        Pattern mobilePattern = Pattern.compile(MOBILE_REG);
        Matcher matcher = mobilePattern.matcher(mobileNum);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isMobileNum("12333333333"));
    }
}
