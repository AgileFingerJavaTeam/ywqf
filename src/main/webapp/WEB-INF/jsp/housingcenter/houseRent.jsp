<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="../common/meta.jsp" %>
<link rel="stylesheet" type="text/css" href="hui/lib/bootstrap-Switch/bootstrapSwitch.css" />

<%-- 自定义css样式 --%>
<style>
	.table>tbody>tr>td{
		text-align:center;
	}
	a{
		text-decoration:none;
	}

</style>
<meta charset="UTF-8">
<meta content="text/html">

</head>
<body>
<div class="page-container">
	<div class="cl pd-5 bg-1 bk-gray mt-20">
		<span class="l">
			<a  _href="house/addHouseInfo" onclick="add()" style="text-decoration: none;margin-right: 50px " class="abtn">
				新增<i class="Hui-iconfont">&#xe600;</i>
			</a>
			<a  _href="house/editHouseInfo" onclick="modaldemo()" style="text-decoration: none;margin-right: 50px "class="abtn">
				编辑<i class="Hui-iconfont">&#xe6df;</i>
			</a>
			<a style="text-decoration: none;margin-right: 50px " _href="house/deleteHouseInfo"  onclick="deleteMessage()" class="abtn">
			 删除<i class="Hui-iconfont">&#xe6e2;</i>
			</a>
		</span>
	</div>
	<div class="cl pd-5   mt-20">

		<div class="l "style="width: 50%">
			小区：
			<span class="select-box" style="width: 25%;display: inline-block">
			  <select class="select" size="1" name="demo1" id="community"></select>
			</span>
			楼号：
			<span class="select-box" style="width:25%;display: inline-block">
			  <select class="select" size="1" name="demo1" id="building" >
				<option value="0"selected>全部</option>
			  </select>
			</span>
			月份：
			<span class="select-box" style="width:25%;display: inline-block">
			  <select class="select" size="1" name="demo1" id="month" >
			  </select>
			</span>
		</div>
		<div class="r"style="width: 50%;">
			<button type="button" class="btn btn-success r" id="" name=""s onclick="picture_colume_add(this);"><i class="Hui-iconfont"></i> 导出</button>

			<div class=" r " style="margin-right: 40px">出租</div>
			<div class="switch r" id="mySwitch" data-on="warning" data-off="danger"  style="margin-right: 40px">
				<input type="checkbox"  value="1" checked />
			</div>

			<div class=" r " style="margin-right: 40px">出售</div>
			<div class="switch r" id="1" data-on="warning" data-off="danger"  style="margin-right: 40px">
				<input type="checkbox"  value="1" checked />
			</div>

		</div>

	</div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort" id="datable">
			<thead>
			<tr class="text-c">
				<th ><input type="checkbox" ></th>
				<th >单据编号</th>
				<th >发布时间</th>
				<th >房源类型</th>
				<th>门牌</th>
				<th >户型</th>
				<th >朝向</th>
				<th >面积</th>
				<th >装修</th>
				<th >出租价格</th>
				<th >出售价格</th>
				<th>照片</th>
				<th >详细介绍</th>
				<th >联系人姓名</th>
				<th >联系人电话</th>
			</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
</div>

<%@ include file="../common/footer.jsp" %>

<script type="text/javascript" src="//code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.4.2/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript" src="//cdn.datatables.net/buttons/1.4.2/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="hui/lib/bootstrap-modal/2.2.4/bootstrap-modal.js"></script>
<script type="text/javascript" src="hui/lib/bootstrap-modal/2.2.4/bootstrap-modalmanager.js"></script>
<script type="text/javascript" src="hui/lib/bootstrap-Switch/bootstrapSwitch.js"></script>
<script type="text/javascript">
    var select_row_id;
    var area=0;
    var prize=0;
    $(function(){
        $.post("house/getCompany",null,function (data) {
            if (data.type==0){
                chooseCommunity();
               /* getHouseList();*/
                $("#community").change(function(){
                    changChild($(this).val());
                });
            }/*else{
                $('.abtn').hide()
                $("#company").append("<option value=\"0\">全部</option>")
                getHouseList();
                $.post("house/getLeaderCompany",null,function (data) {
                    for(var i  in data){
                        $("#company").append("<option value="+data[i].id+">"+data[i].corpName+"</option>")
                    }
                },"json")
                $("#company").change(function(){
                    changChild($(this).val());
                });
            }*/
        },"json")


    });
    function chooseCommunity() {
        $("#community").append("<option value=\"0\">全部</option>")
        $.post("house/getCommunity",null,function (data) {
            for(var i  in data){
                $("#community").append("<option value="+data[i].id+">"+data[i].communityName+"</option>")
            }
        },"json")

    }

    function changChild(id){
        $("#building").empty();
        $("#building").append("<option value=\"0\">全部</option>")
        $.post("HouseCenter/getBuilding",{building_id:id},function (data) {
            for(var i  in data){
                $("#building").append("<option value="+data[i].building+">"+data[i].building+"</option>")
            }
        },"json")
       /* getHouseList();*/

    }
    $(function () {
        $("#month").append("<option value=\"0\" selected>全部</option>")
		for(var i=1;i<=12;i++){
            $("#month").append("<option value="+i+">"+i+'月份'+"</option>")
		}
    })


   /* $("#building").change(function(){
        getHouseList()
    });*/
    /*$(function getHouseList() {
        /!*var community_id=$('#community').val();
        var corp_id=$('#company').val();*!/
        $.post("HouseCenter/getHouseAskList",null,function (data) {
            $('.table-sort').dataTable({
                dom: 'fBrtip',
                buttons: [ {
                    "extend": 'excelHtml5',
                    'text': '导出',  //按钮标题
                    'className': 'btn btn-primary', //按钮的class样式
                    "customize": function( xlsx ) {
                        var sheet = xlsx.xl.worksheets['sheet1.xml'];

                        $('row c[r^="C"]', sheet).attr( 's', '2' );
                    }
                } ],
                'className': 'btn btn-primary', //按钮的class样式
                "pagingType":   "full_numbers",
                "data": data.rows,
                "destroy":true,
                "columns": [
                    {
                        "sClass": "text-center",
                        "data": "id",
                        "render": function (data, type, row, meta) {
                            return '<input type="checkbox"  class="checkchild"  value="' + data + '"  onclick="get(this)"/>';
                        },
                        "bSortable": false
                    },
                    {"data": "houseNeedRentNum"},
                    {"data": "releaseTime"},
                    {"data": "type"},
                    {"data": "houseTypeName"},
                    {"data": "houseDirectionTypeName"},
                    {"data": "floor"},
                    {"data": "areaRange"},
                    {"data": "houseFitmentTypeName"},
                    {"data": "housePriceRange"},
                    {"data": "housePriceRange"},
                    {"data": "remark"},
                    {"data": "customerName"},
                    {"data": "phone"}
                ],
                "oLanguage": { //国际化配置
                    "sProcessing" : "正在获取数据，请稍后...",
                    "sLengthMenu" : "显示 _MENU_ 条",
                    "sZeroRecords" : "没有您要搜索的内容",
                    "sInfo" : "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",
                    "sInfoEmpty" : "记录数为0",
                    "sInfoFiltered" : "(全部记录数 _MAX_ 条)",
                    "sInfoPostFix" : "",
                    "sSearch" : "搜索",
                    "sUrl" : "",
                    "oPaginate": {
                        "sFirst" : "第一页",
                        "sPrevious" : "上一页",
                        "sNext" : "下一页",
                        "sLast" : "最后一页"
                    }
                },
                "aaSorting": [[ 1, "desc" ]],//默认第几个排序
                "bStateSave": true,//状态保存
                "aoColumnDefs": [
                    //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
                    {"orderable":false,"aTargets":[0]}// 不参与排序的列
                ]
            });
        },"json")

    })*/
    function get(obj) {
        select_row_id=$(obj).val()
    }
    function add(){
        $.post("house/getCompany",null,function (data) {
            $('#writeCompany').val(data.corpName)
        })
        $("#writeCommunity").empty()
        $("#modal-add").modal("show")
        $.post("house/getCommunity",null,function (data) {
            for(var i  in data){
                $("#writeCommunity").append("<option value="+data[i].id+">"+data[i].communityName+"</option>")
            }
        },"json")
        $("#houseType").empty()
        $.post("house/getRoomType",null,function (data) {
            for(var i in data){
                $("#houseType").append("<option value="+data[i].id+">"+data[i].houseTypeName+"</option>")

            }
        },"json")
        $("#modal-add").on("hide.bs.modal", function() {
            location.reload()
        })
    }
    function ADD() {
        var json={}
        json.community_id=$('#writeCommunity').val();
        json.building=$('#building').val();
        json.unit=$('#unit').val();
        json.floor=$('#floor').val();
        json.room_num=$('#room_num').val();
        json.house_type_id=$('#house_type_id').val();
        json.area=$('#area').val();
        json.now_estate_unit_price=$('#prize').val();
        json.owner_name=$('#owner_name').val();
        json.owner_tel=$('#owner_tel').val();
        json.family_size=$('#family_size').val();
        json.now_estate_fee=$('#sum').val();
        console.log(json)
        $.post("house/subHouseInfo",{json:json},function (data) {
            alert("添加成功")
        })

    }
    function edit(){

        $.post("house/editHouseInfo",{id:select_row_id},function (data) {
            $('#writeCompany').val(data.corpName)
        })
        $.post("house/getCompany",null,function (data) {
            $('#writeCompany').val(data.corpName)
        })
        $("#modal-edit").modal("show")
        $.post("house/getCommunity",null,function (data) {
            for(var i  in data){
                $("#writeCommunity").append("<option value="+data[i].id+">"+data[i].communityName+"</option>")
            }
        },"json")

        $.post("house/getRoomType",null,function (data) {
            for(var i in data){
                $("#houseType").append("<option value="+data[i].id+">"+data[i].houseTypeName+"</option>")

            }
        },"json")
        $("#modal-edit").on("hide.bs.modal", function() {
            $("#writeCommunity").empty();
            $("#houseType").empty()
            location.reload()
        })
    }
    function deleteMessage(){

        $("#deleteMessage").modal("show");
        $('#rowid').val(select_row_id);
        $("#deleteMessage").on("hide.bs.modal", function() {
            location.reload()
        })
    }
    function Delete(){
        $.post("house/subDelHouseInfo",{id:$('#rowid').val()},function (data) {

        })
    }
    $('#area').bind('input propertychange', function() {
        area=$(this).val()
        $('#sum').val(prize*area)
    });
    $('#prize').bind('input propertychange', function() {
        prize=$(this).val()
        $('#sum').val(prize*area)
    });
</script>
</body>
</html>