package com.example.demo.controller;

import com.example.demo.domain.MemberInfo;
import com.example.demo.redis.UserPrefix;
import com.example.demo.result.CodeMsg;
import com.example.demo.result.Result;
import com.example.demo.service.MemberService;
import com.example.demo.service.RedisService;
import org.omg.CORBA.IRObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    RedisService redisService;

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

    /**
     * redis test
     */
    @RequestMapping("/redis/get")
    public ResponseEntity redisGet(){
        String keyTestest = redisService.get("keyTest", String.class);
        return ResponseEntity.ok(keyTestest);
    }
    @RequestMapping("/redis/set")
    public ResponseEntity redisSet(){
        MemberInfo memberInfo = new MemberInfo();
        memberInfo.setId(1);
        memberInfo.setUsername("test");
        Boolean setTest = redisService.set(UserPrefix.getById,"1", memberInfo);
        if (setTest){
            return ResponseEntity.ok(memberInfo);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

}
