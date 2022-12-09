<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>屄哩屄哩-用户购物车</title>
    <script
            src="<%=request.getContextPath()%>/static/gouwuche/js/js.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/gouwuche/css/css.css" />
    <script
            src="<%=request.getContextPath()%>/static/Homepage/js/jquery.min.js"></script>

</head>
<body>

<script type="text/javascript">

    $(document).ready(function() {
        var userName="<%=request.getSession().getAttribute("userName")%>";
        if(userName==""||userName=="null"){
            location.href = "login.sf";
        }
    });

</script>
<div style="margin-top: 50px">

</div>
<h1 style="text-align: center;color:#8968CD; ">
    我的购物车
</h1>
<div class="xia" style="margin-top: 100px">
    <table id="cartTable" align="center" width="100%">
        <thead>
        <tr class="order_content">
            <th><input class="check_all check" type="checkbox"></input> 全选</th>
            <th>商品</th>
            <th>单价</th>
            <th>数量</th>
            <th>小计</th>
            <th>操作</th>

        </tr>

        </thead>
        <tbody>
        <c:forEach items="${requestScope.user}" var="user">
            <tr class="order_content">
                <td class="check"><input class = "check_one check" type="checkbox"></input></td>

                <td class="goods"><img width="35px" height="35px" src="<%=request.getContextPath()%>${user.shoopingImg}"><span>${user.shoopingName}</span></td>
                <td class="price">${user.shoopingjiage}</td>
                <td class="count">
                    <span class="reduce">-</span>
                    <input class="count_input" type="text" value="1"></input>
                    <span class="add">+</span>
                </td>
                <td class="subtotle" style="color: #6B8E23">${user.shoopingjiage}</td>

                <td class="operation" style="color: #CDB5CD"><a href="delectgouwuche.sf?cartID=${user.cartID}">删除</a></td>

            </tr>
        </c:forEach>
        </tbody>

    </table>
    <div class="slected view">
        <div id="selectedViewList" class="clearfix">

        </div>

        <span class="arrow">.<span>.</span></span>

    </div>
    <div id = "footer" class="footer">
        <label class="fl select_all" >
            <input class="check_all check" type="checkbox" value="全选">
        </label>
        <a class="fl delete_all" id="deleteAll" href="javascript:;">删除</a><!-- href="javascript:; -->
        <button class="addcart yh" id="lijigoumai"><img src="<%=request.getContextPath()%>/static/grids/gridsPay/images/ht.png" width="25" height="25"/>立即购买</button>
        <div class="fr selected_totle">合计：￥ <span id="priceTotle" style="color: #6B8E23">0.00</span> </div>
        <div class="fr selectAll" id="selected">已购商品
            <span id = "selectTotle" style="color: #6B8E23">0</span>件
            <span class="arow up">+++</span>
            <span class="arow down">---</span>
        </div>
    </div>
    <script type="text/javascript">
        $("#lijigoumai").click(function(){
            //alert("立即购买");
            var user = "<%=request.getSession().getAttribute("userName")%>";
            if(user!="null"){
                var a="Confirmorder.sf?girdsID=${requestScope.user.cartID}&gridsName=${requestScope.user.shoopingName}&gridskucun=${gridslist.girdskucun}&gridsjiage=${requestScope.user.shoopingjiage}&gridsimg=${requestScope.user.shoopingImg}"
                location.href =  a;
            }else{
                alert("请登录之后购买");
                location.href = "login.sf";
            }
        })
    </script>

</div>
<script type="text/javascript">
    $(document).ready(function(){
        var tishi="<%=request.getAttribute("tishi")%>";
        if(tishi!="null"){
            alert(tishi);
        }
    });
</script>
</body>
</html>