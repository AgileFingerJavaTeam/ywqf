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
<title>物业缴费年度汇总</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="css/wu.css" />
<link rel="stylesheet" type="text/css" href="css/icon.css" />
<link rel="stylesheet" type="text/css" href="css/common/bootstrap.min.css" />
<link rel="stylesheet" href="Fontawesome/css/font-awesome.min.css">
<link rel="stylesheet" href="hui/lib/bootstrap-Switch/bootstrapSwitch.css">
<link rel="stylesheet" href="hui/lib/My97DatePicker/skin/WdatePicker.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="scripts/echarts.min.js"></script>
<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
<script type="text/javascript" src="hui/lib/bootstrap-modal/2.2.4/bootstrap-modal.js"></script>
<script type="text/javascript" src="hui/lib/bootstrap-modal/2.2.4/bootstrap-modalmanager.js"></script>
<script type="text/javascript" src="hui/lib/bootstrap-Switch/bootstrapSwitch.js"></script>
<script type="text/javascript" src="hui/lib/My97DatePicker/WdatePicker.js"></script>
<!-- <script type="text/javascript" src="js/custom/utils.js"></script> -->
<style type="text/css">
</style>
</head>
<body>
	<input class="hidden" id="userid" name="userid" value="${userid }">
	<input class="hidden" id="type" name="type" value="${type }">
	<div style="margin-top:20px;">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		物业公司&nbsp;&nbsp;
		<select id="corp" class="select-box" name="corp" style="width: 150px;"></select> 
		小区名称&nbsp;&nbsp;
		<select id="community" name="community" style="width: 150px;"></select>
		&nbsp;&nbsp;
 		年份&nbsp;&nbsp;
 		<input id="year" name="year" type="text" runat="server" onfocus="WdatePicker({skin:'default',dateFmt:'yyyy',ychanged:yearChange()})" class="Wdate select-box mt-20" style="width: 150px;"/>
 		&nbsp;&nbsp;
 		时间范围&nbsp;&nbsp;
 		<input id="timeStart" name="timeStart" type="text" runat="server" onfocus="WdatePicker({skin:'default',dateFmt:'MM'})" class="Wdate select-box mt-20" style="width: 150px;"/>
		-<input id="timeEnd" name="timeEnd" type="text" runat="server" onfocus="WdatePicker({skin:'default',dateFmt:'MM',onpicked:timeChange})" class="Wdate select-box mt-20" style="width: 150px;"/>
	</div>
	<br/>
	<br/>	
	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
 	<div class="container-flud">
 		<div class="row" id="chart-container">
 			
 		</div>
 	</div>
</body>
<script type="text/javascript">
		
    var resizeWaiter=false;
    // 使用刚指定的配置项和数据显示图表。
   	var chartsArr = [];
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
	});
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
				 loadeChartsCompanyList();
			} 
		});
	}
	<!----------------------ajax请求echarts加载开始----------------------------->
	function loadeChartsCompanyList(){ 
		var userid =$("#userid").val();
		var type =$("#type").val();
		var corps =$("#corp").val();
		var community =$("#community").val();
		var year =$("#year").val();
		var timeStart =$("#timeStart").val();
		var timeEnd =$("#timeEnd").val();
		var data = {};
		data.userid =userid;
		data.type =type;
		data.community =community;
		data.corps =corps;
		data.year =year;
		data.timeStart =timeStart;
		data.timeEnd =timeEnd;
		$.ajax({
		    url:'payYearNum/search',
		    type:'GET', //GET
		    data:data,
		    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data){
		    	//console.log(data);
		    	var dataLength = data.length;
		    	var domArr  = [];
		    	for(var i in chartsArr){
		    		chartsArr[i].clear();
		    	}
		    	chartsArr=[];
		    	$('#chart-container').html("");
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
	     		          	center : ["43%", "50%"],
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
	<!----------------------ajax请求echarts加载结束----------------------------->
	<!----------------------年份选择限制开始----------------------------->
	function yearChange(){
		loadeChartsCompanyList();
	};
	<!----------------------月份选择限制开始----------------------------->
	function timeChange(){
		var timeStart = $("#timeStart").val();
		var timeEnd = $dp.cal.getP('M');
		if(timeStart==''){
			alert('起始时间不能为空');
			$("#timeEnd").val("");
			}else if(timeStart>timeEnd){
					alert("结束时间必须大于于或者等于起始时间");
					$("#timeEnd").val("");
				}else{
					loadeChartsCompanyList();
			}
	}
	<!--------------物业公司改变，小区下拉框随动，并且进行搜索------------------>
	$("#corp").change(function(){
		community();
	})
	<!--------------小区改变进行搜索------------------>
	$("#community").change(function(){
		loadeChartsCompanyList();
	})
	<!----------------------浏览器窗口变化----------------------------->
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

