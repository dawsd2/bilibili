<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>屄哩屄哩-视频展示</title>
	<link rel="stylesheet" type="text/css" href="<%=path%>/static/Homepage/css/style.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/static/Homepage/css/example.css">
	<script src="<%=path%>/static/Homepage/js/sHover.min.js" type="text/javascript"></script>
	<script src="<%=path%>/static/Homepage/js/jquery.min.js" type="text/javascript"></script>
	<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
	<link type="text/css" rel="stylesheet" href="<%=path%>/static/Homepage/video/bootstrap.min.css">
	<link type="text/css" rel="stylesheet" href="<%=path%>/static/Homepage/video/dashboard.css">
	<link type="text/css" rel="stylesheet" href="<%=path%>/static/Homepage/video/style.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/static/cebianlan/css/style.css">
	<script type="text/javascript" src="<%=path%>/static/cebianlan/js/index.js"></script>
	<script type="text/javascript" src="<%=path%>/static/cebianlan/js/jq22.js"></script>
	<script type="text/javascript" src="<%=path%>/static/cebianlan/js/jquery-1.10.2.min.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bilibiliIndex/css/reset.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bilibiliIndex/css/common.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/bilibiliIndex/css/index.css">
	<script src="<%=request.getContextPath()%>/static/Homepage/js/jquery.min.js" type="text/javascript"></script>
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/static/bilibiliIndex/js/script.js" type="text/javascript"></script></head>

<script language="javascript" type="text/javascript">
	$(document).ready(function() {
		/// wrap inner content of each anchor with first layer and append background layer
		$("#menu1 li a").wrapInner('<span class="out"></span>').append(
				'<span class="bg"></span>');
		// loop each anchor and add copy of text content
		$("#menu1 li a").each(
				function() {
					$(
							'<span class="over">' + $(this).text()
							+ '</span>').appendTo(this);
				});

		$("#menu1 li a").hover(function() {
			// this function is fired when the mouse is moved over
			$(".out", this).stop().animate({
				'top' : '40px'
			}, 250); // move down - hide
			$(".over", this).stop().animate({
				'top' : '0px'
			}, 250); // move down - show
			$(".bg", this).stop().animate({
				'top' : '0px'
			}, 120); // move down - show

		}, function() {
			// this function is fired when the mouse is moved off
			$(".out", this).stop().animate({
				'top': '0px'
			}, 250); // move up - show
			$(".over", this).stop().animate({
				'top': '-40px'
			}, 250); // move up - hide
			$(".bg", this).stop().animate({
				'top': '-40px'
			}, 120); // move up - hide
		})
	});

</script>
<body>
<!-- 客服部分 -->
<div style="right: -230px;background-color:#00B2EE" class="contactusdiyou">
	<div class="hoverbtn">
		<span>联</span><span>系</span><span>我</span><span>们</span>
		<img class="hoverimg" src="<%=path%>/static/cebianlan/images/hoverbtnbg.gif" height="9" width="13">
	</div>
	<div class="conter">
		<div class="blank0"></div>
		<div class="qqcall">
			<dl class="fn_cle">
				<dt>
					<img src="<%=path%>/static/cebianlan/images/zxkfqq.png" height="31" width="31">
				</dt>
				<dd class="f1 f_s14">在线客服：</dd>
				<dd class="f2 kefuQQ">
					<span>客服一</span> <a target="_blank" href="http://shang.qq.com/open_webaio.html?sigt=6abe29a244eb227a65bc98c7bd8db390952bd95efbb3295f83d8383e3adbafd33663e0b1763171504a69aef06db7c246&sigu=53edec6635b8a65c6ebd2879cd09c64b5bf5425f269417462a92f949cec06d26fb69e1450ae26685&tuin=794799102"></a>
					<br> <span>客服二</span> <a target="_blank" href="http://shang.qq.com/open_webaio.html?sigt=6abe29a244eb227a65bc98c7bd8db390952bd95efbb3295f83d8383e3adbafd33663e0b1763171504a69aef06db7c246&sigu=53edec6635b8a65c6ebd2879cd09c64b5bf5425f269417462a92f949cec06d26fb69e1450ae26685&tuin=794799102"></a>
				</dd>
			</dl>
			<div class="blank0" ></div>
		</div>
		<div class="blank0"></div>
		<div class="weixincall">
			<dl class="fn_cle">
				<dt>
					<img src="<%=path%>/static/cebianlan/images/weixin.png" height="31" width="31">
				</dt>
				<dd class="f1">官方微信站：</dd>
				<dd class="f3">
					<img src="<%=path%>/static/cebianlan/images/erweima.png" height="73" width="73">
				</dd>
			</dl>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(function() {
		$(".contactusdiyou").hover(function() {
			$(".hoverimg").attr("src","images/hoverbtnbg1.gif");
			$('.diyoumask').fadeIn();
			$('.contactusdiyou').animate({right:'0'},300);
		}, function() {
			$(".hoverimg").attr("src","images/hoverbtnbg.gif");
			$('.contactusdiyou').animate({right:'-230px'},300,function(){});
			$('.diyoumask').fadeOut();
		});
	});
</script>

<!-- 上方是导航栏 -->
<div style="  border: 4px solid;
  border-image-source: linear-gradient(to right,#E6E6FA, #548B54);
  border-image-slice: 1;background-color: #6495ED;
;margin-top: 0">
	<div style="margin-left: 90%;">
		<%
			if (request.getSession().getAttribute("userName") == null) {
		%>
		<button style="  background-color:rgba(0,0,0,0.7);" class="btn btn-primary ladda-button" data-style="expand-left" id="login">
			<span class="ladda-label"><a href="login.sf" style="font-size: 10px; color: white; text-decoration: none;;z-index: 2">登录</a></span>
		</button>
		<button style="background-color:rgba(0,0,0,0.7);" class="btn btn-primary ladda-button" data-style="expand-left" id="zhuce">
			<span class="ladda-label"><a href="zhuce.sf" style="font-size: 10px; color: white; text-decoration: none;z-index: 2">注册</a></span>
		</button>
		<%
		} else {
		%>
		<button style="background-color: #B5B5B5;margin-right: 100px" class="btn btn-primary ladda-button" data-style="expand-left" id="userxinxi">
				<span style="color: white;" class="ladda-label"><a href="User_full_information.sf" style="font-size: 10px; color: white; text-decoration: none">
						欢迎你的登录: <span style="color: #5D478B"><%=request.getSession().getAttribute("userName")%></span>
				</a></span>
		</button>
		<%
			}
		%>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#userxinxi").click(function(){
				location.href="User_full_information.sf";
			});
			$("#login").click(function(){
				location.href="login.sf";
			});
			$("#zhuce").click(function(){
				location.href="zhuce.sf";
			});
		});
	</script>
</div>
<div>
	<img src="<%=path%>/static/Homepage/images/bilibili.png" style="width: 100%;"  alt=""/>
</div>
<div>
	<c:forEach items="${topiclist}" var="topic" varStatus="i">
		<c:if test="${i.count % 11 == 1}"><li id='class_month'></c:if>

		<div >
			<a style="color: yellowgreen;margin-left: 20px;float: left;font-size: large;margin-top: 15px" href="testshabi.sf?tid=${topic.videoid}"><b>${topic.videoName}</b></a>
		</div>
		<%--每行11个主题--%>
		<c:if test="${i.count % 11 == 0}"></li></c:if>
		<c:set var="n" value="${i.count}"/>
	</c:forEach>
</div>

<%--<div class="recommended-info">--%>
<ul class="pic-list__wrapper clearfix tab-cont__item tab-cont__cur">
	<!-- 这里开始遍历 -->
	<c:forEach items="${list}" var="list">
		<div style="margin-top: 50px">
			<li style="margin-left: 30px" class="item"><a href="video.sf?dizhi=${list.videoAddress}&shipingID=${list.videoID}" class="img-link">
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
		</div>
	</c:forEach>
</ul>


<p style="position: fixed;margin-top:-100px;margin-left: 800px;font-size: larger;text-decoration: underline;color: mediumpurple" align="center">
	<%--                            显示页码，currPageNo默认为1--%>
	当前页数:[${pageObj.currPageNo}/${pageObj.totalPageCount}]&nbsp;
	<c:if test="${pageObj.currPageNo > 1}">
		<a style="color: mediumpurple" href="testshabi.sf?pageIndex=1">首页</a>&nbsp;
		<a  style="color: mediumpurple"href="testshabi.sf?pageIndex=${pageObj.currPageNo - 1}">上一页</a>
	</c:if>
	<c:if test="${pageObj.currPageNo < pageObj.totalPageCount}">
		<a  style="color: mediumpurple"href="testshabi.sf?pageIndex=${pageObj.currPageNo + 1}">下一页</a>
		<a style="color: mediumpurple" href="testshabi.sf?pageIndex=${pageObj.totalPageCount}">末页</a>
	</c:if>
</p>
</div>


</body>
</html>