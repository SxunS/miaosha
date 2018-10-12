package com.example.demo.service;

import com.example.demo.entity.MiaoshaOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author s_xun_s
 * @since 2018-10-11
 */
public interface IMiaoshaOrderService extends IService<MiaoshaOrder> {

    MiaoshaOrder queryByUidAndGid( Long uid, long goodsId);
}
