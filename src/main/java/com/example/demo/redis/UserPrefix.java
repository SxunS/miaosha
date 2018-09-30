package com.example.demo.redis;

import com.example.demo.constant.CookieConstant;

public class UserPrefix extends BasePrefix {
    public UserPrefix(String prefix) {
        super(prefix);
    }

    public UserPrefix(int expireSecond, String prefix) {
        super(expireSecond, prefix);
    }

    public static UserPrefix getById = new UserPrefix("id");
    public static UserPrefix getByName = new UserPrefix("name");
    public static UserPrefix token = new UserPrefix(CookieConstant.USER_TOKEN_EXPIRE_TIME,"token");
}
