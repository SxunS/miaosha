package com.example.demo.dao;

import com.example.demo.domain.MiaoshaOrder;
import com.example.demo.domain.MiaoshaOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MiaoshaOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaosha_order
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    long countByExample(MiaoshaOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaosha_order
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    int deleteByExample(MiaoshaOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaosha_order
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    @Delete({
        "delete from miaosha_order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaosha_order
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    @Insert({
        "insert into miaosha_order (id, user_id, ",
        "order_id, goods_id)",
        "values (#{id,jdbcType=BIGINT}, #{userId,jdbcType=BIGINT}, ",
        "#{orderId,jdbcType=BIGINT}, #{goodsId,jdbcType=BIGINT})"
    })
    int insert(MiaoshaOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaosha_order
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    int insertSelective(MiaoshaOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaosha_order
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    List<MiaoshaOrder> selectByExample(MiaoshaOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaosha_order
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    @Select({
        "select",
        "id, user_id, order_id, goods_id",
        "from miaosha_order",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.example.demo.dao.MiaoshaOrderMapper.BaseResultMap")
    MiaoshaOrder selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaosha_order
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    int updateByExampleSelective(@Param("record") MiaoshaOrder record, @Param("example") MiaoshaOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaosha_order
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    int updateByExample(@Param("record") MiaoshaOrder record, @Param("example") MiaoshaOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaosha_order
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    int updateByPrimaryKeySelective(MiaoshaOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaosha_order
     *
     * @mbg.generated Sun Sep 30 17:07:10 CST 2018
     */
    @Update({
        "update miaosha_order",
        "set user_id = #{userId,jdbcType=BIGINT},",
          "order_id = #{orderId,jdbcType=BIGINT},",
          "goods_id = #{goodsId,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MiaoshaOrder record);
}