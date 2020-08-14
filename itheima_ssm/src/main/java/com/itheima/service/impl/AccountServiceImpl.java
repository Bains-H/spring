package com.itheima.service.impl;

import com.itheima.domain.Account;
import com.itheima.mapper.AccountMapper;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huang.b.h.
 * @date 2020/8/14 16:26
 * @DESC:
 */

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public void save(Account account) {
        accountMapper.save(account);
    }

    public List<Account> findAll() {
        return accountMapper.findAll();
    }

    //public void save(Account account) {
    //    try {
    //        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
    //        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    //        SqlSession sqlSession = sqlSessionFactory.openSession();
    //        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
    //        mapper.save(account);
    //        sqlSession.commit();
    //        sqlSession.close();
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    }
    //}
    //
    //public List<Account> findAll() {
    //    try {
    //        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
    //        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    //        SqlSession sqlSession = sqlSessionFactory.openSession();
    //        AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
    //        List<Account> accountList = mapper.findAll();
    //        sqlSession.close();
    //        return accountList;
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    }
    //    return null;
    //}
}
