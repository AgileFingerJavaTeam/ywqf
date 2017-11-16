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
<title>缴费年度汇总</title>
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
	<div>
		物业公司<input id="company" class="easyui-combobox" data-options="    
	        valueField: 'company',    
	        textField: 'text',    
	        url: 'get_data1.php',    
	        onSelect: function(rec){    
	            var url = 'propertyFee/propertyCompany';    
	            $('#community').combobox('reload', 'propertyFee/districtName');    
	        }" />   
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		小区<input id="community" name=community" class="easyui-combobox" data-options="valueField:'id',textField:'text'" /> 
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input id="year" name="year" class="easyui-combobox" data-options="valueField:'id',textField:'text'" />  
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<font size="3" class="w1">时间范围</font><input  id="time1" name="time1"  type= "text" class= "easyui-datebox"/>-<input  id="time2" name="time2"  type= "text" class= "easyui-datebox"/>
		<input id="search" type="button" value="搜索"/> 
	</div>
 	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="main" style="width: 100%;height:400px;"></div>
</body>
<script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        var resizeWaiter=false;
        // 使用刚指定的配置项和数据显示图表。
    
	$(function(){ 
		var company =$("#company").val();
		var community =$("#community").val();
		var year =$("#year").val();
		var time1 =$("#time1").val();
		var time2 =$("#time2").val();
		var data = {};
		data.company =company;
		data.community =community;
		data.year =year;
		data.time1 =time1;
		data.time2 =time2;
		$.ajax({
		    url:'payYearNum/search',
		    type:'GET', //GET
		    data:data,
		    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data){
		        console.log(data);
		        $('#main').height(Math.ceil(data.length/2)*400);
		        myChart.resize();
		        var targetData = [];
		        var targetTitle = [];
		        for(var i in data){
		        	var helf_i = (parseInt(i)+1)/2;
		        	var line = Math.ceil(helf_i);
		        	targetTitle.push({
		        		text: data[i]['name'],
						x: (33.33*(i%2==0?1:2))+'%',
						y: 100-100/line+'%',
						textAlign: 'center'
					});
		        	targetData.push({
	     		           name: data[i]['name'],
		                    label: {
		                        normal: {
		                        	position: 'inner',
		                            formatter: '{b}：{c}  ',
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
	     		            radius: '25%',
	     		          	center : [(33.33*(i%2==0?1:2))+'%', 100-100/line + 50/Math.ceil(data.length/2) +'%'],
	     		            data:data[i]['reslut'],
     			        });
		        	} 
		        
	        	 myChart.setOption({
	        		 title : targetTitle,
	        		 series : targetData,
	        		 legend:{
	        			 orient:'top',
	        			 x:'right',
	        			 y:'30%',
	        			 data:['未缴费','已缴费']
	        		 }
	     		})
		    }
		})
	});

	$(window).on('resize', function() {
		if(!resizeWaiter) {
			resizeWaiter = true;
			setTimeout(function() {
				//优化，限制图表resize的频率
				myChart.resize();
				resizeWaiter = false;
			}, 100);
		}
	})
</script>
</html>

