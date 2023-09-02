package com.estimate.service;

import com.estimate.pojo.PageBean;
import com.estimate.pojo.User;


public interface UserService {
    boolean login(User user);

    void register(User user);

    PageBean<User> findByPage(int currentPage,int pageSize);

    PageBean<User> findByPageandCondition(int currentPage,int pageSize,User user);

    void resetPwd(int id);

    void delUser(int id);
}
