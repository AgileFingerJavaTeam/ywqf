<%@ page import="java.util.Date" %>
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

</style>
<link rel="stylesheet" href="hui/lib/jquery/jquery-ui.css">
<link rel="stylesheet" href="Fontawesome/css/font-awesome.min.css">
<link rel="stylesheet" href="hui/lib/bootstrap-Switch/bootstrapSwitch.css">
<link rel="stylesheet" href="hui/lib/My97DatePicker/skin/WdatePicker.css">




</head>
<body>
<nav class="breadcrumb">采暖费<span class="c-gray en">&gt;</span>缴费<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="PropertyFeePayment/showProperty" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>

<div class="cl pd-5  mt-20">
    <span class="l">
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a  onclick="modaldemoAdd()" style="text-decoration: none;margin-right: 50px ">
				<i class="Hui-iconfont">&#xe600;</i>新增
			</a>
                <input type="text" value= "${Rid}" id="Rid" style="display: none;">
                <input type="text" value= "${Rname}" id="Rname" style="display: none;">
                <input type="text" value= "${corp_id}" id="corpId" style="display: none;">
    </span>
</div>
<hr>
<div class="cl pd-5  mt-20">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span class="select-box" style="width: 200px;">
	     	  <select class="select" size="1"  id="corp">
		      </select>
     </span>
	&nbsp;&nbsp;&nbsp;&nbsp;缴费日期范围:&nbsp;&nbsp;&nbsp;<span style="color: #AAAAAA;">开始日期</span>&nbsp;
	&nbsp;&nbsp;
	<input id="at_pay_start" name="timeYear" type="text" runat="server"  class="Wdate" style=" width:200px; height: 30px;" onFocus="WdatePicker({lang:'zh-cn',maxDate:'#F{$dp.$D(\'at_pay_end\')||\'new Date()\'}'})"/>
	&nbsp;&nbsp;&nbsp;<span style="color: #AAAAAA;">结束日期</span>&nbsp;
	&nbsp;&nbsp;
	<input id="at_pay_end" name="timeYear" type="text" runat="server"   class="Wdate" style=" width:200px; height: 30px;" onclick="WdatePicker({minDate:'#F{$dp.$D(\'at_pay_start\')}',dateFmt:'yyyy-MM-dd',dchanging:cDayFuncd , Mchanging: cMonthFuncd , ychanging: cYearFuncd , dchanged:cDayFuncd , Mchanged: cMonthFuncd , ychanged: cYearFuncd})"/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	正常
	<div class="switch" id="mySwitch" data-on="warning" data-off="danger" style=" right:-10px; top:10px;">
		<input type="checkbox"  value="1" checked />
	</div>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	作废
	<div class="switch" id="mySwitchs" data-on="warning" data-off="danger" style="right:-5px; top:10px;">
		<input type="checkbox"  value="0" checked />
	</div>

	<br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span class="select-box" style="width: 200px;">
              <select class="select" size="1" id="comm">
              </select>
    </span>
	&nbsp;&nbsp;&nbsp;&nbsp;缴费日期范围:&nbsp;&nbsp;&nbsp;<span style="color: #AAAAAA;">开始日期</span>&nbsp;
	&nbsp;&nbsp;
	<input id="at_service_start" name="timeYear" type="text" runat="server" class="Wdate" style=" width:200px; height: 30px;" onFocus="WdatePicker({lang:'zh-cn',maxDate:'#F{$dp.$D(\'at_service_end\')||\'new Date()\'}'})"/>
	&nbsp;&nbsp;
	<span style="color: #AAAAAA;">结束日期</span>&nbsp;
	&nbsp;&nbsp;
	<input id="at_service_end" name="timeYear" type="text" runat="server" class="Wdate" style=" width:200px; height: 30px;"  onclick="WdatePicker({minDate:'#F{$dp.$D(\'at_service_start\')}',dateFmt:'yyyy-MM-dd',dchanging:cDayFunc , Mchanging: cMonthFunc , ychanging: cYearFunc , dchanged:cDayFunc , Mchanged: cMonthFunc , ychanged: cYearFunc})"/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" placeholder="请输入关键词" class="input-text ac_input" name="search_text" value="" id="at_search" autocomplete="off" style="width:250px"><button type="submit" class="btn btn-default" id="search_button">搜索</button>
</div>
<div class="page-container">
	<div class="mt-20">
		<table class="table table-border table-bordered table-hover table-bg table-sort">
			<thead>
			<tr class="text-c">
				<th style="display: none;">id</th>
				<th width="50" class="text-center">单号</th>
				<th width="70">门牌号</th>
				<th width="80">业主</th>
				<th width="80">面积(M²)</th>
				<th width="80">单价(元/M²)</th>
				<th width="70">年份</th>
				<th width="80">缴纳额(M²)</th>
				<th width="85">收费员工</th>
				<th width="100">缴费日期</th>
				<th width="85">录入员工</th>
				<th width="100">录入日期</th>
				<th width="70">状态</th>
				<th width="50">打印</th>
			</tr>
			</thead>
		</table>
	</div>
</div>
<!-- 作废模态框  start-->
<div id="modal-demo" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content radius">
			<div class="modal-header">
				<h3 class="modal-title">作废单据</h3>
				<a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void()">×</a>
			</div>
			<div class="modal-body">
				<span style="text-align: center;">是否作废此单据？</span>
				<span style="text-align: center; color: red;">(执行后无法撤回！)</span>
				<input style="display: none;" value="" id="asd">
			</div>
			<div class="modal-footer">
				<button class="btn btn-primary" id="Okey">确定</button>
				<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
			</div>
		</div>
	</div>
</div>
<!-- 作废模态框  end-->
<!-- 新增模态框  start-->
<div id="modal-demo-add" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content radius" style="overflow:scroll;  height:600px;width: 500px">
			<form action="" method="post" class="form form-horizontal" id="demoform-1">
				<div class="modal-header">
					<h4	 style="text-align: center">创建缴费单</h4>
					<a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">收费单编号</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text" name="heating_pay_num" id="heating_pay_num"  placeholder="请输入单号" required:true;>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">小区</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<select class="select" size="1" name="community_id" id="community_id" style="height: 31px;">
						</select>
					</div>
				</div>
				<div class="row cl" style="display: none;">
					<label class="form-label col-xs-4 col-sm-5">房间ID</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text" id="house_id"  name="house_id" >
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">门牌号</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text" id="house_num"  name="house_num" autocomplete="off" placeholder="请输入门牌号" >
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">缴费人姓名</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text" id="owner_name"  name="owner_name" readonly="readonly" placeholder="请输入业主姓名" >
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">面积</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text" id="area"   name="area"  placeholder="请输入采暖面积" >
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">单价</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text"  id="heating_unit_price"  name="heating_unit_price"  placeholder="请输入单价" readonly>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">优惠后单价</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text"  id="discount_heating_unit_price"  name="discount_heating_unit_price"  placeholder="优惠后单价"  readonly>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">优惠比例</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text"  id="heating_discount"  name="heating_discount"  placeholder="优惠比例"  readonly>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">年份</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input id="year" name="year" type="text" runat="server" class="Wdate" style=" width:178px; height: 30px;" onclick="WdatePicker({dateFmt:'yyyy',alwaysUseStartDate:true})"/>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">缴费金额</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text"  id="payment_amount"  name="payment_amount" readonly="readonly">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">收费员工</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<select class="select" size="1" name="charge_worker_id" id="charge_worker_id" style="height: 31px;">
						</select>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">缴费日期</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text"  id="payment_date"  name="payment_date" readonly="readonly">

					</div>
				</div>
				<input type="text" value= "" id="id" style="display: none;">
				<input type="text" value= "" id="name" style="display: none;">
				<input type="text" value= "" id="corp_id" style="display: none;">
			</form>
			<br>
			<div class="modal-footer" style="text-align: center">
				<button class="btn btn-primary" id = "insert">确定</button>
				<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
			</div>
		</div>
	</div>
</div>
<!--startprint1--><!--endprint1-->
<!--新增模态框  end -->
<%@ include file="../common/footer.jsp" %>
<script type="text/javascript" src="../hui/lib/bootstrap-modal/2.2.4/bootstrap-modal.js"></script>
<script type="text/javascript" src="../hui/lib/bootstrap-modal/2.2.4/bootstrap-modalmanager.js"></script>
<script type="text/javascript" src="../hui/lib/bootstrap-Switch/bootstrapSwitch.js"></script>
<script type="text/javascript" src="../hui/lib/My97DatePicker/WdatePicker.js"></script>


<%-- 自定义js --%>
<script type="text/javascript">
        $(function(){
            var corpId = $('#corpId').val();
            var data = {};
            data.corp_id = corpId;
            $.ajax({
                url:"ParkingFeePayment/findType",
                type:'post',
                data: data ,
                dataType:'json',
                success:function(data) {
                    //物业下拉框定住 start
                    var type = data.type;
                    if (type == 0) {     //type 为物业类型  1为总部  0为物业公司
                        $("#corp").append("<option value=" + data.corpId + ">" + data.corpName + "</option>")
                        //物业下拉框定住 end
                        //查询操作人有权限的小区 遍历
                        var rid = $('#Rid').val();
                        var ppp = {};
                        ppp.rid = rid;
                        $.ajax({
                            type:'post',
                            url:'ParkingFeePayment/findRidComm',
                            data: ppp,
                            dataType:'json',
                            success:function(data){
                                jQuery('#comm').empty();
                                $("#comm").append("<option value=" + 0 + ">" + '全部小区' + "</option>")
                                for (var i in data) {
                                    var a = data[i].communityId;
                                    $("#comm").append("<option value=" + a + ">" + data[i].communityName + "</option>")
                                }
                            }
                        })
                        var estateSearchId = $('#corp').val();
                        var a = $('#mySwitch').bootstrapSwitch('status');
                        var b = $('#mySwitchs').bootstrapSwitch('status');
                        var at_search = $('#at_search').val();
                        var data = {};
                        data.at_search = at_search;
                        data.estateSearchId = estateSearchId;
                        if(a == b){
                            data.status = '';
                            data.okey ='';
                            $.ajax({
                                url:"HeatingFeePayment/getHeatingList",
                                type:"POST",
                                data:data,
                                dataType:"json",
                                success:function (data){
                                    showDataTable(data);
                                }
                            })
                        }else if(a == true && b == false){
                            data.status = '1';
                            data.okey ='';
                            $.ajax({
                                url:"HeatingFeePayment/getHeatingList",
                                type:"POST",
                                data:data,
                                dataType:"json",
                                success:function (data){
                                    showDataTable(data);
                                }
                            })
                        }else if(a == false && b == true){
                            data.status = '';
                            data.okey ='0';
                            $.ajax({
                                url:"HeatingFeePayment/getHeatingList",
                                type:"POST",
                                data:data,
                                dataType:"json",
                                success:function (data){
                                    showDataTable(data);
                                }
                            })
                        }
                    }else if (type == 1){
                        //遍历除总部 所有物业公司
                        $.ajax({
                            type:'post',
                            url:'ParkingFeePayment/findEstate',
                            dataType:'json',
                            success:function(data){
                                jQuery("#corp").empty();
                                $("#corp").append("<option value="+ 0 +">" + '全部物业公司' + "</option>")
                                $("#comm").append("<option value="+ 0 +">" + '全部小区' + "</option>")
                                for(var i in data){
                                    $("#corp").append("<option value="+ data[i].corpId +">" + data[i].corpName + "</option>")
                                }
                                $('#corp ').change(function(){
                                    corpVal(); //通过物业改变  查物业下小区
                                    //总部物业公司查询
                                    var estateSearchId = $('#corp').val();
                                    var a = $('#mySwitch').bootstrapSwitch('status');
                                    var b = $('#mySwitchs').bootstrapSwitch('status');
                                    var at_search = $('#at_search').val();
                                    var data = {};
                                    data.at_search = at_search;
                                    data.estateSearchId = estateSearchId;
                                    if(a == b){
                                        data.status = '';
                                        data.okey ='';
                                        $.ajax({
                                            url:"HeatingFeePayment/getHeatingList",
                                            type:"POST",
                                            data:data,
                                            dataType:"json",
                                            success:function (data){
                                                showDataTable(data);
                                            }
                                        })
                                    }else if(a == true && b == false){
                                        data.status = '1';
                                        data.okey ='';
                                        $.ajax({
                                            url:"HeatingFeePayment/getHeatingList",
                                            type:"POST",
                                            data:data,
                                            dataType:"json",
                                            success:function (data){
                                                showDataTable(data);
                                            }
                                        })
                                    }else if(a == false && b == true){
                                        data.status = '';
                                        data.okey ='0';
                                        $.ajax({
                                            url:"HeatingFeePayment/getHeatingList",
                                            type:"POST",
                                            data:data,
                                            dataType:"json",
                                            success:function (data){
                                                showDataTable(data);
                                            }
                                        })
                                    }
                                })

                            }
                        })
                    }
                    function corpVal() {
                        var corpVal = $('#corp').val();
                        var data = {};
                        data.corp_id = corpVal;
                        $.ajax({
                            type: 'post',
                            url: 'ParkingFeePayment/findVillage',
                            data: data,
                            dataType: 'json',
                            success: function (data) {
                                jQuery('#comm').empty();
                                $("#comm").append("<option value=" + 0 + ">" + '全部小区' + "</option>")
                                for (var i in data) {
                                    var a = data[i].communityId;
                                    $("#comm").append("<option value=" + a + ">" + data[i].communityName + "</option>")
                                }
                            }
                        })
                    }
                }
            })
    })
    //小区change事件
    $('#comm').on('change',function(){
        var comm = $('#comm').val();
        var estateSearchId = $('#corp').val();
        var a = $('#mySwitch').bootstrapSwitch('status');
        var b = $('#mySwitchs').bootstrapSwitch('status');
        var at_search = $('#at_search').val();
        var data = {};
        data.at_search = at_search;
        data.estateSearchId = estateSearchId;
        data.comm = comm;
        if(a == b){
            data.status = '';
            data.okey ='';
            $.ajax({
                url:"HeatingFeePayment/getHeatingList",
                type:"POST",
                data:data,
                dataType:"json",
                success:function (data){
                    showDataTable(data);
                }
            })
        }else if(a == true && b == false){
            data.status = '1';
            data.okey ='';
            $.ajax({
                url:"HeatingFeePayment/getHeatingList",
                type:"POST",
                data:data,
                dataType:"json",
                success:function (data){
                    showDataTable(data);
                }
            })
        }else if(a == false && b == true){
            data.status = '';
            data.okey ='0';
            $.ajax({
                url:"HeatingFeePayment/getHeatingList",
                type:"POST",
                data:data,
                dataType:"json",
                success:function (data){
                    showDataTable(data);
                }
            })
        }

    })
    //初始查询
    $(function(){
        $.ajax({
            url: "HeatingFeePayment/getHeatingList",
            type: "POST",
            dataType: "json",
            success: function (data) {
                showDataTable(data);
            }
        });
    });
    //dataTable
    function showDataTable(data) {
        $('.table-sort').dataTable({
            "data": data.rows,
            destroy:true,
            "columns": [
                {'data': 'heatingPayNum',},
                {'data': 'houseNum',},
                {'data': 'ownerName',},
                {"data": 'heatingArea',},
                {'data': 'discountHeatingUnitPrice',},
                {'data': 'year',},
                {'data': 'paymentAmount',},
                {"data": 'name',},
                {
                    'data': function (value) {
                        var a_time = value.paymentDate;
                        var date = new Date(a_time);
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
                    },
                },
                {'data': 'operator',},
                {
                    "data": function (value) {
                        var a_time = value.operateTime;
                        var date = new Date(a_time);
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
                    },
                },
                {
                    "data": function (value) {
                        var a = value.status;
                        var b = value.heatingPayId;
                        var title = '修改作废状态';
                        if (a == 1) {
                            html = "<br><a style='color:blue;' class='at-a-status' attr-id='" + b + "' onclick='modaldemo(" + b + ")'> 作废</a>";
                            return '正常' + html;
                        } else {
                            html = "<span style='color:red;'>已作废</span>";
                            return html;
                        }
                    },
                },
                {
                    "data": function () {
                        return "<br><a onclick='put(1)' style='color:blue;'> 打印 </a>" + "<br>";
                    },
                }
            ],
            "sServerMethod": "POST",
            "aaSorting": [[1, "desc"]],//默认第几个排序
            "bStateSave": true,//状态保存
            "aoColumnDefs": [
                //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
                {"orderable": false, "aTargets": [0]}// 不参与排序的列
            ]
        });
    }
    //打印
    function put(oper)
    {
        if (oper < 10)
        {
            bdhtml=window.document.body.innerHTML;//获取当前页的html代码
            sprnstr="<!--startprint"+oper+"-->";//设置打印开始区域
            eprnstr="<!--endprint"+oper+"-->";//设置打印结束区域
            prnhtml=bdhtml.substring(bdhtml.indexOf(sprnstr)+18); //从开始代码向后取html

            prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));//从结束代码向前取html
            window.document.body.innerHTML=prnhtml;
            window.print();
            window.document.body.innerHTML=bdhtml;
        } else {
            window.print();
        }
    }
	//正常状态筛选
	$('#mySwitch').on('switch-change', function (e, data) {
		var a = $('#mySwitchs').bootstrapSwitch('status');
		var status = data.value;
		var comm = $('#comm').val();
		var estateSearchId = $('#corp').val();
		var at_search = $('#at_search').val();
		var data = {};
		if(status == a){
			data.status = '';
			data.okey ='';
			data.comm = comm;
			data.estateSearchId = estateSearchId;
			data.at_search = at_search;
			$.ajax({
				url:"HeatingFeePayment/getHeatingList",
				type:"POST",
				data:data,
				dataType:"json",
				success:function (data){
					showDataTable(data);
				}
			})
		}else if(status == false && a == true){
			data.status = '';
			data.okey ='0';
			data.comm = comm;
			data.estateSearchId = estateSearchId;
			data.at_search = at_search;
			$.ajax({
				url:"HeatingFeePayment/getHeatingList",
				type:"POST",
				data:data,
				dataType:"json",
				success:function (data){
					showDataTable(data);
				}
			})
		}else if(status == true && a == false){
			data.status = '1';
			data.okey ='';
			data.comm = comm;
			data.estateSearchId = estateSearchId;
			data.at_search = at_search;
			$.ajax({
				url:"HeatingFeePayment/getHeatingList",
				type:"POST",
				data:data,
				dataType:"json",
				success:function (data){
					showDataTable(data);
				}
			})
		}
	});
	//作废状态筛选
	$('#mySwitchs').on('switch-change', function (e, data) {
		var status = $('#mySwitch').bootstrapSwitch('status');
		var a = data.value;
		var comm = $('#comm').val();
		var estateSearchId = $('#corp').val();
		var at_search = $('#at_search').val();
		var data = {};
		if(status == a){
			data.status = '';
			data.okey ='';
			data.comm = comm;
			data.estateSearchId = estateSearchId;
			data.at_search = at_search;
			$.ajax({
				url:"HeatingFeePayment/getHeatingList",
				type:"POST",
				data:data,
				dataType:"json",
				success:function (data){
					showDataTable(data);
				}
			})
		}else if(status == false && a == true){
			data.status = '';
			data.okey ='0';
			data.comm = comm;
			data.estateSearchId = estateSearchId;
			data.at_search = at_search;
			$.ajax({
				url:"HeatingFeePayment/getHeatingList",
				type:"POST",
				data:data,
				dataType:"json",
				success:function (data){
					showDataTable(data);
				}
			})
		}else if(status == true && a == false){
			data.status = '1';
			data.okey ='';
			data.comm = comm;
			data.estateSearchId = estateSearchId;
			data.at_search = at_search;
			$.ajax({
				url:"HeatingFeePayment/getHeatingList",
				type:"POST",
				data:data,
				dataType:"json",
				success:function (data){
					showDataTable(data);
				}
			})
		}
	});
	//模糊查询和状态筛选 方法
	function MoHuAndStatus(){
		var a = $('#mySwitch').bootstrapSwitch('status');
		var b = $('#mySwitchs').bootstrapSwitch('status');
		var at_search = $('#at_search').val();
		var data = {};
		data.at_search = at_search;
		if(a == b){
			data.status = '';
			data.okey ='';
			$.ajax({
				url:"HeatingFeePayment/getHeatingList",
				type:"POST",
				data:data,
				dataType:"json",
				success:function (data){
					showDataTable(data);
				}
			})
		}else if(a == true && b == false){
			data.status = '1';
			data.okey ='';
			$.ajax({
				url:"HeatingFeePayment/getHeatingList",
				type:"POST",
				data:data,
				dataType:"json",
				success:function (data){
					showDataTable(data);
				}
			})
		}else if(a == false && b == true){
			data.status = '';
			data.okey ='0';
			$.ajax({
				url:"HeatingFeePayment/getHeatingList",
				type:"POST",
				data:data,
				dataType:"json",
				success:function (data){
					showDataTable(data);
				}
			})
		}
	}
	//模糊查询
	$('#search_button').on('click',function(){
		MoHuAndStatus();
	})
	$('#at_search').on('keyup',function(){
		if($('#at_search').val() == '' || $('#at_search').val() == null){
			MoHuAndStatus();
		}
	})
    //新增模态框
    function modaldemoAdd(){
        var id = $('#Rid').val();
        var corpId = $('#corpId').val();
        $('#id').val(id);
        $('#corp_id').val(corpId);
        $('#modal-demo-add').modal("show") //显示模态框
        // 遍历小区 start
        var ppp = {};
        ppp.rid = id;
        $.ajax({
            type:'post',
            url:'ParkingFeePayment/findRidComm',
            data: ppp,
            dataType:'json',
            success:function(data){
                jQuery('#community_id').empty();

                for (var i in data) {
                    var a = data[i].communityId;
                    $("#community_id").append("<option value=" + a + ">" + data[i].communityName + "</option>")
                }
            }
        })
        // 遍历小区 end
        //缴费日期 start
        var aa = new Date();
        var year = aa.getFullYear();
        var month = aa.getMonth() + 1 < 10 ? "0" + (aa.getMonth() + 1): aa.getMonth() + 1;
        var day = aa.getDate() < 10 ? "0" + aa.getDate() : aa.getDate();
        var dateStr = year + "-" + month + "-" + day;
        $('#payment_date').val(dateStr);
        //缴费日期 end
        //小区change事件
        $('#community_id').on('change',function(){
            $('#house_num').val('');
            $('#owner_name').val('');
            $('#house_id').val('');
            $('#heating_discount').val('');
            $('#area').val('');
            $('#heating_unit_price').val('');
            $('#discount_heating_unit_price').val('');
            $('#payment_amount').val('');
        })
        //遍历收费员工
        $.ajax({
            type:"GET",
            url:"ParkingFeePayment/findAccount",
            dataType:"json",
            success:function(account){
                jQuery("#charge_worker_id").empty();
                for(var i in account){
                    var a = account[i].userId;
                    $("#charge_worker_id").append("<option value="+a+">"+account[i].name+"</option>")
                }
            }
        });
        // 模糊联想 门牌号 start
        $('#house_num').keyup(function () {
            var houseNum =$('#house_num').val();
            var community_id =  $("#community_id").val();
            var payment_date = $('#payment_date').val()
            var data = {};
            data.house_num = houseNum;
            data.community_id = community_id;
            if(houseNum != null && houseNum != ''){
                $.ajax({
                    type:"POST",
                    url:"HeatingFeePayment/findHouseNumIsNull",
                    data:data,
                    dataType:"json",
                    success:function(result){
                        if(result > 0){
                            //查 业主名 采暖面积  原始采暖单价 优惠起始日  优惠结束日  优惠比例
                            $.ajax({
                                type:"POST",
                                url:"HeatingFeePayment/findAreaOrNameOrMoney",
                                data:data,
                                dataType:"json",
                                success:function(findData){
                                    $('#owner_name').val(findData.ownerName);
                                    $('#area').val(findData.area);
                                    $('#heating_unit_price').val(findData.heatingUnitPrice);
                                    $('#house_id').val(findData.houseId);

                                    $.ajax({
                                        type:'post',
										url:'HeatingFeePayment/findHeatingDiscount',
										data: {'community_id':community_id ,'payment_date':payment_date},
										dataType:'json',
										success:function(find){

                                            $('#heating_discount').val(find);
											$('#discount_heating_unit_price').val( $('#heating_unit_price').val()* find);
                                            $('#payment_amount').val($('#discount_heating_unit_price').val() *  $('#area').val());
										}
									})
                                }
                            })

                        }
                    }
                })
            }
        })
        // 模糊联想 门牌号 end
        //单价keyup事件 键盘输入事件
        $('#area').keyup(function (){
            $('#payment_amount').val($('#discount_heating_unit_price').val() *  $('#area').val());
        })
        //关闭刷新页面 start
        $("#modal-demo-add").on("hide.bs.modal", function() {
            location.reload()
        })
        //关闭刷新页面 end
    }
    //添加缴费单
    $('#insert').on('click',function(){
        var heating_pay_num = $('#heating_pay_num').val();
        var house_id = $('#house_id').val();
        var owner_name = $('#owner_name').val();
        var heating_unit_price = $('#heating_unit_price').val();   //单价
        var discount_heating_unit_price = $('#discount_heating_unit_price').val();  //优惠单价
        var heating_area = $('#area').val();
        var payment_amount = $('#payment_amount').val();
        var year = $('#year').val();
        var heating_discount = $('#heating_discount').val();
        var payment_date = $('#payment_date').val();
        var charge_worker_id = $('#charge_worker_id').val();
        var operator = $('#Rname').val();

        var house_num = $('#house_num').val();

        var data = {};
        data.heating_pay_num = heating_pay_num;
        data.house_id = house_id;
        data.owner_name = owner_name;
        data.heating_unit_price = heating_unit_price;
        data.discount_heating_unit_price = discount_heating_unit_price;
        data.heating_area = heating_area;
        data.payment_amount = payment_amount;
        data.year = year;
        data.heating_discount = heating_discount;
        data.payment_date = payment_date;
        data.charge_worker_id = charge_worker_id;
        data.operator = operator;
        data.house_num = house_num;
        if(heating_pay_num == ''&& house_num == '' && year == ''){
            layer.alert('单号,门牌号,年份不能为空！')
        }else if(heating_pay_num == '' ){
            layer.alert('单号不能为空！')
        }else if(house_num == ''){
            layer.alert('门牌号不能为空！')
        }else if(year == ''){
            layer.alert('年份不能为空！')
        }
        $.ajax({
            type:'post',
            url:'HeatingFeePayment/insertHeating',
            data:data,
            dataType:'json',
            success:function(){
                location.reload();
            }
        })
    })
    //作废模态框
    function modaldemo(id){
        $('#asd').val(id);
        $('#modal-demo').modal("show")
    }
    //修改作废状态
    $('#Okey').on('click',function(){
        var d = $('#asd').val();
        var dN = $('#Rname').val();
        var id = {};
        id.heating_pay_id=d;
        id.Rname = dN;
        $.ajax({
            url:'HeatingFeePayment/updateOver',
            data:id,
            dataType:'json',
            method:'post',
            success:function(data){
                location.reload()
            }
        })
    })
</script>
</body>
</html>