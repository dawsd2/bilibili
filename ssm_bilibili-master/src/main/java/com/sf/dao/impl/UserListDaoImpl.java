package com.sf.dao.impl;


import com.sf.dao.UserListDao;
import com.sf.entity.*;
import com.sf.tool.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserListDaoImpl implements UserListDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public UserEntity userlist(String userName) {
        //根据名字查询出用户对象. - -
        String sql = "select * from user where userName=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userName}, new RowMapperEntity());
    }


    public List<VideoEntity> videolist(String videocAtegory) {
        //将全部视频查询出来
        String sql = "select * from video where videocAtegory=? order by rand() limit 8";//将视频标记为1的正常视频全部查询出

        return jdbcTemplate.query(sql, new Object[]{videocAtegory}, new VideoRowMapperEntity());
    }


    //SELECT * from video ORDER BY RAND() LIMIT 5;随机在数据库里面查询出5条记录

    public List<VideoEntity> videolistimit7() {
        String sql = "select * from video order by rand() limit 7";

        return jdbcTemplate.query(sql, new Object[]{}, new VideoRowMapperEntity());
    }


    public List<VideoEntity> videolistimit5MAD() {
        String sql = "select * from video order by rand() limit 5 ";

        return jdbcTemplate.query(sql, new Object[]{}, new VideoRowMapperEntity());
    }


    public List<MessageEntity> messagelist(String videoID) {
        List<MessageEntity> list = null;
        //根据用户传过来的ID 查询出当前视频的所有留言
        //根据名字查询出用户对象. - -
        String sql = "select * from message WHERE messagevideoID=? order by STR_TO_DATE(messageTime,'%m/%d/%Y %h:%i:%s %p') desc";
        //select * from message WHERE messagevideoID="1" order by STR_TO_DATE(messageTime,'%m/%d/%Y %h:%i:%s %p') desc;
        list = jdbcTemplate.query(sql, new Object[]{videoID}, new RowMapperVideoEntity());
        //将查询出来的所有结果全部放入到list集合当中
        return list;

    }


    public List<UserEntity> userlistpage(int pageInt) {
        List<UserEntity> user = null;
		/*limit arg1,arg2 arg1指定查询记录的起始位置；arg2用于指定查询数据所返回的记录数
		select * from tablename limit 0,1
		即取出第一条记录。
		select * from tablename limit 1,1
		第二条记录
		select * from tablename limit 10,20
		从第11条到31条（共计20条）
		select * from tablename limit 0,2
		取出2条数据 第一条和第二条
		这个 limit 是实现分页的关键，每次取出数据库的内容，分页在页面上怎么去操作实现的，这好像很麻烦，要是每次数据库取出特定页的数据就好了，limit 实现这样的功能，对数据升序或降序排序后，利用 SQL 取出特定页的数据，直接显示就行了

		比如数据库返回的数据是
		*/

        String sql = "SELECT * FROM user LIMIT ?,15";
        user = jdbcTemplate.query(sql, new Object[]{pageInt}, new RowMapperEntity());
        return user;
    }


    public List<UserEntity> listmohu(String usermohu) {
        //SELECT * FROM user where userMingzi LIKE '%爱仕达%';
        //模糊查询 根据输入的名字查询
        String sql = "select * from user where userMingzi LIKE ?";
        return jdbcTemplate.query(sql, new Object[]{usermohu}, new RowMapperEntity());
    }


    public List<UserEntity> userPhone(String userPhone) {
        //模糊查询 根据输入的名字查询
        String sql = "select * from user where userPhone LIKE ? order by rand() limit 3";
        return jdbcTemplate.query(sql, new Object[]{userPhone}, new RowMapperEntity());
    }


    public List<UserEntity> userID(String userID) {
        String sql = "select * from user where userID=?";
        return jdbcTemplate.query(sql, new Object[]{userID}, new RowMapperEntity());
    }


    public List<UserEntity> xiaoheiwu(String userStat) {
        //根据名字查询出用户对象. - -
        String sql = "select * from user where userState=?";
        //System.out.println("进来了");
        return jdbcTemplate.query(sql, new Object[]{userStat}, new RowMapperEntity());
    }


    public List<VideoEntity> Pagevideolist(int pageNo, int pageSize) {
        //SELECT * FROM video WHERE videoID<=5 LIMIT 0,6
        String sql = "SELECT * FROM video,videotopic where video.videocAtegory = videotopic.videoid order by videoState LIMIT ?,?";
        return jdbcTemplate.query(sql, new Object[]{pageNo, pageSize}, new VideoRowMapperEntity());
    }


    public int videocoun() {
        //根据标记查询出对应的条数
        String sql = "select count(*) from video";// where videocAtegory = ?
        return jdbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
    }


    public List<GridsEntity> gridslist() {
        String sql = "select * from grids";
        return jdbcTemplate.query(sql, new GridsRowMapperEntity());
    }


    public GridsEntity gridsIDlist(String gridsID) {
        String sql = "select * from grids where gridsID = ?";
        return (GridsEntity) jdbcTemplate.queryForObject(sql, new Object[]{gridsID}, new GridsRowMapperEntity());
    }


    public List<UserEntity> userlistUserName(String userName) {
        //根据名字查询出用户对象. - -
        String sql = "select * from user where userName=?";
        return jdbcTemplate.query(sql, new Object[]{userName}, new RowMapperEntity());
    }


    public List<ShoppingCart> shoppingcart(String userName) {
        String sql = "select * from shoppingcart where userName = ?";
        return jdbcTemplate.query(sql, new Object[]{userName}, new ShoppingCartRowMapperEntity());
    }


    public List<VideoEntity> videolistimit6MAD() {
        String sql = "select * from video order by rand() limit 6";
        return jdbcTemplate.query(sql, new Object[]{}, new VideoRowMapperEntity());
    }


    public List<OrdertableEntity> ordertable(String userName) {
        String sql = "select * from ordertable where OrderuserName=?";
        return jdbcTemplate.query(sql, new Object[]{userName}, new ordertableRowMapperEntity());
    }


    public List<OrdertableEntity> ordertablelist() {
        String sql = "select * from ordertable";
        return jdbcTemplate.query(sql, new Object[]{}, new ordertableRowMapperEntity());
    }


    public List<OrdertableEntity> orderStat(String orderStat) {
        String sql = "select * from ordertable where orderStat = ?";
        return jdbcTemplate.query(sql, new Object[]{orderStat}, new ordertableRowMapperEntity());
    }


    public int countordertable() {
        String sql = "SELECT count(*) FROM ordertable";
        return jdbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
    }


    public List<ForumEntity> forumEnt(String forumliebie) {
        //select * from forum where forumliebie = "1" Order By forumTime Desc
        String sql = "select * from forum where forumliebie = ? Order By forumTime Desc";
        //将查询出来的全部信息保存的List当中
        return jdbcTemplate.query(sql, new Object[]{forumliebie}, new forumEntityRowMapper());
    }


    public ForumEntity forumentitymmp(String forumID) {
        //根ID查询出帖子内容
        String sql = "select * from forum where forumID=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{forumID}, new forumEntityRowMapper());
    }


    public int counttable() {
        String sql = "SELECT count(*) FROM user";
        return jdbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
    }

    public int countfroum() {
        String sql = "SELECT count(*) FROM forum";
        return jdbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
    }

    public int todayfroum() {
        String sql = "SELECT count(*) from forum where TO_DAYS(NOW()) - TO_DAYS(forumTime) <=1";
        return jdbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
    }

    public int zuotianfroum() {
        String sql = "SELECT count(*) from forum where DATEDIFF(forumTime,NOW())=-1";
        return jdbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
    }

    public List<VideoTopicEntity> getAlltopiclist() {
        String sql = "SELECT * FROM Videotopic";
        return jdbcTemplate.query(sql, new Object[]{}, new TopidEntity());
    }

    public int qitianfroum() {
        String sql = "SELECT count(*) from forum where DATE_SUB(CURDATE(),INTERVAL 7 DAY) <=(forumTime)";
        return jdbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
    }


    public List<ForumreplyEntity> forumreply(String forumreplyID) {
        //select * from forum where forumliebie = "1" Order By forumTime Desc
        String sql = "select * from forumreply where replytieziid = ? Order By replytime Desc";
        //将查询出来的全部信息保存的List当中
        return jdbcTemplate.query(sql, new Object[]{forumreplyID}, new forumreplyEntityRowMapper());
    }


    public List<VideoEntity> getVideoByTid(int tid) {
        String sql = "select * from video where videocAtegory = ? order by videoState DESC ";
        return jdbcTemplate.query(sql, new Object[]{tid}, new VideoRowMapperEntity());
    }
}
