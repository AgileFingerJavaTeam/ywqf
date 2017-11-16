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
			<table id="estatePay" class="table table-border table-bordered table-bg table-hover table-sort">
				<thead>
					<tr class="text-c">
						<th width="40">编号</th>
						<th width="70">门牌号</th>
						<th width="40">业主</th>
						<th width="80">手机号</th>
						<th width="85">备用手机号</th>
						<th width="40">面积</th>
						<th width="85">应缴金额/月</th>
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
		    at_marchant_search.timeYearMonth=mydate;
		    /*  登录人所在物业公司ID ---selectCompanyID*/
// 		    at_marchant_search.selectCompanyID=8000;
		    var a = 0;
		    $(function(){
		    	$.ajax({
					url:"estatePay/getEstatePayQuery",
					type:"POST",
					data:at_marchant_search,
					dataType:"json",
					success:function (data){
						$('#Ddl_Year').val(mydate);
						$('#estatePay').dataTable({
							"data": data.rows,
							destroy:true,
							"columns": [
								{'data': function(){
									
									return ++a;
								}},
								{'data': 'houseNum'},
								{'data': 'ownerName'},
								{'data': 'ownerTel'},
								{'data': 'ownerStandbyTel'},
								{'data': 'area'},
								{'data': 'previousEstateFee'},
								{'data': function(value){
									var a = value.status;
									if(a == 1){
										return '已缴费'
									}else{
										return '未缴费'
									} 
								}},
// 								{'data': 'paymentAmount'},
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
//                 var selectcommunityID = $('#community').val();
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
// 					at_marchant_search.timeYearMonth=$dp.cal.getNewP('y');
					var yyy = $dp.cal.getNewP('y');
	                var mmm = $dp.cal.getNewP('M');
	                time=yyy+'-'+mmm;
	                at_marchant_search.timeYearMonth=yyy+'-'+mmm
				}else{
					time=$('#Ddl_Year').val();
					at_marchant_search.timeYearMonth=$('#Ddl_Year').val();
				}
				/*  所选择的物业公司ID ---selectCompanyID*/
//                 at_marchant_search.selectCompanyID=selectCompanyID;
//                 at_marchant_search.selectcommunityID=selectcommunityID;
				var a =0;
                $.ajax({
                    type:'post',
                    data:at_marchant_search,
                    url: "estatePay/getEstatePayQuery",
                    datatype:'json',
                    success:function (data){
						$('#Ddl_Year').val(time);
						$('#estatePay').dataTable({
							"data": data.rows,
							destroy:true,
							"columns": [
								{'data': function(){
									
									return ++a;
								}},
								{'data': 'houseNum'},
								{'data': 'ownerName'},
								{'data': 'ownerTel'},
								{'data': 'ownerStandbyTel'},
								{'data': 'area'},
								{'data': 'previousEstateFee'},
								{'data': function(value){
									var a = value.status;
									if(a == 1){
										return '已缴费'
									}else{
										return '未缴费'
									} 
								}},
// 								{'data': 'paymentAmount'},
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