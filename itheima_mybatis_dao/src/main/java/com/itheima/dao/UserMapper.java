package com.itheima.dao;

import com.itheima.domain.User;

import java.io.IOException;
import java.util.List;

/**
 * @author huang.b.h.
 * @date 2020/8/13 10:28
 * @DESC:
 */

public interface UserMapper {

    public List<User> findAll() throws IOException;

    public User findById(int id);
}
