package com.example.demo.service;

import com.example.demo.constant.CookieConstant;
import com.example.demo.dao.UserMapper;
import com.example.demo.domain.User;
import com.example.demo.redis.UserPrefix;
import com.example.demo.util.MD5Util;
import com.example.demo.util.UUIDUtil;
import com.example.demo.vo.LoginVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
@Service
public class UserService {
    @Autowired
    private RedisService redisService;

    @Autowired
    private UserMapper userMapper;

    private User getUserById(Long id){
        //取缓存
        User user = redisService.get(UserPrefix.getById, id.toString(), User.class);
        if (user != null) {
            return user;
        }
        //取数据库
        user = userMapper.selectByPrimaryKey(id);
        if (user != null) {
            redisService.set(UserPrefix.getById,id.toString(),user);
        }
        return user;
    }

    public String login(HttpServletResponse response, LoginVo loginVo) {
        if (loginVo == null) {
            throw new RuntimeException("UserService 执行login 方法时，获取loginVo为空");
        }
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
        //判断手机号码是否存在
        User user = getUserById(Long.parseLong(mobile));
        if (user == null) {
            throw new RuntimeException("手机号码不存在");
        }
        //校验密码是否正确
        String dBpass = MD5Util.formpassToDBpass(password, user.getSalt());
        if (!dBpass.equals(user.getPassword())) {
            throw new RuntimeException("密码错误");
        }
        //密码校验成功，加入写入cookie 写入redis
        String token = UUIDUtil.uuid();
        addCookie(response,token,user);
        return token;
    }

    private void addCookie(HttpServletResponse response, String token, User user) {
        redisService.set(UserPrefix.token,token,user);
        Cookie cookie = new Cookie(CookieConstant.USER_TOKEN, token);
        cookie.setPath("/");
        cookie.setMaxAge(CookieConstant.USER_TOKEN_EXPIRE_TIME);
        response.addCookie(cookie);
    }

    public User getUserFromToken(String token) {
        if (StringUtils.isBlank(token)) {
            return null;
        }
        return redisService.get(UserPrefix.token,token,User.class);
    }
}
