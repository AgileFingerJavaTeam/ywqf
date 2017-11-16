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
<form action="house/subDelHouseInfo" id="formsub" class="table_form" method="post">
     <table class="table_list">
         
		<tr>
					 <input type="hidden"  name="id" value="${data.id}"/>
					是否删除本条记录？
		 </tr>
        <tr>
            <td colspan="4">
                <button type="button" class="table_form_close_dialog " style="float:right" >否</button>
                <button type="button" id="sub" class=" table_form_submit_dialog" style="float:right">是</button>
            </td>
        </tr>
     </table>
</form>
<script>

</script>


