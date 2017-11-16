<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../common/meta.jsp" %>
<%-- 自定义css样式 --%>
<style type="text/css">
    /* dataTables列内容居中 */
    .table>tbody>tr>td {
        text-align: center;
    }

</style>

<meta charset="UTF-8">
<meta content="text/html">

</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		物业财务管理 <span class="c-gray en">&gt;</span> 车位缴费/欠费信息查看 <a
			class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<div class="text-c">
			<input type="text" name="" id="at_marchant_search" placeholder=" 查询"
				style="width: 250px" class="input-text" onchange="change()">
			<button name="" id="" class="btn btn-success" type="submit">
				<i class="Hui-iconfont">&#xe665;</i>
			</button>
			<span class="select-box inline"> <select name=""
				class="select">
					<option value="0">全部分类</option>
					<option value="1">分类一</option>
					<option value="2">分类二</option>
			</select>
			</span> <span class="select-box inline"> <select name=""
				class="select">
					<option value="0">全部分类</option>
					<option value="1">分类一</option>
					<option value="2">分类二</option>
			</select>
			</span> 缴费年月： <input type="checkbox" name="moneycheck" value="1" onchange="change()">已缴费
			&nbsp;<input type="checkbox" name="moneycheck" value="0" onchange="change()">未缴费
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="http://www.divcss5.com/"
				title="转到DIVCSS5主页">导出</a>
		</div>
		
		<div class="mt-20">
			<table id="parking" class="table table-border table-bordered table-bg table-hover table-sort">
				<thead>
					<tr class="text-c">
						<th width="80">车位编号</th>
						<th width="80">车牌号</th>
						<th width="80">门牌号</th>
						<th width="80">车主姓名</th>
						<th width="60">称谓</th>
						<th width="85">联系电话</th>
						<th width="85">备用联系电话</th>
						<th width="85">车位费金额</th>
						<th width="85">缴费状态</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
	<%@ include file="../common/footer.jsp" %>
	<script type="text/javascript">
			$.ajax({
				url:"parking/getParkingDate",
				type:"POST",
				dataType:"json",
				success:function (data){
					console.log(data)
					$('#parking').dataTable({
						"data": data.rows,
						"columns": [
							{'data': 'parkingNum'},
							{'data': 'licensePlateNumber'},
							{'data': 'houseNum'},
							{'data': 'carOwnerName'},
							{'data':function(value){
								var a = value.gender;
								if(a == 1){
									return '男'
								}else{
									return '女'
								}
							}},
							{'data': 'carOwnerTel'},
							{'data': 'carOwnerStandbyTel'},
							{'data': 'paymentAmount'},
							{'data': function(value){
								var a = value.paymentStatus;
								if(a == 1){
									return '已缴费'
								}else{
									return '未缴费'
								}
							}}
						],
						 "sServerMethod":"POST",
					        "aaSorting": [[ 1, "desc" ]],//默认第几个排序
					        "bStateSave": true,//状态保存
					        "aoColumnDefs": [
					            //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
					            {"orderable":false,"aTargets":[0]}// 不参与排序的列
					        ]
					});
				}
			});
			
	

	
	</script>
</body>
</html>