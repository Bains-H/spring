package com.itheima.mapper;

import com.itheima.domain.Account;

import java.util.List;

/**
 * @author huang.b.h.
 * @date 2020/8/14 16:23
 * @DESC:
 */

public interface AccountMapper {

    public void save(Account account);


    public List<Account> findAll();
}
