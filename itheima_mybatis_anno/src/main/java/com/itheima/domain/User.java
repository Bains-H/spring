package com.itheima.domain;

import java.util.Date;
import java.util.List;

/**
 * @author huang.b.h.
 * @date 2020/8/14 11:24
 * @DESC:
 */

public class User {
    private int id;
    private String username;
    private String password;
    //private Date birthday;

    private List<Order> orderList;

    private List<Role> roleList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //public Date getBirthday() {
    //    return birthday;
    //}
    //
    //public void setBirthday(Date birthday) {
    //    this.birthday = birthday;
    //}

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", orderList=" + orderList +
                ", roleList=" + roleList +
                '}';
    }
}
