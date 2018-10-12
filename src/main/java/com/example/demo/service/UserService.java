package com.example.demo.service;

import com.example.demo.constant.CookieConstant;
import com.example.demo.entity.MiaoshaUser;
import com.example.demo.exception.GlobalException;
import com.example.demo.mapper.MiaoshaUserMapper;
import com.example.demo.redis.UserPrefix;
import com.example.demo.result.CodeMsg;
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
    private MiaoshaUserMapper userMapper;

    private MiaoshaUser getUserById(Long id){
        //取缓存
        MiaoshaUser user = redisService.get(UserPrefix.getById, id.toString(), MiaoshaUser.class);
        if (user != null) {
            return user;
        }
        //取数据库
        user = userMapper.selectById(id);
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
        MiaoshaUser user = getUserById(Long.parseLong(mobile));
        if (user == null) {
            throw new GlobalException(CodeMsg.PHONE_NUM_NOT_EXIST_ERROR);
        }
        //校验密码是否正确
        String dBpass = MD5Util.formpassToDBpass(password, user.getSalt());
        if (!dBpass.equals(user.getPassword())) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        //密码校验成功，加入写入cookie 写入redis
        String token = UUIDUtil.uuid();
        addCookie(response,token,user);
        return token;
    }

    private void addCookie(HttpServletResponse response, String token, MiaoshaUser user) {
        redisService.set(UserPrefix.token,token,user);
        Cookie cookie = new Cookie(CookieConstant.USER_TOKEN, token);
        cookie.setPath("/");
        cookie.setMaxAge(CookieConstant.USER_TOKEN_EXPIRE_TIME);
        response.addCookie(cookie);
    }

    public MiaoshaUser getUserFromToken(String token) {
        if (StringUtils.isBlank(token)) {
            return null;
        }
        return redisService.get(UserPrefix.token,token,MiaoshaUser.class);
    }
}
