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
<nav class="breadcrumb">采暖费<span class="c-gray en">&gt;</span>缴费<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="PropertyFeePayment/showProperty" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<hr>
<div class="cl pd-5  mt-20">
<div  style="width:850px; display: inline-block;">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" placeholder="请输入关键词" class="input-text ac_input c" name="search_text" value="" id="at_search"  style="width:250px;"><button type="submit" class="btn btn-default" id="search_button">搜索</button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <span class="select-box " style="width: 200px;">
              <select class="select" size="1" name="demo1">
                <option value="" selected>全部物业公司</option>
                <option value="1">菜单一</option>
                <option value="2">菜单二</option>
                <option value="3">菜单三</option>
              </select>
        </span>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <span class="select-box" style="width: 200px;">
              <select class="select" size="1" name="demo1">
                <option value="" selected>全部小区</option>
                <option value="1">菜单一</option>
                <option value="2">菜单二</option>
                <option value="3">菜单三</option>
              </select>
        </span>
</div>
    <div style=" width:550px; display: inline-block;">
            <span class="l">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a  onclick="modaldemoAdd()" style="text-decoration: none;margin-right: 50px; right:-10px; top:-20px; ">
				新增<i class="Hui-iconfont">&#xe600;</i>
			</a>
            <a  onclick="modaldemoAdd()" style="text-decoration: none;margin-right: 30px;  right:-10px; top:-20px;">
				编辑<i class="Hui-iconfont">&#xe600;</i>
			</a>
                <input type="text" value= "${Rid}" id="Rid" style="display: none;">
                <input type="text" value= "${Rname}" id="Rname" style="display: none;">
                <input type="text" value= "${corp_id}" id="corpId" style="display: none;">
            </span>
    正常
    <div class="switch" id="mySwitch" data-on="warning" data-off="danger" style=" right:-10px; top:10px;">
        <input type="checkbox"  value="1" checked />
    </div>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    作废
    <div class="switch" id="mySwitchs" data-on="warning" data-off="danger" style="right:-5px; top:10px;">
        <input type="checkbox"  value="0" checked />
    </div>
    </div>
</div>
<div class="page-container">
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort">
            <thead>
            <tr class="text-c">
                <th style="display: none;">id</th>
                <th width="50" class="text-center">工号</th>
                <th width="70">姓名</th>
                <th width="80">头像</th>
                <th width="80">绑定手机</th>
                <th width="80">角色</th>
                <th width="70">状态</th>
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
        <div class="modal-content radius" style="overflow:scroll;  height:400px;width: 500px">
            <form action="StaffManagement/insertStaff" method="post" class="form form-horizontal" id="demoform-1"  method="post" enctype="multipart/form-data">
                <div class="modal-header">
                    <h4	 style="text-align: center">新增员工</h4>
                    <a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
                </div>
                <div class="row cl" style="display: none;">
                    <label class="form-label col-xs-4 col-sm-5">物业ID</label>
                    <div class="formControls col-xs-4 col-sm-5	">
                        <input type="text" class="input-text" name="corp_id" id="at_corp_id"  placeholder="请输入姓名"; required:true;>
                    </div>
                </div>
                <div class="row cl" style="display: none;">
                    <label class="form-label col-xs-4 col-sm-5">操作人名称</label>
                    <div class="formControls col-xs-4 col-sm-5	">
                        <input type="text" class="input-text" name="operator" id="Rnames"  placeholder="请输入姓名"; required:true;>
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-5">姓名</label>
                    <div class="formControls col-xs-4 col-sm-5	">
                        <input type="text" class="input-text" name="name" id="names"  placeholder="请输入姓名"; required:true;>
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-5">电话</label>
                    <div class="formControls col-xs-4 col-sm-5	">
                        <input type="text" class="input-text" id="telephone"  name="telephone" placeholder="请输入电话"; required:true; >
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-5">头像</label>&nbsp;&nbsp;
                        <span class="btn-upload">
                          <a href="javascript:void();" class="btn btn-primary radius"><i class="Hui-iconfont Hui-iconfont-upload"></i> 浏览文件</a>
                          <input type="file" multiple name="avater" class="input-file" id="avater">
                        </span>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-5">角色</label>
                    <div class="formControls col-xs-4 col-sm-5	">
                        <select class="select" size="1" name="role_name" id="role_name" style="height: 31px;">
                            <option value="1">物业公司管理人员</option>
                            <option value="2">小区项目管理人员</option>
                        </select>
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-5">状态</label>
                    <div class="formControls col-xs-4 col-sm-5	">
                        <select class="select" size="1" name="status" id="status" style="height: 31px;">
                            <option value="1" selected>启用</option>
                            <option value="0">停用</option>
                        </select>

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
<script type="text/javascript" src="../scripts/jquery.form.min.js"></script>
<script type="text/javascript" src="../hui/lib/bootstrap-modal/2.2.4/bootstrap-modal.js"></script>
<script type="text/javascript" src="../hui/lib/bootstrap-modal/2.2.4/bootstrap-modalmanager.js"></script>
<script type="text/javascript" src="../hui/lib/bootstrap-Switch/bootstrapSwitch.js"></script>

<%-- 自定义js --%>
<script type="text/javascript">
    //初始查询
    $(function(){
        $.ajax({
            url: "StaffManagement/getStaffList",
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
                {'data': 'userId',},
                {'data': 'name',},
                {'data': function(value){
                    var avater = value.avater
                    var html='<div style="padding:10px">';
                    if (avater!='' || avater!=null){
                        html+='<img src="'+avater+'" style="width:60px; height:50px">';
                    } else {
                        html+='<img src="TP/default_category.png" style="width:60px; height:50px">';
                    }
                    html+='</div>';
                   return html;
                }
                },
                {"data": 'telephone',},
                {'data': function (value) {
                    var type = value.type;
                    if(type == 1){
                        return '物业公司管理人员';
                    }else{
                        return '小区项目管理人员';
                    }

                } },
                {'data':  function (value) {
                    var a = value.status;
                    if (a == 1) {
                        return '启用';
                    } else {
                        var html ="<span style='color: red;'>停用</span>";
                        return html;
                    }
                },},

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
        $('#id').val(id);
        var a = $('#corpId').val();
        $('#at_corp_id').val(a);
        var Rname = $('#Rname').val();
        $('#Rnames').val(Rname);
        $('#modal-demo-add').modal("show") //显示模态框



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
        document.getElementById("demoform-1").submit();
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
        id.id=d;
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