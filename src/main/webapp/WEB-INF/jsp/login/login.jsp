<%--
  Created by IntelliJ IDEA.
  User: gy
  Date: 2017/11/11
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><登陆界面></登陆界面></title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta http-equiv="cleartype" content="on">

    <link rel="stylesheet" type="text/css" href="css/common/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="Fontawesome/css/layui.css" />
    <style>
        body  { font:14px/1.5 微软雅黑;}
        table { border:1px solid #DDD; border-collapse:collapse; width:980px; margin-top:20px; }
        thead,
        tfoot { background:#FAFAFA; }
        td,th { border:1px solid #DDD; text-align:left; font-weight:normal; padding:15px; }
        th,
        .demo { width:100px; min-width:100px; max-width:100px; }
        td    { width:680px; min-width:680px; max-width:680px; }
        /*#demo { width:780px; margin:150px auto; background:#72af3c; color:#FFF; padding:50px 0 100px 0; overflow:hidden; border-radius:1000px; }*/
        #demo i { background: no-repeat top left; display:inline-block; height:60px; width:60px;float: right;margin-right: 20px; background-size: contain;}
        #demo i.icon-xiaoyu { background-image:url(Fontawesome/css/xiaoyu.png); }
        #demo i.icon-zhongyu { background-image:url(Fontawesome/css/zhongyu.png); }
        #demo i.icon-dayu { background-image:url(Fontawesome/css/dayu.png); }
        #demo i.icon-qing { background-image:url(Fontawesome/css/qing.png); }
        #demo i.icon-duoyun { background-image:url(Fontawesome/css/duoyun.png); }
        #demo i.icon-yin { background-image:url(Fontawesome/css/yin.png); }
        #demo i p{
            display: none;}
        #demo p { background:rgba(0,0,0,.3); margin:0 200px; padding:20px; border-radius:1000px; font-size:16px; }
        #demo p span { margin:0 15px; }
        #demo2 {margin:0 auto; padding:15px 0; overflow:hidden;text-align: right;}
        #div{
            background-color: #F0F0F0;
            width:400px;
            height: 400px;
            position: absolute;
            left:55%;
            top:50%;
            margin-left:-280px;
            margin-top:100px;
            margin-bottom:100px;
        }
        #input{
            width:300px;
            height: 250px;
            position: absolute;
            left:93%;
            top:50%;
            margin-left:-280px;
            margin-top:-150px;
            margin-bottom:100px;
        }
    </style>
</head>
<body>
    <div class="row" style="height: 70px;background-color: #F0F0F0">
        <div class="col-md-1">
            <img src="/resource/images/yonghuming.png" style="width:50px;height: 40px;margin-top: 15px;margin-left: 30px">
        </div>
        <div class="col-md-8">
            <p style="height: 40px;margin-top: 15px;">天津云网全房科技发展有限公司<br>物业服务管理后台</p>
        </div>
        <div class="col-md-2" id="demo2"></div>
        <div class="col-md-1" id="demo"></div>

    </div>
    <div style="width: auto;height: auto; position:relative;">
        <div id="div" style="border: 1px solid #dddddd">
            <div id="input">
                账号
                <input type="text" id="username" name="telephone" required  lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input" style="width: 220px;"><br>
                密码
                <input type="password" id="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input" style="width: 220px;"><br>
                <input value="登陆" class="layui-btn layui-btn-primary" type="submit" style="margin-right:20px; margin-top:20px;width: 220px;" id="login">
            </div>
            <hr style="margin-top: 320px;height:1px;">
            <a>忘记密码？</a>
        </div>
    </div>

    <script type="text/javascript" src="scripts/jquery.min.js"></script>
    <script type="text/javascript" src="scripts/jquery.leoweather.min.js"></script>
    <script type="text/javascript" src="scripts/layui.js"></script>
    <script type="text/javascript">
        $('#demo').leoweather({
            format:'<i class="icon-{图标}"></p>'
        });

        $('#demo2').leoweather();

        $(function(){
            $('#login').click(function(){
                var telephone= $("#username").val();
                var password= $("#password").val();
                $.ajax({
                    type:"POST",
                    url:"login/getSession",
                    dataType:"json",
                    data:{"telephone":telephone,"password":password},// 你的formid
                    success: function(data) {
                        window.location.href="index/index";
                    }
                })
            })
        })
    </script>
</body>
</html>
