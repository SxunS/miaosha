package com.example.demo.controller;


import com.example.demo.result.CodeMsg;
import com.example.demo.result.Result;
import com.example.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author s_xun
 */
@Controller
public class HelloWorldController {

    @Autowired
    RedisService redisService;

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



    /**
     * redis test
     */
    @RequestMapping("/redis/get")
    public ResponseEntity redisGet(){
        String keyTestest = redisService.get("keyTest", String.class);
        return ResponseEntity.ok(keyTestest);
    }


}
