<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../common/meta.jsp" %>
<%-- 自定义css样式 --%>
<style type="text/css">
    /* dataTables列内容居中 */
    .table>tbody>tr>td {
        text-align: center;
    }
</style>
<link rel="stylesheet" href="hui/lib/bootstrap-Switch/bootstrapSwitch.css">
<meta charset="UTF-8">
<meta content="text/html">
</head>
<body>
<div class="page-container">
    <div class="text">
        <input type="text" placeholder="请输入关键词" name="searchInfo" id="searchResetApplyInfo" style="width:250px" class="input-text"><a class="btn btn-primary"  onclick="searchApplyResetInfo() " style="margin-right:30px;">搜索</a>
        <div class="r" style="font-size: large">已经重置</div>
        <div class="switch r" id="alreadyReset" data-on="primary" data-off="danger"  >
            <input type="checkbox"  value="1" checked />
        </div>
        <div class="r"  style="margin-right: 40px;font-size: large">等待重置</div>
        <div class="switch r" id="waitReset" data-on="primary" data-off="danger">
            <input type="checkbox"  value="1" checked />
        </div>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort " id="newsTable">
            <thead>
            <tr class="text-c">
                <th width="20">申请时间</th>
                <th width="20">姓名</th>
                <th width="20">物业公司</th>
                <th width="20">绑定手机号</th>
                <th width="20">状态</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>
<div id="confirmResetModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content radius">
            <div class="modal-header">
                <h3 class="modal-title">确认重置密码</h3>
                <a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void()">×</a>
            </div>
            <div class="modal-body">
                <span style="text-align: center;">确定重置密码？</span>
                <input style="display: none;" id="resetPassword">
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" id="confirm">确定</button>
                <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
</div>
<%@ include file="../common/footer.jsp" %>
<script type="text/javascript" src="hui/lib/bootstrap-modal/2.2.4/bootstrap-modal.js"></script>
<script type="text/javascript" src="hui/lib/bootstrap-modal/2.2.4/bootstrap-modalmanager.js"></script>
<script type="text/javascript" src="hui/lib/bootstrap-Switch/bootstrapSwitch.js"></script>
<script type="text/javascript">
    var searchInfo = {};
    //-------获取datatable要显示的信息
    function getDataTableInfo() {
        var checkBoxType = {}
        var a = $("#alreadyReset").bootstrapSwitch('status');
        var b = $("#waitReset").bootstrapSwitch('status');
        if (a == true && b == true){
            checkBoxType = ''
        }else if (a == false && b == true){
            checkBoxType = 0
        }else if (a == true && b == false){
            checkBoxType = 1
        }else {
            checkBoxType = 3
        }
        searchInfo.checkBoxType = checkBoxType
        $.ajax({
            url:"resetPassword/findApplyResetPasswordInfo",
            type:"POST",
            dataType:"JSON",
            data:searchInfo,
            success:function (data) {
                console.log(data)
                showDataTable(data)
            }
        })
    }
    //-----按钮筛选事件
    $(".switch").on('switch-change',function () {
        getDataTableInfo()
    })
    //------显示dataTable
    function showDataTable (data) {
        $('#newsTable').dataTable({
            destroy: true,
            "data":data,
            searching: false,
            "bAutoWidth": false,
            "columns": [{
                'data': 'findTime',
            }, {
                'data': 'realName',
            }, {
                'data': 'corpName',
            },{
                'data': 'phone',
            },{
                'data':  function (value) {
                    var status = value.status;
                    var phone = value.phone;
                    if (status == 0){
                        aspx ="<br><a style='color:blue;' class='at-a-status' attr-id='" + phone + "' onclick='showResetModal(" + phone + ")'> 重置密码</a>";
                        return '等待重置' + aspx;
                    }else {
                        aspx = "<span style='color:red;'>已经重置</span>";
                        return aspx;
                    }
                }
            }],
            "sServerMethod":"POST",
            /* "aaSorting" : [[10, "desc" ]],//默认第几个排序*/
            "bStateSave": true,//状态保存
            "aLengthMenu":[10,20,50],
            "aoColumnDefs": [
                //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
            ],
        });
    }
    //----利用AJAX提交搜索信息
    function SubmitSearchInfo(){
        $.ajax({
            url:"resetPassword/findApplyResetPasswordInfo",
            type: "post",
            dataType:"JSON",
            data:searchInfo,
            success:function(data) {
                showDataTable(data)
            }
        })
    }
    //--------搜索
    function searchApplyResetInfo() {
        var searchResetApplyInfo = $('#searchResetApplyInfo').val();
        searchInfo.searchResetApplyInfo = searchResetApplyInfo
        SubmitSearchInfo()
    }
    $(document).ready(function() {
        getDataTableInfo()
    });
    //-------显示重置密码模态框
    function showResetModal(phone){
        $("#resetPassword").val(phone);
        $("#confirmResetModal").modal("show")
    }
    //-------重置密码
    $('#confirm').on('click',function(){
        var phone = $('#resetPassword').val();
        searchInfo.phone = phone;
        $.ajax({
            url:'resetPassword/resetPassword',
            data:searchInfo,
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