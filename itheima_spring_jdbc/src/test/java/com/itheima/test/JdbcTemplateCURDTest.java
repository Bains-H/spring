package com.itheima.test;

import com.itheima.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCURDTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert(){
        int row = jdbcTemplate.update("insert into account values(?,?)","tom",5000);
        System.out.println(row);
    }

    @Test
    public void testUpdate(){
        jdbcTemplate.update("update account set money=? where name=?",8000,"tom");
    }

    @Test
    public void testDelete(){
        jdbcTemplate.update("delete from account where name=?","tom");
    }

    @Test
    public void testQueryAll(){
        List<Account> list = jdbcTemplate.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(list);
    }

    @Test
    public void testQueryOne(){
        Account account = jdbcTemplate.queryForObject("select * from account where name=?",new BeanPropertyRowMapper<Account>(Account.class),"tom");
        System.out.println(account);
    }

    @Test
    public void testQueryCount(){
        Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(count);
    }
}
