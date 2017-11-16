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
<form action="ForgetPassword/applyResetPassword" id="formsub" class="table_form" method="post">
    <table class="table_list">

        <tr >
            <th width="80" >公司名称：</th>
            <td >
                <input type="text"   name="corp_name" class="easyui-textbox easyui-validatebox" data-options="required:true"/>
            </td>
        </tr>
        <tr>
            <th  width="80">姓名：</th>
            <td >
                <input type="text"  name="real_name"  class="easyui-textbox easyui-validatebox" data-options="required:true"/>
            </td>
            <th width="80">手机号：</th>
            <td >
                <input name="phone" class="easyui-textbox easyui-validatebox" data-options="required:true" />
            </td>
        </tr>
        <tr>
            <td colspan="4">
                <button type="button" class="table_form_submit_dialog" style="float:right">申请重置</button>
            </td>
        </tr>
    </table>
</form>



