package com.example.demo.dao;

import com.example.demo.domain.OrderInfo;
import com.example.demo.domain.OrderInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface OrderInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    long countByExample(OrderInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    int deleteByExample(OrderInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    @Delete({
        "delete from order_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    @Insert({
        "insert into order_info (id, user_id, ",
        "goods_id, delivery_addr_id, ",
        "goods_name, goods_count, ",
        "goods_price, order_channel, ",
        "status, create_time, ",
        "pay_time)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=BIGINT}, ",
        "#{goodsId,jdbcType=BIGINT}, #{deliveryAddrId,jdbcType=BIGINT}, ",
        "#{goodsName,jdbcType=VARCHAR}, #{goodsCount,jdbcType=INTEGER}, ",
        "#{goodsPrice,jdbcType=DECIMAL}, #{orderChannel,jdbcType=TINYINT}, ",
        "#{status,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{payTime,jdbcType=TIMESTAMP})"
    })
    int insert(OrderInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    int insertSelective(OrderInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    List<OrderInfo> selectByExample(OrderInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    @Select({
        "select",
        "id, user_id, goods_id, delivery_addr_id, goods_name, goods_count, goods_price, ",
        "order_channel, status, create_time, pay_time",
        "from order_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.example.demo.dao.OrderInfoMapper.BaseResultMap")
    OrderInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    int updateByExampleSelective(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    int updateByExample(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    int updateByPrimaryKeySelective(OrderInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    @Update({
        "update order_info",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "goods_id = #{goodsId,jdbcType=BIGINT},",
          "delivery_addr_id = #{deliveryAddrId,jdbcType=BIGINT},",
          "goods_name = #{goodsName,jdbcType=VARCHAR},",
          "goods_count = #{goodsCount,jdbcType=INTEGER},",
          "goods_price = #{goodsPrice,jdbcType=DECIMAL},",
          "order_channel = #{orderChannel,jdbcType=TINYINT},",
          "status = #{status,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "pay_time = #{payTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OrderInfo record);
}