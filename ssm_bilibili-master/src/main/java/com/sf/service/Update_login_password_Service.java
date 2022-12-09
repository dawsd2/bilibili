package com.sf.service;

import com.sf.entity.UserEntity;

public interface Update_login_password_Service {

    public boolean Update_login_password(String userName, String passWord, String newpassWord);


    public boolean Update_login_Emial(String userName, String emial, String newemial);


    public boolean Update_login_Phone(String userName, String userPhone, String newuserPhone);


    public boolean Update_login_payPassword(String userName, String paypassword, String newpaypassword);


    public boolean Update_login_hand(String userName, String userHand);


    /**
     * 修改用户的全部信息
     *
     * @param user
     * @return
     */
    public boolean Update_user(UserEntity user);


    public boolean Update_Addred(String sessionName, String dizhi, String xingming, String phone);


    /**
     * 根据ID删除对应的购物车
     *
     * @param cartID
     * @return
     */
    public boolean delectcartID(String cartID);

    public boolean Update_BankCard(String sessionName, String useryinghangka, String useryinhangming, String kaihuhangdizhi, String huzhuxingming);
}
