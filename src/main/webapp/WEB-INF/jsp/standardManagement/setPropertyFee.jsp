<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../common/meta.jsp" %>
<%-- 自定义css样式 --%>
<meta charset="UTF-8">
<meta content="text/html">
<style>
    .table>tbody>tr>td{
        text-align:center;
    }
	.page-container {
	    padding: 0px;
	}
</style>
<link rel="stylesheet" href="Fontawesome/css/font-awesome.min.css">
<link rel="stylesheet" href="hui/lib/bootstrap-Switch/bootstrapSwitch.css">
<link rel="stylesheet" href="hui/lib/My97DatePicker/skin/WdatePicker.css">
</head>
<body>
<div>
	<input class="hidden" id="userid" name="userid" value="${userid }">
	<input class="hidden" id="type" name="type" value="${type }">
</div>
<div class="cl pd-5" style="margin-left:50px">
	<select id="corp" class="select-box"  style="width: 150px;">
		<!-- <option>选择物业</option> -->
	</select>
   	<select id="community" class="select-box"  style="width: 150px;">
   		<!-- <option>金立小区</option> -->
   	</select>
	<input id="likes" type="text" placeholder="请输入关键词" class="input-text ac_input" name="search_text" style="width:150px">
</div>
<div style="margin-left:50px">
	资费更新&nbsp;&nbsp;<input id="money" type="text" class="input-text ac_input" placeholder="输入新的物业费单价" style="width:150px">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<!-- <select id="hourse" class="select-box" style="width:150px">
	<option>1号楼</option>
	</select>
	<select id="door" class="select-box" style="width:150px">
	<option>1门</option>
	</select>
	<select id="floor" class="select-box" style="width:150px">
	<option>1层</option>
	</select> -->
	<input  id="hourse" type="text" class="input-text ac_input" style="width:150px" placeholder="楼号">
	<input  id="door" type="text" class="input-text ac_input" style="width:150px" placeholder="门号">
	<input  id="floor" type="text" class="input-text ac_input" style="width:150px" placeholder="层数">
	<button style="margin-left:200px" type="submit" class="btn btn-default" id="preview" onclick="modaldemo()">预览</button>
	<button type="submit" class="btn btn-default" id="update">修改</button>
</div>
<!-- dataTable 页面 -->
<div class="cl pd-5 bg-1 bk-gray mt-20"> 
	<span class="l">共有数据：<strong>88</strong> 条</span> 
</div>
<div class="page-container">
    <div class="">
        <table class="table table-border table-bordered table-hover table-bg table-sort">
            <thead>
            <tr class="text-c">
                <th style="display: none;">id</th>
                <th width="80">门牌号</th>
                <th width="80">户型</th>
                <th width="80">面积(M²)</th>
                <th width="80">物业单价(M²/月)</th>
                <th width="80">物业费合计(月)</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<!-- 预览模态框  start-->
<div id="modal-demo" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content radius">
            <div class="modal-header">
                <h3 class="modal-title">预览修改结果</h3>
                <a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void()">×</a>
            </div>
            <div class="page-container">
			    <div class="mt-20">
			        <table class="table table-border table-bordered table-hover table-bg table-new">
			            <thead>
			            <tr class="text-c">
			                <th style="display: none;">id</th>
			                <th width="80">门牌号</th>
			                <th width="80">户型</th>
			                <th width="80">面积(M²)</th>
			                <th width="80">新物业单价(M²/月)</th>
			                <th width="80">新物业费合计(月)</th>
			            </tr>
			            </thead>
			        </table>
			    </div>
			</div>
            <div class="modal-footer">
                <!-- <button class="btn btn-primary" id="Okey">确定</button> -->
                <!-- <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button> -->
            </div>
        </div>
    </div>
</div>
<!-- 预览模态框  end-->
<%@ include file="../common/footer.jsp" %>
<script type="text/javascript" src="hui/lib/bootstrap-modal/2.2.4/bootstrap-modal.js"></script>
<script type="text/javascript" src="hui/lib/bootstrap-modal/2.2.4/bootstrap-modalmanager.js"></script>
<script type="text/javascript" src="hui/lib/bootstrap-Switch/bootstrapSwitch.js"></script>
<script type="text/javascript" src="hui/lib/My97DatePicker/WdatePicker.js"></script>
<%-- 自定义js --%>
<script type="text/javascript">
$(function(){
	$.ajax({
		type: 'POST',
		url: 'payYearNum/corpsList' ,
		dataType: 'json',
		success: function(data){
			if(data.length>1){
				$('#corp').append("<option value=''>" + '全部物业公司' + "</option>");
			}
			for (var i in data) {
                var corp = data[i].corpId;
                $("#corp").append("<option value=" + corp + ">" + data[i].corpName + "</option>")
            }
			community();
		} 
	});
})
<!--小区下拉框-->
	function community(){
        var userid = $("#userid").val();
        var type = $("#type").val();
        var corpid = $("#corp").val();
        var data ={};
        data.userid=userid;
        data.type=type;
        data.corpid=corpid;
      	$.ajax({
			url:'payYearNum/communityList',
			dataType:'json',
			type:'Post',
			data:data,
			success: function(data){
				//console.log(data);
				 jQuery('#community').empty();
                 if(data.length>1){
                	 $('#community').append("<option value=''>" + '全部小区' + "</option>")
                 }
				 for (var i in data) {
					 var community = data[i].communityId;
					 $("#community").append("<option value=" +community + ">" + data[i].communityName + "</option>")
				 }
				 showDataTable();
			} 
		});
	}
//dataTable
	function showDataTable() {
		var userid =$("#userid").val();
		var type =$("#type").val();
		var corps =$("#corp").val();
		var community =$("#community").val();
		var likes =$("#likes").val();
		var hourse =$("#hourse").val();
		var door =$("#door").val();
		var floor =$("#floor").val();
		var data = {};
		data.userid =userid;
		data.type =type;
		data.community =community;
		data.corps =corps;
		data.likes =likes;
		data.hourse =hourse;
		data.door =door;
		data.floor =floor;
		$.ajax({
		    url:'setfree/freeProperty',
		    type:'POST', //GET
		    data:data,
		    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data){
		    	console.log(data);
				    	$('.table-sort').dataTable({
				    		"dom": 'tip',
				    		"data": data.rows,
				 	        destroy:true,
				 	       "columns": [
				 	           {'data': 'houseId',},
				 	           {'data': 'houseNum',},
				 	           {"data": 'area',},
				 	           {'data': 'previousEstateUnitPrice',},
				 	           {'data': 'previousEstateFee',}
				 	       ],
				 	       "sServerMethod": "POST",
				 	       //"aaSorting": [[1, "desc"]],//默认第几个排序
				 	       "bStateSave": true,//状态保存
				 	       "aoColumnDefs": [
				 	           //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
				 	           {"orderable": false, "aTargets": [0]}// 不参与排序的列
				 	       ]
				 	   });
				 	}	
		    	})
		    }
	//dataTablenew
	function showDataTableNew() {
		var userid =$("#userid").val();
		var type =$("#type").val();
		var corps =$("#corp").val();
		var community =$("#community").val();
		var likes =$("#likes").val();
		var hourse =$("#hourse").val();
		var door =$("#door").val();
		var floor =$("#floor").val();
		var money =$("#money").val();
		var data = {};
		data.userid =userid;
		data.type =type;
		data.community =community;
		data.corps =corps;
		data.likes =likes;
		data.hourse =hourse;
		data.door =door;
		data.floor =floor;
		data.money =money;
		$.ajax({
		    url:'setfree/freePropertyNew',
		    type:'POST', //GET
		    data:data,
		    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data){
		    	console.log(data);
				    	$('.table-new').dataTable({
				    		"dom": 'tip',
				    		"data": data.rows,
				 	        destroy:true,
				 	       "columns": [
				 	           {'data': 'houseId',},
				 	           {'data': 'houseNum',},
				 	           {"data": 'area',},
				 	           {'data': 'previousEstateUnitPrice',},
				 	           {'data': 'previousEstateFee',}
				 	       ],
				 	       "sServerMethod": "POST",
				 	       //"aaSorting": [[1, "desc"]],//默认第几个排序
				 	       "bStateSave": true,//状态保存
				 	       "aoColumnDefs": [
				 	           //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
				 	           {"orderable": false, "aTargets": [0]}// 不参与排序的列
				 	       ]
				 	   });
				 	}	
		    	})
		    }
	 //预览模态框
    function modaldemo(){
    	$('#modal-demo').modal("show"); //显示模态框
    	showDataTableNew();
	 }
	<!--------------物业公司改变，小区下拉框随动，并且进行搜索------------------>
	$("#corp").change(function(){
		community();
	})
	<!--------------小区改变进行搜索------------------>
	$("#community").change(function(){
		showDataTable();
	})
</script>
</body>
</html>