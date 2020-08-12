package com.itheima.service;

import com.itheima.domain.User;

import java.util.List;

/**
 * @author huang.b.h.
 * @date 2020/8/12 11:31
 * @DESC:
 */

public interface UserService {
    List<User> list();

    void save(User user, Long[] roleIds);

    void delete(Long userId);
}
