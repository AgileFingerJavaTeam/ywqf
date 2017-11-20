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
	<title>修改绑定手机</title>
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

	<script  type="text/javascript" src="hui/lib/layer/2.1/layer.js"></script>
	
	<style>
		body {
/* 		    margin: 150px; */
		    margin-top: 120px;
/* 		    margin-right: 170px; */
		    margin-bottom: 150px;
		    margin-left: 26%;
		    padding: 0px;
		    width: 100%;
		}
	</style>
</head>
<body>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="修改绑定手机" style="width:100%;max-width:400px;padding:30px 60px;" text-align="center" margin="0 auto">
		<form action="myAccount/changePhone" id="ff" method="post">
			<div style="margin-bottom:20px">
				<input id="oldPhone" class="easyui-textbox" type="text" name="oldTelephone" style="width:100%" data-options="label:'原手机号:'" readonly="readonly">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" type="text" name="newTelephone" style="width:100%" data-options="label:'新手机号:',required:true">
			</div>
		</form>
		<div style="text-align:center;padding:5px 0">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">确定</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">取消</a>
		</div>
	</div>
	
	<script>
		$(function(){
			$.ajax({
				url:"myAccount/searchOldPhone",
				type:"POST",
// 				data:at_marchant_search,
				dataType:"json",
				success:function (data){
					
					var phone =data.phone;
					var q = phone[0].telephone;
					console.log(q);
					$('#oldPhone').textbox('setValue',q);
				}
			});
		})
	
		function submitForm(){
			$('#ff').form('submit',{
				success: function(data){  
					var data = eval('(' + data + ')');
					if(data.code==1){
						layer.alert('手机号修改失败,请重新操作');
					}
					if(data.code==0){
						layer.alert('旧手机号与新手机号相同');
					}
					if(data.code==2){
						layer.alert('修改成功');
					}
			    }    
			});
		}
		
// 		function submitForm(){
// 			$('#ff').form('submit');
// 		}
		function clearForm(){
			window.location.href = "${pageScope.basePath }index/main";
		}
	</script>
</body>
</html>