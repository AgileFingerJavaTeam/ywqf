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
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>车位缴费年度汇总</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="css/wu.css" />
<link rel="stylesheet" type="text/css" href="css/icon.css" />
<link rel="stylesheet" type="text/css" href="css/common/bootstrap.min.css" />
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="scripts/echarts.min.js"></script>
<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
<!-- <script type="text/javascript" src="js/custom/utils.js"></script> -->
<style type="text/css">
	.w1{
		margin-bottom:0;
	}
</style>
</head>
<body>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<div>
				物业公司&nbsp;&nbsp;<input id="corps" class="easyui-combobox" name="corps"/> 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				小区名称&nbsp;&nbsp;<input class="easyui-combobox" id="community"	name="community"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				年份&nbsp;&nbsp;<input class="easyui-datebox" id="year" name="year" style="width: 100px" data-options="formatter:yearFormatter,parser:yearParser"/>  
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				月份范围&nbsp;&nbsp;<input  id="time1" name="time1" class= "easyui-combobox" style="width: 100px"/>-<input  id="time2" name="time2" class= "easyui-combobox" style="width: 100px"/>
			</div>
		</div>
		<br/>
		<br/>
		<br/>
		<div class="col-md-1"></div>
	</div>
	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
 	<div class="container-flud">
 		<div class="row" id="chart-container">
 			
 		</div>
 	</div>
   <!-- <div id="main" style="width: 100%;height:400px;"></div>-->
</body>
<script type="text/javascript">
		
    // 基于准备好的dom，初始化echarts实例
    //var myChart = echarts.init(document.getElementById('main'));
    var resizeWaiter=false;
    // 使用刚指定的配置项和数据显示图表。
   	var chartsArr = [];
   
	$(function(){
		$('#corps').combobox({    
			url:'payYearNum/corpsList',
			   method:'get',
			   valueField:'id',
			   textField:'corpName',
			   panelHeight:'auto',
			   onLoadSuccess:function(){
			   	 var data = $(this).combobox('getData');
                 $(this).combobox('select', data[0]['id']);
                 var corpid=$('#corps').val();
                 var relation_id_sign=0;
                 $('#community').combobox({
         			url:'payYearNum/communityList?id='+corpid,
         			   method:'get',
         			   valueField:'id',
         			   textField:'communityName',
         			   panelHeight:'auto',
         			   onLoadSuccess:function(){
         				   if(relation_id_sign==0){
								var data = $(this).combobox('getData');
								if(data.length>1){
									data.unshift({'id':'','communityName':'全部'});
									//console.log(data);
								}
								$(this).combobox('select', data[0]['id']);  
								relation_id_sign=1;
								$("#community").combobox("loadData", data); 
								loadeChartsCompanyList();
         				   }
         				  //loadeChartsCompanyList();
         			   },  
                 		onChange:loadeChartsCompanyList
         		}); 
			   }   
		});
		/* $("#year").datebox({
			formatter:function(date){
				var y = date.getFullYear();
				return y+"";
			}
		});  */
		//开始月份
		$("#time1").combobox({
			valueField:'month',    
			textField:'month',  
			panelHeight:'auto',
			editable:false
		});
		var monthList = [];//创建月份数组
		var startMonth=1;//起始月份
		//数组添加值（1-12月）为固定值
		for(startMonth;startMonth<13;startMonth++){
			monthList.push({"month":startMonth});
		}
		$("#time1").combobox("loadData", monthList);//下拉框加载数据
		//截止月份
		$("#time2").combobox({
			valueField:'month',    
			textField:'month',  
			panelHeight:'auto',
			editable:false
		});
		$("#time2").combobox("loadData", monthList);//下拉框加载数据
	});
	function yearFormatter(date){  
	    var y = date.getFullYear();  
	    var m = date.getMonth()+1;  
	    var d = date.getDate();  
	    return y;  
	};  
	  
	function yearParser(s){  
	    if (!s) return new Date();  
	    var y = s;  
	    var date;  
	    if (!isNaN(y)){  
	        return new Date(y,0,1);  
	    } else {  
	        return new Date();  
	    }  
	}
    function loadeChartsCompanyList(){ 
		var corps =$("#corps").val();
		var community =$("#community").val();
		var year =$("#year").val();
		var time1 =$("#time1").val();
		var time2 =$("#time2").val();
		var data = {};
		data.community =community;
		data.corps =corps;
		data.year =year;
		data.time1 =time1;
		data.time2 =time2;
		console.log(data);
		$.ajax({
		    url:'payYearNum/search',
		    type:'GET', //GET
		    data:data,
		    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data){
		    	//console.log(data);
		    	var dataLength = data.length;
		    	var domArr  = [];
		    	chartsArr=[];
		    	$('#chart-container').innerHTML = "";
		    	//根据返回来的数据创建数量一样的div容器
		    	for(var i = 0 ; i< dataLength ; i++){
		    		//domText = domText+'<div class="col-md-6" id="auto-chart-'+i+'" style="height=400px;"></div>';
		    		domArr.push(document.createElement('div'));
		    		domArr[i].setAttribute('class','col-md-6');
		    		domArr[i].setAttribute('id','auto-chart-'+i);
		    		domArr[i].style.height = '400px';
		    	}
		    	//将容器添加到dom中
		    	$("#chart-container").append(domArr);
		    	//将容器组初始化成echarts对象,并将echarts对象集中保存到一个数组中
		    	for(var i in domArr){
		    		chartsArr.push(echarts.init(domArr[i]));
		    		chartsArr[i].setOption({
		        		 title : {
		        		 	text: data[i]['name'],
							x: 'center',
							subtext: '缴费比例'+data[i]['rate'].toFixed(1)+'%',
							textAlign: 'center'
		        		 },
		        		 series : {
		        		 	name: data[i]['name'],
		                    label: {
		                        normal: {
		                        	position: 'inner',
		                            formatter: '{b}：{c} 户月 ',
		                            rich: {
		                                a: {
		                                    color: '#999',
		                                    lineHeight: 22,
		                                    align: 'center'
		                                },
		                                hr: {
		                                    borderColor: '#aaa',
		                                    width: '100%',
		                                    borderWidth: 0.5,
		                                    height: 0
		                                },
		                                b: {
		                                    fontSize: 16,
		                                    lineHeight: 33
		                                },
		                                per: {
		                                    color: '#eee',
		                                    backgroundColor: '#334455',
		                                    padding: [2, 4],
		                                    borderRadius: 2
		                                }
		                            }
		                        }
		                    },
	     		            type: 'pie',
	     		            radius: '60%',
	     		          	center : ["50%", "50%"],
	     		            data:data[i]['reslut'],
		        		 },
		        		 legend:{
		        			 orient:'top',
		        			 x:'right',
		        			 y:'30%',
		        			 data:['未缴费','已缴费']
		        		 },
		        		 color:['#FF7878','#66FF2d']
		        		 //color:['#9370DB','	#F0E68C']
		     		});
		    	}
		    }
		})
	};

	$(window).on('resize', function() {
		if(!resizeWaiter) {
			resizeWaiter = true;
			setTimeout(function() {
				//优化，限制图表resize的频率
				for(var i in chartsArr ){
					chartsArr[i].resize();
					//console.log(cs);
				}
				//myChart.resize();
				resizeWaiter = false;
			}, 100);
		}
	})
</script>
</html>

