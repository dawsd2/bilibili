<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>屄哩屄哩-周边商品</title>

	<link rel="stylesheet" type="text/css"
		  href="<%=request.getContextPath()%>/static/Shoppingcss/new/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css"
		  href="<%=request.getContextPath()%>/static/Shoppingcss/new/css/style.css">
	<script
			src="<%=request.getContextPath()%>/static/Shoppingcss/new/js/jquery-1.11.3.min.js"></script>
	<script
			src="<%=request.getContextPath()%>/static/Shoppingcss/new/js/shop.min.js"></script>

</head>
<body style="background-color: #F0FFF0">
<div style="background-color: #333333; width: 100%; height: 40px">
	<div style="margin-left: 90%;">
		<%
			if (request.getSession().getAttribute("userName") == null) {
		%>
		<button class="btn btn-primary ladda-button" data-style="expand-left "
				id="login" style="background-color: lightsteelblue" >
				<span class="ladda-label"><a href="login.sf"
											 style="font-size: 10px; color: black; text-decoration: none">登录</a></span>
		</button>

		<button class="btn btn-primary ladda-button" data-style="expand-left"
				style="background-color: lightsteelblue">
				<span class="ladda-label"><a href="zhuce.sf"
											 style="font-size: 10px; color: black; text-decoration: none"
											 id="zhuce">注册</a></span>
		</button>
		<%
		} else {
		%>

		<button class="btn btn-primary ladda-button" data-style="expand-left"
				id="userxinxi" style="background-color: white">
				<span class="ladda-label"><a href="User_full_information.sf"
											 style="font-size: 10px; color: #9FB6CD; text-decoration: none">
						欢迎你的登录: <span style="color: #473C8B"><%=request.getSession().getAttribute("userName")%>
					</span>

				</a></span>
		</button>

		<%
			}
		%>
	</div>

</div>

<h1 style="color: #548B54;margin-left: 550px;overflow: hidden">周边商品</h1>
<div align="left"
	 style="margin-left: 93%; margin-top: 200px; position: fixed; z-index: 999;">
	<a href="gouwuche.sf" style="color: white; background: #CD6839;">查看购物车</a>
	<div>&nbsp;&nbsp;</div>
	<a href="index.sf" style="color: white; background: #CD6839;">返回首页</a>
	<script type="text/javascript"></script>
</div>
<div class="ct-pageWrapper" style="margin: 15px">

	<main style="background-color: #EEEEE0;padding-bottom: 100px">

		<div class="container" style="padding-bottom: -100px;">
			<div class="row"></div>
			<div class="col-md-9">
				<div class="row" >
					<c:forEach items="${gridslist}" var="gridslist">
						<div class="col-sm-4">
							<div class="ct-product" >
								<div class="image">
									<a href="gridspay.sf?girdsID=${gridslist.gridsID}"><img
											src="<%=request.getContextPath()%>${gridslist.girdsimg}"
											alt="${gridslist.girdsName}"></a>
								</div>
								<div class="inner" style="background-color:  #E6E6FA">
									<h2 class="ct-product-title">
										<a href="gridspay.sf?girdsID=${gridslist.gridsID}">${gridslist.girdsName}</a>
									</h2>
									<p class="ct-product-description" ></p>
									<span class="ct-product-price">$ ${gridslist.girdsjiage}</span>
								</div>
							</div>
						</div>
						<br>
					</c:forEach>
				</div>
			</div>
		</div>
	</main>

</div>

</div>

</body>
</html>