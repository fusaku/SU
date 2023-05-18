package com.softusing.Jia.service;

import com.softusing.Jia.mapper.User1Mapper;
import com.softusing.Jia.model.User1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class User1ServiceImpl implements User1Service{
    @Autowired
    private User1Mapper user1Repostory;

    public int save(User1 user1) {
        return user1Repostory.insertSelective(user1);
    }
}
