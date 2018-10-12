package com.example.demo.mapper;

import com.example.demo.entity.MiaoshaGoods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.vo.MGoodsVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author s_xun_s
 * @since 2018-10-11
 */
@Repository
public interface MiaoshaGoodsMapper extends BaseMapper<MiaoshaGoods> {

    @Select("SELECT mg.miaosha_price,mg.stock_count,g.goods_img,g.goods_price,g.id" +
            " from miaosha_goods mg left join goods g on mg.goods_id = g.id")
    List<MGoodsVo> queryMGoodsList();

    @Select("SELECT mg.miaosha_price,mg.stock_count,g.goods_img,g.goods_price,g.id,mg.end_date,mg.start_date" +
            " from miaosha_goods mg left join goods g on mg.goods_id = g.id where g.id = #{goodsId}")
    MGoodsVo queryMGoodsByID(@Param("goodsId") long goodsID);

    /**
     *   减少秒杀商品库存
     * @param miaoshaGoods 秒杀s商品
     * @return 影响条数
     */
    @Update("UPDATE miaosha_goods SET stock_count = stock_count - 1 where goods_id = #{goodsId} and stock_count > 0")
    int reduceStock(MiaoshaGoods miaoshaGoods);
}
