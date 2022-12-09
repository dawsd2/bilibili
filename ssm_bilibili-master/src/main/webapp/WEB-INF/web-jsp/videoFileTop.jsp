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
    <title>屄哩屄哩-视频投稿</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/Homepage/js/jquery-2.0.0.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/Homepage/mycssAndimg/css.css" type="text/css">
</head>
<body style="background-image: url(<%=request.getContextPath()%>/static/Homepage/mycssAndimg/t.png);">
<div id="none">
    <!-- style="width: 100%;height: 60px;background-color: white;" -->
</div>
<div>
    <div>
        <form id="upload_form" action="videoFileTop.sf">

            <div>
                <div><label  style="color: wheat;">请选择投稿视频文件</label></div>
                <div><input type="file" name="files" id="video" /></div>
            </div>
            <div>
                <div><label  style="color: wheat;">请选择投稿封面壁纸</label></div>
                <div><input type="file" name="imgfile" id="img" /></div>
            </div>
            <div>
                <div><label  style="color: wheat;">请输入视频标题</label></div>
                <div><label for="biaoti"></label><input type="text" name="biaoti" id="biaoti"/></div>
            </div>
            <div>
                <div><label  style="color: wheat;">请选择投放区域</label></div>
                <div>
                    <label><input name="Fruit" type="radio" value="1"  checked />动画 </label>
                    <label><input name="Fruit" type="radio" value="2" />番剧 </label>
                    <label><input name="Fruit" type="radio" value="3" />原创 </label>
                    <label><input name="Fruit" type="radio" value="4" />音乐 </label>
                    <label><input name="Fruit" type="radio" value="5" />舞蹈 </label>
                    <label><input name="Fruit" type="radio" value="6"   />游戏 </label>
                    <label><input name="Fruit" type="radio" value="7"  />科技 </label>
                    <label><input name="Fruit" type="radio" value="8" />生活 </label>
                    <label><input name="Fruit" type="radio" value="9"   />鬼畜 </label>
                    <label><input name="Fruit" type="radio" value="10"   />时尚 </label>
                    <label><input name="Fruit" type="radio" value="11"   />广告 </label>
                    <label><input name="Fruit" type="radio" value="12"   />娱乐 </label>
                    <label><input name="Fruit" type="radio" value="13"   />影视 </label>
                </div>
            </div>
            <div>
                <input type="button" value="立即投稿" id="tougao" />  <input type="button" id="fanhui" value="取消返回" />
            </div>
        </form>
        <div style="display: none;" id="daxiaobuneng"><b style="color: red;">总大小不能超过1g</b></div>
    </div>
    <script type="text/javascript">
        $("#fanhui").click(function(){
            location.href = "index.sf";
        })
    </script>

    <script>
        $("#tougao").click(function(){
            //判断视频
            var video = $("#video").val();
            if(video == "") {
                alert("请上传投稿的视频");
                return false;
            } else {
                if(!/\.(mp4)$/.test(video)) {
                    alert("视频格式必须为.MP4格式")
                    return false;
                }
                //判断图片
                var img = $("#img").val();
                if(img == "") {
                    alert("请选择图片");
                    return false;
                } else {
                    if(!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(img)) {
                        alert("图片类型必须是.gif,jpeg,jpg,png中的一种")
                        return false;
                    }
                }
                //开始判断输入的内容
                var biaoti = $("#ibiaoti").val();
                var miaoshu = $("#miaoshu").val();
                if(biaoti == "" || miaoshu == "" || miaoshu == "null" || biaoti == "null") {
                    alert("请正确输入标题和描述");
                    return false;
                }
                //判断文件总大小 不能超1g
                //用户上传的视频
                var addImags =$("#video").prop('files');
                var fileSize=0;
                for(var i=0;i<addImags.length;i++){
                    fileSize=$(addImags)[i].size;
                }
                //用户上传的图片
                var addImags2 =$("#img").prop('files');
                var fileSize2=0;
                for(var i=0;i<addImags2.length;i++){
                    fileSize2=$(addImags2)[i].size;
                }

                var zonggongdaxiao = fileSize+fileSize2;
                var Maxzong = 1073741824;
                if(zonggongdaxiao>Maxzong){
                    $("#daxiaobuneng").show();
                    alert("对不起 文件过大.无法上传");
                    return false;
                }

            }
            //判断结束
            $("#tougao").attr('disabled',true); //将button变成不可点击
            var formData = new FormData($( "#upload_form" )[0]);
            $.ajax({
                url: 'videoFileTop.sf' ,
                type: 'POST',
                data: formData,
                async: true,  //设置为同步
                cache: false,
                contentType: false,
                processData: false,
                success: function (returndata) {
                    //$("#tougao").attr('disabled',false); //将button变成可点击
                },
                error: function (returndata) {
                    alert(returndata);
                }
            });
            $(function (){
                //iCount获取setInterval句柄
                var iCount = setInterval(GetBack, 100);
                function GetBack() {
                    var html = "";
                    $.post("baifenbiAJAX", function(r) {
                        //把json字符串转换为json对象
                        var obj = eval("(" + r + ")");
                        //alert(obj.test);
                        var a=obj.baifenbi;
                        a += 1;
                        /* <div id="none" style="width: 100%;height: 60px;background-color: blue;">
                     <h1>啊开始的空间爱仕达空间</h1>
                     </div> */
                        //得到DIV
                        html += "<div id='none2' style='width: "+a+"%;height: 60px;background-color: blue;'>";
                        html += "<h1>"+a+"%</h1>";
                        html += "</div>";
                        //alert(html);
                        $("#none").html(html);
                        html="";
                        //如果标记不为 0  表示上传完成
                        if (obj.tag != 0) {
                            //alert("进入");
                            //清除setInterval
                            clearInterval(iCount);
                        }
                    });
                }
            });
        });
    </script>
</div>
</body>



</html>