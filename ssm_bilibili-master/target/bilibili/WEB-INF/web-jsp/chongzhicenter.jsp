<%--
  Created by IntelliJ IDEA.
  User: 27767
  Date: 2022/12/5
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>充值中心</title>
</head>
<body>
<form action="updateuse_yue.sf" method="post" enctype="multipart/form-data">
    <p>
        <label> 用户名 </label>
        <input name="userName" id="userName" type="text" class="opt_input" value="${userlist.userMingzi}" />
    </p>
    <p>
        <label> 银行卡号 </label>
        <input name="userName" id="userCard" type="text" class="opt_input" value="${userlist.useryinhangka}" />
    </p>

    <p>
        <label> 充值金额 </label>
        <input name="userRMB" id="userrmb" type="text" class="opt_input" />
    </p>
    <input type="submit" value="充值">

</form>
</body>
</html>
