package com.itheima.service;

import com.itheima.domain.Role;

import java.util.List;

/**
 * @author huang.b.h.
 * @date 2020/8/12 10:44
 * @DESC:
 */

public interface RoleService {
    List<Role> list();

    void save(Role role);
}
