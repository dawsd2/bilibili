package com.sf.service.impl;

import com.sf.dao.impl.UserListDaoImpl;
import com.sf.entity.*;
import com.sf.service.UserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserListServiceImpl implements UserListService {

    @Autowired
    UserListDaoImpl userListDaoImpl;

    public UserEntity userlist(String userName) {
        return userListDaoImpl.userlist(userName);
    }

    public List<VideoEntity> videolist(String videocAtegory) {
        return userListDaoImpl.videolist(videocAtegory);
    }

    public List<VideoEntity> videolistimit7() {
        return userListDaoImpl.videolistimit7();
    }

    public List<VideoEntity> videolistimit5MAD() {
        return userListDaoImpl.videolistimit5MAD();
    }

    public List<MessageEntity> messagelist(String videoID) {
        return userListDaoImpl.messagelist(videoID);
    }

    public List<UserEntity> userlistpage(int pageInt) {
        return userListDaoImpl.userlistpage(pageInt);
    }

    public List<UserEntity> listmohu(String usermohu) {
        return userListDaoImpl.listmohu(usermohu);
    }

    public List<UserEntity> userPhone(String userPhone) {
        return userListDaoImpl.userPhone(userPhone);
    }

    public List<UserEntity> userID(String userID) {
        return userListDaoImpl.userID(userID);
    }

    public List<UserEntity> xiaoheiwu(String userStat) {
        return userListDaoImpl.xiaoheiwu(userStat);
    }


    public List<VideoEntity> Pagevideolist(int pageNo, int pageSize) {
        return userListDaoImpl.Pagevideolist(pageNo, pageSize);
    }

    public List<GridsEntity> gridslist() {
        return userListDaoImpl.gridslist();
    }

    public int videocoun() {
        return userListDaoImpl.videocoun();
    }

    public GridsEntity gridsIDlist(String gridsID) {
        return userListDaoImpl.gridsIDlist(gridsID);
    }

    public List<UserEntity> userlistUserName(String userName) {
        return userListDaoImpl.userlistUserName(userName);
    }

    public List<ShoppingCart> shoppingcart(String userName) {
        return userListDaoImpl.shoppingcart(userName);
    }

    public List<VideoEntity> videolistimit6MAD() {
        return userListDaoImpl.videolistimit6MAD();
    }

    public List<OrdertableEntity> ordertable(String userName) {
        return userListDaoImpl.ordertable(userName);
    }

    public List<OrdertableEntity> ordertablelist() {
        return userListDaoImpl.ordertablelist();
    }

    public List<OrdertableEntity> orderStat(String orderStat) {
        return userListDaoImpl.orderStat(orderStat);
    }

    public int countordertable() {
        return userListDaoImpl.countordertable();
    }

    public List<ForumEntity> forumEnt(String forumliebie) {
        return userListDaoImpl.forumEnt(forumliebie);
    }

    public ForumEntity forumentitymmp(String forumID) {
        return userListDaoImpl.forumentitymmp(forumID);
    }

    public int counttable() {
        return userListDaoImpl.counttable();
    }

    public int countfroum() {
        return userListDaoImpl.countfroum();
    }

    public int todayfroum() {
        return userListDaoImpl.todayfroum();
    }

    public int zuotianfroum() {
        return userListDaoImpl.zuotianfroum();
    }

    public int qitianfroum() {
        return userListDaoImpl.qitianfroum();
    }

    public void findPageNews(Page pageObj) {
        int totalCount = userListDaoImpl.videocoun();
        pageObj.setTotalCount(totalCount); // 设置总数量并计算总页数
        if (totalCount > 0) {
            if (pageObj.getCurrPageNo() > pageObj.getTotalPageCount())
                pageObj.setCurrPageNo(pageObj.getTotalPageCount());
            List<VideoEntity> newsList = userListDaoImpl.Pagevideolist(pageObj.getCurrPageNo(), pageObj.getPageSize());
            pageObj.setNewsList(newsList);
        } else {
            pageObj.setCurrPageNo(0);
            pageObj.setNewsList(new ArrayList<VideoEntity>());
        }
    }

    public List<ForumreplyEntity> forumreply(String forumreplyID) {
        return userListDaoImpl.forumreply(forumreplyID);
    }

    public List<VideoTopicEntity> getAlltopiclist() {
        return userListDaoImpl.getAlltopiclist();
    }

    public List<VideoEntity> findAllVideoByTid(int tid) {
        return userListDaoImpl.getVideoByTid(tid);
    }


}
