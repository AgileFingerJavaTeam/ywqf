<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../common/meta.jsp" %>
<%-- 自定义css样式 --%>
<style type="text/css">
    /* dataTables列内容居中 */
    .table>tbody>tr>td {
        text-align: center;
    }
    .bg{
    	 background-color:gainsboro; height:2.8em;
    	 border: 1px solid wheat;
    }
    .bga{
    	background-color:dimgrey; height:2.8em;
    	border: 1px solid wheat;
    }
    .sc{
    	color:white;
    }

	.statis{ 
		background-color:#1D69A9;
		width:100%; 
		height:2.8em; 
		margin:0 auto; 
		overflow:hidden; 
		position: fixed; 
		bottom:0;
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
	<div class="container-fluid statis">
	    <div class="row">
			<div class="col-md-5 bg">查询月份:<strong id="year"></strong></div>
			<div class="col-md-2 bga"><font class="sc">总车位</font><strong id="people" class="sc"></strong><font class="sc">个</font></div>
			<div class="col-md-3 bga"><font class="sc">缴费</font><strong id="endMoney" class="sc"></strong><font class="sc">户/欠费</font><strong id="noEndMoney" class="sc"></strong><font class="sc">户</font></div>
			<div class="col-md-2 bga"><font class="sc">缴费比例：</font><strong id="percentage" class="sc"></strong><font class="sc">%</font></div>
		</div>
	</div>
	<div class="page-container">
		<div class="text-c">
			<input type="text" placeholder="请输入关键词" class="input-text ac_input" name="search_text" value="" id="at_search" autocomplete="off" style="width:250px"><button type="submit" class="btn btn-default" id="search_button">搜索</button>
			
			<span class="select-box" style="width: 15%;display: inline-block" onchange="change('1')">
				<select class="select" size="1" name="demo1" id="company">
		 		</select>
			</span> 
			<span class="select-box" style="width: 15%;display: inline-block" onchange="change('2')">
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

		    $(function(){ 
			    $.ajax({
			    	url:"corpAndCommunity/getCorpAndCommunity",
			    	type:"post",
			    	dataType:"json",
			    	success:function(data){
			    		var cours = data.rows;
			    		var community = data.total;
			    		if(data.type==0){
			    			$("#company").append("<option value="+cours[0].corpId+">"+cours[0].corpName+"</option>")
			    			for(var i=0;i<community.length;i++){
			    				$("#community").append("<option value="+community[i].communityId+">"+community[i].communityName+"</option>")
			    			}
			    		}else{
			    			for(var i=0;i<cours.length;i++){
			    				$("#company").append("<option value="+cours[i].corpId+">"+cours[i].corpName+"</option>")
			    			}
			    			for(var i=0;i<community.length;i++){
			    				$("#community").append("<option value="+community[i].communityId+">"+community[i].communityName+"</option>")
			    			}
			    		}
			    		
			    		var date=new Date;
						var year=date.getFullYear(); 
						var month=date.getMonth()+1;
						month =(month<10 ? "0"+month:month); 
						var mydate = (year.toString()+"-"+month.toString());
						
					    var at_marchant_search={};
					    at_marchant_search.checked=2;
					    at_marchant_search.timeYearMonth=mydate
//			 		    at_marchant_search.selectCompanyID=1
			    		at_marchant_search.selectCompanyID=cours[0].corpId;
					    at_marchant_search.selectcommunityID=community[0].communityId;
			    		$.ajax({
							url:"parking/getParkingDate",
							type:"POST",
							data:at_marchant_search,
							dataType:"json",
							success:function (data){
								$('#Ddl_Year').val(mydate);
								
								$('#people').text(data.all);
								$('#year').text(mydate);
								$('#endMoney').text(data.pay);
								$('#noEndMoney').text(data.noPay);
								$('#percentage').text(data.percentage);
								
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
												{'data': 'previousParkingUnitPrice',
												 'render':function (data,type,row,meta) {
													 return  '<div style="text-align: right;">'+data+'</div>';
                                                 }},
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
			    })


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
		    $('#search_button').click(function(){
		    	change();
		    });
		    
			function change(e){
				var search = $('#at_search').val();
                var b=$("input[name='moneycheck']:checked").length;
                var at_marchant_search={};
                if(e==1){
                	var selectCompanyID = $('#company').val();
                	
                }else{
                	var selectCompanyID = $('#company').val();
                    var selectcommunityID = $('#community').val();
                }
                
                
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
                
                at_marchant_search.selectCompanyID=selectCompanyID;
                at_marchant_search.selectcommunityID=selectcommunityID;
                at_marchant_search.search = search;
                at_marchant_search.isSelect = e;
                $.ajax({
                    type:'post',
                    data:at_marchant_search,
                    url: "parking/getParkingDate",
                    datatype:'json',
                    success:function (data){
//                     	$('#Ddl_Year').val(time);
                    	var community = data.community;
                    	
                    	$('#people').text(data.all);
						$('#year').text(time);
						$('#endMoney').text(data.pay);
						$('#noEndMoney').text(data.noPay);
						$('#percentage').text(data.percentage);
                    	
                    	if(e==1){
                    		$("#community").empty();
                        	for(var i=0;i<community.length;i++){
    		    				$("#community").append("<option value="+community[i].communityId+">"+community[i].communityName+"</option>")
    		    			}
                    	}
                    	
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
    									{'data': 'previousParkingUnitPrice',
                                            'render':function (data,type,row,meta) {
                                                return  '<div style="text-align: right;">'+data+'</div>';
                                            }},
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