package com.example.demo.service;


import com.example.demo.entity.Goods;
import com.example.demo.entity.MiaoshaGoods;
import com.example.demo.entity.MiaoshaUser;
import com.example.demo.entity.OrderInfo;

public interface IMiaoshaService {

    OrderInfo miaosha(MiaoshaUser user, Goods goods, MiaoshaGoods miaoshaGoods);
}
