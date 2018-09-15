package com.example.demo.redis;

/**
 * @author Lee
 */
public interface KeyPrefix {
    public int expireSecond();
    public String getPrefix();
}
