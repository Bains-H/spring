package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("accountDap")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void out(String outName, double money) {
        jdbcTemplate.update("update account set money=money-? where name=?",money,outName);
    }

    public void in(String inName, double money) {
        jdbcTemplate.update("update account set money=money+? where name=?",money,inName);
    }
}
