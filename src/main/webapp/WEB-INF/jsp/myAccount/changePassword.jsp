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
<html>
<head>
	<base href="<%=basePath%>">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>修改密码</title>
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

	
	<script  type="text/javascript" src="hui\lib\layer\2.1\layer.js"></script>
	<style>
		body {
		    margin-top: 60px;
		    margin-bottom: 150px;
		    margin-left: 26%;
		    padding: 0px;
		    width: 100%;
		}
	</style>
</head>
<body>
	<h2>密码修改</h2>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="密码修改" style="width:100%;max-width:400px;padding:30px 60px;">
		<form action="myAccount/changeAcount" id="ff" method="post">
			<div style="margin-bottom:20px">
				<input class="easyui-passwordbox" prompt="旧密码" name="password" iconWidth="28" style="width:100%;height:34px;padding:10px" data-options="label:'旧密码:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-passwordbox" prompt="新密码" name="newPassword" iconWidth="28" style="width:100%;height:34px;padding:10px" data-options="label:'新密码:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-passwordbox" prompt="确认新密码" name="subPassword" iconWidth="28" style="width:100%;height:34px;padding:10px" data-options="label:'确认新密码:',required:true">
			</div>
		</form>
		<div style="text-align:center;padding:5px 0">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">确定</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">取消</a>
		</div>
	</div>
	<script>
		function submitForm(){
			$('#ff').form('submit',{
				success: function(data){  
					var data = eval('(' + data + ')');
					if(data.code==1){
						layer.alert('旧密码不存在');
					}
					if(data.code==2){
						layer.alert('旧密码输入错误');
					}
					if(data.code==0){
						layer.alert('新密码与确认密码不相同');
					}
					if(data.code==3){
						layer.alert('密码修改没成功,请重新操作');
					}
					if(data.code==4){
						layer.alert('密码修改成功');
					}
			    }    
			});
		}
		function clearForm(){
			window.location.href = "${pageScope.basePath }index/main";
		}
	</script>
</body>
</html>