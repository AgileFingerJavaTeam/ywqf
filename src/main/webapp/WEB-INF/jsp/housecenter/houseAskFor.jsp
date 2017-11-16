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
			<a  _href="house/editHouseInfo" onclick="modaldemo()" style="text-decoration: none;margin-right: 50px "class="abtn">
				编辑<i class="Hui-iconfont">&#xe6df;</i>
			</a>
			<a style="text-decoration: none;margin-right: 50px " _href="house/deleteHouseInfo"  onclick="deleteMessage()" class="abtn">
			 删除<i class="Hui-iconfont">&#xe6e2;</i>
			</a>
		</span>
	</div>
	<div class="cl pd-5   mt-20">
		物业公司：
		<span class="select-box" style="width: 20%;display: inline-block">
		  <select class="select" size="1" name="demo1" id="company">
			  <option value="0"selected>全部</option>
		  </select>
		</span>
		小区：
		<span class="select-box" style="width: 20%;display: inline-block">
		  <select class="select" size="1" name="demo1" id="community" >
		  	<option value="0"selected>全部</option>
		  </select>
		</span>

		<button type="button" class="btn btn-success" id="" name=""style="float: right" onclick="picture_colume_add(this);"><i class="Hui-iconfont"></i> 导出</button>

		<span  style="width: 20%;float:right; display: inline-block">
		  <select class="select" size="1" name="demo1" id="community" >
		  	<option value="0"selected>全部</option>
		  </select>
		</span>
	</div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort" id="datable">
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
<%--<div id="modal-demo" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content radius" style=" overflow:scroll;height:600px;width: 500px">
			<form action="house/subHouseInfo" method="post" class="form form-horizontal" id="form1">
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

						  <select class="input-text add" size="1" name="demo1" id="writeCommunity" >

						  </select>

					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">楼号：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text add" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();" placeholder="请输入楼号">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">门号：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text add" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"  placeholder="请输入门号">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">层号：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text add" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();"  placeholder="请输入层号">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">房号：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text add" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();" placeholder="请输入房号">
					</div>
				</div>

				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">户型：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<select id="houseType" class="input-text add"></select>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">面积：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text add"id="area" onkeyup="(this.v=function(){this.value.replace(/^[+]{0,1}(\d+)$|^[+]{0,1}(\d+\.\d+)$/,'');}).call(this)" onblur="this.v();" placeholder="请输入面积">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">物业单价：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text add"id="prize" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();" placeholder="请输入物业单价">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">户主姓名：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text add" autocomplete="off" placeholder="请输入户主姓名">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">联系电话：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text add" autocomplete="off" placeholder="请输入联系电话">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">备用联系电话：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text add" autocomplete="off" placeholder="请输入备用联系电话">
					</div>
				</div>

				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">家庭成员数量：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text add" autocomplete="off" placeholder="请输入家庭成员数量">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-5">物业费合计：</label>
					<div class="formControls col-xs-4 col-sm-5	">
						<input type="text" class="input-text add"id="sum" autocomplete="off" readonly>
					</div>
				</div>
			</form>
			<div class="modal-footer" style="text-align: center">
				<button class="btn btn-primary">确定</button>
				<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
			</div>
		</div>
	</div>
</div>

<div id="deleteMessage" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content radius">
			<form action="house/subHouseInfo" method="post" class="form form-horizontal" id="demoform-1">
				<div class="modal-header">
					<h4	 style="text-align: center">删除信息</h4>
					<a class="close" data-dismiss="modal" aria-hidden="true">×</a>
				</div>
				<div class="row cl">

					<label class="form-label col-xs-4 col-sm-5">是否删除本条数据?</label>
				</div>
				<div class="modal-footer" style="text-align: center">
					<button class="btn btn-primary">确定</button>
					<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
				</div>
			</form>
		</div>
	</div>
</div>--%>
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
                    getHouseList();
				}else{
/*
                    $('.abtn').hide()
*/
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
				}
            },"json")


	});
	function changChild(id){
           $("#community").empty();
           $("#community").append("<option value=\"0\">全部</option>")
           $.post("house/getChildCommunity",{id:id},function (data) {

               for(var i  in data){
                   $("#community").append("<option value="+data[i].id+">"+data[i].communityName+"</option>")
               }
           },"json")
           getHouseList();

        }
    function chooseCommunity() {
        $.post("house/getCommunity",null,function (data) {
            for(var i  in data){
                    $("#community").append("<option value="+data[i].id+">"+data[i].communityName+"</option>")
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
                "bAutoWidth" : true, //是否自适应宽度
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
                    {"data": "building"},
                    {"data": "unit"},
                    {"data": "floor"},
                    {"data": "roomNum"},
                    {"data": "houseNum"},
                    {"data": "houseTypeName"},
                    {"data": "area"},
                    {"sClass": "text-r",
                        "data": "nowEstateUnitPrice"
                    },
                    {"data": "ownerName"},
                    {"data": "ownerTel"},
                    {"data": "ownerStandbyTel"},
                    {"data": "familySize"},
                    {"data": "nowEstateFee"}
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
        $("#modal-demo").modal("show")
            $.post("house/getCommunity",null,function (data) {
                for(var i  in data){
                    $("#writeCommunity").append("<option value="+data[i].id+">"+data[i].communityName+"</option>")
                }
            },"json")
        $("#houseType").empty()
        $.post("house/getRoomType",null,function (data) {
            for(var i in data){
                $("#houseType").append("<option value=i>"+data[i].houseTypeName+"</option>")

            }
        },"json")
        $("#modal-demo").on("hide.bs.modal", function() {
            location.reload()
        })
    }
	function deleteMessage(){

            $("#deleteMessage").modal("show")
            $.post("house/getRoomType",null,function (data) {
                for(var i in data){
                    $("#sel").append("<option value=i>"+data[i].houseTypeName+"</option>")

                }
            },"json")
            $("#deleteMessage").on("hide.bs.modal", function() {
                location.reload()
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