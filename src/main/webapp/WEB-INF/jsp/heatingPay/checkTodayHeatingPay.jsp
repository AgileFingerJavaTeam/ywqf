<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../common/meta.jsp" %>
<%-- 自定义css样式 --%>
<style type="text/css">
    /* dataTables列内容居中 */
    .table>tbody>tr>td {
        text-align: center;
    }
    .bg{
        background-color:gainsboro; height:2.8em;
    }
    .bga{
        background-color:dimgrey; height:2.8em;
    }
    .sc{
        color:white;
    }
    .statis{
        background-color:#1D69A9;
        width:100%;
        height:2.8em;
        margin:0 auto;
        overflow:hidden;
        position: fixed;
        bottom:0;
    }
</style>

<meta charset="UTF-8">
<meta content="text/html">

</head>
<body>
<div class="container-fluid statis">
    <div class="row">
        <div class="col-md-9 bg">对账日期:<strong id="checkDate"></strong></div>
        <div class="col-md-3 bga"><font class="sc">账单统计：</font><strong id="TotalDues" class="sc"></strong><font class="sc">元</font></div>
    </div>
</div>
<div class="page-container">
    <div class="text">
        <input type="text" placeholder="请输入关键字" name="searchInfo" id="search" style="width:250px" class="input-text"><a class="btn btn-primary"  onclick="clickSearch() " style="margin-right:30px;">搜索</a>
        物业:
        <span class="select-box inline" style="margin-right:30px;">
		<select name="corps" class="select" id="corps">
        </select>
		</span>
        小区:
        <span class="select-box inline" style="margin-right:30px;">
		<select name="community" class="select" id="community"style="width:130px" >
			<option value="0">全部小区</option>
		</select>
		</span>
        对账日期:
        <span style="margin-right:30px;">
        <input type="text" onclick="WdatePicker({onpicked:function(){clickDate()},lang:'zh-cn',maxDate:new Date()})" class="input-text Wdate" id="ss"  style="width:120px;">
        </span>
        <a class="btn btn-primary radius aaa" id="bb">导出</a>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort " id="checkBillTable">
            <thead>
            <tr class="text-c">
                <th width="55">单号</th>
                <th width="50">业主</th>
                <th width="50">门牌号</th>
                <th width="50">采暖费单价(元/平米)</th>
                <th width="30">采暖季年份</th>
                <th width="35">优惠比例</th>
                <th width="50">优惠单价（元/平米）</th>
                <th width="45">采暖面积(平米)</th>
                <th width="35">缴费额（元）</th>
                <th width="50">收费员工</th>
                <th width="75">缴费日期</th>
                <th width="50">录入员工</th>
                <th width="75">录入日期</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>
<%@ include file="../common/footer.jsp" %>
<script type="text/javascript">
    TimeDefault()  //设置默认时间
    var searchInfo = {};
    searchInfo.date = $('#ss').val()//获取当前时间
    //-------获取datatable要显示的信息
    function getDataTableInfo() {

        $.ajax({
            url:"heatingPay/findHeatingPayInfo",
            type:"POST",
            dataType:"JSON",
            data:searchInfo,
            success:function (data) {
                showDataTable(data)
            }
        })
    }
    //------显示dataTable
    function showDataTable (data) {
        var date = $("#ss").val();
        $("#checkDate").text(date)
        var count = data.amount;
        if(count == null){
            var count = 0
            $("#TotalDues").text(count)//给缴费总额赋值
        }else{ $("#TotalDues").text(count)}//给缴费总额赋值
        $('.table-sort').dataTable({
            "data":data.data,
//            "bPaginate" : true,//分页工具条显示
//            paging: true,
            destroy: true,
            searching: false,
//            "serverSide":true,
            "sAjaxDataProp" : "aData",//是服务器分页的标志，必须有
//        "sAjaxSource": "estatePay/findTodayEstatePayInfo",
            "columns": [
                {
                    'data': 'heatingPayNum',
                }, {
                    'data': 'ownerName',
                }, {
                    'data': 'houseNum',
                }, {
                    "data": 'discountHeatingUnitPrice',
                }, {
                    'data': 'year',
                }, {
                    'data': 'heatingDiscount',
                }, {
                    "data": 'discountHeatingUnitPrice',
                }, {
                    'data': 'heatingArea',
                }, {
                    'data': 'paymentAmount',
                }, {
                    "data": 'name',
                }, {
                    'data': 'paymentDate',
                }, {
                    'data': 'operator',
                }, {
                    "data": 'operateTime',
                }
            ],
            "sServerMethod":"POST",
            "aaSorting" : [[10, "desc" ]],//默认第几个排序
            "bStateSave": true,//状态保存
//            "serverSide":true,
            "aLengthMenu":[10,20,50],
            "aoColumnDefs": [
                //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
                {"orderable":false,"aTargets":[0]}// 不参与排序的列
            ],
            "pagingType":   "full_numbers",
            "oLanguage": { //国际化配置
                "sProcessing": "正在获取数据，请稍后...",
                "sLengthMenu": "显示 _MENU_ 条",
                "sZeroRecords": "没有您要搜索的内容",
                "sInfo": "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",
                "sInfoEmpty": "记录数为0",
                "sInfoFiltered": "(全部记录数 _MAX_ 条)",
                "sInfoPostFix": "",
                "sSearch": "搜索",
                "sUrl": "",
                "oPaginate": {
                    "sFirst": "第一页",
                    "sPrevious": "上一页",
                    "sNext": "下一页",
                }
            }
        });

    }
    //------获取登录用户身份
    function getUserType() {
        $.ajax({
            type:"post",
            url:"estatePay/findUserType",
            dataType:"json",
            success:function (data) {
                var userType = data;
                if (userType == "0"){
                    getUserBelongsCrop()
                    getUserManagedCommunity()
                    getDataTableInfo()
                }else {
                    $("#corps").append("<option value="+0+" >全部物业</option>");
                    getDataTableInfo()
                    getCorpsInfo()
                    selectCorps()
                }
            }
        })
    }
    //-------获取登录员工所属物业公司
    function getUserBelongsCrop() {
        $.ajax({
            type: "post",
            url: "estatePay/findUserBelongsCrop", //获取json数据
            dataType: "json",
            success: function(data) {
                var opt = "<option value='" + data.corpId + "'>" + data.corpName + "</option>";
                $("#corps").append(opt);
                searchInfo.corpId = $("#corps").val()//获取当前物业ID
            },
            error: function() {
                alert("系统异常，请稍后再试！")
            }
        });
    }
    //-------获取所有物业公司
    function getCorpsInfo() {
        $.ajax({
            type: "post",
            url: "estatePay/findCorpsInfo", //获取json数据
            dataType: "json",
            success: function(data) {
                for(var i = 0; i < data.length; i++) {
                    var id = data[i].corpId;
                    var name = data[i].corpName;
                    var opt = "<option value='" + id + "'>" + name + "</option>";
                    $("#corps").append(opt);
                    searchInfo.corpId = $("#corps").val()//获取当前物业ID
                }
            },
            error: function() {
                alert("系统异常，请稍后再试！")
            }
        });
    }
    //-------选择物业公司
    function selectCorps() {
        var corpsID = {};
        var corpsId =document.getElementById("corps");
        $("#corps").change(function(){
            corpsId = document.getElementById('corps').value
            corpsID.corpsId = corpsId;
            $("#community").empty()
            $("#community").append("<option value=\"0\">全部小区</option>");
            $.ajax({
                url:"estatePay/findCorpManagedCommunity",
                type: "post",
                dataType:"JSON",
                data:corpsID,
                success: function(data) {
                    for(var i = 0; i < data.length; i++) {
                        var id = data[i].communityId;
                        var name = data[i].communityName;
                        var opt = "<option value='" + id + "'>" + name + "</option>";
                        $("#community").append(opt);
                        searchInfo.communityId = $("#community").val()//获取当前小区ID
                    }
                },
                error: function() {
                    alert("系统异常，请稍后再试！")
                }
            })
        })
    }

    //----获取当前员工管理的所有小区
    function getUserManagedCommunity() {
        $.ajax({
            type: "post",
            url: "estatePay/findUserManagedCommunity", //获取json数据
            dataType: "json",
            success: function(data) {
                for(var i = 0; i < data.length; i++) {
                    var id = data[i].communityId;
                    var name = data[i].communityName;
                    var opt = "<option value='" + id + "'>" + name + "</option>";
                    $("#community").append(opt);
                    searchInfo.communityId = $("#community").val()//获取当前小区ID
                }
            },
            error: function() {
                alert("系统异常，请稍后再试！")
            }
        });
    }
    //-------根据所选物业搜索
    $("#corps").change(function(){
        corpId = $('#corps').val()
        searchInfo.corpId = corpId;
        console.log(searchInfo)
        SubmitSearchInfo()
    })
    //-------根据所选小区搜索
    $("#community").change(function(){
        communityId = $('#community').val()
        searchInfo.communityId = communityId;
        SubmitSearchInfo()
    })
    //--------根据所选时间搜索
    function clickDate() {
        var date = $('#ss').val()
        searchInfo.communityId = $('#community').val();
        searchInfo.date = date;
        SubmitSearchInfo()
    }
    //----利用AJAX提交搜索信息
    function SubmitSearchInfo(){
        $.ajax({
            url:"heatingPay/findHeatingPayInfo",
            type: "post",
            dataType:"JSON",
            data:searchInfo,
            success:function(data) {
                showDataTable(data)
            }
        })
    }
    //--------搜索
    function clickSearch() {
        var search = $('#search').val();
        searchInfo.search = search
        SubmitSearchInfo()
    }
    //-------时间默认值
    function TimeDefault() {
        var d = new Date();
        function addzero(v) {if (v < 10) return '0' + v;return v.toString();}
        var s = d.getFullYear().toString() + '-'+addzero(d.getMonth() + 1)+ '-'+addzero(d.getDate());
        document.getElementById('ss').value=s;
    }
    $(document).ready(function() {
        getUserType()
    });

</script>
</body>
</html>