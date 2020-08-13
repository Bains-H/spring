package com.itheima.mapper;

import com.itheima.domain.User;

import java.util.List;

/**
 * @author huang.b.h.
 * @date 2020/8/13 11:20
 * @DESC:
 */

public interface UserMapper {
    public List<User> findByCondition(User condition);

    public List<User> findByIds(List<Integer> ids);
}
