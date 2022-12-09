<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/static/User_Data_Update/js/jquery-1.8.3.min.js"></script>

<title>屄哩屄哩</title>
</head>
<body>

<c:forEach items="${listuser}" var="list">
<form action="updateuser.sf?userID=${list.userID}" method="post" enctype="multipart/form-data">
    <p>
        <label> 用户名 </label>
        <input name="userName" id="userName" type="text" class="opt_input" value="${list.userName}"/>
    </p>
    <p>
        <label> 电话号码 </label>
        <input name="userPhone" id="mobile" type="text" class="opt_input" value="${list.userPhone}"/>
    </p>
    <p>
        <label> 地址 </label>
        <textarea name = "addr" id="addr" cols="40" rows="70">${list.userAddress}</textarea>
    </p>
    <p>
        <label>状态 </label>
        <textarea name="state" id="state" cols="70" rows="10">${list.userState}</textarea>
    </p>
    <p>
        <label> 密码 </label>
        <input name="passWord" id="passWord" type="text" class="opt_input" value="${list.passWord}"/>
    </p>
    <p>
        <label> QQ </label>
        <input name="userQQ" id="userQQ" type="text" class="opt_input" value="${list.userQQ}"/>
    </p>
    <p>
        <label> 邮箱 </label>
        <input id="email" name="userEmial" type="text" class="opt_input" value="${list.userEmial}"/>
    </p>
    <p>
        <label> 性别 </label>
        <input name="userSex" id="userSex" type="text" class="opt_input" value="${list.usersex}"/>
    </p>
    <p>
        <label> 真实姓名 </label>
        <input name="userzhenshiName" id="userzhenshiName" type="text" class="opt_input" value="${list.userMingzi}"/>
    </p>

    <input type="submit" value="提交" class="opt_sub" />
    <input type="reset" value="重置" class="opt_sub" />

</form>
</c:forEach>
</body>
</html>