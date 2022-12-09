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
	<title>屄哩屄哩-首页</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bilibiliIndex/css/reset.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bilibiliIndex/css/common.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/bilibiliIndex/css/index.css">
	<script src="<%=request.getContextPath()%>/static/Homepage/js/jquery.min.js" type="text/javascript"></script>
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/static/bilibiliIndex/js/script.js" type="text/javascript"></script>
</head>
<body>

<header id="header" >
	<div id="page_top">
		<div class="bg-wrap">
			<div class="bg"></div>
			<div class="mask"></div>
		</div>
		<div class="header-top">
			<div class="page-width clearfix">
				<div class="header-top__nav">
					<ul>
						<li class="item"><a style="margin-bottom: 30px" href="admin.sf">后台</a></li>
						<div style="margin-top:-73px;margin-left: 50px">
							<li class="item item-home"><a href="index.sf">主站</a></li>
							<li class="item"><a href="Shopping.sf">商品购买</a>
							<li class="item"><a href="videoFileTop">我要投稿</a>
							<li class="item"><a href="forum.sf">进入论坛</a></li>
						</div>
					</ul>
				</div>
				<div class="header-top__user">
					<%
						if (request.getSession().getAttribute("userName") == null) {
					%>
					<div class="login-box">
						<a href="login.sf">登录</a>
						<a href="zhuce.sf">注册</a>
					</div>
					<%
					} else {
					%>
					<div onmouseover="project()">
						<span style="color: pink;margin-top: 10px">欢迎你的登录:<%=request.getSession().getAttribute("userName") %></span>

					</div>
					<%}%>
				</div>
				<div class="header-top__user" style="position: fixed; z-index: 999; width: 300px; height: 160px; background-color: white; margin-left: 55%; margin-top:40px" id="div2">
					<div id="kawayi" onmouseout="asjdh()">
						<div style="width: 130px; height: 160px; background-color: white; position: fixed; margin-left: 14%">

							<div style="width: 90px; height: 90px; margin-top: -113px; margin-left: -110px">
								<img id="imgtest" alt="" style="width: 130px; height: 160px;margin-top: 116px;margin-left: 110px;border-radius: 50%" onmouseover="project()" onmouseout="about()"
									 src="<%=request.getContextPath()%>/static/Homepage/img/kawayi.png">
							</div>
						</div>

					</div>
					<div class="center_header">
						<div align="center" style="margin-left: 60%">
							<a href="#"><img width="20px" height="20px" src="<%=request.getContextPath()%><%=request.getSession().getAttribute("userHand")%>"/></a>

						</div>
						<div align="center" style="margin-left: -100px">
							<span style="color: black;"> <b><%=request.getSession().getAttribute("userName")%></b></span>
						</div>

						<div style="background-color: white">------------------------</div>
					</div>
					<div>
						<br> <a  href="User_full_information.sf" style="color: lawngreen;font-size: medium;margin-left: 25px">个人信息</a>
						<a href="Update_login_password.sf" style="color: palevioletred;font-size: medium;margin-left: 25px">修改密码</a>
						<a href="User_full_information.sf" style="color: mediumpurple;font-size: medium;margin-left: 25px">修改头像</a><br>
						<div style="background-color: white">------------------------</div>
						<br> <a href="exect.sf" style="margin-left: 23%">切换用户</a>
					</div>
				</div>
			</div>
			<script type="text/javascript">
				$(document).ready(function(){
					$("#div2").hide();
				})
				function asjdh() {//移出
					//alert("1");
					$("#div2").hide();
				}
				function project() {//移入
					//alert("2");
					$("#div2").show();
				}
			</script>
		</div>
	</div>
	<div class="header-c">
		<div class="page-width">
			<a href="#" id="header_logo"></a>
			<p id="header_title"></p>
			<div class="header-title">哔哩哔哩 (゜-゜)つロ 干杯~</div>
		</div>
	</div>
</header>

<nav id="nav">
	<div class="page-width clearfix">
		<ul class="nav-list">
			<li class="item item-home"><a href="index.sf" class="link">首页</a></li>
			<li class="item"><a href="testshabi.sf" class="link"><div class="num"><i>999+</i></div> 动画</a></li>
			<li class="item"><a href="testshabi.sf" class="link"><div class="num"><i>999+</i></div> 番剧</a></li>
			<li class="item"><a href="testshabi.sf" class="link"><div class="num"><i>999+</i></div> 音乐</a></li>
			<li class="item"><a href="testshabi.sf" class="link"><div class="num"><i>999+</i></div> 舞蹈</a></li>
			<li class="item"><a href="testshabi.sf" class="link"><div class="num"><i>999+</i></div> 游戏</a></li>
			<li class="item"><a href="testshabi.sf" class="link"><div class="num"><i>999+</i></div> 科技</a></li>
			<li class="item"><a href="testshabi.sf" class="link"><div class="num"><i>999+</i></div> 生活</a></li>
			<li class="item"><a href="testshabi.sf" class="link"><div class="num"><i>999+</i></div> 鬼畜</a></li>
			<li class="item"><a href="testshabi.sf" class="link"><div class="num"><i>999+</i></div> 时尚</a></li>
			<li class="item"><a href="testshabi.sf" class="link"><div class="num"><i>999+</i></div> 广告</a></li>
			<li class="item"><a href="testshabi.sf" class="link"><div class="num"><i>999+</i></div> 娱乐</a></li>
			<li class="item"><a href="testshabi.sf" class="link"><div class="num"><i>999+</i></div> 影视</a></li>
			<li class="item item-square"><a href="testshabi.sf" class="link">广场</a><div class="nav-square__hover"></div></li>
			<li class="item item-room"><a href="xiaoheiwu.sf" class="link">小黑屋</a></li>
		</ul>

		<div class="nav-gif" id="qiulingyang">
			<img src="<%=request.getContextPath()%>/static/bilibiliIndex/images/cont/nav_img.gif" alt="求领养">
		</div>
	</div>
</nav>

<div id="banner">
	<div class="page-width clearfix">
		<div class="slider fl">
			<div class="slider-img">
				<a href="#" slider-title="pic1"><img src="<%=request.getContextPath()%>/static/bilibiliIndex/images/cont/slider_img1.png" alt="#"></a>
				<a href="#" slider-title="pic2"><img src="<%=request.getContextPath()%>/static/bilibiliIndex/images/cont/slider_img2.png" alt="#"></a>
				<a href="#" slider-title="pic3"><img src="<%=request.getContextPath()%>/static/bilibiliIndex/images/cont/slider_img3.png" alt="#"></a>
				<a href="#" slider-title="pic4"><img src="<%=request.getContextPath()%>/static/bilibiliIndex/images/cont/slider_img4.png" alt="#"></a>
			</div>
			<div class="slider-title"><p>pic1</p></div>
			<div class="slider-btn"><span class="cur"></span> <span></span> <span></span> <span></span></div>
			<a href="#" class="slider-more">More</a>
		</div>
		<div class="banner-list fr">
			<ul>
				<c:forEach items="${vvlist}" var="vvlist">
					<li><a href="video.sf?dizhi=${vvlist.videoAddress}&shipingID=${vvlist.videoID}">
						<img src="<%=request.getContextPath()%>${vvlist.videoImage}" alt="#">
						<div class="info">
							<p class="title">${vvlist.videoName }</p>
							<p class="author">up主：admin</p>
							<p class="play">播放：${vvlist.videolookTime}</p>
						</div>
					</a></li>
				</c:forEach>
			</ul>
			<a href="#" class="btn btn-prev">昨日</a>
			<a href="#" class="btn btn-next">一周</a>
		</div>
	</div>
</div>

<div id="main">
	<div class="page-width">
		<!-- 舞蹈 -->
		<div class="mainCont clearfix" id="dance" js-move="true">
			<div class="pic-list fl" js-tab="true">
				<div class="pic-list__title">
					<i class="icon icon-dance"></i>
					<h2>动画</h2>
					<div class="tab-title"><a href="#" class="cur">有新动态</a>
					</div>
					<div class="more-wrap"><a href="#" class="dynamic" id="shuaxin"><i></i>392条新动态</a>
					</div>
				</div>
				<ul class="pic-list__wrapper clearfix tab-cont__item tab-cont__cur">
					<!-- 这里开始遍历 -->
					<c:forEach items="${list}" var="list">
						<li class="item"><a href="video.sf?dizhi=${list.videoAddress}&shipingID=${list.videoID}" class="img-link">
							<img src="<%=request.getContextPath()%>${list.videoImage}" alt="#">
							<span class="mask"></span> <span class="time">${list.videoTime}</span></a>
							<div class="img-info">
								<a href="video.sf?dizhi=${list.videoAddress}&shipingID=${list.videoID}">${list.videoName }</a>
								<div class="btm">
									<div class="user"><i></i>admin</div>
									<div class="online"><i></i>${list.videolookTime}</div>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
			<div class="main-side fr" js-tab="true">
				<div class="main-side__title">
					<div class="rank-t"><h3>排行</h3></div>
					<div class="tab-title"><a href="#" class="cur">全部</a>
					</div>
				</div>
				<div class="main-side__cont">
					<div class="tab-cont">
						<ul class="tab-cont__item main-rank" id="did2"></ul>
					</div>
					<button type="button" class="more" id="chakan">查看更多<i></i>
					</button>
				</div>
			</div>
		</div>

		<!-- 游戏 -->
		<div class="mainCont clearfix" id="game" js-move="true">
			<div class="pic-list fl" js-tab="true">
				<div class="pic-list__title">
					<i class="icon icon-game"></i><h2>MAD</h2>
					<div class="tab-title"><a href="#" class="cur">有新动态</a>
					</div>
					<div class="more-wrap"><a href="#" class="dynamic" id="shuaxin1"><i></i>392条新动态</a>
					</div>
				</div>
				<ul class="pic-list__wrapper clearfix tab-cont__item tab-cont__cur">
					<c:forEach items="${list2}" var="list2">
						<li class="item"><a href="video.sf?dizhi=${list2.videoAddress}&shipingID=${list2.videoID}" class="img-link">
							<img src="<%=request.getContextPath()%>${list2.videoImage}" alt="#">
							<span class="mask"></span> <span class="time">${list2.videoTime}</span>
						</a>
							<div class="img-info">
								<a
										href="video.sf?dizhi=${list2.videoAddress}&shipingID=${list2.videoID}">${list2.videoName }</a>
								<div class="btm">
									<div class="user">
										<i></i>admin
									</div>
									<div class="online">
										<i></i>${list2.videolookTime}</div>
								</div>
							</div></li>
					</c:forEach>
				</ul>
			</div>
			<div class="main-side fr" js-tab="true">
				<div class="main-side__title">
					<div class="rank-t">
						<h3>排行</h3>
					</div>
					<div class="tab-title">
						<a href="#" class="cur">全部</a>
					</div>

				</div>
				<div class="main-side__cont">
					<div class="tab-cont">
						<ul class="tab-cont__item main-rank" id="did3">

						</ul>

					</div>
					<button type="button" class="more" id="chakan3">
						查看更多<i></i>
					</button>
					<script type="text/javascript">


					</script>
				</div>
			</div>
		</div>

		<!-- 科技 -->
		<div class="mainCont clearfix" id="technology" js-move="true">
			<div class="pic-list fl" js-tab="true">
				<div class="pic-list__title">
					<i class="icon icon-technology"></i>
					<h2>动漫</h2>
					<div class="tab-title">
						<a href="#" class="cur">有新动态</a>
					</div>
					<div class="more-wrap">
						<a href="#" class="dynamic" id="shuaxin2"><i></i>392条新动态</a>
					</div>
				</div>
				<ul class="pic-list__wrapper clearfix tab-cont__item tab-cont__cur">

					<c:forEach items="${list3}" var="list3">
						<li class="item"><a href="video.sf?dizhi=${list3.videoAddress}&shipingID=${list3.videoID}" class="img-link">
							<img src="<%=request.getContextPath()%>${list3.videoImage}" alt="#">
							<span class="mask"></span> <span class="time">${list3.videoTime}</span>
						</a>
							<div class="img-info">
								<a href="video.sf?dizhi=${list3.videoAddress}&shipingID=${list3.videoID}">${list3.videoName }</a>
								<div class="btm">
									<div class="user">
										<i></i>admin
									</div>
									<div class="online">
										<i></i>${list3.videolookTime}</div>
								</div>
							</div></li>
					</c:forEach>
				</ul>
			</div>
			<div class="main-side fr" js-tab="true">
				<div class="main-side__title">
					<div class="rank-t">
						<h3>排行</h3>
					</div>
					<div class="tab-title">
						<a href="#" class="cur">全部</a>
					</div>

				</div>
				<div class="main-side__cont">
					<div class="tab-cont">
						<ul class="tab-cont__item main-rank" id=did4>

						</ul>

					</div>
					<button type="button" class="more" id="chakan4">
						查看更多<i></i>
					</button>

					<script type="text/javascript" src="<%=request.getContextPath()%>/static/adminjs/adminjs.js"></script>
				</div>
			</div>
		</div>
	</div>
</div>

<div id="sideBar">
	<div class="sideBar-list">
		<br> <a href="#">动漫</a> <a href="#">动画</a> <a href="#">番剧</a> <br>
		<a href="#"><i></i>排序</a>
	</div>
	<br>
</div>


</body>
</html>