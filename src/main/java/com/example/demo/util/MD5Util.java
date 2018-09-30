package com.example.demo.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
    public static final String SALT = "1a2b3c4d";
    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    public static String inputpassToFormpass(String inputpass){
        String str = "" + SALT.charAt(0) + SALT.charAt(2) + inputpass + SALT.charAt(5) + SALT.charAt(4);
        return md5(str);
    }

    public static String formpassToDBpass(String formpass,String dbSalt){
        String str = "" + dbSalt.charAt(0) + dbSalt.charAt(2) + formpass + dbSalt.charAt(5) + dbSalt.charAt(4);
        return md5(str);
    }

    public static String inputpassToDBpass(String inputpass,String dbSalt){
        String formpass = inputpassToFormpass(inputpass);
        return formpassToDBpass(formpass,dbSalt);
    }

    public static void main(String[] args) {
        //8f36fb823df52789af4f6b14c85f1f75
        System.out.println(inputpassToDBpass("admin", "1a2b3c4d"));
        //dd3691fd927f34ce2de9a6e5246cfc6f
        System.out.println(inputpassToFormpass("admin"));
    }
}
