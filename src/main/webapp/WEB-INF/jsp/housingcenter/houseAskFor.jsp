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
			<a  onclick="add()" style="text-decoration: none;margin-right: 50px " class="abtn">
				新增<i class="Hui-iconfont">&#xe600;</i>
			</a>
			<a  onclick="edit()" style="text-decoration: none;margin-right: 50px "class="abtn">
				编辑<i class="Hui-iconfont">&#xe6df;</i>
			</a>
			<a style="text-decoration: none;margin-right: 50px "  onclick="deleteMessage()" class="abtn">
			 删除<i class="Hui-iconfont">&#xe6e2;</i>
			</a>
		</span>
	</div>
	<div class="cl pd-5   mt-20">

		<div class="l "style="width: 50%">
			物业公司：
			<span class="select-box" style="width: 40%;display: inline-block">
			  <select class="select" size="1" name="demo1" id="company">

			  </select>
			</span>
			小区：
			<span class="select-box" style="width:40%;display: inline-block">
			  <select class="select" size="1" name="demo1" id="community" >
				<option value="0"selected>全部</option>
			  </select>
			</span>
		</div>
		<div class="r"style="width: 50%;">
			<button type="button" class="btn btn-success r" id="" name=""s onclick="picture_colume_add(this);"><i class="Hui-iconfont"></i> 导出</button>

			<div class=" r " style="margin-right: 40px">求租</div>
			<div class="switch r" id="HouseSeek" data-on="primary" data-off="danger"  style="margin-right: 40px">
				<input type="checkbox"  value="1" checked />
			</div>

			<div class=" r " style="margin-right: 40px">求购</div>
			<div class="switch r" id="HouseBuy" data-on="primary" data-off="danger"  style="margin-right: 40px">
				<input type="checkbox"  value="1" checked />
			</div>

		</div>

	</div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort" id="datable" style="width: 100%">
			<thead>
			<tr class="text-c">
				<th ><input type="checkbox" ></th>
				<th >单据编号</th>
				<th >发布时间</th>
				<th >需求类型</th>
				<th >户型</th>
				<th >朝向</th>
				<th >楼层</th>
				<th >面积</th>
				<th >装修情况</th>
				<th >租价范围</th>
				<th >房价范围</th>
				<th >详细需求</th>
				<th >联系人姓名</th>
				<th >联系人电话</th>
			</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
</div>
<div id="modal-add" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content radius" style=" overflow:scroll;height:600px;width: 500px">
			<form action="house/subEditHouseInfo" method="post" class="form form-horizontal"   id="addForm">

			<div class="modal-header">
					<h4	 style="text-align: center">新增</h4>
					<a class="close" data-dismiss="modal" aria-hidden="true" >×</a>
				</div>

				<input type="hidden" id="company_id" >
				<input type="hidden" id="community_id" >
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">单据编号：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text" id="neednum" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();" placeholder="请输入单据编号">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">需求类型：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<select id="askType" class="input-text ">
							<option value="1">求租</option>
							<option value="2">求购</option>
							<option value="3">既租也购</option>
						</select>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">户型：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<select id="house_type" class="input-text "></select>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">朝向：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<select id="direction" class="input-text "></select>
					</div>
				</div>

				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">面积：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<select id="area" class="input-text "></select>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">装修情况：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<select  class="input-text " id="fitment"></select>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">租价范围：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<select  class="input-text " id="rent"></select>
						<select  class="input-text " id="sale" hidden></select>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">详细需求：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text " id="note"  placeholder="请输入详细需求">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">联系人姓名：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text "id="owner_name" autocomplete="off" placeholder="请输入姓名">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">联系人电话：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text "id="owner_tel" autocomplete="off" placeholder="请输入电话">
					</div>
				</div>
			</form>
			<div class="modal-footer" style="text-align: center">
				<button class="btn btn-primary"onclick="submitData()">保存</button>
				<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
			</div>
		</div>
	</div>
</div>
<div id="modal-edit" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content radius" style=" overflow:scroll;height:600px;width: 500px">
			<form action="house/subEditHouseInfo" method="post" class="form form-horizontal"   id="editForm">

			<div class="modal-header">
					<h4	 style="text-align: center">编辑</h4>
					<a class="close" data-dismiss="modal" aria-hidden="true" >×</a>
				</div>

				<input type="hidden" id="rowsid" >
				<input type="hidden" id="community_id_edit" >
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">单据编号：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text" id="neednum_edit" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();" placeholder="请输入单据编号">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">需求类型：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<select id="askType_edit" class="input-text ">
							<option value="1">求租</option>
							<option value="2">求购</option>
						</select>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">户型：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<select id="house_type_edit" class="input-text "></select>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">朝向：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<select id="direction_edit" class="input-text "></select>
					</div>
				</div>

				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">面积：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<select id="area_edit" class="input-text "></select>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">装修情况：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<select  class="input-text " id="fitment_edit"></select>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">租价范围：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<select  class="input-text " id="rent_edit"></select>
						<select  class="input-text " id="sale_edit" hidden></select>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">详细需求：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text " id="note_edit"  placeholder="请输入详细需求">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">联系人姓名：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text "id="owner_name_edit" autocomplete="off" placeholder="请输入姓名">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">联系人电话：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text "id="owner_tel_edit" autocomplete="off" placeholder="请输入电话">
					</div>
				</div>
			</form>
			<div class="modal-footer" style="text-align: center">
				<button class="btn btn-primary"onclick="submitDataEdit()">保存</button>
				<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
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
				<input type="hidden" name="id" id="rowid">
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
<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.4.2/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript" src="//cdn.datatables.net/buttons/1.4.2/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="hui/lib/bootstrap-modal/2.2.4/bootstrap-modal.js"></script>
<script type="text/javascript" src="hui/lib/bootstrap-modal/2.2.4/bootstrap-modalmanager.js"></script>
<script type="text/javascript" src="hui/lib/bootstrap-Switch/bootstrapSwitch.js"></script>
<script type="text/javascript">
    var select_row_id;
    var community_id;
    var corp_id;
    var json;
    $(function(){
        $.post("house/getCompany",null,function (data) {
            if (data.type==0){
                $("#company").append("<option value="+data.corpId+">"+data.corpName+"</option>")
                chooseCommunity();
               getHouseList();
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
         community_id=$('#community').val();
         corp_id=$('#company').val();
         var type;
        var a = $('#HouseSeek').bootstrapSwitch('status');
        var b = $('#HouseBuy').bootstrapSwitch('status');
        if(a==true && b==true){
            type=3;
        }else if (a==true && b==false){
            type=1
        }else if (a==false && b==true){
            type=2
        }else {
           type=0
        }

        $.post("HouseCenter/getHouseAskList",{corp_id:corp_id,community_id:community_id,type:type},function (data) {
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
                    {"data": "houseAreaTypeName"},
                    {"data": "houseFitmentTypeName"},
                    {"data": "rent"},
                    {"data": "buy"},
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

    }
    function get(obj) {
        select_row_id=$(obj).val()
    }
    function add(){
        corp_id=$('#company').val();
        community_id=$('#community').val();
        $("#modal-add").modal("show");
		$('#company_id').val(corp_id);
        $('#community_id').val(community_id);
        checkData();
        $("#modal-add").on("hide.bs.modal", function() {
            location.reload()
        })
    }
    function submitData() {
        community_id=$('#community').val();
        corp_id=$('#company').val();
        var data={}
        data.corp_id=community_id;
		data.community_id=corp_id;
        data.house_need_rent_num=$('#neednum').val();
        data.type=$('#askType').val();
        data.house_type_id=$('#house_type').val();
        data.house_direction_type_id=$('#direction').val();
        data.house_area_type_id=$('#area').val();
        data.house_fitment_type_id=$('#fitment').val();
        data.rent_house_price_range_id=$('#rent').val();
        data.buy_house_price_range_id=$('#sale').val();
        data.remark=$('#note').val();
        data.customer_name=$('#owner_name').val();
        data.phone=$('#owner_tel').val();
        console.log(data)
        $.post("HouseCenter/subAdd",data,function (data) {
            location.reload()
        })

    }
    function checkData() {
        $.post("HouseCenter/findHouseType",null,function (data) {
            for(var i  in data){
                $("#house_type").append("<option value="+data[i].houseTypeId+">"+data[i].houseTypeName+"</option>")
            }
        },"json");
        $.post("HouseCenter/findDirection",null,function (data) {
            for(var i  in data){
                $("#direction").append("<option value="+data[i].houseDirectionTypeId+">"+data[i].houseDirectionTypeName+"</option>")
            }
        },"json");
        $.post("HouseCenter/findArea",null,function (data) {
            for(var i  in data){
                $("#area").append("<option value="+data[i].id+">"+data[i].houseAreaTypeName+"</option>")
            }
        },"json");
        $.post("HouseCenter/findFitment",null,function (data) {
            for(var i  in data){
                $("#fitment").append("<option value="+data[i].houseFitmentTypeId+">"+data[i].houseFitmentTypeName+"</option>")
            }
        },"json");
        $.post("HouseCenter/findRentPrice",null,function (data) {
            for(var i  in data){
                $("#rent").append("<option value="+data[i].housePriceRangeId+">"+data[i].housePriceRangeName+"</option>")
            }
        },"json");
        $.post("HouseCenter/findBuyPrice",null,function (data) {
            for(var i  in data){
                $("#sale").append("<option value="+data[i].housePriceRangeId+">"+data[i].housePriceRangeName+"</option>")
            }
        },"json");
    }
    function edit(){
        $('#rowsid').val(select_row_id);
        $("#modal-edit").modal("show")
		$.post("HouseCenter/getAskById",{id:select_row_id},function (data) {
		    console.log(data);
			$('#company_id_edit').val(data.corpId);
            $('#community_id_edit').val(data.communityId);
            $('#neednum_edit').val(data.houseNeedRentNum);
            $('#askType_edit').val(data.type);
            $('#house_type_edit').val(data.houseTypeId);
            $('#direction_edit').val(data.houseDirectionTypeId);
            $('#area_edit').val(data.id);
            $('#fitment_edit').val(data.houseFitmentTypeId);
            $('#rent_edit').val(data.rentId);
            $('#sale_edit').val(data.buyId);
            $('#note_edit').val(data.remark);
            $('#owner_name_edit').val(data.customerName);
            $('#owner_tel_edit').val(data.phone);
        },"json")
        $.post("HouseCenter/findHouseType",null,function (data) {
            for(var i  in data){
                $("#house_type_edit").append("<option value="+data[i].houseTypeId+">"+data[i].houseTypeName+"</option>")
            }
        },"json");
        $.post("HouseCenter/findDirection",null,function (data) {
            for(var i  in data){
                $("#direction_edit").append("<option value="+data[i].houseDirectionTypeId+">"+data[i].houseDirectionTypeName+"</option>")
            }
        },"json");
        $.post("HouseCenter/findArea",null,function (data) {
            for(var i  in data){
                $("#area_edit").append("<option value="+data[i].id+">"+data[i].houseAreaTypeName+"</option>")
            }
        },"json");
        $.post("HouseCenter/findFitment",null,function (data) {
            for(var i  in data){
                $("#fitment_edit").append("<option value="+data[i].houseFitmentTypeId+">"+data[i].houseFitmentTypeName+"</option>")
            }
        },"json");
        $.post("HouseCenter/findRentPrice",null,function (data) {
            for(var i  in data){
                $("#rent_edit").append("<option value="+data[i].housePriceRangeId+">"+data[i].housePriceRangeName+"</option>")
            }
        },"json");
        $.post("HouseCenter/findBuyPrice",null,function (data) {
            for(var i  in data){
                $("#sale_edit").append("<option value="+data[i].housePriceRangeId+">"+data[i].housePriceRangeName+"</option>")
            }
        },"json");
        $("#modal-edit").on("hide.bs.modal", function() {
            location.reload()
        })
    }
    function submitDataEdit() {
        community_id=$('#community_id_edit').val();
        var data={}
        data.community_id=community_id;
        data.house_need_rent_num=$('#neednum_edit').val();
        data.type=$('#askType_edit').val();
        data.house_type_id=$('#house_type_edit').val();
        data.house_direction_type_id=$('#direction_edit').val();
        data.house_area_type_id=$('#area_edit').val();
        data.house_fitment_type_id=$('#fitment_edit').val();
        data.rent_house_price_range_id=$('#rent_edit').val();
        data.buy_house_price_range_id=$('#sale_edit').val();
        data.remark=$('#note_edit').val();
        data.customer_name=$('#owner_name_edit').val();
        data.phone=$('#owner_tel_edit').val();
        data.id=$('#rowsid').val();
        console.log(data)
        $.post("HouseCenter/subEdit",data,function (data) {
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
        $.post("HouseCenter/subDelHouseInfo",{id:$('#rowid').val()},function (data) {
            location.reload()
        })
    }
    $('#HouseSeek').on('switch-change', function () {
			getHouseList()
    });
    $('#HouseBuy').on('switch-change', function () {
        getHouseList()
    });

</script>
</body>
</html>