package com.itheima.mapper;

import com.itheima.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author huang.b.h.
 * @date 2020/8/14 13:21
 * @DESC:
 */

public interface RoleMapper {

    @Select("select * from sys_user_role ur,sys_role r where ur.roleId=r.id and ur.userId=#{uid}")
    public List<Role> findByUid(int id);
}
