package com.example.demo.service;

import com.example.demo.dao.MemberInfoDao;
import com.example.demo.domain.MemberInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private MemberInfoDao memberInfoDao;


    @Autowired
    public MemberService(MemberInfoDao memberInfoDao) {
        this.memberInfoDao = memberInfoDao;
    }
    public MemberInfo getMemberById(int id){
        return memberInfoDao.getMemberInfoById(id);
    }
}
