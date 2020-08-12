package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author huang.b.h.
 * @date 2020/8/12 11:34
 * @DESC:
 */

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findAll() {
        List<User> userList = jdbcTemplate.query("select * from sys_user",new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    public Long save(final User user) {
        //创建PreparedStatementCreator
        PreparedStatementCreator creator = new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                //使用原始jdbc完成有个PreparedStatement的组建
                PreparedStatement preparedStatement = connection.prepareStatement("insert into sys_user values(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1,null);
                preparedStatement.setString(2,user.getUsername());
                preparedStatement.setString(3,user.getEmail());
                preparedStatement.setString(4,user.getPassword());
                preparedStatement.setString(5,user.getPhoneNum());
                return preparedStatement;
            }
        };
        //创建keyHolder
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(creator,keyHolder);
        //获得生成的主键
        long userId = keyHolder.getKey().longValue();

        //jdbcTemplate.update("insert into sys_user values(?,?,?,?,?)",null,user.getUsername(),user.getEmail(),user.getPassword(),user.getPhoneNum());
        return userId;
    }

    public void saveUserRoleRel(Long userId, Long[] roleIds) {
        for (Long roleId:roleIds){
            jdbcTemplate.update("insert into sys_user_role values(?,?)",userId,roleId);
        }
    }

    public void delUserRoleRel(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId=?",userId);
    }

    public void delUser(Long userId) {
        jdbcTemplate.update("delete from sys_user where id=?",userId);

    }
}
