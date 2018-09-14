package com.example.demo.controller;

import com.example.demo.domain.MemberInfo;
import com.example.demo.result.CodeMsg;
import com.example.demo.result.Result;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author s_xun
 */
@Controller
public class HelloWorldController {
    final
    MemberService memberService;

    @Autowired
    public HelloWorldController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloWorld(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name",name);
        return "hello";
    }
    @RequestMapping(value = "/helloSuccess",method = RequestMethod.GET)
    public Result<String> helloSuccess(){
        return Result.success("Hello World!");
    }
    @RequestMapping(value = "/helloError",method = RequestMethod.GET)
    public Result helloError(){
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping("/db/get")
    @ResponseBody
    public Result<MemberInfo> dbGet(){
        MemberInfo memberById = memberService.getMemberById(1);
        return Result.success(memberById);
    }

}
