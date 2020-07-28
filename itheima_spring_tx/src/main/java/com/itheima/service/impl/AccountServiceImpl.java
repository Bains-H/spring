package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void transfer(String outName, String inName, double money) {
        accountDao.out(outName,money);
        int i = 1/0;
        accountDao.in(inName,money);
    }
}
