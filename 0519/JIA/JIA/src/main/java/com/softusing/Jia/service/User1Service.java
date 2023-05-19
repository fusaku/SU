package com.softusing.Jia.service;


import com.softusing.Jia.model.User1;

import java.util.List;

public interface User1Service {
    int save(User1 user1);

    boolean login(User1 user1);
    boolean saveFlag(User1 user1);
    List<User1> queryUser1ByArray();


}
