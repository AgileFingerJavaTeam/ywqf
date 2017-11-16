<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../common/meta.jsp" %>
<%-- 自定义css样式 --%>
<style type="text/css">
    /* dataTables列内容居中 */
    .table>tbody>tr>td {
        text-align: center;
    }
    .modal{
        width: 1000px;
        margin-left: -500px;
    }
    .modal.fade.in{
        top: 100px;
    }
</style>
<meta charset="UTF-8">
<meta content="text/html">
</head>
<body>
<div class="page-container">
    <div class="text">
        <input type="text" placeholder="请输入关键字" name="searchInfo" id="searchNewsInfo" style="width:250px" class="input-text"><a class="btn btn-primary"  onclick="searchNews() " style="margin-right:30px;">搜索</a>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort " id="newsTable">
            <thead>
            <tr class="text-c">
                <th width="8">时间</th>
                <th width="5">发布人</th>
                <th width="100">标题</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>
<div id="ps-f" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content radius" >
                <div class="modal-header">
                    <h4	 style="text-align: left"><input id="model-title" type="text" style="border: hidden;font-size: large" readonly></h4>
                    <a class="close" data-dismiss="modal" aria-hidden="true" >×</a>
                </div>
            <div class="modal-body">
                <textarea id="model-content" type="text" style="border: hidden;width: 100%;font-size: 15px;resize:none" readonly></textarea>
            </div>
            <div class="modal-footer" style="text-align: center">
                <%--<button class="btn btn-primary"aria-hidden="true">确定</button>--%>
                <button class="btn" id="closeModel" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
</div>
<%@ include file="../common/footer.jsp" %>
<script type="text/javascript" src="hui/lib/bootstrap-modal/2.2.4/bootstrap-modal.js"></script>
<script type="text/javascript" src="hui/lib/bootstrap-modal/2.2.4/bootstrap-modalmanager.js"></script>
<script type="text/javascript">
    var searchInfo = {};
    //-------获取datatable要显示的信息
    function getDataTableInfo() {
        $.ajax({
            url:"newsHall/findNewsInfo",
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
        $('#newsTable').dataTable({
            destroy: true,
            "data":data,
            searching: false,
            "bAutoWidth": false,
            "columns": [{
                    'data': 'releaseTime',
                }, {
                    'data': 'name',
                }, {
                    'data': 'title',
                }
            ],
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
            url:"newsHall/findNewsInfo",
            type: "post",
            dataType:"JSON",
            data:searchInfo,
            success:function(data) {
                showDataTable(data)
            }
        })
    }
    //------显示详情模态框
    var messageTable = $('#newsTable').dataTable();
    function showContentModel(){
        var nTrs = messageTable.fnGetNodes();//fnGetNodes获取表格所有行，nTrs[i]表示第i行tr对象
        for(var i = 0; i < nTrs.length; i++){
            if($(nTrs[i]).hasClass('1')){
                var title = messageTable.fnGetData(nTrs[i]).title
                var content = messageTable.fnGetData(nTrs[i]).content
            }
        }
        $("#ps-f").modal("show")
        $("#model-title").val(title)
        $("#model-content").val(content)
    }
    //--------点击当前行时选择当前行并执行显示当前行详情模态框
    $('#newsTable').on('click','tbody>tr',function () {
        if (messageTable.$('tr.selected').removeClass('1')){
            $(this).addClass('1');
            showContentModel()
            $(this).removeClass('1');
        }
    })
    //--------搜索
    function searchNews() {
        var searchNewsInfo = $('#searchNewsInfo').val();
        searchInfo.searchNewsInfo = searchNewsInfo
        SubmitSearchInfo()
    }
    $(document).ready(function() {
        getDataTableInfo()
    });
</script>

</body>
</html>