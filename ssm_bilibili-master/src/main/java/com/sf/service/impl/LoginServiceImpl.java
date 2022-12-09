package com.sf.service.impl;

import com.sf.dao.impl.LoginDaoimpl;
import com.sf.entity.OrdertableEntity;
import com.sf.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//对应服务层，主要设计一些复杂的逻辑，需要用到 Dao 层
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginDaoimpl loginService;

    //验证登录
    public boolean loginuser(String userName, String passWord) {
        int num = loginService.login(userName, passWord);
        if (num > 0) {
            return true;
        }
        return false;
    }

    //确认支付密码是否正确
    public boolean paypassword(String userName, String pass) {
        int num = loginService.paypassword(userName, pass);
        if (num > 0) {
            return true;
        }
        return false;
    }

    //修改余额
    public boolean updateRMB(String userRMB, String userName) {
        int num = loginService.updateRMB(userRMB, userName);
        if (num > 0) {
            return true;
        }
        return false;
    }

    //下单
    public boolean ordertable(OrdertableEntity ordertable) {
        int num = loginService.ordertable(ordertable);
        if (num > 0) {
            return true;
        }
        return false;
    }

    public boolean Confirmorder(String orderID) {
        int num = loginService.Confirmorder(orderID);
        if (num > 0) {
            return true;
        }
        return false;
    }

    public boolean Cancellationoforder(String orderID) {
        int num = loginService.Cancellationoforder(orderID);
        if (num > 0) {
            return true;
        }
        return false;
    }

    public boolean delordertable(String orderID) {
        int num = loginService.delordertable(orderID);
        if (num > 0) {
            return true;
        }
        return false;
    }

    public boolean Delivergoods(String OrderStat, String orderID) {
        int num = loginService.Delivergoods(OrderStat, orderID);
        if (num > 0) {
            return true;
        }
        return false;
    }

}
