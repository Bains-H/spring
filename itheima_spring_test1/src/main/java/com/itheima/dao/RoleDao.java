package com.itheima.dao;

import com.itheima.domain.Role;

import java.util.List;

/**
 * @author huang.b.h.
 * @date 2020/8/12 10:46
 * @DESC:
 */

public interface RoleDao {
    List<Role> findAll();

    void save(Role role);

    List<Role> findRoleByUserId(Long id);
}
