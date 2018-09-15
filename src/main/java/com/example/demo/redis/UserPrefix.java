package com.example.demo.redis;

public class UserPrefix extends BasePrefix {
    public UserPrefix(String prefix) {
        super(prefix);
    }
    public static UserPrefix getById = new UserPrefix("id");
    public static UserPrefix getByName = new UserPrefix("name");
}
