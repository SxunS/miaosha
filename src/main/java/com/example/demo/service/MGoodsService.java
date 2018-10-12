package com.example.demo.service;

import com.example.demo.entity.MiaoshaGoods;
import com.example.demo.mapper.MiaoshaGoodsMapper;
import com.example.demo.vo.MGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MGoodsService {

    @Autowired
    MiaoshaGoodsMapper goodsMapper;

    public List<MGoodsVo> queryMGoodsList(){
        return goodsMapper.queryMGoodsList();
    }

    public MGoodsVo queryMGoodsByID(long goodsID) {
        return goodsMapper.queryMGoodsByID(goodsID);
    }
}
