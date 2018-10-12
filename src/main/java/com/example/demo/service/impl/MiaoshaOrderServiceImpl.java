package com.example.demo.service.impl;

import com.example.demo.entity.MiaoshaOrder;
import com.example.demo.mapper.MiaoshaOrderMapper;
import com.example.demo.service.IMiaoshaOrderService;
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
public class MiaoshaOrderServiceImpl extends ServiceImpl<MiaoshaOrderMapper, MiaoshaOrder> implements IMiaoshaOrderService {

    @Autowired
    private MiaoshaOrderMapper miaoshaOrderMapper;

    @Override
    public MiaoshaOrder queryByUidAndGid(Long uid, long goodsId) {
        return miaoshaOrderMapper.queryByUidAndGid(uid, goodsId);
    }
}
