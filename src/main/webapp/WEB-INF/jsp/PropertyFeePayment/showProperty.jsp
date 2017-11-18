<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="../common/meta.jsp" %>
<%-- 自定义css样式 --%>
<meta charset="UTF-8">
<meta content="text/html">

<head>

</head>
<style>
	.datagrid-row {
		height: 70px;
		text-align:center;
	}

</style>
<body>
<div class="page-container">
<table id="atProperty"></table>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"> <a href="javascript:;" onclick="member_add('添加用户','member-add.html','','510')" class="btn btn-primary radius">新增<span class="r"><a href="javascript:;" onclick="datadel()" class="btn btn-primary radius">导出<i class="Hui-iconfont">&#xe644;</i></a></span> </div>
</body>
<script>
$.Admin.atProperty = {
    //组件ID
    'id' : '#atProperty',
    //工具栏
    'tools' : [    
        { text: '添加&nbsp;&nbsp;', iconCls: 'icon-add', handler: function(){
                $.Admin.atProperty.AddAT();
            } 
        }, 
        {
          text:'&nbsp;&nbsp;物业:&nbsp;<input type="text" class="easyui-combobox" style="width:100px; height: 25px;"  id="estateSearch"></div>',
        
          },
        {
            text:'&nbsp;&nbsp;小区:&nbsp;<input type="text"  class="easyui-combobox" style="width:100px; height: 25px;" id="commSearch">',
        },
        { 
            text:'&nbsp;&nbsp;<input id="at_search" style="width:100px">', 
          },
          {
            iconCls:'icon-search',
            handler:function(){ 
            $.Admin.atProperty.search();
          }
          },
        {
            text:'正常&nbsp;<input class="easyui-switchbutton status"  checked>&nbsp;&nbsp;作废&nbsp;<input class="easyui-switchbutton status" checked><select name="status" class="easyui-combobox" ><option value="">全部状态</option><option value="1">正常</option><option value="0">已作废</option>',
        },
        {
            text:'&nbsp;&nbsp;缴费：<input id="at_pay_start" class="easyui-datebox" required  style="width:130px">&nbsp;一&nbsp;<input id="at_pay_end" class="easyui-datebox" required style="width:130px">',
        },
        {
            text:'&nbsp;&nbsp;服务：<input id="at_service_start" class="easyui-datebox" required  style="width:130px">&nbsp;一&nbsp;<input id="at_service_end" class="easyui-datebox" required style="width:130px">',
        },
    ],
    //添加角色
    'AddAT' : function(){
        var id = $.Admin.random_dialog();
        $(id).dialog({
            title: '添加缴费单',
            iconCls: 'fa fa-plus',
            href: "PropertyFeePayment/showInsert",
            modal: true,
            width:450,
            height:610,
            onClose : function(){
                $(this).dialog("destroy");
            },
            onOpen : function(){
                var top = $(this).offset().top-$(this).position().top;
                $(this).dialog('resize',{
                    top: (top/2)+'px'
                });
            }
        });
    }, 
    
    'over' :function(){
    	   var get_select_row = $($.Admin.atProperty.id).datagrid('getSelected');
           var data = {id: get_select_row.id};
           if(get_select_row.status=='0'){
               $.messager.show({
                   title:'消息',
                   msg:'已作废状态不能更改'
               })
               return false;
           };
           var id = $.Admin.random_dialog();
           $(id).dialog({
               title: '作废',
               iconCls: 'fa fa-edit',
               queryParams: data,
               href: "PropertyFeePayment/showOver",
               modal: true,
               width: 400,
               height:200,
               onClose : function(){
                   $(this).dialog("destroy");
               },
               onOpen : function(){
                   var top = $(this).offset().top-$(this).position().top;
                   $(this).dialog('resize',{
                       top: (top/2)+'px'
                   });
               }
           });
    },
   
    //模糊查询
    'search' :function(){
    	var a=$('#at_search').val();
    	var at_search={};
    	at_search.at_search=a;
          $.ajax({
        	  type:'post',
              title: '模糊查询',
              data:at_search,
              iconCls:'icon-search',
              url: "PropertyFeePayment/getPropertyList",
              datatype:'json',
              success:function(search_list){
            	  $('#atProperty').datagrid('loadData', search_list);
              }
              
          });
    },
  
}

$($.Admin.atProperty.id).datagrid({
	title: '当前位置：业务管理 > 担保职位管理 > 发布担保职位',
    border: false,
    toolbar: $.Admin.atProperty.tools,
    fitColumns: true,
    fit: true,
    ctrlSelect: true,
    singleSelect: false,
    idField: 'id',
    url: "PropertyFeePayment/getPropertyList",
    pagination:true,
	pagePosition:'bottom',
	pageNumber:1,
	pageSize:20,
	pageList:[10,20,30,50,100],
	columns:[[
	          {field:'ck',checkbox:true},    
	          {field:'estatePayNum',title:'单号',align:'center',width:100},
	          {field:'houseNum',title:'门牌号',align:'center',width:100},
	          {field:'ownerName',title:'业主',align:'center',width:100},
              {field:'area',title:'面积(m²)',align:'center',width:100},
              {field:'estateUnitPrice',title:'单价(m²/月)',align:'center',width:100,formatter:function(value){
            	  if(value!=null){
            		  return value+"元";
            	  }
              }
              },
	          {field:'serviceStartDate',title:'服务起始日',align:'center',width:100,formatter:function(value){
	        	    var date = new Date(value);
	                var year = date.getFullYear().toString();
	                var month = (date.getMonth() + 1);
	                var day = date.getDate().toString();
	                if (month < 10) {
	                    month = "0" + month;
	                }
	                if (day < 10) {
	                    day = "0" + day;
	                }
	                return year + "-" + month + "-" + day;
	          }},
	          {field:'serviceEndDate',title:'服务截止日',align:'center',width:100,formatter:function(value){
	        	  var date = new Date(value);
	                var year = date.getFullYear().toString();
	                var month = (date.getMonth() + 1);
	                var day = date.getDate().toString();
	                if (month < 10) {
	                    month = "0" + month;
	                }
	                if (day < 10) {
	                    day = "0" + day;
	                }
	                return year + "-" + month + "-" + day;
	          }},
	          {field:'payMonthTypeId',title:'缴纳月数',align:'center',width:100,formatter:function(value){
            	  if(value!=null){
            		  return value+"个月";
            	  }
              }},
	          {field:'paymentAmount',title:'缴纳额',align:'center',width:100},
	          {field:'account',title:'收费员工',align:'center',width:100},
	          {field:'payDate',title:'缴费日期',align:'center',width:100,formatter:function(value){
	        	  var date = new Date(value);
	                var year = date.getFullYear().toString();
	                var month = (date.getMonth() + 1);
	                var day = date.getDate().toString();
	                if (month < 10) {
	                    month = "0" + month;
	                }
	                if (day < 10) {
	                    day = "0" + day;
	                }
	                return year + "-" + month + "-" + day;
	          }},
	          {field:'operator',title:'录入员工',align:'center',width:100},
	          {field:'operateTime',title:'录入日期',align:'center',width:100,formatter:function(value){
	        	  var date = new Date(value);
	                var year = date.getFullYear().toString();
	                var month = (date.getMonth() + 1);
	                var day = date.getDate().toString();
	                if (month < 10) {
	                    month = "0" + month;
	                }
	                if (day < 10) {
	                    day = "0" + day;
	                }
	                return year + "-" + month + "-" + day;
	          }},
	          {field:'status',title:'状态',align:'center',width:100,formatter:function(value){
	        	  if(value == '1'){
	        		  html="<br><br><a onclick='$.Admin.atProperty.over();' style='color:blue;'> 作废</a>";
	        		  return '正常'+html;
	        	  }else{
	        		  html ="<span style='color:red;'>已作废</span>";
	        		  return html;
	        	  }
	          }},
	          {field:'put',title:'打印',align:'center',width:100,formatter:function(){
	        	  return  "<a onclick='put()' style='color:blue;'> 打印 </a>";
	          }},
	      ]],
    onDblClickRow: function(row){ 
    	
    },
    onRowContextMenu: function(e,index,data){
        e.preventDefault();//阻止浏览器捕获右键事件
    }
});  

	//模糊查询X
  $('#at_search').textbox({ icons: [{ 
 	 iconCls: 'icon-clear', 
 	 handler: function (e) { 
 		 $(e.data.target).textbox('clear');
 		 $.Admin.atProperty.search();
 		 } 
  }] 
})
    	
  $('#estateSearch').combobox({
	    url:'PropertyFeePayment/findEstate',
	    valueField:'id',
	    textField:'corpName',
	    panelHeight:'auto',
	    'onChange':function(){
	    	 var esval=$('#estateSearch').combobox('getValue');
	    	 var estateSearchId = {};
	    	 estateSearchId.estateSearchId = esval;
			 $.ajax({
			        type:'post',
			        title: '状态筛选',
			        data:estateSearchId,
			        url: "PropertyFeePayment/findComm",
			        datatype:'json',
			        success:function(search_list){
			        	$('#commSearch').combobox({
			        	    valueField:'id',
			        	    textField:'communityName',
			        	    panelHeight:'auto',
			           })
			        	$('#commSearch').combobox('clear');
                		$('#commSearch').combobox('loadData', search_list);    
			           /*  $('#commSearch').combobox({
			            	 valueField:'id',
			         	     textField:'communityName',
			         	     panelHeight:'auto',
			            }) */
			        }
			    })
			    if(estateSearchId == 0){
			    	
			    }else{
		   $.ajax({
			        type:'post',
			        title: '状态筛选',
			        data:estateSearchId,
			        url: "PropertyFeePayment/getPropertyList",
			        datatype:'json',
			        success:function(search_list){
			        	 $('#atProperty').datagrid('loadData', search_list);
			        }
			    })	}    
		},
	}); 
  
 

$('.status').switchbutton({
	'onChange':function(){
		status= $(".status").switchbutton("options").checked;
		alert(status);
		if(status == false){
			alert('等于false');
			var okeys = '';
		}else{
			alert('等于true');
			var okeys = '1';
		}
		 var okey = {};
		    okey.okey=okeys;
			 $.ajax({
			        type:'post',
			        title: '状态筛选',
			        data:okey,
			        url: "PropertyFeePayment/getPropertyList",
			        datatype:'json',
			        success:function(search_list){
			            $('#atProperty').datagrid('loadData', search_list);
			        }
			    })
	}
})
	$('#status').combobox({
		 panelHeight:'auto',
		'onChange':function(){
			var statu = $('#status').val();
			var status = {};
			status.status=statu;
			 $.ajax({
			        type:'post',
			        title: '状态筛选',
			        data:status,
			        url: "PropertyFeePayment/getPropertyList",
			        datatype:'json',
			        success:function(search_list){
			            $('#atProperty').datagrid('loadData', search_list);
			        }
			    })
		},
	});
	

$('#at_service_start').datebox({
	onSelect: function(date){
         var at_serv_start=$('#at_service_start').val();
         var at_service_start={};
         at_service_start.at_service_start=at_serv_start;
         $.ajax({
		        type:'post',
		        title: '时间查询',
		        data:at_service_start,
		        url: "PropertyFeePayment/getPropertyList",
		        datatype:'json',
		        success:function(search_list){
		            $('#atProperty').datagrid('loadData', search_list);
		        }
		    });
	}
})
$('#at_service_end').datebox({
	onSelect: function(date){
         var at_serv_end=$('#at_service_end').val();
         var at_service_end = {};
         at_service_end.at_service_end = at_serv_end;
         $.ajax({
		        type:'post',
		        title: '时间查询',
		        data:at_service_end,
		        url: "PropertyFeePayment/getPropertyList",
		        datatype:'json',
		        success:function(search_list){
		            $('#atProperty').datagrid('loadData', search_list);
		        }
		    });
	}
})
$('#at_pay_end').datebox({
	 onSelect: function(date){
		 var at_pay_start=$('#at_pay_start').val();
         var at_pay_end=$('#at_pay_end').val();
         alert("开始日期："+at_pay_start);
         alert("截止日期："+at_pay_end);
         var at_date_time={};
         if(at_pay_start == null && at_pay_end == null){
             at_date_time = '';
         }else if(at_pay_start !=null && at_pay_end == null){
        	 at_date_time = '';
         }else if(at_pay_end !=null && at_pay_start == null){
        	 at_date_time = '';
         }else{
             at_date_time.at_pay_start=at_pay_start;
             at_date_time.at_pay_end=at_pay_end;
         }
		    $.ajax({
		        type:'post',
		        title: '时间查询',
		        data:at_date_time,
		        url: "PropertyFeePayment/getPropertyList",
		        datatype:'json',
		        success:function(search_list){
		            $('#atProperty').datagrid('loadData', search_list);
		        }
		    });
	    }
});

</script>
