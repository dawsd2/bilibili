package com.sf.dao.impl;

import com.sf.dao.RegisterDao;
import com.sf.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class RegisterImpl implements RegisterDao {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public int Register(UserEntity user) {
        //默认为0
        int register = 0;
        //SELECT count(*) FROM user WHERE userName="admin" and `passWord`="123321aaa";
        //先根据用户名查询
        String sql = "SELECT count(*) FROM user WHERE userName = ?";
        int num = jdbcTemplate.queryForObject(sql, new Object[]{user.getUserName()}, Integer.class);
        if (num > 0) {
            System.out.println("此用户被注册");
        } else {
            //开始注册
            String chaxunSql = "insert into user(userID,userName,passWord,userQQ,usersex,userPhone,userState,userEmial,userHand,userPaypassword) values(?,?,?,?,?,?,?,?,?,?)";
            register = jdbcTemplate.update(chaxunSql, user.getUserID(), user.getUserName(), user.getPassWord(), user.getUserQQ(), user.getUsersex(), user.getUserPhone(), user.getUserState(), user.getUserEmial(), user.getUserHand(), user.getUserPaypassword());

        }
        return register;
    }

}
