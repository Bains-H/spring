package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

/**
 * @author huang.b.h.
 * @date 2020/8/14 16:24
 * @DESC:
 */

public interface AccountService {

    public void save(Account account);

    public List<Account> findAll();
}
