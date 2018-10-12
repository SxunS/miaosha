package com.example.demo.controller;


import com.example.demo.entity.Goods;
import com.example.demo.entity.MiaoshaUser;
import com.example.demo.entity.OrderInfo;
import com.example.demo.service.IGoodsService;
import com.example.demo.service.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author s_xun_s
 * @since 2018-10-11
 */
@Controller
@RequestMapping("/demo/order-info")
public class OrderInfoController {

    @Autowired
    private IOrderInfoService orderInfoService;

    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("/order_detail/{orderId}")
    public String orderDetail(Model model, @PathVariable Long orderId, MiaoshaUser user){
        if (user == null) {
            return "login";
        }
        OrderInfo orderInfo = orderInfoService.getById(orderId);
        Long goodsId = orderInfo.getGoodsId();
        Goods goods = goodsService.getById(goodsId);
        model.addAttribute("goods",goods);
        model.addAttribute("orderInfo",orderInfo);
        return "order_detail";
    }
}
