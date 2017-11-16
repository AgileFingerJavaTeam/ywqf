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
	<title>公司信息管理界面</title>
	<meta name="keywords" content="">
	<meta name="description" content="">
	<meta http-equiv="cleartype" content="on">

    <link rel="stylesheet" type="text/css" href="easyui/1.5.2/themes/bootstrap/easyui.css" />
    <link rel="stylesheet" href="Fontawesome/css/platform-1.css">
    <link rel="stylesheet" type="text/css" href="scripts/theme/default/layer.css">


</head>
<body>
	<div class="page" position:relative; left:-20px;>
	<div class="form-div" style="width:100%;max-width:400px;padding:30px 60px;" text-align="center" margin="0 auto">
		<form action="CompanyInfor/editCompanyInfor" id="ff" method="post">
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="corpName" iconWidth="28" value="${data.data.corpName }" style="width:100%;height:34px;padding:10px" data-options="label:'公司名称:',required:true" easytip="disappear:lost-focus;theme:blue;"  readonly>
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" prompt="等级" message="请输入公司等级！" name="aptitude" value="${data.data.aptitude }" iconWidth="28" style="width:100%;height:34px;padding:10px" data-options="label:'资质:',required:true,missingMessage:'该输入项为必输项！'" easytip="disappear:lost-focus;theme:blue;">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" prompt="清输入注册地址" ajax-message="请输入公司注册地址!" name="regAddress" value="${data.data.regAddress }" iconWidth="28" style="width:100%;height:34px;padding:10px" data-options="label:'注册地址:',required:true,missingMessage:'该输入项为必输项！'" easytip="disappear:lost-focus;theme:blue;">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" prompt="请输入公司简介" ajax-message="请输入公司简介!" name="description" value="${data.data.description }" iconWidth="28" style="width:100%;height:34px;padding:10px" data-options="label:'公司简介:',required:true,missingMessage:'该输入项为必输项！'" easytip="disappear:lost-focus;theme:blue;" style="width:100px;height:30px;">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" prompt="请输入电话" ajax-message="请输入电话!" easyform="length:11;" name="serviceTel" value="${data.data.serviceTel }" iconWidth="28" style="width:100%;height:34px;padding:10px" data-options="label:'服务电话:',required:true,missingMessage:'该输入项为必输项！'" easytip="disappear:lost-focus;theme:blue;">
			</div>
		</form>
		<div style="text-align:center;padding:5px 0">
			<input value="保 存" type="submit" style="margin-right:20px; margin-top:20px;" onclick="submitForm()">
			<%--<a href="javascript:void(0)" class="easyui-linkbutton"  style="width:80px">保存</a>--%>
			<!-- <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">取消</a> -->
		</div>
	</div>
	</div>
    <script type="text/javascript" src="scripts/jquery-2.1.0.min.js"></script>
    <script type="text/javascript" src="scripts/easyform.js"></script>
    <script type="text/javascript" src="easyui/1.5.2/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="scripts/layer.js"></script>
	<script>
		function submitForm(){
			$('#ff').form('submit',{
				success: function(data){
					var data = eval('(' + data + ')');
					if(data.status==1){
                        layer.alert('保存成功！', {icon: 6});
					}
					if(data.status==0){
                        layer.alert('保存失败！', {icon: 6});
					}
			    }    
			});
		}

        $(document).ready(function ()
        {
            $('#ff').easyform();
        });

        var HEIGHT = $(window).innerHeight();

        $(document).ready(function(){

            $(".page").css("height", HEIGHT+"px");

        });


	</script>
</body>
</html>