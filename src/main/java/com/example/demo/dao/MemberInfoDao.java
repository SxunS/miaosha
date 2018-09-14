package com.example.demo.dao;

import com.example.demo.domain.MemberInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface MemberInfoDao {
    @Select("select * from memberInfo where id = #{id}")
    public MemberInfo getMemberInfoById(@Param("id") int id);
}
