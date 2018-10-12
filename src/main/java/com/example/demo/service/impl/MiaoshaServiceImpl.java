package com.example.demo.service.impl;

import com.example.demo.constant.OrderStatus;
import com.example.demo.entity.*;
import com.example.demo.exception.GlobalException;
import com.example.demo.result.CodeMsg;
import com.example.demo.service.IMiaoshaGoodsService;
import com.example.demo.service.IMiaoshaOrderService;
import com.example.demo.service.IMiaoshaService;
import com.example.demo.service.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class MiaoshaServiceImpl implements IMiaoshaService {

    @Autowired
    private IMiaoshaGoodsService miaoshaGoodsService;

    @Autowired
    private IOrderInfoService orderInfoService;

    @Autowired
    private IMiaoshaOrderService miaoshaOrderService;

    @Override
    public OrderInfo miaosha(MiaoshaUser user, Goods goods, MiaoshaGoods miaoshaGoods) {
        //减库存(仅限秒杀一件)
        boolean success = miaoshaGoodsService.reduceStock(miaoshaGoods);
        if (success) {
            //下订单
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setCreateTime(LocalDateTime.now());
            orderInfo.setGoodsCount(1);
            orderInfo.setGoodsId(goods.getId());
            orderInfo.setGoodsName(goods.getGoodsName());
            orderInfo.setGoodsPrice(miaoshaGoods.getMiaoshaPrice());
            orderInfo.setUserId(user.getId());
            orderInfo.setStatus(OrderStatus.UNPAID.getStatus());
            orderInfoService.save(orderInfo);
            //记录秒杀订单
            MiaoshaOrder miaoshaOrder = new MiaoshaOrder();
            miaoshaOrder.setGoodsId(miaoshaGoods.getGoodsId());
            miaoshaOrder.setOrderId(orderInfo.getId());
            miaoshaOrder.setUserId(user.getId());
            miaoshaOrderService.save(miaoshaOrder);
            return orderInfo;
        }else {
            throw new GlobalException(CodeMsg.MIAOSHA_ALREADY);
        }
    }
}
