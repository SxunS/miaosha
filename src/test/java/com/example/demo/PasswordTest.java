package com.example.demo;

import org.junit.Test;
import org.springframework.util.DigestUtils;

import java.security.MessageDigest;

public class PasswordTest {
    @Test
    public void test01(){
        String s = DigestUtils.md5DigestAsHex("test".getBytes());
        System.out.println(s);
    }
}
