<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="../common/meta.jsp" %>
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
			<a  _href="house/editHouseInfo"onclick="edit()" style="text-decoration: none;margin-right: 50px "class="abtn">
				编辑<i class="Hui-iconfont">&#xe6df;</i>
			</a>
			<a style="text-decoration: none;margin-right: 50px " _href="house/deleteHouseInfo"  onclick="deleteMessage()" class="abtn">
			 删除<i class="Hui-iconfont">&#xe6e2;</i>
			</a>
			<a  _href="house/addHouseInfo" onclick="modaldemo()"style="text-decoration: none;margin-right: 50px ">
				导入<i class="Hui-iconfont">&#xe600;</i>
			</a>
		</span>
	</div>
	<div class="cl pd-5   mt-20">
		物业公司：
		<span class="select-box" style="width: 20%;display: inline-block">
		  <select class="select" size="1" name="demo1" id="company">

		  </select>
		</span>
		小区：
		<span class="select-box" style="width: 20%;display: inline-block">
		  <select class="select" size="1" name="demo1" id="community" >
		  	<option value="0"selected>全部</option>
		  </select>
		</span>
	</div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort" id="datable">
			<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" ></th>
				<th width="50">楼号</th>
				<th width="50">门号</th>
				<th width="50">层号</th>
				<th width="60">房号</th>
				<th width="80">门牌号</th>
				<th width="100">户型</th>
				<th width="60">面积</th>
				<th width="80"id="goods">物业单价</th>
				<th width="80">户主姓名</th>
				<th width="100">联系电话</th>
				<th width="100">备用联系电话</th>
				<th width="60">家庭成员</th>
				<th width="80">物业费合计</th>
			</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
</div>
<div id="modal-add" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content radius" style=" overflow:scroll;height:600px;width: 500px">
			<form action="house/subHouseInfo" method="post" class="form form-horizontal"   id="addForm">
				<div class="modal-header">
					<h4	 style="text-align: center">新增小区配置</h4>
					<a class="close" data-dismiss="modal" aria-hidden="true" >×</a>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">物业：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text"class="input-text add" id="writeCompany"readonly >
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">小区：</label>
					<div class="formControls col-xs-4 col-sm-5	">

						  <select class="input-text add" size="1" name="community_id" id="writeCommunity" >

						  </select>

					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">楼号：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text" id="building" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();" placeholder="请输入楼号">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">门号：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text" id="unit" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"  placeholder="请输入门号">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">层号：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text" id="floor" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"  placeholder="请输入层号">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">房号：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text " id="room_num" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();" placeholder="请输入房号">
					</div>
				</div>

				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">户型：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<select id="houseType" class="input-text "></select>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">面积：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text "  id="area" onkeyup="(this.v=function(){this.val(/^[+]{0,1}(\d+)$|^[+]{0,1}(\d+\.\d+)$/);}).call(this)" onblur="this.v();" placeholder="请输入面积">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">物业单价：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text " name="now_estate_unit_price" id="prize" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();" placeholder="请输入物业单价">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">户主姓名：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text " id="owner_name"  placeholder="请输入户主姓名">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">联系电话：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text "id="owner_tel" autocomplete="off" placeholder="请输入联系电话">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">备用联系电话：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text "id="owner_standby_tel" autocomplete="off" placeholder="请输入备用联系电话">
					</div>
				</div>

				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">家庭成员数量：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text "id="family_size" autocomplete="off" placeholder="请输入家庭成员数量">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">物业费合计：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text "id="sum" autocomplete="off" readonly>
					</div>
				</div>
			</form>
			<div class="modal-footer" style="text-align: center">
				<button class="btn btn-primary"onclick="ADD()">确定</button>
				<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
			</div>
		</div>
	</div>
</div>
<div id="modal-edit" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content radius" style=" overflow:scroll;height:600px;width: 500px">
			<form action="house/subEditHouseInfo" method="post" class="form form-horizontal"   id="editForm">
				<div class="modal-header">
					<h4	 style="text-align: center">修改小区配置</h4>
					<a class="close" data-dismiss="modal" aria-hidden="true" >×</a>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">物业：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text"class="input-text add" id="editCompany"readonly >
						<input type="hidden"id="chooseid">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">小区：</label>
					<div class="formControls col-xs-4 col-sm-5	">

						<select class="input-text add" size="1" id="editCommunity" >

						</select>

					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">楼号：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text add" id="editBuilding" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();" placeholder="请输入楼号">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">门号：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text add" id="editUnit" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"  placeholder="请输入门号">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">层号：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text add" id="editFloor" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"  placeholder="请输入层号">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">房号：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text add" id="editRoom"  onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();" placeholder="请输入房号">
					</div>
				</div>

				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">户型：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<select id="editHouseType" class="input-text add" ></select>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">面积：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text " id="areaEdit" onkeyup="(this.v=function(){this.val(/^[+]{0,1}(\d+)$|^[+]{0,1}(\d+\.\d+)$/);}).call(this)" onblur="this.v();" placeholder="请输入面积">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">物业单价：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text " id="prizeEdit" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();" placeholder="请输入物业单价">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">户主姓名：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" id="editName" class="input-text "placeholder="请输入户主姓名">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">联系电话：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text "id="editTel" autocomplete="off" placeholder="请输入联系电话">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">备用联系电话：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" id="editTelCopy" class="input-text " autocomplete="off" placeholder="请输入备用联系电话">
					</div>
				</div>

				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">家庭成员数量：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text"id="editNum" class="input-text "autocomplete="off" placeholder="请输入家庭成员数量">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">物业费合计：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text " id="sumEdit" autocomplete="off" readonly>
					</div>
				</div>
			</form>
			<div class="modal-footer" style="text-align: center">
				<button class="btn btn-primary"onclick="EDIT()">确定</button>
				<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
			</div>
		</div>
	</div>
</div>
<div id="deleteMessage" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content radius">
				<div class="modal-header">
					<h4	 style="text-align: center">删除信息</h4>
					<a class="close" data-dismiss="modal" aria-hidden="true">×</a>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">是否删除本条数据?</label>
					<input type="hidden" id="rowid">
				</div>
				<div class="modal-footer" style="text-align: center">
					<button class="btn btn-primary"onclick="Delete()">确定</button>
					<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
				</div>
		</div>
	</div>
</div>

<%@ include file="../common/footer.jsp" %>

<script type="text/javascript" src="//code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" src="hui/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.4.2/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript" src="//cdn.datatables.net/buttons/1.4.2/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="hui/lib/bootstrap-modal/2.2.4/bootstrap-modal.js"></script>
<script type="text/javascript" src="hui/lib/bootstrap-modal/2.2.4/bootstrap-modalmanager.js"></script>
<script type="text/javascript">
	var select_row_id=null;
	var area=0;
	var prize=0;
	$(function(){
            $.post("house/getCompany",null,function (data) {
                if (data.type==0){
                    $("#company").append("<option value="+data.corpId+">"+data.corpName+"</option>")
					chooseCommunity();
                    getHouseList();
				}else{
					$('.abtn').hide()
                    $("#company").append("<option value=\"0\">全部</option>")
                    getHouseList();
                    $.post("house/getLeaderCompany",null,function (data) {
                        for(var i  in data){
                            $("#company").append("<option value="+data[i].corpId+">"+data[i].corpName+"</option>")
                        }
                    },"json")
                    $("#company").change(function(){
                        changChild($(this).val());
                    });
				}
            },"json")


	});
	function changChild(id){
           $("#community").empty();
           $("#community").append("<option value=\"0\">全部</option>")
           $.post("house/getChildCommunity",{id:id},function (data) {

               for(var i  in data){
                   $("#community").append("<option value="+data[i].communityId+">"+data[i].communityName+"</option>")
               }
           },"json")
           getHouseList();

        }
    function chooseCommunity() {
        $.post("house/getCommunity",null,function (data) {
            for(var i  in data){
                    $("#community").append("<option value="+data[i].communityId+">"+data[i].communityName+"</option>")
			}
        },"json")

    }
    $("#community").change(function(){
        getHouseList()
    });
    function getHouseList() {
        var community_id=$('#community').val();
        var corp_id=$('#company').val();
        $.post("house/getHouseList",{corp_id:corp_id,community_id:community_id},function (data) {
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
                        "data": "houseId",
                        "render": function (data, type, row, meta) {
                            return '<input type="checkbox"  class="checkchild"  value="' + data + '"  onclick="get(this)"/>';
                        },
                        "bSortable": false
                    },
                    {"data": "building"},
                    {"data": "unit"},
                    {"data": "floor"},
                    {"data": "roomNum"},
                    {"data": "houseNum"},
                    {"data": "houseTypeName"},
                    {"data": "area"},
                    {"sClass": "text-r",
                        "data": "previousEstateUnitPrice"
                    },
                    {"data": "ownerName"},
                    {"data": "ownerTel"},
                    {"data": "ownerStandbyTel"},
                    {"data": "familySize"},
                    {"data": "previousEstateFee"}
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

    }
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
                    $("#writeCommunity").append("<option value="+data[i].communityId+">"+data[i].communityName+"</option>")
                }
            },"json")
        $("#houseType").empty()
        $.post("house/getRoomType",null,function (data) {
            for(var i in data){
                $("#houseType").append("<option value="+data[i].houseTypeId+">"+data[i].houseTypeName+"</option>")

            }
        },"json")
        $("#modal-add").on("hide.bs.modal", function() {
            location.reload()
        })
    }
    function ADD() {
		var data={}
		data.community_id=$('#writeCommunity').val();
		data.building=$('#building').val();
		data.unit=$('#unit').val();
		data.floor=$('#floor').val();
		data.room_num=$('#room_num').val();
		data.house_type_id=$('#houseType').val();
        data.area=$('#area').val();
        data.previous_estate_unit_price=$('#prize').val();
        data.owner_name=$('#owner_name').val();
        data.owner_tel=$('#owner_tel').val();
        data.owner_standby_tel=$('#owner_standby_tel').val();
        data.family_size=$('#family_size').val();
        data.previous_estate_fee=$('#sum').val();
        $.post("house/subHouseInfo",data,function (data) {
            location.reload()
        })

    }
    function edit(){
        if(select_row_id==null){
			alert("请选择要编辑的数据行");
            return false;
		}
        $("#modal-edit").modal("show");
        $('#chooseid').val(select_row_id);
        $.post("house/editHouseInfo",{id:select_row_id},function (data) {
            console.log(data);
            $('#editCompany').val(data.corpName)
           $('#editCommunity').val(data.communityId);
            $('#editBuilding').val(data.building);
            $('#editUnit').val(data.unit);
            $('#editFloor').val(data.floor);
            $('#editRoom').val(data.roomNum);
            $('#editHouseType').val(data.houseTypeId);
            $('#areaEdit').val(data.area);
            $('#prizeEdit').val(data.previousEstateUnitPrice);
            $('#editName').val(data.ownerName);
            $('#editTel').val(data.ownerTel);
            $('#editTelCopy').val(data.ownerStandbyTel);
            $('#editNum').val(data.familySize);
            $('#sumEdit').val(data.previousEstateFee);
        })
        $.post("house/getCommunity",null,function (data) {
            for(var i  in data){
                $("#editCommunity").append("<option value="+data[i].communityId+">"+data[i].communityName+"</option>")
            }
        },"json")

        $.post("house/getRoomType",null,function (data) {
            for(var i in data){
                $("#editHouseType").append("<option value="+data[i].houseTypeId+">"+data[i].houseTypeName+"</option>")

            }
        },"json")
        $("#modal-edit").on("hide.bs.modal", function() {
            $("#editCommunity").empty();
            $("#editHouseType").empty()
            location.reload()
        })
    }
    function EDIT() {
        var data={}
        data.community_id=$('#editCommunity').val();
        data.building=$('#editBuilding').val();
        data.unit=$('#editUnit').val();
        data.floor=$('#editFloor').val();
        data.room_num=$('#editRoom').val();
        data.house_type_id=$('#editHouseType').val();
        data.area=$('#areaEdit').val();
        data.previous_estate_unit_price=$('#prizeEdit').val();
        data.owner_name=$('#editName').val();
        data.owner_tel=$('#editTel').val();
        data.owner_standby_tel=$('#editTelCopy').val();
        data.family_size=$('#editNum').val();
        data.previous_estate_fee=$('#sumEdit').val();
        data.id=$('#chooseid').val();
        $.post("house/subEditHouseInfo",data,function (data) {
            location.reload()
        })

    }

	function deleteMessage(){
        if(select_row_id==null){
            alert("请选择要删除的数据行");
            return false;
        }
            $("#deleteMessage").modal("show");
			$('#rowid').val(select_row_id);
            $("#deleteMessage").on("hide.bs.modal", function() {
                location.reload()
            })
        }
	function Delete(){
	    var id=$('#rowid').val();
        $.post("house/subDelHouseInfo",{id:id},function (data) {
            location.reload();
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