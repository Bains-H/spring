package com.itheima.service.impl;

import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.service.UserService;

import java.util.List;

/**
 * @author huang.b.h.
 * @date 2020/8/12 11:32
 * @DESC:
 */

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<User> list() {
        List<User> userList = userDao.findAll();
        //封装userList中的每一个user的role数值
        for (User user : userList){
            //获得user的id
            Long id = user.getId();
            //用id作为参数 查询当前userId对应的集合数据
            List<Role> roles = roleDao.findRoleByUserId(id);
            user.setRoles(roles);
        }

        return userList;
    }

    public void save(User user, Long[] roleIds) {
        Long userId = userDao.save(user);
        userDao.saveUserRoleRel(userId,roleIds);
    }

    public void delete(Long userId) {
        userDao.delUserRoleRel(userId);
        userDao.delUser(userId);
    }
}
