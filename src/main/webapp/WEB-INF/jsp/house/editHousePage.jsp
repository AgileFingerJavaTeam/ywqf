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
<form action="house/subEditHouseInfo" id="formsub" class="table_form" method="post">
     <table class="table_list">
         
		<tr >
	             <th width="80" >物业公司：</th>
	             <td >
					 <input type="hidden"  name="id" value="${data.id}"/>
	             		<input type="hidden"  name="corp_id" id="corp_id" value="${corp_id}"/>
	            	  <input type="text"   name="corpsname" id="corps_name" value="${corpsname}" class="easyui-textbox easyui-validatebox" data-options="readonly:true"/>
	             </td>
	              <th width="80" >小区：</th>
	             <td >	             
	            	  <input type="text"   name="community_id"  value="${data.communityName}" id="community_name" class="easyui-textbox easyui-validatebox" data-options="required:true"/>
	             </td>                    
         </tr>
         <tr>
				 <th  width="80">楼号：</th>
	             <td >
	                  <input type="text" id="building"  name="building"  value="${data.building}"  class="easyui-textbox easyui-validatebox" data-options="required:true"/>
	             </td>
	              <th width="80">门号：</th>
	             <td >
				         <input  id="unit"  name="unit"  value="${data.unit}" class="easyui-textbox easyui-validatebox" data-options="required:true" />
	             </td>   
		 </tr>
		 <tr>
				 <th  width="80">层号：</th>
	             <td >
	                  <input type="text" id="floor"  name="floor" value="${data.floor}" class="easyui-textbox easyui-validatebox" data-options="required:true"/>
	             </td>
	              <th width="80">房号：</th>
	             <td >
				         <input  id="room_num"  name="room_num" value="${data.roomNum}" class="easyui-textbox easyui-validatebox" data-options="required:true" />
	             </td>   
		 </tr>
      	<tr>
				 <th  width="80">户型：</th>
	             <td >

	                  <input type="text" id="room_type"  value="${data.houseTypeName}" name="house_type_id" class="easyui-textbox easyui-validatebox" data-options="required:true"/>
	            	 
	             </td>
	              <th width="80">面积 ：</th>
	             <td >
				         <input  id="area"  name="area" value="${data.area}"  class="easyui-textbox easyui-validatebox" data-options="required:true" />
	             </td>   
		 </tr>
		 <tr>
				 <th  width="80">物业单价：</th>
	             <td >
	                  <input type="text" id="now_estate_unit_price"  name="now_estate_unit_price" value="${data.nowEstateUnitPrice}" class="easyui-textbox easyui-validatebox" data-options="required:true"/>
	             </td>
	              <th width="80">户主姓名：</th>
	             <td >
				         <input  id="owner_name"  name="owner_name" value="${data.ownerName}"  class="easyui-textbox easyui-validatebox" data-options="required:true" />
	             </td>   
		 </tr>
		 <tr>
				 <th  width="80">联系电话：</th>
	             <td >
	                  <input type="text" id="owner_tel"  name="owner_tel" value="${data.ownerTel}"  class="easyui-textbox easyui-validatebox" data-options="required:true"/>
	             </td>
	              <th width="80">备用电话：</th>
	             <td >
				         <input  id="owner_standby_tel"  name="owner_standby_tel" value="${data.ownerStandbyTel}"  class="easyui-textbox easyui-validatebox" data-options="required:true" />
	             </td>   
		 </tr>
		 <tr>
				 <th  width="80">家庭成员：</th>
	             <td >
	                  <input type="text" id="family_size"  name="family_size" value="${data.familySize}" class="easyui-textbox easyui-validatebox" data-options="required:true"/>
	             </td>
	              <th width="80">物业费合计：</th>
	             <td >
				         <input  id="now_estate_fee"  name="now_estate_fee" value="${data.nowEstateFee}" class="easyui-textbox easyui-validatebox" data-options="required:true" />
	             </td>   
		 </tr>
        <tr>
            <td colspan="4">
                <button type="button" class="table_form_close_dialog " style="float:right" >关闭</button>               
                <button type="button" id="sub" class=" table_form_submit_dialog" style="float:right">保存</button>
            </td>
        </tr>
     </table>
</form>
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
        /*onSelect:function (namelist) {
            $("#room_type").textbox().textbox("setValue",namelist.id)
        }*/
    }) ;
	$('#sub').click(function () {



    })

</script>


