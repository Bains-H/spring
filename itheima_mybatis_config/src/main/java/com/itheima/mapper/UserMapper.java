package com.itheima.mapper;

import com.itheima.domain.User;

import java.util.List;

/**
 * @author huang.b.h.
 * @date 2020/8/14 6:35
 * @DESC:
 */

public interface UserMapper {

    public void save(User user);

    public User findById(int id);

    public List<User> findAll();
}
