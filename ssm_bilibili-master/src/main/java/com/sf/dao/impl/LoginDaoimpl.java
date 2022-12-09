package com.sf.dao.impl;

import com.sf.dao.LoginDao;
import com.sf.entity.OrdertableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
//通用的注解，可标注任意类为 Spring 的组件。如果一个 Bean 不知道属于哪个层，可以使用 @Component 注解标注。
//实例化到spring容器当中
@Component
public class LoginDaoimpl implements LoginDao {

    @Autowired
    JdbcTemplate jdbcTemplate;//引入Jdbc模板资源
        //Spring对jdbc的封装的模板
    //登录
    public int login(String userName, String passWord) {
        String sql = "select count(*) from user where userName = ? and passWord = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userName, passWord}, Integer.class);
    }

    //确认支付密码是否正确
    public int paypassword(String userName, String pass) {
        String sql = "select count(*) from user where userName=? and userPaypassword=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userName, pass}, Integer.class);
    }

    //修改余额
    public int updateRMB(String userRMB, String userName) {
        String update = "update user set userRMB=? where userName=?";
        return jdbcTemplate.update(update, userRMB, userName);
    }

    //下单
    public int ordertable(OrdertableEntity ordertable) {
        String sql = "insert into ordertable (OrderID,OrderuserName,OrderIgridsName,OrdergridsImg,OrderzongRMB,OrderStat,OrderTime,OrderAddr) values(?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, ordertable.getOrderID(), ordertable.getOrderuserName(), ordertable.getOrderIgridsName(), ordertable.getOrdergridsImg(), ordertable.getOrderzongRMB(), ordertable.getOrderStat(), ordertable.getOrderTime(), ordertable.getOrderAddr());
    }

    //更改订单状态
    public int Confirmorder(String orderID) {
        int b = 0;
        //根据ID查询出是否存在这个订单 是否为发货状态
        String sql = "select count(*) from ordertable where OrderID = ? and OrderStat = 2";//是否有这个商品 并且是待发货状态
        int num = jdbcTemplate.queryForObject(sql, new Object[]{orderID}, Integer.class);
        if (num > 0) {
            //有此订单.. 待发货状态
            String sql2 = "update  ordertable set OrderStat=4 where OrderID=?";//更改为收货
            b = jdbcTemplate.update(sql2, orderID);
        } else {
            b = 0;//查不到此订单
        }
        return b;
    }

    public int Cancellationoforder(String orderID) {
        String sql2 = "update  ordertable set OrderStat=3 where OrderID=?";//更改为待取消订单
        return jdbcTemplate.update(sql2, orderID);
    }

    public int delordertable(String orderID) {
        String sql2 = "update  ordertable set OrderStat=5 where OrderID=?";//更改为待取消订单
        return jdbcTemplate.update(sql2, orderID);
    }

    public int Delivergoods(String OrderStat, String orderID) {
        String sql2 = "update  ordertable set OrderStat=? where OrderID=?";//立即发货
        return jdbcTemplate.update(sql2, OrderStat, orderID);
    }

}
