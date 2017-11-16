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



</head>
<body>
<nav class="breadcrumb">车位费<span class="c-gray en">&gt;</span>缴费<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="PropertyFeePayment/showProperty" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>

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
              <select class="select" size="1" name="demo1">
                <option value="" selected>全部物业公司</option>
                <option value="1">菜单一</option>
                <option value="2">菜单二</option>
                <option value="3">菜单三</option>
              </select>
        </span>
	&nbsp;&nbsp;&nbsp;&nbsp;缴费日期范围:&nbsp;&nbsp;&nbsp;<span style="color: #AAAAAA;">开始日期</span>&nbsp;
	&nbsp;&nbsp;
	<span class="select-box" style="width: 200px;">
              <select class="select" size="1" name="demo1">
                <option value="" selected>开始日期</option>
                <option value="1">菜单一</option>
                <option value="2">菜单二</option>
                <option value="3">菜单三</option>
              </select>
        </span>
	&nbsp;&nbsp;&nbsp;<span style="color: #AAAAAA;">结束日期</span>&nbsp;
	&nbsp;&nbsp;
	<span class="select-box" style="width: 200px;">
              <select class="select" size="1" name="demo1">
                <option value="" selected>结束日期</option>
                <option value="1">菜单一</option>
                <option value="2">菜单二</option>
                <option value="3">菜单三</option>
              </select>
        </span>
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
              <select class="select" size="1" name="demo1">
                <option value="" selected>全部小区</option>
                <option value="1">菜单一</option>
                <option value="2">菜单二</option>
                <option value="3">菜单三</option>
              </select>
        </span>
	&nbsp;&nbsp;&nbsp;&nbsp;缴费日期范围:&nbsp;&nbsp;&nbsp;<span style="color: #AAAAAA;">开始日期</span>&nbsp;
	&nbsp;&nbsp;
	<span class="select-box" style="width: 200px;">
              <select class="select" size="1" name="demo1">
                <option value="" selected>开始日期</option>
                <option value="1">菜单一</option>
                <option value="2">菜单二</option>
                <option value="3">菜单三</option>
              </select>
        </span>
	&nbsp;&nbsp;
	<span style="color: #AAAAAA;">结束日期</span>&nbsp;
	&nbsp;&nbsp;
	<span class="select-box" style="width: 200px;">
              <select class="select" size="1" name="demo1">
                <option value="" selected>结束日期</option>
                <option value="1">菜单一</option>
                <option value="2">菜单二</option>
                <option value="3">菜单三</option>
              </select>
        </span>
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
				<th width="70">车位编号</th>
				<th width="80">车主姓名</th>
				<th width="100">车牌号</th>
				<th width="80">门牌号</th>
				<th width="70">单价</th>
				<th width="100">服务期起始日</th>
				<th width="100">服务期截止日</th>
				<th width="70">缴纳月数</th>
				<th width="70">缴纳额</th>
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
				<h3 class="modal-title">修改作废状态</h3>
				<a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void()">×</a>
			</div>
			<div class="modal-body">
				<span style="text-align: center;">是否修改作废状态？</span>
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
						<input type="text" class="input-text" name="parking_pay_num" id="parking_pay_num"  placeholder="请输入单号" required:true;>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">小区</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<select class="select" size="1" name="community_id" id="community_id" style="height: 31px;">
						</select>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">门牌号</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text" id="house_num" autocomplete="value"  name="house_num" autocomplete="off" placeholder="请输入业主门牌号" >
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">车位编号</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text" id="parking_num" autocomplete="value"  name="parking_num" readonly="readonly" placeholder="请输入车位编号" >
					</div>
				</div>
				<div class="row cl" >
					<label class="form-label col-xs-4 col-sm-5">缴费人姓名</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text"  id="owner_name"  name="owner_name" readonly="readonly" placeholder="请输入业主姓名" >
					</div>
				</div>
				<div class="row cl" >
					<label class="form-label col-xs-4 col-sm-5">车位ID</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text"  id="parking_space_id"  name="parking_space_id" readonly="readonly" placeholder="请输入业主姓名" >
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">车主姓名</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text" autocomplete="off" id="car_owner_name"  name="car_owner_name" readonly="readonly" placeholder="请输入车主姓名" >
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">车牌号</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text" id="license_plate_number"  name="license_plate_number" autocomplete="off" placeholder="请输入车牌号" readonly="readonly">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">车位单价</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text"   id="parking_unit_price" name="parking_unit_price"   placeholder="请输入车牌单价" >
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">缴纳月数</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<select class="select" size="1" name="pay_month_type_id" id="pay_month_type_id" style="height: 31px;">
						</select>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">服务起始日期</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text" autocomplete="off" id="service_start_date"  name="service_start_date"  readonly  value="">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">服务截止日期</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text" autocomplete="off" id="service_end_date"  name="service_end_date"  readonly  value="">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">缴费金额</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text" autocomplete="off" id="payment_amount"  name="payment_amount" readonly="readonly">
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
						<input type="text" class="input-text"  id="pay_date"  name="pay_date" readonly="readonly">

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

<%-- 自定义js --%>
<script type="text/javascript">
	//初始查询
    $(function(){
        $.ajax({
            url: "ParkingFeePayment/getParkingList",
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
                {'data': 'parkingPayNum',},
                {'data': 'parkingNum',},
                {'data': 'carOwnerName',},
                {"data": 'licensePlateNumber',},
                {'data': 'houseNum',},
                {'data': 'parkingUnitPrice',},
                {
                    'data': function (value) {
                        var a_time = value.serviceStartDate;
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
                        var a_time = value.serviceEndDate;
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
                    'data': function (value) {
                        var a = value.payMonth;
                        return a + '个月'
                    },
                },
                {'data': 'paymentAmount',},
                {"data": 'name',},
                {
                    'data': function (value) {
                        var a_time = value.payDate;
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
                        var b = value.parkingPayId;
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
    //正常switch
    $('#mySwitch').on('switch-change', function (e, data) {
        var a = $('#mySwitchs').bootstrapSwitch('status');
        var status = data.value;
        var data = {};
        if(status == a){
            data.status = '';
            data.okey ='';
            $.ajax({
                url:"PropertyFeePayment/getPropertyList",
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
            $.ajax({
                url:"PropertyFeePayment/getPropertyList",
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
            $.ajax({
                url:"PropertyFeePayment/getPropertyList",
                type:"POST",
                data:data,
                dataType:"json",
                success:function (data){
                    showDataTable(data);
                }
            })
        }
    });
    //作废switch
    $('#mySwitchs').on('switch-change', function (e, data) {
        var status = $('#mySwitch').bootstrapSwitch('status');
        var a = data.value;
        var data = {};
        if(status == a){
            data.status = '';
            data.okey ='';
            $.ajax({
                url:"PropertyFeePayment/getPropertyList",
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
            $.ajax({
                url:"PropertyFeePayment/getPropertyList",
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
            $.ajax({
                url:"PropertyFeePayment/getPropertyList",
                type:"POST",
                data:data,
                dataType:"json",
                success:function (data){
                    showDataTable(data);
                }
            })
        }
    });
    //模糊查询
    $('#search_button').on('click',function(){
        var a = $('#mySwitch').bootstrapSwitch('status');
        var b = $('#mySwitchs').bootstrapSwitch('status');
        alert('a='+a);
        alert('b='+b);
        var at_search = $('#at_search').val();
        var data = {};
        data.at_search = at_search;
        if(a == b){
            data.status = '';
            data.okey ='';
            $.ajax({
                url:"PropertyFeePayment/getPropertyList",
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
                url:"PropertyFeePayment/getPropertyList",
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
                url:"PropertyFeePayment/getPropertyList",
                type:"POST",
                data:data,
                dataType:"json",
                success:function (data){
                    showDataTable(data);
                }
            })
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
        var corp_id={};
        corp_id.corp_id=corpId;
        $.ajax({
            type:"POST",
            url:"ParkingFeePayment/findVillage",
            data:corp_id,
            dataType:"json",
            success:function(asdf){
                jQuery("#community_id").empty();
                for(var i in asdf){
                    var a = asdf[i].communityId;
                    $("#community_id").append("<option value="+a+">"+asdf[i].communityName+"</option>")
                }
            }
        });
        // 遍历小区 end
        //缴费日期 start
        var aa = new Date();
        var year = aa.getFullYear();
        var month = aa.getMonth() + 1 < 10 ? "0" + (aa.getMonth() + 1): aa.getMonth() + 1;
        var day = aa.getDate() < 10 ? "0" + aa.getDate() : aa.getDate();
        var dateStr = year + "-" + month + "-" + day;
        $('#pay_date').val(dateStr);
        //缴费日期 end
        //小区change事件
        $('#community_id').on('change',function(){
            $('#house_num').val('');
            $('#car_owner_name').val('');
            $('#license_plate_number').val('');
            $('#parking_unit_price').val('');
            $('#payment_amount').val('');
            $('#service_start_date').val('');
            $('#service_end_date').val('');
            $('#owner_name').val('');
            $('#house_id').val('');
            $('#parking_space_id').val('');
            $('#parking_num').val('');
        })
        // 遍历码表缴纳月数
        $.ajax({
            type:"POST",
            url:"ParkingFeePayment/findMoneyMonth",
            dataType:"json",
            success:function(ddf){
                jQuery("#pay_month_type_id").empty();
                for(var i in ddf){
                    $("#pay_month_type_id").append("<option value="+ddf[i].count+">"+ddf[i].count+'个月'+"</option>")
                }
            }
        });
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
        //缴费月数change事件
        $('#pay_month_type_id').on('change',function(){
            var month = $('#pay_month_type_id').val();
            var price = $('#parking_unit_price').val();
            $('#payment_amount').val(price * month);
        // 显示截止日期
            var time = $('#service_start_date').val();
            var j = parseInt(month);
            var val = Date.parse(time);
            var newDate = new Date(val);
            var atime = newDate.setMonth(newDate.getMonth()+ j);
            var aa = new Date(atime);

            var format = function(atime, format){
                var aa = new Date(atime);
                var tf = function(i){return (i < 10 ? '0' : '') + i};
                return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function(a){
                    switch(a){
                        case 'yyyy':
                            return tf(aa.getFullYear());
                            break;
                        case 'MM':
                            return tf(aa.getMonth() + 1);
                            break;
                        case 'mm':
                            return tf(aa.getMinutes());
                            break;
                        case 'dd':
                            return tf(aa.getDate());
                            break;
                        case 'HH':
                            return tf(aa.getHours());
                            break;
                        case 'ss':
                            return tf(aa.getSeconds());
                            break;
                    }
                })
            }
            var dateTime = format(new Date(aa), 'yyyy-MM-dd');
            $('#service_end_date').val(dateTime)
		})
        // 模糊联想 门牌号 start
        $('#house_num').keyup(function () {
            var houseNum =$('#house_num').val();
            var community_id =  $("#community_id").val();
            var data = {};
            data.house_num = houseNum;
            data.community_id = community_id;
            if(houseNum != null && houseNum != ''){
                $.ajax({
                    type:"POST",
                    url:"ParkingFeePayment/findHouseNumIsNull",
                    data:data,
                    dataType:"json",
                    success:function(result){
                        if(result > 0){
                            //查车主姓名  车牌号   车位单价   车位编号  业主姓名   业主联系电话
                            $.ajax({
                                type:"POST",
                                url:"ParkingFeePayment/findCarNumberOrMoneyOrName",
                                data:data,
                                dataType:"json",
                                success:function(findData){
                                    $('#parking_num').val(findData.parkingNum);
                                    $('#license_plate_number').val(findData.licensePlateNumber);
                                    $('#car_owner_name').val(findData.carOwnerName);
                                    $('#owner_name').val(findData.ownerName);
                                    $('#parking_unit_price').val(findData.previousParkingUnitPrice);
                                    $('#parking_space_id').val(findData.parkingSpaceId);


                                    var month = $('#pay_month_type_id').val();
                                    var price = $('#parking_unit_price').val();
                                    $('#payment_amount').val(price * month);
                                }
                            })
                            //查起始时间 = 上次结束时间+1天
                            $.ajax({
                                type:"POST",
                                url:"ParkingFeePayment/findStartTime",
                                data:data,
                                dataType:"json",
                                success:function(time){
                                    $('#service_start_date').val(time);
                                    var months = $('#pay_month_type_id').val();
                                    var j = parseInt(months);
                                    var val = Date.parse(time);
                                    var newDate = new Date(val);
                                    var atime = newDate.setMonth(newDate.getMonth()+ j);
                                    var aa = new Date(atime);

                                    var format = function(atime, format){
                                        var aa = new Date(atime);
                                        var tf = function(i){return (i < 10 ? '0' : '') + i};
                                        return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function(a){
                                            switch(a){
                                                case 'yyyy':
                                                    return tf(aa.getFullYear());
                                                    break;
                                                case 'MM':
                                                    return tf(aa.getMonth() + 1);
                                                    break;
                                                case 'mm':
                                                    return tf(aa.getMinutes());
                                                    break;
                                                case 'dd':
                                                    return tf(aa.getDate());
                                                    break;
                                                case 'HH':
                                                    return tf(aa.getHours());
                                                    break;
                                                case 'ss':
                                                    return tf(aa.getSeconds());
                                                    break;
                                            }
                                        })
                                    }
                                    var dateTime = format(new Date(aa), 'yyyy-MM-dd');
                                    $('#service_end_date').val(dateTime)
                                }
                            })
                        }
                    }
                })
            }
        })
        // 模糊联想 门牌号 end
        //单价keyup事件 键盘输入事件
        $('#parking_unit_price').keyup(function (){
            var month = $('#pay_month_type_id').val();
            var price = $('#parking_unit_price').val();
            $('#payment_amount').val(price * month);
        })
        //关闭刷新页面 start
        $("#modal-demo-add").on("hide.bs.modal", function() {
            location.reload()
        })
        //关闭刷新页面 end
	}
	//添加缴费单
    $('#insert').on('click',function(){
        var parking_pay_num = $('#parking_pay_num').val();
        var community_id = $('#community_id').val();
        var house_num = $('#house_num').val();
        var parking_num = $('#parking_num').val();
        var car_owner_name = $('#car_owner_name').val();
        var owner_name = $('#owner_name').val();
        var house_id = $('#house_id').val();
        var parking_space_id = $('#parking_space_id').val();
        var license_plate_number = $('#license_plate_number').val();
        var parking_unit_price = $('#parking_unit_price').val();
        var pay_month_type_id = $('#pay_month_type_id').val();
        var service_start_date = $('#service_start_date').val();
        var service_end_date = $('#service_end_date').val();
        var payment_amount = $('#payment_amount').val();
        var charge_worker_id = $('#charge_worker_id').val();
        var pay_date = $('#pay_date').val();
        var corp_id = $('#corpId').val();
        var operator = $('#Rname').val();
        var car_owner_tel = $('#car_owner_tel').val();

        var data = {};
        data.corp_id = corp_id;
        data.parking_pay_num = parking_pay_num;
        data.community_id = community_id;
        data.house_num = house_num;
        data.parking_num = parking_num;
        data.car_owner_name = car_owner_name;
        data.owner_name = owner_name;
        data.house_id = house_id;
        data.parking_space_id = parking_space_id;
        data.license_plate_number = license_plate_number;
        data.parking_unit_price = parking_unit_price;
        data.pay_month_type_id = pay_month_type_id;
        data.pay_date = pay_date;
        data.payment_amount = payment_amount;
        data.service_start_date = service_start_date;
        data.service_end_date = service_end_date;
        data.charge_worker_id = charge_worker_id;
        data.operator = operator;
        data.car_owner_tel = car_owner_tel;
        if(parking_pay_num == ''&& house_num == ''){
            layer.alert('单号和门牌号不能为空！')
        }else if(parking_pay_num == '' ){
            layer.alert('单号不能为空！')
        }else if(house_num == ''){
            layer.alert('门牌号不能为空！')
        }
        $.ajax({
            type:'post',
            url:'ParkingFeePayment/insertParking',
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
        var id = {};
        id.id=d;
        $.ajax({
            url:'ParkingFeePayment/updateOver',
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