package com.itheima.domain;

import java.util.List;

/**
 * @author huang.b.h.
 * @date 2020/7/29 18:30
 * @DESC:
 */

public class Vo {
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Vo{" +
                "userList=" + userList +
                '}';
    }
}
