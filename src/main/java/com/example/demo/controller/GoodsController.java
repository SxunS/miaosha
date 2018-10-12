package com.example.demo.controller;

import com.example.demo.entity.MiaoshaGoods;
import com.example.demo.entity.MiaoshaUser;
import com.example.demo.service.MGoodsService;
import com.example.demo.service.UserService;
import com.example.demo.vo.MGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private UserService userService;
    @Autowired
    private MGoodsService mGoodsService;

    @RequestMapping("/to_list")
    public String toLogin(Model model,MiaoshaUser user){
        if (user == null) {
            return "login";
        }
        model.addAttribute("user",user);
        List<MGoodsVo> mGoodsList = mGoodsService.queryMGoodsList();
        model.addAttribute("goodsList",mGoodsList);
        return "goods_list";
    }

    @RequestMapping("/goods_detail/{goodsID}")
    public String toGoodsDetail(MiaoshaUser user, @PathVariable long goodsID, Model model){
        model.addAttribute("user",user);
        MGoodsVo mGoodsVo = mGoodsService.queryMGoodsByID(goodsID);
        //计算秒杀活动剩余时间
        long start = mGoodsVo.getStartDate().getTime();
        long end = mGoodsVo.getEndDate().getTime();
        long now = System.currentTimeMillis();
        long remainTime = -1;
        byte miaoshaStatus = -1;
        if (now < start) {
            //秒杀还未开始，进行倒计时
            miaoshaStatus = 0;
            remainTime = (now - start)/1000;
        }else if (now > end){
            //秒杀已经结束
        }else {
            //秒杀正在进行
            miaoshaStatus = 1;
            remainTime = 0;
        }
        model.addAttribute("remainTime",remainTime);
        model.addAttribute("miaoshaStatus",miaoshaStatus);
        model.addAttribute("goods",mGoodsVo);
        return "goods_detail";
    }
}
