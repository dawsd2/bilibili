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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/Houtai/css/style.css" type="text/css" />
    <script
            src="<%=request.getContextPath()%>/static/Homepage/js/sHover.min.js"></script>
    <script
            src="<%=request.getContextPath()%>/static/User_Data_Update/js/jquery-1.8.3.min.js"></script>


    <title>屄哩屄哩-小黑屋</title>
</head>
<body>
<h1 style="margin-left: 600px;margin-top: 100px">我的小黑屋</h1>
<table style=" background-color: rgb(0,0,0,0.5);margin-left: 75px" border="1px" cellspacing="0" width="1100px" class="table" height="400px">
    <tr>

        <td height="100%" valign="top">
            <div style="overflow:auto;height:100%; width:100%;margin-top:100px">
                <table style="" width="100%" border="0" cellpadding="3" cellspacing="1" class="table1">
                    <TR style="font-size: large;color:pink;">
                        <th align="center"><input type="checkbox" name="checkbox" id="checkbox"></th>
                        <th style="color:pink" align="center">用户名</th>
                        <th style="color:pink" align="center">用户性别</th>
                        <th  style="color:pink"align="center">原因</th>
                    </TR>
                    <c:forEach items="${user}" var="user">
                        <TR>
                            <TD align="center"><input type="checkbox" name="checkbox2" id="checkbox2"></TD>
                            <TD align="center">${user.userName}</TD>
                            <TD align="center">${user.usersex}</TD>
                            <TD align="center">${user.userState}</TD>
                        </TR>
                    </c:forEach>
                </table>
            </div>
        </td>
    </tr>
</table>

</body>
</html>