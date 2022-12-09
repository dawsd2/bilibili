package com.sf.dao;

import com.sf.entity.*;

public interface MessageDao {
	/**
	 * 	直接保存用户留言信息到留言表
	 * @param message
	 * @return
	 */
	public int message(MessageEntity message);
	
	
	
	public int Shoppingcart(ShoppingCart shoppingCart);
	
	
	/**
	 * 直接保存论坛帖子
	 * @param forument
	 * @return
	 */
	public int forumadd(ForumEntity forument);
	
	/**
	 * 直接保存回复的帖子内容
	 * @param
	 * @return
	 */
	public int forumreply(ForumreplyEntity forumreply);

	int addvideo(VideoEntity video);
}
