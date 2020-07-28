package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//<bean id="userService" class="com.itheima.service.impl.UserServiceImpl">
//@Component("useService")
@Service("userService")
@Scope("singleton")
public class UserServiceImpl implements UserService {

    @Value("${jdbc.driver}")
    private String driver;

    //<property name="userDao" ref="userDao"></property>
    //@Autowired //按照数据类型从spring容器中进行匹配
    //@Qualifier("userDao") //按照id从容器中进行匹配，但是此处要结合@Autowired一起使用
    @Resource(name = "userDao")
    private UserDao userDao;

    //使用xml进行配置市必须写，使用注解方法配置是可以不用
    //public void setUserDao(UserDao userDao) {
    //    this.userDao = userDao;
    //}

    public void save() {
        System.out.println(driver);
        userDao.save();
    }

    @PostConstruct
    public void init(){
        System.out.println("Service对象的初始化方法");
    }

    @PreDestroy
    public void destory(){
        System.out.println("Service对象的销毁方法");
    }
}
