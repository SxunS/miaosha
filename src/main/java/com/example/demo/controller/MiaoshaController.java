package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.*;
import com.example.demo.result.CodeMsg;
import com.example.demo.service.IGoodsService;
import com.example.demo.service.IMiaoshaGoodsService;
import com.example.demo.service.IMiaoshaOrderService;
import com.example.demo.service.IMiaoshaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/miaosha")
public class MiaoshaController {

    @Autowired
    private IMiaoshaGoodsService miaoshaGoodsService;

    @Autowired
    private IMiaoshaOrderService miaoshaOrderService;

    @Autowired
    private IMiaoshaService miaoshaService;

    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("do_miaosha")
    public String miaosha(Model model, MiaoshaUser user, @RequestParam String goodsId){
        if (user == null) {
            return "login";
        }
        //判断库存是否有货
        MiaoshaGoods miaoshaGoods = miaoshaGoodsService.getById(goodsId);
        Integer miaoshaGoodsStockCount = miaoshaGoods.getStockCount();
        if (miaoshaGoodsStockCount <= 0) {
            model.addAttribute("errmsg",CodeMsg.MIAOSHA_STOCK_NOT_ENOUGH);
            return "miaosha_fail";
        }
        //判断当前用户是否重复秒杀
        Long uid = user.getId();
        MiaoshaOrder miaoshaOrder = miaoshaOrderService.queryByUidAndGid(uid,Long.parseLong(goodsId));
        if (miaoshaOrder != null) {
            model.addAttribute("errmsg",CodeMsg.MIAOSHA_REPEAT);
            return "miaosha_fail";
        }
        //秒杀 （减库存，下订单）
        Goods goods = goodsService.getById(miaoshaGoods.getGoodsId());
        OrderInfo orderInfo = miaoshaService.miaosha(user,goods,miaoshaGoods);
        model.addAttribute("orderInfo",orderInfo);
        model.addAttribute("goods",goods);
        return "order_detail";
    }
}
