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
<link rel="stylesheet" href="hui/lib/My97DatePicker/skin/WdatePicker.css">
<link rel="stylesheet" href="hui/lib/Hui-iconfont/1.0.7/iconfont.css">



</head>
<body>
<nav class="breadcrumb">采暖费<span class="c-gray en">&gt;</span>优惠设置<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="PropertyFeePayment/showProperty" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>

<div class="cl pd-5  mt-20">
    <span class="l">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a onclick="modaldemoAdd()" style="text-decoration: none;margin-right: 50px ">
				新增&nbsp;&nbsp;<i class="Hui-iconfont Hui-iconfont-add2"></i>
			</a>
    </span>
</div>
<hr>
<!-- dataTable 页面 -->
<div class="page-container">
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort">
            <thead>
            <tr class="text-c">
                <th width="50" class="text-center">优惠政策编码</th>
                <th width="80">优惠起始日期</th>
                <th width="70">优惠结束日期</th>
                <th width="80">优惠比例(%)</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<!-- 新增模态框  start-->
<div id="modal-demo-add" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content radius" style="overflow:scroll; height:320px;width: 500px">
            <form action="" method="post" class="form form-horizontal" id="demoform-1">
                <div class="modal-header">
                    <h4	 style="text-align: center">创建优惠</h4>
                    <%--<a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>--%>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-5">优惠起止日期</label>
                    <div class="formControls col-xs-4 col-sm-5	">
                        <input type="text" class="input-text" id="discountStartDate"   name="discountStartDate" autocomplete="off" placeholder="请输入优惠起始日期" required:true;>
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-5">优惠截止日期</label>
                    <div class="formControls col-xs-4 col-sm-5	">
                        <input type="text" class="input-text" id="discountEndDate"   name="discountEndDate" autocomplete="off" placeholder="请输入优惠结束日期" required:true;>
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-5">优惠比例</label>
                    <div class="formControls col-xs-4 col-sm-5	">
                        <input type="text" class="input-text" id="rate"   name="rate" autocomplete="off" placeholder="请输入优惠比例(%)" required:true;>
                    </div>
                </div>
            </form>
            <br>
            <div class="modal-footer" style="text-align: center">
                <button class="btn btn-primary" id="insert">确定</button>
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
    //初始查询
    $(function(){
            $.ajax({
                url: "heatingPrefeTreat/getHeatingPrefeTreat",
                type: "POST",
                dataType: "json",
                success: function (data) {
                     showDataTable(data);
                },
            });
    });
    //dataTable
    function showDataTable(data) {
        $('.table-sort').dataTable({
            dom:"rtip",
            "data": data,
            destroy:true,
            "columns": [
                {'data': 'heatingDiscountTypeId',},
                {'data': 'discountStartDate',},
                {'data': 'discountEndDate',},
                {"data": 'rate',},
            ],
        });
    }
   //新增模态框
    function modaldemoAdd() {
        $('#modal-demo-add').modal('show');
        //关闭刷新页面 start
        $("#modal-demo-add").on("hide.bs.modal", function() {
            location.reload()
        })
        //关闭刷新页面 end
    }
    $('#insert').on('click',function(){
        var discount_start_date = $('#discountStartDate').val();
        var discount_end_date = $('#discountEndDate').val();
        var rate = $('#rate').val();
        var data = {};
        data.discount_start_date = discount_start_date;
        data.discount_end_date = discount_end_date;
        data.rate = rate;

        if(discount_start_date == '' && discount_end_date == '' && rate == ''){
            layer.alert('优惠起止日期结束日期和比例不能为空！')
        }else if(discount_start_date == '' ){
            layer.alert('优惠起止日期不能为空！')
        }else if(discount_end_date == ''){
            layer.alert('优惠结束日期不能为空！')
        }else if(rate == ''){
            layer.alert('优惠比例不能为空！')
        }
       $.ajax({
           type:'post',
           url:'heatingPrefeTreat/addHeatingPrefeTreat',
           data:data,
           dataType:'json',
           success:function(){
               location.reload();
           }
       })
    })

</script>
</body>
</html>