package com.example.demo.service;

import com.example.demo.entity.MiaoshaGoods;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author s_xun_s
 * @since 2018-10-11
 */
public interface IMiaoshaGoodsService extends IService<MiaoshaGoods> {

    boolean reduceStock(MiaoshaGoods miaoshaGoods);
}
