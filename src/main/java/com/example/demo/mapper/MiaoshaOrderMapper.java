package com.example.demo.mapper;

import com.example.demo.entity.MiaoshaOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author s_xun_s
 * @since 2018-10-11
 */
@Repository
public interface MiaoshaOrderMapper extends BaseMapper<MiaoshaOrder> {

    @Select("SELECT order_id from miaosha_order WHERE goods_id = #{goodsId}  AND user_id = #{uid}")
    MiaoshaOrder queryByUidAndGid(@Param("uid") Long uid,@Param("goodsId") long goodsId);
}
