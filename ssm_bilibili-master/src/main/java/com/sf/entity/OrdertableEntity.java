package com.sf.entity;


//订单实体表
public class OrdertableEntity {
	
	
	/*		
	订单状态:
		1      为: 代发货
		2      为: 已发货
		3      为: 退货中
		4      为: 订单取消*/


    private String orderID;//订单ID
    private String orderuserName;//订单人名字
    private String orderIgridsName;//订单商品名字
    private String ordergridsImg;//订单商品图片
    private String orderzongRMB;//订单总价格
    private String orderStat;//订单状态
    private String orderTime;//订单时间
    private String orderAddr;//订单收货地址

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderuserName() {
        return orderuserName;
    }

    public void setOrderuserName(String orderuserName) {
        this.orderuserName = orderuserName;
    }

    public String getOrderIgridsName() {
        return orderIgridsName;
    }

    public void setOrderIgridsName(String orderIgridsName) {
        this.orderIgridsName = orderIgridsName;
    }

    public String getOrdergridsImg() {
        return ordergridsImg;
    }

    public void setOrdergridsImg(String ordergridsImg) {
        this.ordergridsImg = ordergridsImg;
    }

    public String getOrderzongRMB() {
        return orderzongRMB;
    }

    public void setOrderzongRMB(String orderzongRMB) {
        this.orderzongRMB = orderzongRMB;
    }

    public String getOrderStat() {
        return orderStat;
    }

    public void setOrderStat(String orderStat) {
        this.orderStat = orderStat;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderAddr() {
        return orderAddr;
    }

    public void setOrderAddr(String orderAddr) {
        this.orderAddr = orderAddr;
    }


}
