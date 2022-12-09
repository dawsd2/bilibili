<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>屄哩屄哩-论坛</title>
<link rel="stylesheet" id="css_widthauto" type="text/css" href="<%=request.getContextPath()%>/static/Forum/css/style_4_widthauto.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/Forum/css/style_4_common.css"/>
<link href="<%=request.getContextPath()%>/kindeditor/themes/default/default.css" type="text/css" rel="stylesheet"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/Forum/css/style_4_forum_forumdisplay.css"/>
<script src="<%=request.getContextPath()%>/static/Forum/js/common.js" type="text/javascript"></script>
<script type="text/javascript">HTMLNODE.className += ' widthauto'</script>
<script src="<%=request.getContextPath()%>/static/Forum/js/forum.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/Homepage/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/kindeditor/kindeditor-all.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/kindeditor/lang/zh-CN.js"></script>

</head>
<body id="nv_forum" class="pg_forumdisplay" onkeydown="if(event.keyCode===27) return false;">
<div id="append_parent"></div>
<div id="ajaxwaitid"></div>
<div id="hd">
<div class="wp">
<div class="hdc cl margin-top-bottom">
<div class="login-container" align="center">
<div class="well well-small pull-right user-panel-mini">
    <input type="hidden" name="quickforward" value="yes"/>
    <input type="hidden" name="handlekey" value="ls"/>
    <c:choose>
    <c:when test="${sessionScope.userName==''||sessionScope.userName==null}">
        <form action="loginforum.sf" method="post">
        <div class="controls controls-row">
            <input class="input-medium" type="text" name="username" id="ls_username" class="px vm xg1" placeholder="用户名" tabindex="901"/>
            <input class="input-medium" placeholder="密码" type="password" name="password" id="ls_password" class="px vm" autocomplete="off" tabindex="902"/>
        </div>
        <ul class="nav nav-pills" style="margin-bottom: 0px">
            <li><a href="zhuce.sf" class="xi2 xw1" style="color: #000000; font-size: 14px">立即注册</a></li>
            <li>
            <li class="pull-right" style="padding-top: 4px;"><label class="checkbox" style="margin-right: 10px; float: left; margin-top: 4px;">
                <input type="checkbox" name="cookietime" id="ls_cookietime" class="pc" value="" tabindex="903"/>自动登录</label>
                <button type="submit" class="btn btn-primary pull-left" tabindex="904" style="width: 75px;">登录</button>
            </li>
        </ul>
            </form>
        </c:when>
        <c:when test="${sessionScope.userName!=''||sessionScope.userName!=null}">
            <div class="controls controls-row">
                欢迎你的登录:${sessionScope.userName}
            </div>
            <div>
                <a href="logoone.sf" class="xi2 xw1" style="color: #000000; font-size: 14px">返回首页</a>
                <a href="forum.sf" class="xi2 xw1" style="color: #000000; font-size: 14px">返回论坛</a>
            </div>
        </c:when>
        <c:otherwise>
        <form action="loginforum.sf" method="get">
            <div class="controls controls-row">
                <input class="input-medium" type="text" name="username" id="ls_username" class="px vm xg1" placeholder="用户名" tabindex="901"/>
                <input class="input-medium" placeholder="密码" type="password" name="password" id="ls_password" class="px vm" autocomplete="off" tabindex="902"/>
            </div>
            <ul class="nav nav-pills" style="margin-bottom: 0px">
                <li><a href="" class="xi2 xw1" style="color: #000000; font-size: 14px">立即注册</a></li>
                <li>
                <li class="pull-right" style="padding-top: 4px;"><label class="checkbox" style="margin-right: 10px; float: left; margin-top: 4px;">
                    <input type="checkbox" name="cookietime" id="ls_cookietime" class="pc" value="" tabindex="903"/>自动登录
                </label>
                    <button type="submit" class="btn btn-primary pull-left" tabindex="904" style="width: 75px;">登录</button>
                </li>
            </ul>
        </form>
        </c:otherwise>
    </c:choose>
</div>
</div>
</div>
    <div id="nv">
    <ul class="nav ">
    <li class="active" id="mn_forums "><a href="forum.sf" hidefocus="true " title="BBS ">论坛<span>BBS</span></a></li>
    <li class="active" id="mn_forum "><a href="logoone.sf" hidefocus="true " title="BBS ">首页<span>BBS</span></a></li>
    </ul>
    </div>
</div>
</div>

    <div id="wp" class="wp">
    <div id="diynavtop" class="area"></div>
    <div id="pt" class="bm cl">
    <div class="z">
    </div>
    </div>
    <div class="wp">
    <div id="diy1" class="area"></div>
    </div>
    <div class="boardnav trans-20">
    <div id="ct" class="wp cl">
    <div id="threadlist" class="btr bbr tl bm bmw trans-80">
    <div class="th">
        <table id="head-table" cellspacing="0" cellpadding="0">
            <tr>
                <th colspan="2"></th>
                <td class="by">作者</td>
                <td class="num">回复/查看</td>
                <td class="by"></td>
            </tr>
        </table>
    </div>
<div class="bm_c">
    <div id="forumnew" style="display: none"></div>

    <input type="hidden" name="formhash" value="52cd20e6"/> <input type="hidden" name="listextra" value="page%3D1"/>
    <table summary="forum_343" cellspacing="0" cellpadding="0" id="threadlisttableid">

        <tbody id="stickthread_515875">
        <tr>
            <td class="icn"></td>
            <th class="common"></th>
            <td class="by"></td>
            <td class="num">
            <td class="by"></td>
        </tr>
        </tbody>
        <tbody id="separatorline">

        </tbody>
    <c:forEach items="${list}" var="list">
        <tbody id="normalthread_555837">
        <tr>
            <td class="icn"><a href="forumReply.sf?forumID=${list.forumID}" title="有新回复 - 新窗口打开" target="_blank">
                <img src="<%=request.getContextPath()%>/static/Forum/picture/folder_new.gif"/>
            </a></td>
            <th class="new"><a class="tdpre y" href="javascript:void(0);" onclick="previewThread('555837', 'normalthread_555837');">预览</a>
                <a href="forumReply.sf?forumID=${list.forumID}" onclick="atarget(this)" class="s xst">${list.forumBT }</a> <span class="tps">&nbsp;
                    <a href="forumReply.sf?forumID=${list.forumID}"></a></span></th>
            <td class="by"><cite> <a href="forumReply.sf?forumID=${list.forumID}" c="1" style="color: #333333;">${list.forumuserName }</a></cite>
                <em><span>${list.forumTime }</span></em>
            </td>
            <td class="num"><a href="javascript:void(0);" class="xi2">${list.forumAmount}</a></td>
            <td class="by"></td>
        </tr>
        </tbody>

    </c:forEach>
    </table>

</div>
</div>
<div id="f_pst" class="bm trans-60">
<div class="bm_h0 title-bar">
    <h2>快速发帖</h2>
</div>
<div class="bm_c">
    <form method="post" autocomplete="off" id="fastpostform" action="forummessage.sf">
        <div id="fastpostreturn" style="margin: -5px 0 5px"></div>
        <div class="pbt cl">
            <input type="text" id="subject" name="subject" class="px"  tabindex="11" style="width: 25em"/>
        </div>
        <p>
            <label> 内容 </label>
            <textarea name="ncontent" id="ncontent"></textarea>
        </p>
        <p class="ptm pnpost">
            <button type="submit" tabindex="13" class="pn0 pnc btn btn-primary"><strong>发表帖子</strong></button>
        </p>
    </form>
    <script type="text/javascript">
        var editor1;
        /**页面初始化 创建文本编辑器工具**/
        KindEditor.ready(function (K) {
            editor1 = K.create('textarea[name="ncontent"]', {//定义属性
                cssPath: '<%=request.getContextPath()%>/kindeditor/plugins/code/prettify.css',
                uploadJson: '<%=request.getContextPath()%>/kindeditor/jsp/upload_json.jsp',
                fileManagerJson: '<%=request.getContextPath()%>/kindeditor/jsp/file_manager_json.jsp',
                allowFileManager: true,
                afterCreate: function () {
                    var self = this;
                    K.ctrl(document, 13, function () {
                        self.sync();
                        document.forms['example'].submit();
                    });
                    K.ctrl(self.edit.doc, 13, function () {
                        self.sync();
                        document.forms['example'].submit();
                    });
                }
            });
            prettyPrint();
        });
    </script>

<%--                    <script type="text/javascript">--%>
<%--                        $("#butt").click(function () {--%>
<%--                            //获得val--%>
<%--                            var biaoti = $("#subject").val();//标题--%>
<%--                            var neirong = $("#ncontent").val();//内容--%>
<%--                            var admin = "<%=request.getSession().getAttribute("userName")%>";--%>

<%--                            if (admin == "null") {--%>
<%--                                alert("请登录之后操作");--%>
<%--                            } else {--%>
<%--                                if (biaoti == null || biaoti === "" || neirong == null || neirong === "") {--%>

<%--                                    alert("请输入内容,在进行发布");--%>
<%--                                } else {--%>
<%--                                    $("#butt").attr('disabled', true);//不可点击--%>
<%--                                    var html = "";--%>
<%--                                    //将得到的使用ajax提交--%>
<%--                                    $.post("forummessage.sf", {"subject": biaoti, "ncontent": neirong}, function (test) {--%>
<%--                                        var ht = eval("(" + test + ")");--%>
<%--                                        $.each(ht, function (index, m) {--%>
<%--                                            html += m;--%>
<%--                                        });--%>
<%--                                        alert(html);--%>
<%--                                        //window.location.href="index.jsp"--%>
<%--                                        //window.location.href="jb51.jsp?backurl="+window.location.href;--%>
<%--                                        html = "";--%>
<%--                                    });--%>
<%--                                    $("#butt").attr('disabled', false);//可点击--%>
<%--                                }--%>
<%--                            }--%>

<%--                        });--%>

<%--                    </script>--%>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>