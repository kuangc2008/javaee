package com.kc.dao;

import com.kc.domain.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();
}
