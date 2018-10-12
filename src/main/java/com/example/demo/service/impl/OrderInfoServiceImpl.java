package com.example.demo.service.impl;

import com.example.demo.entity.OrderInfo;
import com.example.demo.mapper.OrderInfoMapper;
import com.example.demo.service.IOrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {

}
