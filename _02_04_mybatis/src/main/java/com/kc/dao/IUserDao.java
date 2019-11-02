package com.kc.dao;

import com.kc.domain.User;
import java.util.List;

public interface IUserDao {

    List<User> findAll();



    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);
}
