package com.sf.dao.impl;

import com.sf.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.sf.dao.MessageDao;

@Component
public class MessageImpl implements MessageDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;//得到模板
	
	//添加留言
	public int message(MessageEntity message) {
		String sql="insert into message(messageID,messagevideoID,messageuserID,messageuserName,message,messageTime,messageHand) values(?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, message.getMessageID(), message.getMessagevideoID(),message.getMessageuserID(),message.getMessageuserName(), message.getMessage(),message.getMessageTime(),message.getMessageHand());
	}

	//添加商品
	public int Shoppingcart(ShoppingCart shoppingCart) {
		String sql = "insert into shoppingcart(cartID,userName,shoopingID,shoopingName,shoopingImg,shoopingjiage) values (?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, shoppingCart.getCartID(),shoppingCart.getUserName(),shoppingCart.getShoopingID(),shoppingCart.getShoopingName(),shoppingCart.getShoopingImg(),shoppingCart.getShoopingjiage());
	}

	//添加论坛帖子
	public int forumadd(ForumEntity forument) {
		String sql = "insert into forum(forumID,forumBT,forummessage,forumuserName,forumTime,forumliebie,forumAmount,firumhand) values (?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, forument.getForumID(),forument.getForumBT(),forument.getForummessage(),forument.getForumuserName(),forument.getForumTime(),forument.getForumliebie(),forument.getForumAmount(),forument.getFirumhand());
	}


	//
	public int forumreply(ForumreplyEntity forumreply) {/*
		public String replyid;//回复ID
		public String replyneirong;//回帖内容
		public String replytime;//回帖时间
		public String replyhand;//回帖人头像
		public String replytieziid;//回复帖子的ID
		*/
		String sql = "insert into forumreply (replyid,replyneirong,replytime,replyhand,replytieziid,replyname) values (?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, forumreply.getReplyid(),forumreply.getReplyneirong(),forumreply.getReplytime(),forumreply.getReplyhand(),forumreply.getReplytieziid(),forumreply.getReplyname());
	}

	public int addvideo(VideoEntity video) {
		String sql="insert into video(videoID, videoName,  videoImage,videoAddress, videoCollection,videoLeaving,videolooktime,athuor, videoTime, videoState, videocAtegory) values(?,?,?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql,video.getVideoID(),video.getVideoName(),video.getVideoImage(),video.getVideoAddress(),video.getVideoCollection(),video.getVideoLeaving(),video.getVideolookTime(),video.getAthuor(),video.getVideoTime(),video.getVideoState(),video.getVideocAtegory());
	}



}
