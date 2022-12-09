package com.sf.service;

import com.sf.entity.*;

import java.util.List;

public interface UserListService {

    /**
     * 根据用户的名字 查询出用户的所有信息
     *
     * @return
     */
    public UserEntity userlist(String userName);

    /**
     * 将video 全部信息全部查询出来
     */
    public List<UserEntity> userlistUserName(String userName);


    /**
     * 根据ID查询出此条论坛的全部信息
     *
     * @param forumID
     * @return
     */
    public ForumEntity forumentitymmp(String forumID);

    /**
     * 根据ID查询出当前视频的所有留言
     *
     * @return
     */
    public List<ForumreplyEntity> forumreply(String forumreplyID);

    /**
     * 将video 全部信息全部查询出来
     */
    public List<VideoEntity> videolist(String videocAtegory);


    /**
     * 随机在video 里面查询出5条记录
     *
     * @return
     */
    public List<VideoEntity> videolistimit7();

    /**
     * 随机在video 里面查询出6条记录
     *
     * @return
     */
    public List<VideoEntity> videolistimit6MAD();


    /**
     * 随机在video 里面查询出5条记录
     *
     * @return
     */
    public List<VideoEntity> videolistimit5MAD();


    /**
     * 根据ID查询出当前视频的所有留言
     *
     * @return
     */
    public List<MessageEntity> messagelist(String videoID);


    /**
     * 将用户表里面所有的用户只查询出15条. 到时候方便分页
     *
     * @return
     */
    public List<UserEntity> userlistpage(int pageInt);


    /**
     * 根据用户输入的内容 进行模糊查询出所得
     *
     * @return
     */
    public List<UserEntity> listmohu(String usermohu);


    /**
     * 根据用户输入的手机号 进行模糊查询出所得
     *
     * @return
     */
    public List<UserEntity> userPhone(String userPhone);


    /**
     * 根据ID查询出用户的所有信息
     *
     * @return
     */
    public List<UserEntity> userID(String userID);

    /**
     * 根据用户的状态 查询出用户的所有信息
     *
     * @return
     */
    public List<UserEntity> xiaoheiwu(String userStat);


    public List<VideoEntity> Pagevideolist(int pageNo, int pageSize);


    /**
     * 将商品全部信息查询出来
     *
     * @return
     */
    public List<GridsEntity> gridslist();


    /**
     * 根据商品ID查询出商品信息
     *
     * @param gridsID
     * @return
     */
    public GridsEntity gridsIDlist(String gridsID);


    /**
     * 根据登录的用户名 查询出购物车里面的商品
     *
     * @param userName
     * @return
     */
    public List<ShoppingCart> shoppingcart(String userName);


    /**
     * 根据用户名查询出所有的订单
     */
    public List<OrdertableEntity> ordertable(String userName);


    /**
     * 查询出所有的订单
     */
    public List<OrdertableEntity> ordertablelist();


    /**
     * 查询出标记的订单
     */
    public List<OrdertableEntity> orderStat(String orderStat);


    /**
     * 查询出订单表里面有多少条记录
     *
     * @return
     */
    public int countordertable();


    /**
     * 根据论坛类型查询出符合条件的论坛
     *
     * @param forumliebie
     * @return
     */
    public List<ForumEntity> forumEnt(String forumliebie);


    /**
     * 根据表名查询出有多少记录
     *
     * @param
     * @return
     */
    public int counttable();

    void findPageNews(Page pageObj);
}
