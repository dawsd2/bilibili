package com.sf.tool;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sf.entity.UserEntity;


//用户表
public class RowMapperEntity implements RowMapper<UserEntity>{

	public UserEntity mapRow(ResultSet arg0, int arg1) throws SQLException {
		UserEntity user=new UserEntity();
		
		user.setPassWord(arg0.getString("passWord"));
		user.setUsersex(arg0.getString("usersex"));
		user.setUserAddress(arg0.getString("userAddress"));
		user.setUserEmial(arg0.getString("userEmial"));
		user.setUserHand(arg0.getString("userHand"));
		user.setUserID(arg0.getString("userID"));
		user.setUserMingzi(arg0.getString("userMingzi"));
		user.setUserName(arg0.getString("userName"));
		user.setUserPaypassword(arg0.getString("userPaypassword"));
		user.setUserPhone(arg0.getString("userPhone"));
		user.setUserQQ(arg0.getString("userQQ"));
		user.setUserState(arg0.getString("userState"));
		user.setUseryinhangka(arg0.getString("useryinhangka"));
		user.setUserRMB(arg0.getString("userRMB"));
		user.setHuzhuxingming(arg0.getString("huzhuxingming"));
		user.setKaihuhangdizhi(arg0.getString("kaihuhangdizhi"));
		user.setUseryinhangming(arg0.getString("useryinhangming"));
		return user;
	}

	
	
}
