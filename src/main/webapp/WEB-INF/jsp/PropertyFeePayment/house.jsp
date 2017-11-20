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



</head>
<body>
<nav class="breadcrumb">物业费<span class="c-gray en">&gt;</span>缴费<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="PropertyFeePayment/showProperty" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>

<div class="cl pd-5  mt-20">
    <span class="l">
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a   onclick="modaldemoAdd()" style="text-decoration: none;margin-right: 50px ">
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
              <select class="select" size="1"  id="corp">
              </select>
        </span>
    &nbsp;&nbsp;&nbsp;&nbsp;缴费日期范围:&nbsp;&nbsp;&nbsp;<span style="color: #AAAAAA;">开始日期</span>&nbsp;
    &nbsp;&nbsp;
     <input id="at_pay_start" name="timeYear" type="text" runat="server"  class="Wdate" style=" width:200px; height: 30px;" onFocus="WdatePicker({lang:'zh-cn',maxDate:'#F{$dp.$D(\'at_pay_end\')||\'new Date()\'}'})"/>
    &nbsp;&nbsp;&nbsp;<span style="color: #AAAAAA;">结束日期</span>&nbsp;
    &nbsp;&nbsp;
     <input id="at_pay_end" name="timeYear" type="text" runat="server"   class="Wdate" style=" width:200px; height: 30px;" onclick="WdatePicker({minDate:'#F{$dp.$D(\'at_pay_start\')}',dateFmt:'yyyy-MM-dd',dchanging:cDayFuncd , Mchanging: cMonthFuncd , ychanging: cYearFuncd , dchanged:cDayFuncd , Mchanged: cMonthFuncd , ychanged: cYearFuncd})"/>
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
              <select class="select" size="1" id="comm">
              </select>
    </span>
    &nbsp;&nbsp;&nbsp;&nbsp;服务日期范围:&nbsp;&nbsp;&nbsp;<span style="color: #AAAAAA;">开始日期</span>&nbsp;
    &nbsp;&nbsp;
    <input id="at_service_start" name="timeYear" type="text" runat="server" class="Wdate" style=" width:200px; height: 30px;" onFocus="WdatePicker({lang:'zh-cn',maxDate:'#F{$dp.$D(\'at_service_end\')||\'new Date()\'}'})"/>
    &nbsp;&nbsp;
    <span style="color: #AAAAAA;">结束日期</span>&nbsp;
    &nbsp;&nbsp;
    <input id="at_service_end" name="timeYear" type="text" runat="server" class="Wdate" style=" width:200px; height: 30px;"  onclick="WdatePicker({minDate:'#F{$dp.$D(\'at_service_start\')}',dateFmt:'yyyy-MM-dd',dchanging:cDayFunc , Mchanging: cMonthFunc , ychanging: cYearFunc , dchanged:cDayFunc , Mchanged: cMonthFunc , ychanged: cYearFunc})"/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" placeholder="请输入关键词" class="input-text ac_input" name="search_text" value="" id="at_search" autocomplete="off" style="width:250px"><button type="submit" class="btn btn-default" id="search_button">搜索</button>
</div>
<!-- dataTable 页面 -->
<div class="page-container">
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort">
            <thead>
            <tr class="text-c">
                <th style="display: none;">id</th>
                <th width="50" class="text-center">单号</th>
                <th width="80">门牌号</th>
                <th width="70">业主</th>
                <th width="80">面积(M²)</th>
                <th width="90">单价(M²/月)</th>
                <th width="100">服务起始日</th>
                <th width="100">服务截止日</th>
                <th width="70">缴纳月数</th>
                <th width="70">缴纳额</th>
                <th width="70">收费员工</th>
                <th width="100">缴费日期</th>
                <th width="70">录入员工</th>
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
                <h3 class="modal-title">作废单据</h3>
                <a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void()">×</a>
            </div>
            <div class="modal-body">
                <span style="text-align: center;">是否作废此单据？</span>
                <span style="text-align: center; color: red;">(执行后无法撤回！)</span>
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
        <div class="modal-content radius" style="overflow:scroll; height:650px;width: 500px">
            <form action="" method="post" class="form form-horizontal" id="demoform-1">
                <div class="modal-header">
                    <h4	 style="text-align: center">创建缴费单</h4>
                    <a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-5">单号</label>
                    <div class="formControls col-xs-4 col-sm-5	">
                        <input type="text" class="input-text" name="estate_pay_num" id="estate_pay_num"  autocomplete="off" placeholder="请输入单号" required:true; >
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
                        <input type="text" class="input-text" id="house_num"  name="house_num" placeholder="请输入门牌号" required:true;>
                    </div>
                </div>
                <div class="row cl" style="display: none;">
                    <label class="form-label col-xs-4 col-sm-5">房间ID</label>
                    <div class="formControls col-xs-4 col-sm-5	">
                        <input type="text" class="input-text" id="house_id"   name="house_id"  placeholder="房间ID" required:true;>
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-5">业主</label>
                    <div class="formControls col-xs-4 col-sm-5	">
                        <input type="text" class="input-text" autocomplete="off" id="owner_name"  name="owner_name" readonly="readonly" style="border: none;">
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-5">面积</label>
                    <div class="formControls col-xs-4 col-sm-5	">
                        <input type="text" class="input-text" autocomplete="off"  id="area" name="area"  readonly="readonly" style="border: none;">
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
                    <label class="form-label col-xs-4 col-sm-5">单价</label>
                    <div class="formControls col-xs-4 col-sm-5	">
                        <input type="text" class="input-text" autocomplete="off" id="estate_unit_price"  name="estate_unit_price"  required>
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
                    <label class="form-label col-xs-4 col-sm-5">缴纳金额</label>
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
                        <input type="text" class="input-text" autocomplete="off" id="pay_date"  name="pay_date"  readonly  >
                    </div>
                </div>
                <input type="text" value= "" id="id" style="display: none;">
                <input type="text" value= "" id="name" style="display: none;">
                <input type="text" value= "" id="corp_id" style="display: none;">
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
    $(function(){
       var corpId = $('#corpId').val();
       var data = {};
       data.corp_id = corpId;
          $.ajax({
              url:"PropertyFeePayment/findType",
              type:'post',
              data: data ,
              dataType:'json',
              success:function(data) {
                  //物业下拉框定住 start
                  var type = data.type;
                  if (type == 0) {     //type 为物业类型  1为总部  0为物业公司
                      $("#corp").append("<option value=" + data.corpId + ">" + data.corpName + "</option>")
                      //物业下拉框定住 end
                      //查询操作人有权限的小区 遍历
                      var rid = $('#Rid').val();
                      var ppp = {};
                      ppp.rid = rid;
                      $.ajax({
                         type:'post',
                         url:'PropertyFeePayment/findRidComm',
                         data: ppp,
                         dataType:'json',
                         success:function(data){
                                jQuery('#comm').empty();
                                $("#comm").append("<option value=" + 0 + ">" + '全部小区' + "</option>")
                             for (var i in data) {
                                 var a = data[i].communityId;
                                 $("#comm").append("<option value=" + a + ">" + data[i].communityName + "</option>")
                             }
                         }
                      })
                      var estateSearchId = $('#corp').val();
                      var a = $('#mySwitch').bootstrapSwitch('status');
                      var b = $('#mySwitchs').bootstrapSwitch('status');
                      var at_search = $('#at_search').val();
                      var data = {};
                      data.at_search = at_search;
                      data.estateSearchId = estateSearchId;
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
                  }else if (type == 1){
                      //遍历除总部 所有物业公司
                      $.ajax({
                          type:'post',
                          url:'PropertyFeePayment/findEstate',
                          dataType:'json',
                          success:function(data){
                              jQuery("#corp").empty();
                              $("#corp").append("<option value="+ 0 +">" + '全部物业公司' + "</option>")
                              $("#comm").append("<option value="+ 0 +">" + '全部小区' + "</option>")
                              for(var i in data){
                              $("#corp").append("<option value="+ data[i].corpId +">" + data[i].corpName + "</option>")
                              }
                              $('#corp ').change(function(){
                                  corpVal(); //通过物业改变  查物业下小区
                                  //总部物业公司查询
                                  var estateSearchId = $('#corp').val();
                                  var a = $('#mySwitch').bootstrapSwitch('status');
                                  var b = $('#mySwitchs').bootstrapSwitch('status');
                                  var at_search = $('#at_search').val();
                                  var data = {};
                                  data.at_search = at_search;
                                  data.estateSearchId = estateSearchId;
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

                          }
                      })
                  }
                  function corpVal() {
                      var corpVal = $('#corp').val();
                      var data = {};
                      data.corp_id = corpVal;
                      $.ajax({
                          type: 'post',
                          url: 'PropertyFeePayment/findVillage',
                          data: data,
                          dataType: 'json',
                          success: function (data) {
                              jQuery('#comm').empty();
                                  $("#comm").append("<option value=" + 0 + ">" + '全部小区' + "</option>")
                              for (var i in data) {
                                  var a = data[i].communityId;
                                  $("#comm").append("<option value=" + a + ">" + data[i].communityName + "</option>")
                              }
                          }
                      })
                  }
              }
          })

    })
    //小区change事件
    $('#comm').on('change',function(){
        var comm = $('#comm').val();
        var estateSearchId = $('#corp').val();
        var a = $('#mySwitch').bootstrapSwitch('status');
        var b = $('#mySwitchs').bootstrapSwitch('status');
        var at_search = $('#at_search').val();
        var data = {};
        data.at_search = at_search;
        data.estateSearchId = estateSearchId;
        data.comm = comm;
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
    //初始查询
    $(function(){
            $.ajax({
                url: "PropertyFeePayment/getPropertyList",
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
               {'data': 'estatePayNum',},
               {'data': 'houseNum',},
               {'data': 'ownerName',},
               {"data": 'area',},
               {'data': 'estateUnitPrice',},
               {'data': function (value) {
                       var a_time = value.serviceStartDate;
                       var date = new Date(a_time);
                       var year = date.getFullYear().toString();
                       var month = (date.getMonth() + 1);
                       var day = date.getDate().toString();
                       if (month < 10) { month = "0" + month; }
                       if (day < 10) { day = "0" + day; }
                       return year + "-" + month + "-" + day; },
               },
               {"data": function (value) {
                       var a_time = value.serviceEndDate;
                       var date = new Date(a_time);
                       var year = date.getFullYear().toString();
                       var month = (date.getMonth() + 1);
                       var day = date.getDate().toString();
                       if (month < 10) { month = "0" + month; }
                       if (day < 10) { day = "0" + day; }
                       return year + "-" + month + "-" + day; },
               },
               {'data': function (value) {
                       var a = value.payMonth;
                       return a + '个月'
                   },
               },
               {'data': 'paymentAmount',},
               {"data": 'name',},
               {'data': function (value) {
                       var a_time = value.payDate;
                       var date = new Date(a_time);
                       var date = new Date(a_time);
                       var year = date.getFullYear().toString();
                       var month = (date.getMonth() + 1);
                       var day = date.getDate().toString();
                       if (month < 10) { month = "0" + month; }
                       if (day < 10) { day = "0" + day; }
                       return year + "-" + month + "-" + day; },
               },
               {'data': 'operator',},
               {"data": function (value) {
                       var a_time = value.operateTime;
                       var date = new Date(a_time);
                       var year = date.getFullYear().toString();
                       var month = (date.getMonth() + 1);
                       var day = date.getDate().toString();
                       if (month < 10) { month = "0" + month; }
                       if (day < 10) { day = "0" + day; }
                       return year + "-" + month + "-" + day; },
               },
               {"data": function (value) {
                       var a = value.status;
                       var b = value.estatePayId;
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
               {"data": function () {
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
    function put(oper){
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
    //正常状态筛选
    $('#mySwitch').on('switch-change', function (e, data) {
       var a = $('#mySwitchs').bootstrapSwitch('status');
       var status = data.value;
       var comm = $('#comm').val();
       var estateSearchId = $('#corp').val();
       var at_search = $('#at_search').val();
       var data = {};
        if(status == a){
            data.status = '';
            data.okey ='';
            data.comm = comm;
            data.estateSearchId = estateSearchId;
            data.at_search = at_search;
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
            data.comm = comm;
            data.estateSearchId = estateSearchId;
            data.at_search = at_search;
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
            data.comm = comm;
            data.estateSearchId = estateSearchId;
            data.at_search = at_search;
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
    //作废状态筛选
    $('#mySwitchs').on('switch-change', function (e, data) {
       var status = $('#mySwitch').bootstrapSwitch('status');
        var a = data.value;
        var comm = $('#comm').val();
        var estateSearchId = $('#corp').val();
        var at_search = $('#at_search').val();
        var data = {};
        if(status == a){
            data.status = '';
            data.okey ='';
            data.comm = comm;
            data.estateSearchId = estateSearchId;
            data.at_search = at_search;
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
            data.comm = comm;
            data.estateSearchId = estateSearchId;
            data.at_search = at_search;
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
            data.comm = comm;
            data.estateSearchId = estateSearchId;
            data.at_search = at_search;
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
    //模糊查询和状态筛选 方法
    function MoHuAndStatus(){
        var a = $('#mySwitch').bootstrapSwitch('status');
        var b = $('#mySwitchs').bootstrapSwitch('status');
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
    }
    //模糊查询
    $('#search_button').on('click',function(){
        MoHuAndStatus();
    })
    $('#at_search').on('keyup',function(){
        if($('#at_search').val() == '' || $('#at_search').val() == null){
            MoHuAndStatus();
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
        var ppp = {};
        ppp.rid = id;
        $.ajax({
            type:'post',
            url:'PropertyFeePayment/findRidComm',
            data: ppp,
            dataType:'json',
            success:function(data){
                jQuery('#community_id').empty();

                for (var i in data) {
                    var a = data[i].communityId;
                    $("#community_id").append("<option value=" + a + ">" + data[i].communityName + "</option>")
                }
            }
        })
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
            $('#area').val('');
            $('#owner_name').val('');
            $('#estate_unit_price').val('');
            $('#payment_amount').val('');
            $('#service_start_date').val('');
            $('#service_end_date').val('');
            $('#house_id').val('');
        })
        // 遍历码表缴纳月数
        $.ajax({
            type:"POST",
            url:"PropertyFeePayment/findMoneyMonth",
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
            url:"PropertyFeePayment/findAccount",
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
            var price = $('#estate_unit_price').val();
            var area = $('#area').val();
            $('#payment_amount').val(price * month*area);
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
                  url:"PropertyFeePayment/findHouseNumIsNull",
                  data:data,
                  dataType:"json",
                  success:function(result){
                      if(result > 0){
                          //查面积  单价   名字
                        $.ajax({
                            type:"POST",
                            url:"PropertyFeePayment/findAreaOrMoneyOrName",
                            data:data,
                            dataType:"json",
                            success:function(findData){
                               $('#area').val(findData.area);
                               $('#owner_name').val(findData.ownerName);
                               $('#house_id').val(findData.houseId);
                               $('#estate_unit_price').val(findData.previousEstateUnitPrice);

                                var month = $('#pay_month_type_id').val();
                                var price = $('#estate_unit_price').val();
                                var area = $('#area').val();
                                $('#payment_amount').val(price * month*area);

                                //查起始时间 = 上次结束时间+1天
                                $.ajax({
                                    type:"POST",
                                    url:"PropertyFeePayment/findStartTime",
                                    data:{'house_id': findData.houseId},
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
                        })

                      }
                  }
              })
             }
        })
        // 模糊联想 门牌号 end
        //单价keyup事件 键盘输入事件
        $('#estate_unit_price').keyup(function (){
            var month = $('#pay_month_type_id').val();
            var price = $('#estate_unit_price').val();
            var area = $('#area').val();
            $('#payment_amount').val(price * month*area);
        })
        //关闭刷新页面 start
        $("#modal-demo-add").on("hide.bs.modal", function() {
            location.reload()
        })
        //关闭刷新页面 end
    }
    $('#insert').on('click',function(){
        var estate_pay_num = $('#estate_pay_num').val();
        var house_id = $('#house_id').val();
        var owner_name = $('#owner_name').val();
        var area = $('#area').val();
        var estate_unit_price = $('#estate_unit_price').val();
        var pay_month_type_id = $('#pay_month_type_id').val();
        var pay_date = $('#pay_date').val();
        var payment_amount = $('#payment_amount').val();
        var service_start_date = $('#service_start_date').val();
        var service_end_date = $('#service_end_date').val();
        var charge_worker_id = $('#charge_worker_id').val();
        var operator = $('#Rname').val();
        var house_num = $('#house_num').val();

        var data = {};
        data.estate_pay_num = estate_pay_num;
        data.house_id = house_id;
        data.owner_name = owner_name;
        data.area = area;
        data.estate_unit_price = estate_unit_price;
        data.pay_month_type_id = pay_month_type_id;
        data.pay_date = pay_date;
        data.payment_amount = payment_amount;
        data.service_start_date = service_start_date;
        data.service_end_date = service_end_date;
        data.charge_worker_id = charge_worker_id;
        data.operator = operator;

        if(estate_pay_num == ''&& house_num == ''){
            layer.alert('单号和门牌号不能为空！')
        }else if(estate_pay_num == '' ){
            layer.alert('单号不能为空！')
        }else if(house_num == ''){
            layer.alert('门牌号不能为空！')
        }
       $.ajax({
           type:'post',
           url:'PropertyFeePayment/insertProperty',
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
        var dN = $('#Rname').val();
        var id = {};
        id.id=d;
        id.Rname = dN;
       $.ajax({
           url:'PropertyFeePayment/updateOver',
           data:id,
           dataType:'json',
           method:'post',
           success:function(data){
               location.reload()
           }
       })
    })


    function cDayFuncd(){
        cFuncd('d');
    }
    function cMonthFuncd(){
        cFuncd('M');
    }
    function cYearFuncd(){
        cFuncd('y');
    }
    function cFuncd(whod) {
        var  p, c = $dp.cal;
        if (whod == 'y') {
            p = 'y';
        }
        else if (whod == 'M') {
            p = 'M';
        }
        else if (whod == 'd') {
            p = 'd';
        }
        var PDdatas = $dp.cal.newdate
        var PDend = PDdatas.d + 1;
        var at_pay_end = PDdatas.y + '-' + PDdatas.M + '-' + PDend;
        var at_pay_start = $('#at_pay_start').val();
        var at_service_end = $('#at_service_end').val()
        var at_service_start = $('#at_service_start').val()
        var comm = $('#comm').val();
        var estateSearchId = $('#corp').val();
        var a = $('#mySwitch').bootstrapSwitch('status');
        var b = $('#mySwitchs').bootstrapSwitch('status');
        var at_search = $('#at_search').val();
        if(at_pay_start == ''){
            layer.alert('开始日期不能为空')
        }
        var FWtime = {};
        FWtime.at_pay_start = at_pay_start;
        FWtime.at_pay_end = at_pay_end;
        FWtime.at_service_start = at_service_start;
        FWtime.at_service_end = at_service_end;
        FWtime.comm = comm;
        FWtime.estateSearchId = estateSearchId;
        FWtime.at_search = at_search;
        if(a == b){
            FWtime.status = '';
            FWtime.okey ='';
            $.ajax({
                url:"PropertyFeePayment/getPropertyList",
                type:"POST",
                data:FWtime,
                dataType:"json",
                success:function (data){
                    showDataTable(data);
                }
            })
        }else if(a == true && b == false){
            FWtime.status = '1';
            FWtime.okey ='';
            $.ajax({
                url:"PropertyFeePayment/getPropertyList",
                type:"POST",
                data:FWtime,
                dataType:"json",
                success:function (data){
                    showDataTable(data);
                }
            })
        }else if(a == false && b == true){
            FWtime.status = '';
            FWtime.okey ='0';
            $.ajax({
                url:"PropertyFeePayment/getPropertyList",
                type:"POST",
                data:FWtime,
                dataType:"json",
                success:function (data){
                    showDataTable(data);
                }
            })
        }

    }
    function cDayFunc(){
        cFunc('d');
    }
    function cMonthFunc(){
        cFunc('M');
    }
    function cYearFunc(){
        cFunc('y');
    }
    function cFunc(who){
        var str,p,c = $dp.cal;
        if(who=='y'){
            p='y';
        }
        else if(who=='M'){
            p='M';
        }
        else if(who=='d'){
            p='d';
        }
        var PDdatas = $dp.cal.newdate
        var PDend = PDdatas.d+1;
        var at_service_end = PDdatas.y+'-'+PDdatas.M+'-'+PDdatas.d;
        var at_service_start = $('#at_service_start').val()
        var at_pay_end = $('#at_pay_end').val();
        var at_pay_start = $('#at_pay_start').val();
        var comm = $('#comm').val();
        var estateSearchId = $('#corp').val();
        var a = $('#mySwitch').bootstrapSwitch('status');
        var b = $('#mySwitchs').bootstrapSwitch('status');
        var at_search = $('#at_search').val();
       if(at_service_start == ''){
           layer.alert('开始日期不能为空')
       }
        var FWtime = {};
             FWtime.at_pay_start = at_pay_start;
             FWtime.at_pay_end = at_pay_end;
             FWtime.at_service_start = at_service_start;
             FWtime.at_service_end = at_service_end;
             FWtime.comm = comm;
             FWtime.estateSearchId = estateSearchId;
             FWtime.at_search = at_search;
        if(a == b){
            FWtime.status = '';
            FWtime.okey ='';
            $.ajax({
                url:"PropertyFeePayment/getPropertyList",
                type:"POST",
                data:FWtime,
                dataType:"json",
                success:function (data){
                    showDataTable(data);
                }
            })
        }else if(a == true && b == false){
            FWtime.status = '1';
            FWtime.okey ='';
            $.ajax({
                url:"PropertyFeePayment/getPropertyList",
                type:"POST",
                data:FWtime,
                dataType:"json",
                success:function (data){
                    showDataTable(data);
                }
            })
        }else if(a == false && b == true){
            FWtime.status = '';
            FWtime.okey ='0';
            $.ajax({
                url:"PropertyFeePayment/getPropertyList",
                type:"POST",
                data:FWtime,
                dataType:"json",
                success:function (data){
                    showDataTable(data);
                }
            })
        }

    }
</script>
</body>
</html>