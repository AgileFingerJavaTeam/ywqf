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
		<span class="select-box" style="width: 10%;display: inline-block">
		  <select class="select" size="1" name="demo1" id="company">

		  </select>
		</span>
		小区：
		<span class="select-box" style="width: 10%;display: inline-block">
		  <select class="select" size="1" name="demo1" id="community" >
		  	<option value="0"selected>全部</option>
		  </select>
		</span>
	</div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort" id="datable" style="width: 100%">
			<thead>
			<tr class="text-c">
				<th ><input type="checkbox" ></th>
				<th >车位编号</th>
				<th >车牌号</th>
				<th >车位位</th>
				<th >车位费</th>
				<th >车主姓名</th>
				<th >车主房号</th>
				<th >车主电话</th>
				<th id="goods">备用电话</th>
			</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
</div>
<div id="modal-add" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content radius" style=" overflow:scroll;height:600px;width: 500px">
			<form action="house/subHouseInfo" method="post" class="form form-horizontal" >
				<div class="modal-header">
					<h4	 style="text-align: center">新增车位配置</h4>
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
					<label class="form-label col-xs-4 col-sm-5">车位编号：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text" id="parking_num" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();" placeholder="请输入车位编号">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">车牌号：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text" id="license_plate_number"placeholder="请输入车牌号">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">车位位置描述：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text" id="location_description"  placeholder="请输入车位位置描述">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">车位单价：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text " id="previous_parking_unit_price" placeholder="请输入车位单价">
					</div>
				</div>

				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">车主门牌号：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input  class="input-text" id="house_num" placeholder="请输入车主门牌号"></input>
						<input type="hidden" id="house_id">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">车主姓名：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text "  id="car_owner_name" placeholder="请输入车主姓名">

					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">称谓：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<select  class="input-text " id="gender" placeholder="请输入称谓">
							<option value="1">先生</option>
							<option value="0">女士</option>
						</select>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">车主电话：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text " id="car_owner_tel" placeholder="请输入车主电话">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">车主备用电话：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text " id="car_owner_standby_tel"  placeholder="请输入车主备用电话">
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
			<form action="house/subHouseInfo" method="post" class="form form-horizontal">
				<div class="modal-header">
					<h4	 style="text-align: center">修改车位配置</h4>
					<a class="close" data-dismiss="modal" aria-hidden="true" >×</a>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">物业：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text"class="input-text " id="writeCompanyEdit"readonly >
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">小区：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<select class="input-text" size="1"id="writeCommunityEdit" ></select>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">车位编号：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="hidden" id="chooseid">
						<input type="text" class="input-text" id="parking_num_edit" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();" placeholder="请输入车位编号">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">车牌号：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text" id="license_plate_number_edit"placeholder="请输入车牌号">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">车位位置描述：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text" id="location_description_edit"  placeholder="请输入车位位置描述">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">车位单价：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text " id="previous_parking_unit_price_edit" placeholder="请输入车位单价">
					</div>
				</div>

				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">车主门牌号：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input  class="input-text" id="house_num_edit" placeholder="请输入车主门牌号"></input>
						<input type="hidden" id="house_id_edit">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">车主姓名：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text "  id="car_owner_name_edit" placeholder="请输入车主姓名">

					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">称谓：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<select  class="input-text " id="gender_edit" placeholder="请输入称谓">
							<option value="1">先生</option>
							<option value="0">女士</option>
						</select>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">车主电话：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text " id="car_owner_tel_edit" placeholder="请输入车主电话">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">车主备用电话：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text " id="car_owner_standby_tel_edit"  placeholder="请输入车主备用电话">
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
<script type="text/javascript">
	var select_row_id;
	var area=0;
	var prize=0;
	$(function(){
            $.post("house/getCompany",null,function (data) {
                if (data.type==0){
                    $("#company").append("<option value="+data.corpId+">"+data.corpName+"</option>")
					chooseCommunity();
                    getParkingList();
				}else{
					$('.abtn').hide()
                    $("#company").append("<option value=\"0\">全部</option>")
                    getParkingList();
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
        getParkingList();

        }
    function chooseCommunity() {
        $.post("house/getCommunity",null,function (data) {
            for(var i  in data){
                    $("#community").append("<option value="+data[i].communityId+">"+data[i].communityName+"</option>")
			}
        },"json")

    }
    $("#community").change(function(){
        getParkingList()
    });
    function getParkingList() {
        var community_id=$('#community').val();

        var corp_id=$('#company').val();

        $.post("parkingConfig/getParkingList",{corp_id:corp_id,community_id:community_id},function (data) {
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
                        "data": "parkingSpaceId",
                        "render": function (data, type, row, meta) {
                            return '<input type="checkbox"  class="checkchild"  value="' + data + '"  onclick="get(this)"/>';
                        },
                        "bSortable": false
                    },
                    {"data": "parkingNum"},
                    {"data": "licensePlateNumber"},
                    {"data": "locationDescription"},
                    {"data": "previousParkingUnitPrice"},
                    {"data": "carOwnerName"},
                    {"data": "houseNum"},
                    {"data": "carOwnerTel"},
                    {"data": "carOwnerStandbyTel"}
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
        $('#house_num').bind('input propertychange', function() {
          	var house_num=$('#house_num').val();
          	var community_id=$('#writeCommunity').val();
          	if(house_num!=null && house_num!=''){
          	    $.post("parkingConfig/getHouseNum",{house_num:house_num,community_id:community_id},function (result) {
					if(result!=null){
                        $('#car_owner_name').val(result.ownerName);
                        $('#car_owner_tel').val(result.ownerTel);
                        $('#car_owner_standby_tel').val(result.ownerStandbyTel);
						$('#house_id').val(result.houseId);
					}
                },"json")
			}
        });



        $("#modal-add").on("hide.bs.modal", function() {
            location.reload()
        })
    }
    function ADD() {
		var json={}
		json.community_id=$('#writeCommunity').val();
		json.parking_num=$('#parking_num').val();
		json.license_plate_number=$('#license_plate_number').val();
		json.location_description=$('#location_description').val();
		json.previous_parking_unit_price=$('#previous_parking_unit_price').val();
		json.house_id=$('#house_id').val();
        json.car_owner_name=$('#car_owner_name').val();
        json.gender=$('#gender').val();
        json.car_owner_tel=$('#car_owner_tel').val();
        json.car_owner_standby_tel=$('#car_owner_standby_tel').val();
        $.post("parkingConfig/subAddParking",json,function (data) {
            location.reload()
        },"json")

    }


    function edit(){
        if(select_row_id==null){
            alert("请选择要编辑的数据行");
            return false;
        }
        $.post("parkingConfig/getParkingById",{row_id:select_row_id},function (data) {

            $('#writeCommunityEdit').val(data.communityId);
            $('#parking_num_edit').val(data.parkingNum);
            $('#license_plate_number_edit').val(data.licensePlateNumber);
            $('#location_description_edit').val(data.locationDescription);
            $('#previous_parking_unit_price_edit').val(data.previousParkingUnitPrice);
            $('#house_num_edit').val(data.houseNum);
            $('#car_owner_name_edit').val(data.carOwnerName);
            $('#gender_edit').val(data.gender);
            $('#car_owner_tel_edit').val(data.carOwnerTel);
            $('#car_owner_standby_tel_edit').val(data.carOwnerStandbyTel);
            $('#chooseid').val(data.parkingSpaceId);
            $('#house_id_edit').val(data.houseId);
        })
        $.post("house/getCompany",null,function (data) {
            $('#writeCompanyEdit').val(data.corpName)
        })
        $("#modal-edit").modal("show")
        $.post("house/getCommunity",null,function (data) {
            for(var i  in data){
                $("#writeCommunityEdit").append("<option value="+data[i].communityId+">"+data[i].communityName+"</option>")
            }
        },"json")



        $('#house_num_edit').bind('input propertychange', function() {
            var house_num=$('#house_num_edit').val();
            var community_id=$('#writeCommunityEdit').val();
            if(house_num!=null && house_num!=''){
                $.post("parkingConfig/getHouseNum",{house_num:house_num,community_id:community_id},function (result) {
                    if(result!=null){
                        $('#car_owner_name_edit').val(result.ownerName);
                        $('#car_owner_tel_edit').val(result.ownerTel);
                        $('#car_owner_standby_tel_edit').val(result.ownerStandbyTel);
                        $('#house_id_edit').val(result.houseId);
                    }
                },"json")
            }
        });

        $("#modal-edit").on("hide.bs.modal", function() {
            $("#writeCommunity").empty();
            location.reload()
        })
    }

    function EDIT() {
        var data={}
        data.community_id=$('#writeCommunityEdit').val();
        data.parking_num=$('#parking_num_edit').val();
        data.license_plate_number=$('#license_plate_number_edit').val();
        data.location_description=$('#location_description_edit').val();
        data.previous_parking_unit_price=$('#previous_parking_unit_price_edit').val();
        data.house_id=$('#house_id_edit').val();
        data.car_owner_name=$('#car_owner_name_edit').val();
        data.gender=$('#gender_edit').val();
        data.car_owner_tel=$('#car_owner_tel_edit').val();
        data.car_owner_standby_tel=$('#car_owner_standby_tel_edit').val();
        data.row_id=$('#chooseid').val();
        console.log(data);
        $.post("parkingConfig/subEditParking",data,function (data) {
            location.reload();
        },"json")

    }
	function deleteMessage(){
        if(select_row_id==null){
            alert("请选择要编辑的数据行");
            return false;
        };
            $("#deleteMessage").modal("show");
			$('#rowid').val(select_row_id);
            $("#deleteMessage").on("hide.bs.modal", function() {
                location.reload()
            })
        }
	function Delete(){
        $.post("parkingConfig/subDeleteParking",{row_id:$('#rowid').val()},function (data) {
            location.reload()
        },"json")
	}
</script>
</body>
</html>