package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author huang.b.h.
 * @date 2020/8/14 11:33
 * @DESC:
 */

public class MyBatisTest {

    private UserMapper mapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void test1(){

        User user = new User();
        user.setUsername("lucy");
        user.setPassword("123");

        mapper.save(user);
    }

    @Test
    public void test2(){
        User user = new User();
        user.setId(7);
        user.setUsername("eric");
        user.setPassword("123");

        mapper.update(user);
    }

    @Test
    public void test3(){
        mapper.delete(10);
    }

    @Test
    public void test4(){
        List<User> userList = mapper.findAll();
        for (User user:userList){
            System.out.println(user);
        }
    }

    @Test
    public void test5(){
        User user = mapper.findById(7);
        System.out.println(user);
    }

    @Test
    public void test6(){
        List<User> userAndOrderAll = mapper.findUserAndOrderAll();
        for (User user : userAndOrderAll) {
            System.out.println(user);
        }
    }

    @Test
    public void test7(){
        List<User> userAndRoleAll = mapper.findUserAndRoleAll();
        for (User user : userAndRoleAll) {
            System.out.println(user);
        }
    }
}
