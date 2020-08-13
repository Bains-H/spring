package com.itheima.test;

import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author huang.b.h.
 * @date 2020/8/12 23:47
 * @DESC:
 */

public class MyBatisTest {

    @Test
    //查询操作
    public void test1() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作 参数namespace+id
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        //打印数据
        System.out.println(userList);
        sqlSession.close();
    }

    @Test
    //插入操作
    public void test2() throws IOException {

        //模拟User对象
        User user = new User();
        user.setUsername("tom");
        user.setPassword("123");

        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("userMapper.save",user);

        sqlSession.commit();
        sqlSession.close();
        test1();
    }

    @Test
    //修改操作
    public void test3() throws IOException{

        //模拟User对象
        User user = new User();
        user.setId(6);
        user.setUsername("lucy");
        user.setPassword("123");

        InputStream resourceAsSteam = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("userMapper.update",user);

        sqlSession.commit();
        sqlSession.close();
        test1();
    }

    @Test
    //删除操作
    public void test4() throws IOException{
        InputStream resourceAaStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAaStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("userMapper.delete",6);
        sqlSession.commit();
        sqlSession.close();
        test1();
    }

}
