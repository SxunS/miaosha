package com.example.demo.controller;

import com.example.demo.constant.CookieConstant;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private UserService userService;

    @RequestMapping("/to_list")
    public String toLogin(Model model,User user){
        if (user == null) {
            return "login";
        }
        model.addAttribute("user",user);
        return "goods_list";
    }
}
