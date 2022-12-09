package com.sf.dao.impl;

import com.sf.dao.Update_login_password_Dao;
import com.sf.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Update_login_password_Impl implements Update_login_password_Dao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int Update_login_password(String userName, String passWord, String newpassWord) {
        int what = 0;
        //先查询出用户名和密码是否匹配 才能更改密码
        String sql = "select count(*) from user where userName=? and passWord=?";
        int num = jdbcTemplate.queryForObject(sql, new Object[]{userName, passWord}, Integer.class);
        if (num > 0) {
            //UPDATE user set `newpassWord`="111" where userName="admin";
            //此用户存在  并且密码匹配 可以进行修改密码
            String update = "update user set passWord=? where userName=?";
            what = jdbcTemplate.update(update, newpassWord, userName);
        } else {
            return what;
        }
        return what;
    }

    public int Update_login_Emial(String userName, String emial, String newemial) {
        int what = 0;
        //先查询出用户名和密码是否匹配 才能更改密码
        String sql = "select count(*) from user where userName=? and userEmial=?";
        int num = jdbcTemplate.queryForObject(sql, new Object[]{userName, emial}, Integer.class);
        if (num > 0) {
            //UPDATE user set `newpassWord`="111" where userName="admin";
            //此用户存在  并且密码匹配 可以进行修改密码
            String update = "update user set userEmial=? where userName=?";
            what = jdbcTemplate.update(update, newemial, userName);
        } else {
            return what;
        }
        return what;
    }

    public int Update_login_Phone(String userName, String userPhone, String newuserPhone) {

        int what = 0;
        //先查询出用户名和密码是否匹配 才能更改密码
        String sql = "select count(*) from user where userName=? and userPhone=?";
        int num = jdbcTemplate.queryForObject(sql, new Object[]{userName, userPhone}, Integer.class);
        if (num > 0) {
            //UPDATE user set `newpassWord`="111" where userName="admin";
            //此用户存在  并且密码匹配 可以进行修改密码
            String update = "update user set userPhone=? where userName=?";
            what = jdbcTemplate.update(update, newuserPhone, userName);
        } else {
            return what;
        }
        return what;
    }


    public int Update_login_payPassword(String userName, String paypassword, String newpaypassword) {
        int what = 0;
        //先查询出用户名和密码是否匹配 才能更改密码
        String sql = "select count(*) from user where userName=? and userPaypassword=?";
        int num = jdbcTemplate.queryForObject(sql, new Object[]{userName, paypassword}, Integer.class);
        if (num > 0) {
            //UPDATE user set `newpassWord`="111" where userName="admin";
            //此用户存在  并且密码匹配 可以进行修改密码
            String update = "update user set userPaypassword=? where userName=?";
            what = jdbcTemplate.update(update, newpaypassword, userName);
        } else {
            return what;
        }
        return what;
    }

    public int Update_login_hand(String userName, String userHand) {

            //UPDATE user set `newpassWord`="111" where userName="admin";
            //此用户存在  并且密码匹配 可以进行修改密码
            String update = "update user set userHand=? where userName=?";
            return jdbcTemplate.update(update, userHand,userName);
    }

    public int Update_user(UserEntity user) {

        String sql = "update  user set userName = ? , userMingzi = ? ,usersex = ? , passWord = ? , userAddress = ? ,userPhone = ? , userQQ = ? , userEmial = ?   where userID = ?";
        return jdbcTemplate.update(sql, user.getUserName(), user.getUserMingzi(), user.getUsersex(), user.getPassWord(), user.getUserAddress(), user.getUserPhone(), user.getUserQQ(), user.getUserEmial(), user.getUserID());
    }

    public int Update_Addred(String sessionName, String dizhi, String xingming, String phone) {
        //此用户存在  并且密码匹配 可以进行修改密码
        String update = "update user set userMingzi=?,userPhone=?,userAddress=? where userName=?";
        return jdbcTemplate.update(update, xingming, phone, dizhi, sessionName);
    }

    public int delectcartID(String cartID) {
        String sql = "delete from shoppingcart where cartID = ?";
        return jdbcTemplate.update(sql, cartID);
    }


    public int Update_BankCard(String sessionName, String useryinhangka, String useryinhangming, String kaihuhangdizhi, String huzhuxingming) {
        String sql = "update user set useryinhangming=?,huzhuxingming=?,useryinhangka=?,kaihuhangdizhi=? where userName=?";
        return jdbcTemplate.update(sql, useryinhangka, useryinhangming, kaihuhangdizhi, huzhuxingming, sessionName);
    }


    public int Updateyue(String sessionNmae, String userRMB) {
        String sql = "update user set userRMB=? where userName=?";
        return jdbcTemplate.update(sql, userRMB, sessionNmae);
    }


}
