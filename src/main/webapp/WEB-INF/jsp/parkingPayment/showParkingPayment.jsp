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
<link rel="stylesheet" href="Fontawesome/css/font-awesome.min.css">
<link rel="stylesheet" href="hui/lib/bootstrap-Switch/bootstrapSwitch.css">
<link rel="stylesheet" type="text/css" href="scripts/theme/default/layer.css">
</head>
<body>
<nav class="breadcrumb">车位费<span class="c-gray en">&gt;</span>缴费<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="PropertyFeePayment/showProperty" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<hr>
<div class="cl mt-20">
	<div class="clearfix mt-20" style="float: left; width: 250px; margin-left: 20px" >
			<input type="text" placeholder="请输入车位编号" class="input-text ac_input" name="parkingNum" id="parking_num" autocomplete="off" style="width:150px"><input value="搜索" type="submit" class="btn btn-default" id="search_button" onclick="submitForm()">
	</div>
	<span class="select-box radius mt-20" style="width: 150px; float: left; margin-right: 20px">
  		<select class="select" size="1" name="corpName" id="select1"></select>
	</span>
	<span class="select-box radius mt-20" style="width: 150px;float: left; margin-right: 20px">
  		<select class="select" size="1" name="communityName" id="select2"></select>
	</span>

	<input id="year" name="year" type="text" runat="server" onfocus="WdatePicker({skin:'default',dateFmt:'yyyy'})" class="Wdate select-box mt-20" style="width: 150px;float: left; margin-right: 20px"/>
</div>

<div class="page-container">
	车位编号：<span id="parkingNum"></span> &nbsp;&nbsp;&nbsp;车牌号：<span id="licensePlateNumber"></span>&nbsp;&nbsp;&nbsp;门牌号：<span id="houseNum"></span>&nbsp;&nbsp;&nbsp;业主姓名：<span id="ownerName"></span>&nbsp;&nbsp;&nbsp;称谓：<span id="gender"></span>&nbsp;&nbsp;&nbsp;联系电话：<span id="carOwnerTel"></span>&nbsp;&nbsp;&nbsp;备用联系电话：<span id="carOwnerStandbyTel"></span>&nbsp;&nbsp;&nbsp;
	<div class="mt-20">
		<table class="table table-border table-bordered table-hover table-bg table-sort">
			<thead>
			<tr class="text-c">
				<th style="display: none;">id</th>
				<th width="20">月份</th>
				<th width="100">缴费状态</th>
				<th width="20">月份</th>
				<th width="100">缴费状态</th>
			</tr>
			<tr class="text-c">
				<th style="display: none;">id</th>
				<th width="20">1</th>
				<th width="100" id="january"></th>
				<th width="20">7</th>
				<th width="100" id="july"></th>
			</tr>
			<tr class="text-c">
				<th style="display: none;">id</th>
				<th width="20">2</th>
				<th width="100" id="february"></th>
				<th width="20">8</th>
				<th width="100" id="august"></th>
			</tr>
			<tr class="text-c">
				<th style="display: none;">id</th>
				<th width="20">3</th>
				<th width="100" id="march"></th>
				<th width="20">9</th>
				<th width="100" id="september"></th>
			</tr>
			<tr class="text-c">
				<th style="display: none;">id</th>
				<th width="20">4</th>
				<th width="100" id="april"></th>
				<th width="20">10</th>
				<th width="100" id="october"></th>
			</tr>
			<tr class="text-c">
				<th style="display: none;">id</th>
				<th width="20">5</th>
				<th width="100" id="may"></th>
				<th width="20">11</th>
				<th width="100" id="november"></th>
			</tr>
			<tr class="text-c">
				<th style="display: none;">id</th>
				<th width="20">6</th>
				<th width="100" id="june"></th>
				<th width="20">12</th>
				<th width="100" id="december"></th>
			</tr>
			</thead>
		</table>
	</div>
</div>

<%@ include file="../common/footer.jsp" %>
<%-- 自定义js --%>
<script type="text/javascript" src="scripts/jquery.icheck.min.js"></script>
<script type="text/javascript" src="scripts/layer.js"></script>
<script type="text/javascript">
    $(function(){
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
		})
    });

    function submitForm(){
        var parkingNum = $('#parking_num').val();
        var	corpId = $('#select1').val();
        var communityId = $('#select2').val();
        var year = $('#year').val();
        var data = {};
        data.parkingNum = parkingNum;
        data.corpId = corpId;
        data.communityId = communityId;
        data.year = year;
		$.ajax({
			type:'post',
			url:'parkingPay/findParkingPay',
			data:data,
			dataType:'json',
			success:function (arrey) {
			    if(arrey == null){
                    layer.alert('没有此车位编码！', {icon: 5});
				}else {
                $('#parkingNum').html(arrey.findParkingPay.parkingNum);
                $('#licensePlateNumber').html(arrey.findParkingPay.licensePlateNumber);
                $('#houseNum').html(arrey.findParkingPay.houseNum);
                $('#ownerName').html(arrey.findParkingPay.ownerName);
                if(arrey.findParkingPay.gender > 0){
                    $('#gender').html("先生");
				}else {
                    $('#gender').html("女士");
				}
                $('#carOwnerTel').html(arrey.findParkingPay.carOwnerTel);
                $('#carOwnerStandbyTel').html(arrey.findParkingPay.carOwnerStandbyTel);

                if(arrey.findParkingStatus[0].paymentStatus == 0 || arrey.findParkingStatus[0].paymentStatus == null){
                    $('#january').html("未缴费");
                    $('#january').attr({style:"color:red"});
				}else {
                    $('#january').html("已缴费");
				}
                if(arrey.findParkingStatus[1].paymentStatus == 0 || arrey.findParkingStatus[1].paymentStatus == null){
                    $('#february').html("未缴费");
                    $('#february').attr({style:"color:red"});
                }else {
                    $('#february').html("已缴费");
                }
                if(arrey.findParkingStatus[2].paymentStatus == 0 || arrey.findParkingStatus[2].paymentStatus == null){
                    $('#march').html("未缴费");
                    $('#march').attr({style:"color:red"});
                }else {
                    $('#march').html("已缴费");
                }
                if(arrey.findParkingStatus[3].paymentStatus == 0 || arrey.findParkingStatus[3].paymentStatus == null){
                    $('#april').html("未缴费");
                    $('#april').attr({style:"color:red"});
                }else {
                    $('#april').html("已缴费");
                }
                if(arrey.findParkingStatus[4].paymentStatus == 0 || arrey.findParkingStatus[4].paymentStatus == null){
                    $('#may').html("未缴费");
                    $('#may').attr({style:"color:red"});
                }else {
                    $('#may').html("已缴费");
                }
                if(arrey.findParkingStatus[5].paymentStatus == 0 || arrey.findParkingStatus[5].paymentStatus == null){
                    $('#june').html("未缴费");
                    $('#june').attr({style:"color:red"});
                }else {
                    $('#june').html("已缴费");
                }
                if(arrey.findParkingStatus[6].paymentStatus == 0 || arrey.findParkingStatus[6].paymentStatus == null){
                    $('#july').html("未缴费");
                    $('#july').attr({style:"color:red"});
                }else {
                    $('#july').html("已缴费");
                }
                if(arrey.findParkingStatus[7].paymentStatus == 0 || arrey.findParkingStatus[7].paymentStatus == null){
                    $('#august').html("未缴费");
                    $('#august').attr({style:"color:red"});
                }else {
                    $('#august').html("已缴费");
                }
                if(arrey.findParkingStatus[8].paymentStatus == 0 || arrey.findParkingStatus[8].paymentStatus == null){
                    $('#september').html("未缴费");
                    $('#september').attr({style:"color:red"});
                }else {
                    $('#september').html("已缴费");
                }
                if(arrey.findParkingStatus[9].paymentStatus == 0 || arrey.findParkingStatus[9].paymentStatus == null){
                    $('#october').html("未缴费");
                    $('#october').attr({style:"color:red"});
                }else {
                    $('#october').html("已缴费");
                }
                if(arrey.findParkingStatus[10].paymentStatus == 0 || arrey.findParkingStatus[10].paymentStatus == null){
                    $('#november').html("未缴费");
                    $('#november').attr({style:"color:red"});
                }else {
                    $('#november').html("已缴费");
                }
                if(arrey.findParkingStatus[11].paymentStatus == 0 || arrey.findParkingStatus[11].paymentStatus == null){
                    $('#december').html("未缴费");
                    $('#december').attr({style:"color:red"});
                }else {
                    $('#december').html("已缴费");
                }
                }
                /*$('#december').html(arrey.findListPaymentInfor[11].paymentStatus);*/
            }
		})
    }


	$(document).ready(function () {
        $(function(){
            $.post("parkingPay/getPayCost",null,function (data) {
                if (data.type==0){
                    console.log(data.corpName)
                   $("#select1").append("<option value="+data.corpId+">"+data.corpName+"</option>")
                    aaa();
                }
            },"json")
        });
    })

    function aaa() {
        $.post("parkingPay/getCommunity",null,function (data) {
            for(var a in data){
                $("#select2").append("<option value="+data[a].communityId+">"+data[a].communityName+"</option>")
            }
        },"json")
    }

</script>
</body>
</html>