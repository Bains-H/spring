package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 * @author huang.b.h.
 * @date 2020/8/12 11:33
 * @DESC:
 */

public interface UserDao {
    List<User> findAll();

    Long save(User user);

    void saveUserRoleRel(Long id, Long[] roleIds);

    void delUserRoleRel(Long userId);

    void delUser(Long userId);
}
