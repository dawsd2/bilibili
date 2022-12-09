package com.sf.service.impl;

import com.sf.dao.impl.Update_login_password_Impl;
import com.sf.entity.UserEntity;
import com.sf.service.Update_login_password_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Update_login_password_Service_Impl implements Update_login_password_Service {

    @Autowired
    Update_login_password_Impl update_login_password_Impl;

    public boolean Update_login_password(String userName, String passWord, String newpassWord) {
        int num = update_login_password_Impl.Update_login_password(userName, passWord, newpassWord);
        if (num > 0) {
            return true;
        }
        return false;
    }

    public boolean Update_login_Emial(String userName, String emial, String newemial) {

        int num = update_login_password_Impl.Update_login_Emial(userName, emial, newemial);
        if (num > 0) {
            return true;
        }
        return false;
    }

    public boolean Update_login_Phone(String userName, String userPhone, String newuserPhone) {
        int num = update_login_password_Impl.Update_login_Phone(userName, userPhone, newuserPhone);
        if (num > 0) {
            return true;
        }
        return false;
    }

    public boolean Update_login_payPassword(String userName, String paypassword, String newpaypassword) {
        int num = update_login_password_Impl.Update_login_payPassword(userName, paypassword, newpaypassword);
        if (num > 0) {
            return true;
        }
        return false;
    }

    public boolean Update_login_hand(String userName, String userHand) {
        int num = update_login_password_Impl.Update_login_hand(userName, userHand);
        if (num > 0) {
            return true;
        }
        return false;
    }

    public boolean Update_user(UserEntity user) {
        int num = update_login_password_Impl.Update_user(user);
        if (num > 0) {
            return true;
        }
        return false;
    }

    public boolean Update_Addred(String sessionName, String dizhi, String xingming, String phone) {
        int i = update_login_password_Impl.Update_Addred(sessionName, dizhi, xingming, phone);
        if (i > 0) {
            return true;
        }
        return false;
    }

    public boolean delectcartID(String cartID) {
        int num = update_login_password_Impl.delectcartID(cartID);
        if (num > 0) {
            return true;
        }
        return false;
    }

    public boolean Update_BankCard(String sessionName, String useryinhangka, String useryinhangming, String kaihuhangdizhi, String huzhuxingming) {
        int num = update_login_password_Impl.Update_BankCard(sessionName, useryinhangka, useryinhangming, kaihuhangdizhi, huzhuxingming);
        if (num > 0) {
            return true;
        }
        return false;
    }

    public boolean Update_yue(String sessionNmae, String userRMB) {
        int num = update_login_password_Impl.Updateyue(sessionNmae, userRMB);
        if (num > 0) {
            return true;
        }
        return false;
    }
}
