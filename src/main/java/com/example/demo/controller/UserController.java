package com.example.demo.controller;

import com.example.demo.result.Result;
import com.example.demo.service.UserService;
import com.example.demo.util.ValidatorUtil;
import com.example.demo.vo.LoginVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @RequestMapping(value = "/to_login",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "/do_login",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> doLogin(HttpServletResponse response, @Valid LoginVo loginVo){
        LOG.info(loginVo.toString());
        //参数校验
//        String mobile = loginVo.getMobile();
//        String password = loginVo.getPassword();
//        if (StringUtils.isBlank(mobile)) {
//            throw new RuntimeException("手机号码不能为空");
//        }
//        if (StringUtils.isBlank(password)) {
//            throw new  RuntimeException("密码不能为空");
//        }
//        if (!ValidatorUtil.isMobileNum(mobile)){
//            throw new RuntimeException("手机号码不合法");
//        }
        String token = userService.login(response,loginVo);
        return Result.success(token);
    }
}
