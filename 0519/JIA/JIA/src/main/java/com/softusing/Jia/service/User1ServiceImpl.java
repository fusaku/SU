package com.softusing.Jia.service;


import com.softusing.Jia.mapper.User1Mapper;
import com.softusing.Jia.model.User1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User1ServiceImpl implements User1Service {
    @Autowired
    private User1Mapper user1Repostory;

    public int save(User1 user1) {
        String name = user1.getUsername();
        return user1Repostory.insertSelective(user1);
    }

    public boolean login(User1 user1) {
        String name = user1.getUsername();
        String password = user1.getPassword();
        User1 u1 = user1Repostory.selectUser1ByName(name);
        if (u1 == null) {
            return false;
        } else {
            if (u1.getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean saveFlag(User1 user1) {
        String name = user1.getUsername();
        User1 u1 = user1Repostory.selectUser1ByName(name);
        if (u1 == null) {
            return true;
        }else {
            if (u1.getUsername().equals(name)) {
                return false;
            } else {
                return true;
            }
        }
    }

    @Override
    public List<User1> queryUser1ByArray() {
        return user1Repostory.queryUser1ByArray();
    }
}
