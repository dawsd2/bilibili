package com.sf.entity;

//商品实体表
public class ShoppingCart {
    private String cartID; //购物车ID
    private String userName;//购物人名字(账号)
    private String shoopingID;//商品ID
    private String shoopingName;//商品名字
    private String shoopingImg;//商品图片地址
    private String shoopingjiage;//商品价格

    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getShoopingID() {
        return shoopingID;
    }

    public void setShoopingID(String shoopingID) {
        this.shoopingID = shoopingID;
    }

    public String getShoopingName() {
        return shoopingName;
    }

    public void setShoopingName(String shoopingName) {
        this.shoopingName = shoopingName;
    }

    public String getShoopingImg() {
        return shoopingImg;
    }

    public void setShoopingImg(String shoopingImg) {
        this.shoopingImg = shoopingImg;
    }

    public String getShoopingjiage() {
        return shoopingjiage;
    }

    public void setShoopingjiage(String shoopingjiage) {
        this.shoopingjiage = shoopingjiage;
    }


}
