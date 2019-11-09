package com.kc.dao;

import com.kc.domain.Account;
import com.kc.domain.AccountUser;

import java.util.List;


public interface IAccountDao {

    /**
     * 查询所有账户，同时还要获取到当前账户的所属用户信息
     * @return
     */
    List<Account> findAll();

    List<AccountUser> findAllAccount();
}
