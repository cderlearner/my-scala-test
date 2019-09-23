package com.example.myscalatest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyPhoneValidate {

    public static void main(String[] args) {
        boolean res = isMobileNO("15110522372");
        System.out.println(res);
    }

    /*
     * 判断手机号码
     */
    public static boolean isMobileNO(String mobiles) {
//        Pattern p = Pattern.compile("^((13[0-9])|(17[0])|(17[7])|(14[57])|(15[012356789])|7(17[68])|(18[0-9]))\\d{8}$");
//        Pattern p = Pattern.compile("^((13[0-9])|(17[0])|(17[7])|(14[57])|(15[012356789])|7(17[68])|(18[0-9]))\\d{8}$");
//        虚拟号正则表达式：Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(14[57])|(17[0])|(17[7])|(18[0,0-9]))\\d{8}$");
        Pattern p = Pattern.compile("^((17[0])|(14[7])|(15[1]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 判断是否为邮箱
     *
     * @param email
     * @return
     */
    public static boolean isVaildEmail(String email) {
        String emailPattern = "[a-zA-Z0-9][a-zA-Z0-9._-]{2,16}[a-zA-Z0-9]@[a-zA-Z0-9]+.[a-zA-Z0-9]+";
        boolean result = Pattern.matches(emailPattern, email);
        return result;
    }

    /**
     * 用户名是否为电话号码
     *
     * @param name
     * @return
     */
    public static String getPhoneName(String name) {
        return isMobileNO(name) ? name.replace(name.substring(4, 8), "***") : name;
    }

}
