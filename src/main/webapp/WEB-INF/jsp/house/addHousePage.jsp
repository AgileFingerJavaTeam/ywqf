<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="../common/meta.jsp" %>
<%-- 自定义css样式 --%>
<meta charset="UTF-8">
<meta content="text/html">

</head>
<body>
<%--<div style="padding:10px 90px 20px 130px">--%>
<form action="house/subHouseInfo" method="post" style="text-align: center">
	<div style="500px">
		<table   style="margin:auto ">

			<tr>
				<th   align="right">物业公司：</th>
				<td >
					<input type="hidden"  name="corp_id" id="corp_id" value="${corp_id}"/>
					<%--
                                          <input type="text"   name="corpsname" id="corps_name" value="${corpsname}" class="easyui-textbox easyui-validatebox" data-options="readonly:true"/>
                    --%>
					<span>${corpsname}</span>
				</td>
			</tr>
			<tr>
				<th  align="right">小区：</th>
				<td >
					<input type="text" placeholder="默认尺寸" class="input-text radius size-M">
				</td>
			</tr>
			<tr>
				<th  align="right">楼号：</th>
				<td >
					<input type="text" placeholder="默认尺寸" class="input-text radius size-M">
				</td>
			</tr>
			<tr>
				<th  align="right">门号：</th>
				<td >
					<input type="text" placeholder="默认尺寸" class="input-text radius size-M">
				</td>
			</tr>
			<tr>
				<th align="right">层号：</th>
				<td >
					<input type="text" placeholder="默认尺寸" class="input-text radius size-M">
				</td>
			</tr>
			<tr>
				<th align="right">房号：</th>
				<td >
					<input type="text" placeholder="默认尺寸" class="input-text radius size-M">
					<input id="house_num" name="house_num" type="hidden">
				</td>
			</tr>
			<tr>
				<th  width="80" align="right">户型：</th>
				<td >
					<input type="text" placeholder="默认尺寸" class="input-text radius size-M">

				</td>
			</tr>
			<tr>
				<th align="right">面积 ：</th>
				<td >
					<input type="text" placeholder="默认尺寸" class="input-text radius size-M">
				</td>
			</tr>
			<tr>
				<th  align="right">物业单价：</th>
				<td >
					<input type="text" placeholder="默认尺寸" class="input-text radius size-M">
				</td>
			</tr>
			<tr>
				<th align="right">户主姓名：</th>
				<td >
					<input type="text" placeholder="默认尺寸" class="input-text radius size-M">
				</td>
			</tr>
			<tr>
				<th align="right">联系电话：</th>
				<td >
					<input type="text" placeholder="默认尺寸" class="input-text radius size-M">
				</td>
			</tr>
			<tr>
				<th  align="right">备用电话：</th>
				<td >
					<input type="text" placeholder="默认尺寸" class="input-text radius size-M">
				</td>
			</tr>
			<tr>
				<th  align="right">家庭成员：</th>
				<td >
					<input type="text" placeholder="默认尺寸" class="input-text radius size-M">
				</td>
			</tr>
			<tr>
				<th align="right">物业费合计：</th>
				<td >
					<input type="text" placeholder="默认尺寸" class="input-text radius size-M">
				</td>
			</tr>
			<tr>
				<td colspan="4" align="right">
					<button type="button" class="table_form_close_dialog " style="float:right" >关闭</button>
					<button type="button" id="sub" class="table_form_submit_dialog" style="float:right">保存</button>
				</td>
			</tr>
		</table>
	</div>

</form>
<%--</div>--%>
	<script>
var corp_id=$('#corp_id').val();
/* 根据物业查询小区名称*/
$("#community_name").combobox({    
	  url:"house/getCommunityName",
	  method : "post",  
	  queryParams: {"corp_id":corp_id},
	  valueField: 'id',
	  textField: 'communityName',

	  }) ;

/* 查询户型  */
$("#room_type").combobox({    
	  url:"house/getRoomType",
	  method : "post",  
	  valueField: 'id',
	  textField: 'houseTypeName',

	  }) ;


</script>
</body>
</html>


