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
<!DOCTYPE html>
<html lang="en">
<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>首页</title>
	<meta name="keywords" content="">
	<meta name="description" content=""> 
	<script type="text/javascript" src="easyui/1.5.2/jquery.min.js"></script> 
	<script type="text/javascript" src="scripts/jquery.form.min.js"></script> 
	<link rel="stylesheet" type="text/css" href="easyui/1.5.2/themes/bootstrap/easyui.css" />
    <link rel="stylesheet" type="text/css" href="easyui/1.5.2/themes/icon.css">
    <script type="text/javascript" src="easyui/1.5.2/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/1.5.2/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" type="text/css" href="Fontawesome/css/font-awesome.min.css">
    <script type="text/javascript"  src="scripts/custom/jquery.all.event.js"></script>
    <script type="text/javascript"  src="scripts/custom/jquery.admin.js"></script>
    <link rel="stylesheet" type="text/css" href="css/main.css" >
    <script type="text/javascript"  src="scripts/custom/main.js"></script> 
    <script type="text/javascript"  src="scripts/custom/utils.js"></script>
    <!-- kindeditor -->
    <link rel="stylesheet" type="text/css" href="scripts/kindeditor/themes/default/default.css" >
    <script type="text/javascript"  src="scripts/kindeditor/kindeditor-all.js"></script>
	<script  type="text/javascript" src="scripts/kindeditor/lang/zh_CN.js"></script>
    
</head>
<body class="easyui-layout" data-url="">
	<div id="body-lock-screen-loading">
	    <table width="100%" height="100%" align="center">
	        <tbody>
	            <tr>
	                <td><i class="fa fa-spinner fa-spin" style="font-size: 36px"></i></td>
	            </tr>
	        </tbody>
	    </table>
	</div>
	<!--顶部 Start-->
	<div id="north" data-options="region: 'north'" style="height:80px;overflow:hidden;">
	    <ul class="north-head">
	        <li class="pull-left"><h1>我们去找工作后台管理</h1></li>
	        <li class="pull-right">
	            <a class="easyui-linkbutton window-open" data-options="plain:true,iconCls:'fa fa-globe'" data-href="/">访问首页</a>
	            <a class="easyui-splitbutton" data-options="menu:'#ID-FB03-F3BD-D9D2-4CF1',iconCls:'fa fa-user'">用户</a>
	            <!-- <a class="easyui-splitbutton" data-options="menu:'#ID-DE01-DD0C-13C4-8397',iconCls:'fa fa-question-circle'">帮助中心</a> -->
	        </li>
	    </ul>
	    
	    <div class="north-navbar">
	        <ul>
	            <!-- <li>
	            	<a class="navbar-button" data-href="common/getSonMenu" data-id="1" data-level="1" data-icon="fa fa-user">个人中心</a>
	            </li> -->
	            <li>
	            	<a class="navbar-button" data-href="common/getSonMenu" data-id="4" data-level="1000" data-icon="fa fa-user">系统中心</a>
	            </li>
	            <li>
	            	<a class="navbar-button" data-href="common/getSonMenu" data-id="19" data-level="1" data-icon="fa fa-user">基础管理</a>
	            </li>
	            <li>
	            	<a class="navbar-button" data-href="common/getSonMenu" data-id="28" data-level="1" data-icon="fa fa-user">业务管理</a>
	            </li>      
	         </ul>
	    </div>
	</div>
	<!--顶部 End-->
	<!--左侧 Start-->
	<div id="west" 
	     data-options="region: 'west',title:'左侧菜单',
	     tools: [{iconCls:'fa fa-refresh',handler:function(){$.Admin.reload_all_left_menu();}},{iconCls:'fa fa-folder-o',handler:function(){$.Admin.collapse_all_left_menu();}},{iconCls:'fa fa-folder-open-o',handler:function(){$.Admin.expand_all_left_menu();}}]" style="width:170px;">
	    <div id="left" class="easyui-accordion" data-options="fit:false,border:false"></div>
	</div>
	<!--左侧 End-->
	<!--右边 Start-->
	<div id="center" data-options="region:'center'">
	    <div id="layout-tabs" class="easyui-tabs" data-options="tabPosition:'top',fit:true,border:false,plain:false">
	        <div data-options="title: '欢迎页面', href: 'index/main', iconCls: 'fa fa-home',cache: true, tools:[{iconCls:'icon-mini-refresh',handler:function(){$.Admin.refresh_tabs();}}]"></div>
	    </div>
	</div>
	<!--右边 End-->
	<!--底部 Start-->
	<div id="south" data-options="region:'south'" style="height:30px;line-height:30px;text-align:center;overflow:hidden;">@2016 版权所有 通用后台管理系统</div>
	<!--底部 End-->
	<div id="ID-FB03-F3BD-D9D2-4CF1">
	    <div iconCls="fa fa-group" data-width="400" data-height="280">普通管理员</div><div iconCls="fa fa-group" data-width="400" data-height="280">信息发布员</div>    <div class="menu-sep"></div>
	    <div class="window-location-tabs" iconCls="fa fa-search" data-icon="fa fa-search"  data-href="/Admin/Person/Profile.html" data-width="400" data-height="280">查看资料</div>
	    <div class="window-location-tabs" iconCls="fa fa-edit" data-icon="fa fa-edit"  data-href="/Admin/Person/EditProfile.html" data-width="400" data-height="280">修改资料</div>
	    <div class="window-location-tabs" iconCls="fa fa-key" data-icon="fa fa-key"  data-href="/Admin/Person/EditPassword.html" data-width="400" data-height="250">修改密码</div>
	    <div class="menu-sep"></div>
	    <div class="window-location-confirm" iconCls="fa fa-sign-out"  data-msg="确定要退出系统吗？" data-href="{:U('Public/logout')}">退出登录</div>
	</div>
	<!-- <div id="ID-DE01-DD0C-13C4-8397">
	    <div iconCls="fa fa-trash-o" data-href="/admin/index/public_clearcatche.html" data-width="350" data-height="200">清除缓存</div>
	    <div iconCls="fa fa-bar-chart" data-href="/admin/index/public_sysinfo.html" data-width="600" data-height="400">系统信息</div>
	    <div iconCls="fa fa-send-o" data-href="/admin/index/public_feedback.html" data-width="400" data-height="300">留言反馈</div>
	    <div class="menu-sep"></div>
	    <div iconCls="fa fa-book" data-type="iframe" data-href="http://www.jeasytp.com/doc.html">开发文档</div>
	    <div iconCls="fa fa-globe" data-type="iframe" data-href="http://www.jeasytp.com">官方网站</div>
	    <div class="menu-sep"></div>
	    <div iconCls="fa fa-expand">全屏模式</div>
	    <div iconCls="fa fa-info-circle" data-href="/admin/index/public_about.html" data-width="400" data-height="300">关于系统</div>
	</div> -->
	<div id="dialog-box"></div>
</body>
</html>

