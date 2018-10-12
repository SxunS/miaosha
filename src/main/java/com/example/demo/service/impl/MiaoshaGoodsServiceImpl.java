package com.example.demo.service.impl;

import com.example.demo.entity.MiaoshaGoods;
import com.example.demo.mapper.MiaoshaGoodsMapper;
import com.example.demo.service.IMiaoshaGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author s_xun_s
 * @since 2018-10-11
 */
@Service
public class MiaoshaGoodsServiceImpl extends ServiceImpl<MiaoshaGoodsMapper, MiaoshaGoods> implements IMiaoshaGoodsService {

    @Autowired
    private MiaoshaGoodsMapper miaoshaGoodsMapper;

    @Override
    public boolean reduceStock(MiaoshaGoods miaoshaGoods) {
        int affectedRows = miaoshaGoodsMapper.reduceStock(miaoshaGoods);
        return affectedRows > 0;
    }
}
