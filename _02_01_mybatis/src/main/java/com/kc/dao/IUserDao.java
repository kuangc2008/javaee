package com.kc.dao;

import com.kc.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {

    List<User> findAll();

    @Select("select * from user")
    List<User> findAll2();
}
