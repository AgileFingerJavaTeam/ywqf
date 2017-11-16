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
		物业财务管理 <span class="c-gray en">&gt;</span> 月度缴费/欠费信息查看 <a
			class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<div class="text-c">
			<input type="text" name="" id="at_marchant_search" placeholder=" 查询"
				style="width: 250px" class="input-text">
			<button name="" id="" class="btn btn-success" type="submit">
				<i class="Hui-iconfont">&#xe665;</i>
			</button>
			<span class="select-box" style="width: 15%;display: inline-block" onchange="change()">
				<select class="select" size="1" name="demo1" id="company">
		 		</select>
			</span> 
			<span class="select-box" style="width: 15%;display: inline-block">
				<select class="select" size="1" name="demo1" id="community" >
				</select>
			</span>
			缴费年份：
			<input id="Ddl_Year" name="timeYear" type="text"  onfocus="WdatePicker({skin:'default',dateFmt:'yyyy-MM', Mchanged: cMonthFunc ,ychanged: cYearFunc})" class="Wdate input-text" style=" width:80px;"/>
			<input type="checkbox" name="moneycheck" value="1" onchange="change()">已缴费
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
			var date=new Date;
			var year=date.getFullYear(); 
			var month=date.getMonth()+1;
			month =(month<10 ? "0"+month:month); 
			var mydate = (year.toString()+"-"+month.toString());
			
		    var at_marchant_search={};
		    at_marchant_search.checked=2;
		    at_marchant_search.timeYearMonth=mydate
// 		    at_marchant_search.selectCompanyID=1
		    $(function(){
				$.ajax({
					url:"parking/getParkingDate",
					type:"POST",
					data:at_marchant_search,
					dataType:"json",
					success:function (data){
						$('#Ddl_Year').val(mydate);
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
												return '先生'
											}else{
												return '女士'
											}
										}},
										{'data': 'carOwnerTel'},
										{'data': 'carOwnerStandbyTel'},
										{'data': 'previousParkingUnitPrice'},
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
						        "aaSorting": [[ 1, "asc" ]],//默认第几个排序
						        "bStateSave": true,//状态保存
						        "aoColumnDefs": [
						            //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
						            {"orderable":false,"aTargets":[0]}// 不参与排序的列
						        ]
						});
					}
				});
			    
	
			    
// 			    $.ajax({
// 			    	url:"heating/getHeatingCorps",
// 			    	type:"post",
// 			    	dataType:"json",
// 			    	success:function(data){
// 			    		var cours = data.rows;
// 			    		var community = data.total;
// 			    		if(data.type==0){
// 			    			$("#company").append("<option value="+cours[0].corpsID+">"+cours[0].corpName+"</option>")
// 			    			for(var i=0;i<community.length;i++){
// 			    				$("#community").append("<option value="+community[i].communityId+">"+community[i].communityName+"</option>")
// 			    			}
// 			    		}else{
// 			    			for(var i=0;i<cours.length;i++){
// 			    				$("#company").append("<option value="+cours[i].corpsID+">"+cours[i].corpName+"</option>")
// 			    			}
// 			    			$("#community").append("<option value="+0+">全部"+"</option>")
// 			    		}
			    		
// 			    	}
// 			    })
		    })
		    function cYearFunc(){
		    	cFunc('y');
		    }
		    function cMonthFunc(){
		    	cFunc('M');
		    }
		    function cFunc(who){
		    	change();
		    }
		    
		    
			function change(){
                var b=$("input[name='moneycheck']:checked").length;
//                 var selectCompanyID = $('#company').val();
                var at_marchant_search={};
                if(b==2 || b==0){
                	at_marchant_search.checked=2;
                }else{
                	$("input[name='moneycheck']:checked").each(
                            function() {
                            	at_marchant_search.checked=$(this).val(); 
                            }
                        );
                }
                var time;
                if($dp.cal){
                	var yyy = $dp.cal.getNewP('y');
                    var mmm = $dp.cal.getNewP('M');
                    time = yyy+'-'+mmm;
                    at_marchant_search.timeYearMonth=yyy+'-'+mmm;
                }else{
                	time = $('#Ddl_Year').val();
                	at_marchant_search.timeYearMonth=$('#Ddl_Year').val();
                }
                
//                 at_marchant_search.timeYearMonth=$('#Ddl_Year').val();
//                 at_marchant_search.selectCompanyID=selectCompanyID;
                $.ajax({
                    type:'post',
                    data:at_marchant_search,
                    url: "parking/getParkingDate",
                    datatype:'json',
                    success:function (data){
//                     	$('#Ddl_Year').val(time);
//                     	var community = data.community;
// 		    			$("#community").empty();
//                     	for(var i=0;i<community.length;i++){
// 		    				$("#community").append("<option value="+community[i].communityId+">"+community[i].communityName+"</option>")
// 		    			}
                    	
    					$('#parking').dataTable({
    						"bDestroy":true,
    						"data": data.rows,
    						"columns": [
    									{'data': 'parkingNum'},
    									{'data': 'licensePlateNumber'},
    									{'data': 'houseNum'},
    									{'data': 'carOwnerName'},
    									{'data':function(value){
    										var a = value.gender;
    										if(a == 1){
    											return '先生'
    										}else{
    											return '女士'
    										}
    									}},
    									{'data': 'carOwnerTel'},
    									{'data': 'carOwnerStandbyTel'},
    									{'data': 'previousParkingUnitPrice'},
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
    					        "aaSorting": [[ 1, "asc" ]],//默认第几个排序
    					        "bStateSave": true,//状态保存
    					        "aoColumnDefs": [
    					            //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
    					            {"orderable":false,"aTargets":[0]}// 不参与排序的列
    					        ]
    					});
    				}

                });
			}
	</script>
</body>
</html>