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
<nav class="breadcrumb">物业费<span class="c-gray en">&gt;</span>缴费<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="PropertyFeePayment/showProperty" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<hr>
<div class="cl mt-20">
	<div class="clearfix mt-20" style="float: left; width: 250px; margin-left: 20px" >
		<%--<form method="get" id="ff" action="payCost/getOwnerInfor">--%>
			<input type="text" placeholder="请输入门牌号" class="input-text ac_input" name="house_num" id="house_num" autocomplete="off" style="width:150px"><input value="搜索" type="submit" class="btn btn-default" id="search_button" onclick="submitForm()">
			<%--<button type="submit" class="btn btn-default" id="search_button">搜索</button>--%>
		<%--</form>--%>
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
	门牌号：<span id="houseNum"></span> &nbsp;&nbsp;&nbsp;业主姓名：<span id="ownerName"></span>&nbsp;&nbsp;&nbsp;联系电话：<span id="ownerTel"></span>&nbsp;&nbsp;&nbsp;备用联系电话：<span id="ownerStandbyTel"></span>&nbsp;&nbsp;&nbsp;
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
				<th width="100" id="january" attr-id="one" class="paymentStatus"></th>
				<th width="20">7</th>
				<th width="100" id="july" attr-id="seven" class="paymentStatus"></th>
			</tr>
			<tr class="text-c">
				<th style="display: none;">id</th>
				<th width="20">2</th>
				<th width="100" id="february" attr-id="two" class="paymentStatus"></th>
				<th width="20">8</th>
				<th width="100" id="august" attr-id="eight" class="paymentStatus"></th>
			</tr>
			<tr class="text-c">
				<th style="display: none;">id</th>
				<th width="20">3</th>
				<th width="100" id="march" attr-id="three" class="paymentStatus"></th>
				<th width="20">9</th>
				<th width="100" id="september" attr-id="night" class="paymentStatus"></th>
			</tr>
			<tr class="text-c">
				<th style="display: none;">id</th>
				<th width="20">4</th>
				<th width="100" id="april" attr-id="four" class="paymentStatus"></th>
				<th width="20">10</th>
				<th width="100" id="october" attr-id="ten" class="paymentStatus"></th>
			</tr>
			<tr class="text-c">
				<th style="display: none;">id</th>
				<th width="20">5</th>
				<th width="100" id="may" attr-id="five" class="paymentStatus"></th>
				<th width="20">11</th>
				<th width="100" id="november" attr-id="eleven" class="paymentStatus"></th>
			</tr>
			<tr class="text-c">
				<th style="display: none;">id</th>
				<th width="20">6</th>
				<th width="100" id="june" attr-id="six" class="paymentStatus"></th>
				<th width="20">12</th>
				<th width="100" id="december" attr-id="twelve" class="paymentStatus"></th>
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
        var houseNum = $('#house_num').val();
        var	corpId = $('#select1').val();
        var communityId = $('#select2').val();
        var year = $('#year').val();
        var data = {};
        data.houseNum = houseNum;
        data.corpId = corpId;
        data.communityId = communityId;
        data.year = year;
		$.ajax({
			type:'post',
			url:'payCost/getOwnerInfor',
			data:data,
			dataType:'json',
			success:function (arrey) {
			    if(arrey == null){
                    layer.alert('没有此门牌号！', {icon: 5});
				}else {
					$('#houseNum').html(arrey.findOwnerInfor.houseNum);
					$('#ownerName').html(arrey.findOwnerInfor.ownerName);
					$('#ownerTel').html(arrey.findOwnerInfor.ownerTel);
					$('#ownerStandbyTel').html(arrey.findOwnerInfor.ownerStandbyTel);

					/*var findListPaymentInfor = arrey.findListPaymentInfor;
					for(var i=0;i<findListPaymentInfor.lengh;i++){
						var paymentStatus = arrey[i].paymentStatus;
						if(paymentStatus == 0){
							$(this).html("未缴费");
							$(this).attr({style:"color:red"});
							$(this).html(arrey.findListPaymentInfor[i].paymentStatus);
						}else{
							$('#january').html("已缴费");
							$(this).html(arrey.findListPaymentInfor[i].paymentStatus);
						}
					}*/
					if(arrey.findListPaymentInfor[0].paymentStatus == 0 || arrey.findListPaymentInfor[0].paymentStatus == null){
						$('#january').html("未缴费");
						$('#january').attr({style:"color:red"});
					}else {
						$('#january').html("已缴费");
					}
					if(arrey.findListPaymentInfor[1].paymentStatus == 0 || arrey.findListPaymentInfor[1].paymentStatus == null){
						$('#february').html("未缴费");
						$('#february').attr({style:"color:red"});
					}else {
						$('#february').html("已缴费");
					}
					if(arrey.findListPaymentInfor[2].paymentStatus == 0 || arrey.findListPaymentInfor[2].paymentStatus == null){
						$('#march').html("未缴费");
						$('#march').attr({style:"color:red"});
					}else {
						$('#march').html("已缴费");
					}
					if(arrey.findListPaymentInfor[3].paymentStatus == 0 || arrey.findListPaymentInfor[3].paymentStatus == null){
						$('#april').html("未缴费");
						$('#april').attr({style:"color:red"});
					}else {
						$('#april').html("已缴费");
					}
					if(arrey.findListPaymentInfor[4].paymentStatus == 0 || arrey.findListPaymentInfor[4].paymentStatus == null){
						$('#may').html("未缴费");
						$('#may').attr({style:"color:red"});
					}else {
						$('#may').html("已缴费");
					}
					if(arrey.findListPaymentInfor[5].paymentStatus == 0 || arrey.findListPaymentInfor[5].paymentStatus == null){
						$('#june').html("未缴费");
						$('#june').attr({style:"color:red"});
					}else {
						$('#june').html("已缴费");
					}
					if(arrey.findListPaymentInfor[6].paymentStatus == 0 || arrey.findListPaymentInfor[6].paymentStatus == null){
						$('#july').html("未缴费");
						$('#july').attr({style:"color:red"});
					}else {
						$('#july').html("已缴费");
					}
					if(arrey.findListPaymentInfor[7].paymentStatus == 0 || arrey.findListPaymentInfor[7].paymentStatus == null){
						$('#august').html("未缴费");
						$('#august').attr({style:"color:red"});
					}else {
						$('#august').html("已缴费");
					}
					if(arrey.findListPaymentInfor[8].paymentStatus == 0 || arrey.findListPaymentInfor[8].paymentStatus == null){
						$('#september').html("未缴费");
						$('#september').attr({style:"color:red"});
					}else {
						$('#september').html("已缴费");
					}
					if(arrey.findListPaymentInfor[9].paymentStatus == 0 || arrey.findListPaymentInfor[9].paymentStatus == null){
						$('#october').html("未缴费");
						$('#october').attr({style:"color:red"});
					}else {
						$('#october').html("已缴费");
					}
					if(arrey.findListPaymentInfor[10].paymentStatus == 0 || arrey.findListPaymentInfor[10].paymentStatus == null){
						$('#november').html("未缴费");
						$('#november').attr({style:"color:red"});
					}else {
						$('#november').html("已缴费");
					}
					if(arrey.findListPaymentInfor[11].paymentStatus == 0 || arrey.findListPaymentInfor[11].paymentStatus == null){
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
            $.post("payCost/getPayCost",null,function (data) {
                if (data.type==0){
                    console.log(data.corpName)
                   $("#select1").append("<option value="+data.corpId+">"+data.corpName+"</option>")
                    aaa();
                }
            },"json")
        });
    })

    function aaa() {
        $.post("payCost/getCommunity",null,function (data) {
            for(var a in data){
                $("#select2").append("<option value="+data[a].communityId+">"+data[a].communityName+"</option>")
            }
        },"json")
    }

</script>
</body>
</html>