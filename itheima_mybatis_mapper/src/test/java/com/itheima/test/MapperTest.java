package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huang.b.h.
 * @date 2020/8/13 11:22
 * @DESC:
 */

public class MapperTest {
    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //模拟条件user
        User condition = new User();
        condition.setId(1);
        condition.setUsername("zhangsan");
        condition.setPassword("123");

        List<User> userList = mapper.findByCondition(condition);
        System.out.println(userList);
    }

    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //模拟Ids的数据
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(3);

        List<User> userList = mapper.findByIds(ids);
        System.out.println(userList);
    }
}
