package com.example.demo.service;

import com.alibaba.fastjson.JSON;
import com.example.demo.redis.KeyPrefix;
import com.example.demo.redis.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {
    @Autowired
    private RedisConfig redisConfig;

    @Autowired
    private JedisPool jedisPool;

    public <T> T get(String key, Class<T> clazz){
        Jedis jedis = null;
        try {
           jedis  = jedisPool.getResource();
            String str = jedis.get(key);
            return strToBean(str,clazz);
        }finally {
            returnToPool(jedis);
        }
    }

    public <T> T get(KeyPrefix keyPrefix,String key,Class<T> clazz){
        String realKey = keyPrefix.getPrefix() + key;
        return get(realKey,clazz);
    }

    public <T> Boolean set(String key, T object){
        Jedis jedis = null;
        try {
            jedis  = jedisPool.getResource();
            String str = beanToStr(object);
            jedis.set(key,str);
            return str != null;
        }finally {
            returnToPool(jedis);
        }
    }
    public <T> Boolean set(String key,int second, T object){
        Jedis jedis = null;
        try {
            jedis  = jedisPool.getResource();
            String str = beanToStr(object);
            if (second <= 0){
                jedis.set(key,str);
            }else {
                jedis.setex(key,second,str);
            }
            return str != null;
        }finally {
            returnToPool(jedis);
        }
    }

    public <T> Boolean set(KeyPrefix keyPrefix,String key, T value){
        String realKey = keyPrefix.getPrefix() + key;
        int second = keyPrefix.expireSecond();
        return set(realKey,second,value);
    }

    /**
     * 判断 redisKey 是否存在
     */
    public Boolean exist(String key){
        Jedis jedis = null;
        try {
            jedis  = jedisPool.getResource();
            return jedis.exists(key);
        }finally {
            returnToPool(jedis);
        }
    }

    public Boolean exist(KeyPrefix keyPrefix,String key){
        String realKey = keyPrefix.getPrefix() + key;
        return exist(realKey);
    }

    /**
     * 增加
     */
    public Long incr(String key){
        Jedis jedis = null;
        try {
            jedis  = jedisPool.getResource();
            return jedis.incr(key);
        }finally {
            returnToPool(jedis);
        }
    }

    public Long incr(KeyPrefix keyPrefix,String key){
        Jedis jedis = null;
        try {
            jedis  = jedisPool.getResource();
            String realKey = keyPrefix.getPrefix() + key;
            return jedis.incr(realKey);
        }finally {
            returnToPool(jedis);
        }
    }

    /**
     *  减少
     */
    public Long decr(String key){
        Jedis jedis = null;
        try {
            jedis  = jedisPool.getResource();
            return jedis.decr(key);
        }finally {
            returnToPool(jedis);
        }
    }

    public Long decr(KeyPrefix keyPrefix,String key){
        Jedis jedis = null;
        try {
            jedis  = jedisPool.getResource();
            String realKey = keyPrefix.getPrefix() + key;
            return jedis.decr(realKey);
        }finally {
            returnToPool(jedis);
        }
    }



    private <T> String beanToStr(T clazz) {
        if (clazz == null) {
            return null;
        }
        Class<?> aClass = clazz.getClass();
        if (aClass == int.class || aClass == Integer.class){
            return "" + clazz;
        }else if (aClass == long.class || aClass == Long.class){
            return "" + clazz;
        }else if (aClass == String.class){
            return (String) clazz;
        }else {
            return JSON.toJSONString(clazz);
        }

    }

    private <T> T strToBean(String str, Class<T> clazz) {
        if (str == null || str.length() == 0 || clazz == null){
            return null;
        }else if (clazz == int.class || clazz == Integer.class){
            return (T) Integer.valueOf(str);
        }else if (clazz == long.class || clazz == Long.class){
            return (T) Long.valueOf(str);
        }else if (clazz == String.class){
            return (T) str;
        }else {
            return JSON.toJavaObject((JSON) JSON.parseObject(str,clazz),clazz);
        }
    }

    private void returnToPool(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }



}
