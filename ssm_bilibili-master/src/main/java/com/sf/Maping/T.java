package com.sf.Maping;

import com.google.gson.Gson;
import com.sf.entity.*;
import com.sf.service.MessageService;
import com.sf.service.UserListService;
import com.sf.service.impl.MessageServiceImpl;
import com.sf.service.impl.Update_login_password_Service_Impl;
import com.sf.service.impl.UserListServiceImpl;
import com.sf.tool.GetDataTime;
import com.sf.tool.GetUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ws.schild.jave.MultimediaInfo;
import ws.schild.jave.MultimediaObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

//对应 Spring MVC 控制层，主要用来接受用户请求并调用 Service 层返回数据给前端页面。
@Controller
public class T {
    public static int a = 0;
    @Autowired
    UserListService userListService;
    @Autowired
    MessageServiceImpl messageServiceImpl;
    @Autowired
    Update_login_password_Service_Impl update_login_password_Service_Impl;
    @Autowired
    UserListServiceImpl userListServiceImpl;
    @Autowired
    MessageService messageService;

    public static String ReadVideoTime(String FileUrl) {
        File source = new File(FileUrl);
        String length = "";
        try {
            MultimediaObject instance = new MultimediaObject(source);
            MultimediaInfo result = instance.getInfo();
            long ls = result.getDuration() / 1000;
            Integer hour = (int) (ls / 3600);
            Integer minute = (int) (ls % 3600) / 60;
            Integer second = (int) (ls - hour * 3600 - minute * 60);
            String hr = hour.toString();
            String mi = minute.toString();
            String se = second.toString();
            if (hr.length() < 2) {
                hr = "0" + hr;
            }

            if (mi.length() < 2) {
                mi = "0" + mi;
            }

            if (se.length() < 2) {
                se = "0" + se;
            }

            length = hr + ":" + mi + ":" + se;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return length;
    }

    @RequestMapping("index.sf")
    public String test() {
        return "forward:/logoone.sf";
    }

    // 将数据库里面所有的视频查询出来 发送到首页面
    @RequestMapping("logoone.sf")
    public ModelAndView logoone(HttpServletRequest request, HttpServletResponse response) {
        List<VideoEntity> list = userListServiceImpl.videolist("1");// 1 为动画
        Map model = new HashMap();
        model.put("list", list);
        List<VideoEntity> list2 = userListServiceImpl.videolist("2");// 2
        model.put("list2", list2);
        List<VideoEntity> list3 = userListServiceImpl.videolist("3");// 3
        model.put("list3", list3);
        // 随机查6条数据出来
        List<VideoEntity> vvlist = userListServiceImpl.videolistimit6MAD();
        model.put("vvlist", vvlist);
        return new ModelAndView("index", model);

    }

    // AJAX 提交
    @RequestMapping(value = "ajaxTuiJian", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody void ajaxTuiJian(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<VideoEntity> list = userListServiceImpl.videolistimit7();
        // 设置编码
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String sbb = gson.toJson(list);
        out.write(sbb);
    }

    // AJAX 提交
    @RequestMapping(value = "ajaxTuiJian2", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody void webajax2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<VideoEntity> list = userListServiceImpl.videolistimit5MAD();

        // 设置编码
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String sbb = gson.toJson(list);
        out.write(sbb);
    }

    @RequestMapping(value = "querendingdan1.sf", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody void querendingdan(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String userName = (String) request.getSession().getAttribute("userName");
        List<UserEntity> user = userListServiceImpl.userlistUserName(userName);
        // user.getUserID();
        // 设置编码
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String sbb = gson.toJson(user);
        out.write(sbb);
    }

    @RequestMapping("zhuce.sf")
    public String zhuce(HttpServletRequest request) {
        // 随机生成一个4位数验证码
        int num = GetUUID.yanzma();
        // 将int 转换为 String
        String yanzheng = "";
        yanzheng = String.valueOf(num);
        // 将验证码放入到session里面....暂时想不到其他办法
        request.getSession().setAttribute("yanzhengma", yanzheng);
        return "zhuce";

    }

    @RequestMapping("login.sf")
    public String login() {
        return "loginnew";

    }

    // 信息修改界面
    @RequestMapping("User_full_information.sf")
    public ModelAndView User_full_information(HttpServletRequest request) {
        // 得到登录用户的名字
        String userName = (String) request.getSession().getAttribute("userName");
        UserEntity user = userListServiceImpl.userlist(userName);
        Map model = new HashMap();
        model.put("user", user);
        return new ModelAndView("User_full_information", model);

    }

    // 修改登录密码界面
    @RequestMapping("Update_login_password.sf")
    public String Update_login_password(String passWord, String newpassWord, String newpassWord2,
                                        HttpServletRequest request) {
        String userName = (String) request.getSession().getAttribute("userName");
        if (passWord != null || newpassWord != null || newpassWord2 != null) {
            if (Objects.equals(newpassWord, newpassWord2)) {
                boolean bl = update_login_password_Service_Impl.Update_login_password(userName, passWord, newpassWord);
                if (bl) {
                    return "User_full_information";
                } else {
                    request.setAttribute("PassWordErro", "对不起,旧密码输入有误!");
                }
            } else {
                request.setAttribute("PassWordErro", "两次密码输入有误!");
            }
        }
        return "Update_login_password";

    }

    // 修改邮箱界面
    @RequestMapping("Update_email.sf")
    public String Update_email(HttpServletRequest request, String emial, String newemial) {
        String userName = (String) request.getSession().getAttribute("userName");
        if (userName != null || emial != null || newemial != null) {
            boolean bl = update_login_password_Service_Impl.Update_login_Emial(userName, emial, newemial);
            if (bl) {
                return "User_full_information";
            } else {
                request.setAttribute("PassWordErro2", "对不起,原邮箱输入错误!");
            }
        } else {
            request.setAttribute("PassWordErro", "输入不能为空!");
        }

        return "Update_email";

    }

    // 修改手机界面
    @RequestMapping("Update_Phone.sf")
    public String Update_Phone(HttpServletRequest request, String userPhone, String newuserPhone) {
        // 得到session里面的用户名
        String userName = (String) request.getSession().getAttribute("userName");
        if (userName != null || userPhone != null || newuserPhone != null) {
            boolean bl = update_login_password_Service_Impl.Update_login_Phone(userName, userPhone, newuserPhone);
            if (bl) {
                return "User_full_information";
            } else {
                request.setAttribute("PassWordErro3", "对不起,原手机号码错误!");
            }
        } else {
            request.setAttribute("PassWordErro3", "输入不能为空!");
        }
        return "Update_Phone";// User_full_information.sf

    }

    // 修改支付密码界面
    @RequestMapping("Update_PayPassword.sf")
    public String Update_PayPassword(String paypassword, String newpaypassword, String newpaypassword2,
                                     HttpServletRequest request) {
        String userName = (String) request.getSession().getAttribute("userName");
        if (paypassword != null || newpaypassword != null || newpaypassword2 != null) {
            if (Objects.equals(newpaypassword, newpaypassword2)) {
                boolean bl = update_login_password_Service_Impl.Update_login_payPassword(userName, paypassword, newpaypassword);
                if (bl) {
                    return "User_full_information";
                } else {
                    request.setAttribute("PassWordErro5", "对不起,旧密码输入有误!");
                }
            } else {
                request.setAttribute("PassWordErro5", "两次密码输入有误!");
            }
        }
        return "Update_PayPassword";

    }

    // 用户查看所有信息界面
    @RequestMapping("Information.sf")
    public ModelAndView Information(HttpServletRequest request) {
        // 得到登录用户的名字
        String userName = (String) request.getSession().getAttribute("userName");
        UserEntity user = userListServiceImpl.userlist(userName);
        Map model = new HashMap();

        model.put("user", user);// userlist是个Arraylist之类的

        return new ModelAndView("Information", model);

    }

    // 用户银行卡界面
    @RequestMapping("Bank_Card.sf")
    public String Bank_Card() {
        // System.out.println("测试是否进入此方法");
        return "Bank_Card";
    }

    // 收货地址jsp界面
    @RequestMapping("Delivery_address.sf")
    public String Delivery_address() {
        // System.out.println("测试是否进入此方法");
        return "Delivery_address";
    }

    @RequestMapping("update_bankcard.sf")
    public String update_bankcard(String useryinhangka, String useryinhangming, String kaihuhangdizhi, String huzhuxingming, String useryinhangkahao, HttpServletRequest request) {
        String sessionName = (String) request.getSession().getAttribute("userName");
        if (useryinhangka != null || huzhuxingming != null || useryinhangming != null || kaihuhangdizhi != null || useryinhangkahao != null) {
            if (Objects.equals(useryinhangka, useryinhangkahao)) {
                boolean bl = update_login_password_Service_Impl.Update_BankCard(sessionName, useryinhangka, useryinhangming, kaihuhangdizhi, huzhuxingming);
                String tishi = "";
                if (bl) {
                    tishi = "修改成功";
                    request.setAttribute("title", tishi);
                } else {
                    tishi = "修改失败...请检查是否输入正确";
                    request.setAttribute("title", tishi);
                }
            } else {
                request.setAttribute("PassWordErro5", "两次银行卡输入有误!");
            }
        }
        return "Bank_Card";
    }

    // String usermingzi,String userPhone,String userAddress
    // 修改收货地址
    @RequestMapping("updateDelivery_address.sf")
    public String updateDelivery_address(String usermingzi, String userPhone, String userAddress, HttpServletRequest request) {
        String sessionName = (String) request.getSession().getAttribute("userName");
        boolean bl = update_login_password_Service_Impl.Update_Addred(sessionName, userAddress, usermingzi, userPhone);
        String tishi = "";
        if (bl) {
            tishi = "修改成功";
            request.setAttribute("tishi", tishi);
        } else {
            tishi = "修改失败...请检查是否输入正确";
            request.setAttribute("tishi", tishi);
        }
        return "Delivery_address";

    }

    @RequestMapping("video.sf")
    public ModelAndView video(String dizhi, HttpServletRequest request, String shipingID) {
        // 获得地址
        System.out.println(dizhi);
        request.setAttribute("dizhi", dizhi);

        // System.out.println("===============================");
        Map model = new HashMap();

        System.out.println(shipingID);//拿到视频地址
        request.setAttribute("shipingID", shipingID);
        // 根据视频ID查询出 此视频的所有留言
        List<MessageEntity> messagelist = userListService.messagelist(shipingID);

        for (MessageEntity message : messagelist) {
            message.getMessageuserName();// 得到用户名
            // 根据每个用户名查询出每个用户对应的头像地址
            // userEntity userent =
            // userListService.userlist(message.getMessageuserName());
            // System.out.println(userent.getUserName());
            // model.put("userent",userent);//userlist是个Arraylist之类的
            model.put("messagelist", messagelist);// userlist是个Arraylist之类的
        }

        return new ModelAndView("Video", model);

        // return "Video";

    }

    // 切换账号
    @RequestMapping("exect.sf")
    public String exect(HttpServletRequest request) {

        // System.out.println("切换账号");
        // 将session里面的用户信息全部清空
        request.getSession().removeAttribute("userName");
        return "loginnew";

    }

    @RequestMapping("Houtai.sf")
    public ModelAndView Houtai(HttpServletRequest request) {
        // 设置一个默认从第一条开始查询 只查询出15条记录
        String pageInt = "0";
        int test = Integer.parseInt(pageInt);

        List<UserEntity> list = userListServiceImpl.userlistpage(test);

        Map model = new HashMap();
        model.put("list", list);

        return new ModelAndView("Houtai", model);

    }

    // AJAX 提交 根据用户名查询
    @RequestMapping(value = "userchaxunmessage1", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody void userchaxunmessage1(HttpServletRequest request, HttpServletResponse response, String message) throws IOException {
        // 得到内容 ajax提交进来
        List<UserEntity> list = userListServiceImpl.listmohu("%" + message + "%");
        // 设置编码
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String sbb = gson.toJson(list);
        if (list.size() == 0) {
            sbb = "0";
        }
        out.write(sbb);
    }
    // AJAX 提交 修改用户数据

    // AJAX 提交 根据用户名查询
    @RequestMapping(value = "userchaxunmessage2", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody void userchaxunmessage2(HttpServletRequest request, HttpServletResponse response,
                                                 String message) throws IOException {
        // 得到内容 ajax提交进来
        List<UserEntity> list = userListServiceImpl.userPhone("%" + message + "%");

        // 设置编码
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String sbb = gson.toJson(list);
        if (list.size() == 0) {
            sbb = "0";
        }
        out.write(sbb);
    }

    // AJAX 提交 根据ID查询
    @RequestMapping("userID.sf")
    public ModelAndView userID(HttpServletRequest request, HttpServletResponse response, String userID) throws IOException {
        // 得到内容 ajax提交进来
        List<UserEntity> list = userListServiceImpl.userID(userID);
        // 设置编码
        Map map = new HashMap();
        map.put("listuser", list);
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String sbb = gson.toJson(list);
        if (list.size() == 0) {
            sbb = "0";
        }
        out.write(sbb);
        return new ModelAndView("Xinxi", map);
    }

    @RequestMapping("updateuser.sf")
    public String updateuser(String userID, String userName, String userzhenshiName, String userSex, String passWord, String addr, String userPhone, String userQQ, String userEmial, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String echo = "";
        UserEntity user = new UserEntity();
        // 设置编码
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        user.setUserName(userName);
        user.setUserMingzi(userzhenshiName);
        user.setUsersex(userSex);

        user.setPassWord(passWord);
        user.setUserAddress(addr);
        user.setUserPhone(userPhone);
        user.setUserQQ(userQQ);
        user.setUserEmial(userEmial);
        user.setUserID(userID);
        boolean bl = update_login_password_Service_Impl.Update_user(user);
        if (bl) {
            echo = "修改成功";
            System.out.println("成功");
        } else {
            echo = "修改失败,请联系管理员";
        }
        request.setAttribute("echo", echo);
        return "forward:/Houtai.sf";

    }

    // 跳转到小黑屋界面.... 测试
    @RequestMapping("xiaoheiwu.sf")
    public ModelAndView xiaoheiwu(HttpServletRequest request) {
        // 将用户表里面被拉黑的用户全部查询出来
        List<UserEntity> user = userListServiceImpl.xiaoheiwu("异常");
        Map model = new HashMap();
        model.put("user", user);
        return new ModelAndView("xiaoheiwu", model);

    }

    @RequestMapping("testshabi.sf")
    public ModelAndView testshabi(HttpServletRequest request) {
        String tid = request.getParameter("tid");
        // 获得当前页数
        String pageIndex = request.getParameter("pageIndex");
        //如果pageindex为空，则默认为1
        List<VideoEntity> list4 = null;
        if (pageIndex == null || (pageIndex = pageIndex.trim()).length() == 0) {
            pageIndex = "1";
        }
        int currPageNo = Integer.parseInt(pageIndex);
        if (currPageNo < 1)
            currPageNo = 1;
        Page pageObj = new Page();
        System.out.println(pageObj);
        pageObj.setCurrPageNo(currPageNo); // 设置当前页码
        pageObj.setPageSize(15); // 设置每页显示条数
        if (tid == null || (tid = tid.trim()).length() == 0) {
            userListServiceImpl.findPageNews(pageObj); // 分页查询新闻
            list4 = pageObj.getNewsList(); //获取每页的所有新闻
            System.out.println(list4);
        } else {
            // 查询指定主题下的新闻
            list4 = userListServiceImpl.findAllVideoByTid(Integer.parseInt(tid));
        }
        Map model = new HashMap();
        model.put("list", list4);
        model.put("pageObj", pageObj);
        List<VideoTopicEntity> topiclist = userListServiceImpl.getAlltopiclist();
        model.put("topiclist", topiclist);

        return new ModelAndView("DisplayVideo", model);

    }

    // AJAX 提交
    @RequestMapping(value = "gouwuchet.sf", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody void gouwuche(HttpServletRequest request, HttpServletResponse response, String userName,
                                       String girdsName, String girdsimg, String girdsjiage, String girdsID) throws IOException {
        System.out.println(girdsID);
        System.out.println(userName);
        System.out.println(girdsName);
        System.out.println(girdsimg);
        System.out.println(girdsjiage);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCartID(GetUUID.getUUID());
        shoppingCart.setShoopingID(girdsID);
        shoppingCart.setShoopingImg(girdsimg);
        shoppingCart.setShoopingjiage(girdsjiage);
        shoppingCart.setShoopingName(girdsName);
        shoppingCart.setUserName(userName);
        boolean bl = messageServiceImpl.Shoppingcart(shoppingCart);

        String list = "";
        if (bl) {
            list = "添加成功";
        } else {
            list = "添加失败";
        }

        // 设置编码
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String sbb = gson.toJson(list);
        out.write(sbb);
    }

    // 商品详情页面 请求
    @RequestMapping("gridspay.sf")
    public String gridspay(HttpServletRequest request, String girdsID) {
        GridsEntity gridslist = userListServiceImpl.gridsIDlist(girdsID);
        request.setAttribute("gridslist", gridslist);
        return "gridspay";

    }

    // 确认订单界面
    // Confirmorder
    @RequestMapping("Confirmorder.sf")
    public String Confirmorder(HttpServletRequest request, String girdsID, String gridsName, int gridskucun, String gridsjiage, String gridsimg) {
        // 乱码问题
        try {
            gridsName = new String(gridsName.getBytes("ISO-8859-1"), "utf-8");

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            System.out.println("Confirmorder.sf" + "这里的乱码解决失败");
        }

        GridsEntity grids = new GridsEntity();
        grids.setGridsID(girdsID);
        grids.setGirdsimg(gridsimg);
        grids.setGirdsjiage(gridsjiage);
        grids.setGirdsName(gridsName);
        grids.setGirdskucun(gridskucun);
        System.out.println(grids.getGirdsName());

        request.setAttribute("grids", grids);

        return "Confirmorder";
    }

    @RequestMapping("gouwuche.sf")
    public String gouwuche(HttpServletRequest request) {
        String userName = (String) request.getSession().getAttribute("userName");
        List<ShoppingCart> user = userListServiceImpl.shoppingcart(userName);

        request.setAttribute("user", user);
        return "gouwuche";

    }

    // AJAX 提交
    @RequestMapping(value = "delectgouwuche.sf", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public String delectgouwuche(HttpServletRequest request, HttpServletResponse response, String cartID)
            throws IOException {
        // System.out.println(cartID);
        boolean bl = update_login_password_Service_Impl.delectcartID(cartID);
        String tishi = "";
        if (bl) {
            // System.out.println("删除成功");
            tishi = "删除成功";
            request.setAttribute("tishi", tishi);
        } else {
            // System.out.println("删除失败");
            tishi = "已经删除,查找不到此商品";
            request.setAttribute("tishi", tishi);
        }
        return "forward:/gouwuche.sf";

    }

    @RequestMapping("Shopping.sf")
    public ModelAndView Shopping(HttpServletRequest request) {
        List<GridsEntity> gridslist = userListServiceImpl.gridslist();

        Map model = new HashMap();
        model.put("gridslist", gridslist);

        return new ModelAndView("Shoppingnew", model);

    }

    @RequestMapping("Order.sf")
    public ModelAndView Order(HttpServletRequest request) {
        String userName = (String) request.getSession().getAttribute("userName");
        // 根据名字查询出所有的订单
        List<OrdertableEntity> ordertable = userListServiceImpl.ordertable(userName);

        Map model = new HashMap();
        model.put("ordertable", ordertable);

        return new ModelAndView("Order", model);

    }

    // 全部订单
    @RequestMapping("Adminbackgroundshipment")
    public ModelAndView admin(HttpServletRequest request) {
        List<OrdertableEntity> ordertable = userListServiceImpl.ordertablelist();
        Map model = new HashMap();
        model.put("ordertable", ordertable);
        return new ModelAndView("Adminbackgroundshipment", model);
    }

    // 待发货
    @RequestMapping("Shipmentpending")
    public ModelAndView Shipmentpending(HttpServletRequest request) {
        List<OrdertableEntity> ordertable = userListServiceImpl.orderStat("1");
        Map model = new HashMap();
        model.put("ordertable", ordertable);
        return new ModelAndView("Shipmentpending", model);
    }

    // 已完成订单
    @RequestMapping("Completedorder")
    public ModelAndView Completedorder(HttpServletRequest request) {
        List<OrdertableEntity> ordertable = userListServiceImpl.orderStat("4");
        Map model = new HashMap();
        model.put("ordertable", ordertable);
        return new ModelAndView("Completedorder", model);
    }

    // 待会退的
    @RequestMapping("Returngoods")
    public ModelAndView Returngoods(HttpServletRequest request) {
        List<OrdertableEntity> ordertable = userListServiceImpl.orderStat("3");
        Map model = new HashMap();
        model.put("ordertable", ordertable);
        return new ModelAndView("Returngoods", model);
    }

    @RequestMapping("DeletOrder")
    public ModelAndView DeletOrder(HttpServletRequest request) {
        List<OrdertableEntity> ordertable = userListServiceImpl.orderStat("5");
        Map model = new HashMap();
        model.put("ordertable", ordertable);
        return new ModelAndView("DeletOrder", model);
    }

    // 跳转到查询界面
    @RequestMapping("Inquiryorder")
    public String Inquiryorder(HttpServletRequest request) {

        return "Inquiryorder";
    }

    // AJAX 查询用户订单
    @RequestMapping(value = "AJAXinquiryorder", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody void AJAXinquiryorder(HttpServletRequest request, HttpServletResponse response, String val)
            throws IOException {
        // 根据用户名查询出此用户下单 String val//这个为用户名
        List<OrdertableEntity> ordertable = userListServiceImpl.ordertable(val);
        // user.getUserID();
        // 设置编码
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String sbb = gson.toJson(ordertable);
        out.write(sbb);
    }

    // 查询出订单表一共多少条记录
    @RequestMapping(value = "countordertable", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody void countordertable(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String tishi = "";
        // 根据用户名查询出此用户下单 String val//这个为用户名
        int ordertable = userListServiceImpl.countordertable();

        if (a == ordertable) {
            tishi = "无新订单";
        } else {
            a = ordertable;
            tishi = "新订单";
        }
        // 设置编码
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String sbb = gson.toJson(tishi);
        out.write(sbb);
    }

    @RequestMapping("admin.sf")
    public String AdminBL(HttpServletRequest request) {
        return "AdminBL";
    }

    /************************ 文件上传 ****************************************/
    @RequestMapping("videoFileTop")
    public String videoFileTop(HttpServletRequest request) {

        return "videoFileTop";
    }


    @RequestMapping("UploadServle")
    public String uphand (@RequestParam("uploadFile") MultipartFile uploadFile, HttpServletResponse response,HttpServletRequest request, UserEntity user){
        String FileName = "/static/userHand_Top/upload/";
        if (!uploadFile.isEmpty()) {
            try {
                // new 出一个实体
                VideoTopEntity video = new VideoTopEntity();
                // 放入session中
                request.getSession().setAttribute("video", video);// 放入到session中
                System.out.println("文件总大小" + uploadFile.getSize());
                // 文件保存路径
                String filePath = "C:\\Users\\27767\\Desktop\\ssm_bilibili-master\\src\\main\\webapp\\static\\userHand_Top\\upload\\" + uploadFile.getOriginalFilename();
                System.out.println(filePath);
                /******************** 测试 **************************/
                File storeFile = new File(filePath);
                // 得到输入流
                InputStream in = uploadFile.getInputStream();
                // 得到文件的输出流
                OutputStream out = new FileOutputStream(storeFile);
                // 文件总大小
                long max = uploadFile.getSize();
                video.setFileSize(max);
                video.setFilename(uploadFile.getOriginalFilename());
                // 剩余大小
                long other = max;
                int len = 0;// 读取写入长度
                // 读写缓冲
                byte[] b = new byte[300];
                // 循环从输入流写入到输出流,结束循环是len==-1
                while ((len = in.read(b)) != -1) {
                    out.write(b, 0, len);
                    other -= len;
                    video.setFileSY(other);
                    float zong = (float) (Integer.parseInt(String.valueOf(max)));
                    int shengxia = Integer.parseInt(String.valueOf(other));
                    float ii3 = (float) zong - shengxia;// 传了多少
                    if (shengxia != 0) {
                        int baifenbi = (int) ((ii3 / zong) * 100);
                        video.setBaifenbi(baifenbi);
                    }
                }
                out.flush();// 刷新
                out.close();// 关闭
                in.close();// 关闭
                video.setTag(1);// 标记为1的时候表示上传成功
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String sessionName = (String) request.getSession().getAttribute("userName");

        String videourl = FileName + uploadFile.getOriginalFilename();
        user.setUserHand(videourl);
        boolean bl = update_login_password_Service_Impl.Update_login_hand(sessionName, videourl);
        if (bl) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
        return "User_full_information";
    }

    @RequestMapping("videoFileTop.sf")
    public String videoFileTop(@RequestParam("files") MultipartFile videofiles, @RequestParam("imgfile") MultipartFile imgfile, VideoEntity videos, HttpServletRequest request, String biaoti, String Fruit) {
        System.out.println("用户输入的标题为:" + biaoti + Fruit);
        String FileName = "/static/videolook/";
        String ImageFileName = "/static/videolook/videolookimg/";
        System.out.println("正在调用保存方法");
        if (!videofiles.isEmpty()) {
            try {
                // new 出一个实体
                VideoTopEntity video = new VideoTopEntity();
                // 放入session中
                request.getSession().setAttribute("video", video);// 放入到session中
                System.out.println("文件总大小" + videofiles.getSize());
                // 文件保存路径
                String filePath = "C:\\Users\\27767\\Desktop\\ssm_bilibili-master\\src\\main\\webapp\\static\\videolook\\" + videofiles.getOriginalFilename();
                System.out.println(filePath);
                String videoLength = ReadVideoTime(filePath);//视频时长
                System.out.println(videoLength);
                videos.setVideoTime(videoLength);
                /******************** 测试 **************************/
                File storeFile = new File(filePath);
                // 得到输入流
                InputStream in = videofiles.getInputStream();
                // 得到文件的输出流
                OutputStream out = new FileOutputStream(storeFile);
                // 文件总大小
                long max = videofiles.getSize();
                video.setFileSize(max);
                video.setFilename(videofiles.getOriginalFilename());
                // 剩余大小
                long other = max;
                int len = 0;// 读取写入长度
                // 读写缓冲
                byte[] b = new byte[300];
                // 循环从输入流写入到输出流,结束循环是len==-1
                while ((len = in.read(b)) != -1) {
                    out.write(b, 0, len);
                    other -= len;
                    video.setFileSY(other);
                    float zong = (float) (Integer.parseInt(String.valueOf(max)));
                    int shengxia = Integer.parseInt(String.valueOf(other));
                    float ii3 = (float) zong - shengxia;// 传了多少
                    if (shengxia != 0) {
                        int baifenbi = (int) ((ii3 / zong) * 100);
                        video.setBaifenbi(baifenbi);
                    }
                }
                out.flush();// 刷新
                out.close();// 关闭
                in.close();// 关闭
                video.setTag(1);// 标记为1的时候表示上传成功
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!imgfile.isEmpty()) {
            try {
                // new 出一个实体
                VideoTopEntity video = new VideoTopEntity();
                // 放入session中
                request.getSession().setAttribute("video", video);// 放入到session中
                System.out.println("文件总大小" + videofiles.getSize());
                // 文件保存路径
                String filePath = "C:\\Users\\27767\\Desktop\\ssm_bilibili-master\\src\\main\\webapp\\static\\videolook\\videolookimg\\" + imgfile.getOriginalFilename();
                System.out.println(filePath);
                /******************** 测试 **************************/
                File storeFile = new File(filePath);
                // 得到输入流
                InputStream in = videofiles.getInputStream();
                // 得到文件的输出流
                OutputStream out = new FileOutputStream(storeFile);
                // 文件总大小
                long max = imgfile.getSize();
                video.setFileSize(max);
                video.setFilename(imgfile.getOriginalFilename());
                // 剩余大小
                long other = max;
                int len = 0;// 读取写入长度
                // 读写缓冲
                byte[] b = new byte[300];
                // 循环从输入流写入到输出流,结束循环是len==-1
                while ((len = in.read(b)) != -1) {
                    out.write(b, 0, len);
                    other -= len;
                    video.setFileSY(other);
                    float zong = (float) (Integer.parseInt(String.valueOf(max)));
                    int shengxia = Integer.parseInt(String.valueOf(other));
                    float ii3 = (float) zong - shengxia;// 传了多少
                    if (shengxia != 0) {
                        int baifenbi = (int) ((ii3 / zong) * 100);
                        video.setBaifenbi(baifenbi);
                    }
                }
                out.flush();// 刷新
                out.close();// 关闭
                in.close();// 关闭
                video.setTag(1);// 标记为1的时候表示上传成功
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String sessionName = (String) request.getSession().getAttribute("userName");
        // 开始存储数据库 - -
        String videourl = FileName + videofiles.getOriginalFilename();
        String imgurl = ImageFileName + imgfile.getOriginalFilename();
        System.out.println(videourl);
        System.out.println(imgurl);

        videos.setAthuor(sessionName);
        videos.setVideoState("1");
        videos.setVideoAddress(videourl);
        videos.setVideoID(GetUUID.getUUID());
        videos.setVideoCollection("2");
        videos.setVideoLeaving("2");
        videos.setVideoName(biaoti);
        videos.setVideocAtegory(Fruit);
        videos.setVideolookTime("200");
        videos.setVideoImage(imgurl);
        boolean bl = messageServiceImpl.addvideo(videos);
        if (bl) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }

        return "videoFileTop";

    }

    /************************* 这里写个百分比的AJAX *******************************/
    @RequestMapping(value = "baifenbiAJAX", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody void baifenbiAJAX(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("video") == null) {
            // new 出一个实体
            VideoTopEntity video = new VideoTopEntity();
            video.setBaifenbi(0);
            video.setFilename("请稍后..");
            video.setFileSize(0);
            video.setFileSY(0);
            video.setTag(0);
            // 放入session中
            request.getSession().setAttribute("video", video);// 放入到session中

            // - -想不到办法....就先让线程休息3秒在往下跑吧
            /*
             * try { Thread.sleep(3000); } catch (InterruptedException e) {
             * System.out.println("线程休息出错"); e.printStackTrace(); }
             */
        } else {
            VideoTopEntity video = (VideoTopEntity) request.getSession().getAttribute("video");
            // 设置编码
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            String sbb = gson.toJson(video);
            out.write(sbb);
        }

    }

    //论坛首页
    @RequestMapping("forum.sf")
    public String forum(HttpServletRequest request) {

        int count = userListServiceImpl.counttable();
        int messacount = userListServiceImpl.countfroum();
        int onedaycount = userListServiceImpl.todayfroum();
        int yessdaycount = userListServiceImpl.zuotianfroum();
        int servedatcount = userListServiceImpl.qitianfroum();
        System.out.println("论坛" + messacount);//得到注册用户的总数量
        System.out.println("论坛" + onedaycount);//得到注册用户的总数量
        System.out.println("论坛" + yessdaycount);//得到注册用户的总数量
        System.out.println("论坛" + count);//得到注册用户的总数量
        System.out.println("论坛" + servedatcount);//得到注册用户的总数量
        //将所有的论坛全部查询出来
        String a = (String) request.getServletContext().getAttribute("getUserName");
        request.setAttribute("userNamemessage", a);//最新注册的用户
        request.setAttribute("usercount", count);//用户总数
        request.setAttribute("messacount", messacount);//帖子总数
        request.setAttribute("onedaycount", onedaycount);//今日总帖子数量
        request.setAttribute("yessdaycount", yessdaycount);//昨日总帖子数量
        request.setAttribute("servedatcount", servedatcount);//7天总帖子数量
        return "Forumindex";
    }

    @RequestMapping("Forum")
    public ModelAndView Forum(HttpServletRequest request) {
        //将所有的论坛全部查询出来
        List<ForumEntity> list = userListServiceImpl.forumEnt("1");
        Map model = new HashMap();
        model.put("list", list);
        return new ModelAndView("Forum", model);
    }

    //
    //论坛帖子详细
    @RequestMapping("forumReply.sf")
    public ModelAndView forumReply(HttpServletRequest request, String forumID) {
        //将所有的论坛全部查询出来
        ForumEntity user = userListServiceImpl.forumentitymmp(forumID);
        //在根据此ID查询出所有的回复
        List<ForumreplyEntity> forumre = userListServiceImpl.forumreply(forumID);
        Map model = new HashMap();
        model.put("user", user);
        model.put("forumre", forumre);
        return new ModelAndView("ForumReply", model);
    }


    //发布文章AJAX
    @RequestMapping(value = "forummessage.sf", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public String forummessage(HttpServletRequest request, HttpServletResponse response, String subject, String ncontent) throws IOException {
        ForumEntity forument = new ForumEntity();
        //给实体设值
        forument.setForumID(GetUUID.getUUID());
        forument.setForumBT(subject);
        forument.setForummessage(ncontent);
        forument.setForumuserName((String) request.getSession().getAttribute("userName"));
        forument.setForumTime(GetDataTime.DQtime());
        forument.setForumliebie("1");//类别也默认为1吧
        forument.setForumAmount("0");
        forument.setFirumhand((String) request.getSession().getAttribute("userHand"));
        String list = "";

        //调用保存方法
        boolean bl = messageService.forumadd(forument);
        if (bl) {
            list = "发表成功";
            request.setAttribute("list", list);
        } else {
            list = "发表失败";
            request.setAttribute("list", list);
        }
        // 设置编码
        response.setCharacterEncoding("UTF-8");
        try {
            request.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            String sbb = gson.toJson(list);
            out.write(sbb);
        } catch (UnsupportedEncodingException e) {
            System.out.println("发布论坛文章这里出错了");
        }
        return "Forumindex";
    }

    /****************************************************************/

    //发布文章AJAX
    @RequestMapping(value = "forumreply.sf", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody void forumreply(HttpServletRequest request, HttpServletResponse response, String neirong, String id) throws IOException {

        // 设置编码
        response.setCharacterEncoding("UTF-8");
        try {
            String listecho = "";
            ForumreplyEntity forumreply = new ForumreplyEntity();
            forumreply.setReplyhand((String) request.getSession().getAttribute("userHand"));
            forumreply.setReplyid(GetUUID.getUUID());
            forumreply.setReplyneirong(neirong);
            forumreply.setReplytieziid(id);
            forumreply.setReplytime(GetDataTime.DQtime());
            forumreply.setReplyname((String) request.getSession().getAttribute("userName"));
            //调用方法
            boolean bl = messageServiceImpl.forumreply(forumreply);
            if (bl) {
                listecho = "回复成功";
            } else {
                listecho = "回复失败,请联系管理员";
            }
            request.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            String sbb = gson.toJson(listecho);
            out.write(sbb);
        } catch (UnsupportedEncodingException e) {
            System.out.println("回复论坛帖子这里出错了");
        }
    }

    // 用户银行卡界面
    @RequestMapping("UpdateRMB.sf")
    public ModelAndView UPdateRmb(HttpServletRequest request, String userID) {
        // 得到登录用户的名字
        String userName = (String) request.getSession().getAttribute("userName");
        UserEntity user = userListServiceImpl.userlist(userName);
        Map model = new HashMap();

        model.put("userlist", user);// userlist是个Arraylist之类的

        return new ModelAndView("chongzhicenter", model);
    }

    @RequestMapping("updateuse_yue.sf")
    public String updateuser(String userRMB, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sessionNmae = (String) request.getSession().getAttribute("userName");
        boolean bl = update_login_password_Service_Impl.Update_yue(sessionNmae, userRMB);
        String tishi = "";
        if (bl) {
            tishi = "充值成功";
            request.setAttribute("tishi", tishi);
        } else {
            tishi = "充值失败";
            request.setAttribute("tishi", tishi);
        }
        return "Information";
    }

}
