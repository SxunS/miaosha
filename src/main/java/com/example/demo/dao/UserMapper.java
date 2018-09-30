package com.example.demo.dao;

import com.example.demo.domain.User;
import com.example.demo.domain.UserExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaosha_user
     *
     * @mbg.generated Fri Sep 28 14:26:35 CST 2018
     */
    long countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaosha_user
     *
     * @mbg.generated Fri Sep 28 14:26:35 CST 2018
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaosha_user
     *
     * @mbg.generated Fri Sep 28 14:26:35 CST 2018
     */
    @Delete({
        "delete from miaosha_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaosha_user
     *
     * @mbg.generated Fri Sep 28 14:26:35 CST 2018
     */
    @Insert({
        "insert into miaosha_user (id, nickname, ",
        "password, salt, ",
        "head, register_date, ",
        "last_login_date, login_count)",
        "values (#{id,jdbcType=BIGINT}, #{nickname,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{salt,jdbcType=VARCHAR}, ",
        "#{head,jdbcType=VARCHAR}, #{registerDate,jdbcType=TIMESTAMP}, ",
        "#{lastLoginDate,jdbcType=TIMESTAMP}, #{loginCount,jdbcType=INTEGER})"
    })
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaosha_user
     *
     * @mbg.generated Fri Sep 28 14:26:35 CST 2018
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaosha_user
     *
     * @mbg.generated Fri Sep 28 14:26:35 CST 2018
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaosha_user
     *
     * @mbg.generated Fri Sep 28 14:26:35 CST 2018
     */
    @Select({
        "select",
        "id, nickname, password, salt, head, register_date, last_login_date, login_count",
        "from miaosha_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
   // @ResultMap("com.example.demo.dao.UserMapper.BaseResultMap")
    User selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaosha_user
     *
     * @mbg.generated Fri Sep 28 14:26:35 CST 2018
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaosha_user
     *
     * @mbg.generated Fri Sep 28 14:26:35 CST 2018
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaosha_user
     *
     * @mbg.generated Fri Sep 28 14:26:35 CST 2018
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miaosha_user
     *
     * @mbg.generated Fri Sep 28 14:26:35 CST 2018
     */
    @Update({
        "update miaosha_user",
        "set nickname = #{nickname,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "salt = #{salt,jdbcType=VARCHAR},",
          "head = #{head,jdbcType=VARCHAR},",
          "register_date = #{registerDate,jdbcType=TIMESTAMP},",
          "last_login_date = #{lastLoginDate,jdbcType=TIMESTAMP},",
          "login_count = #{loginCount,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(User record);
}