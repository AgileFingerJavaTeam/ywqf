<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../common/meta.jsp" %>
<link rel="stylesheet" href="hui/lib/kindeditor/themes/qq/qq.css" />
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
</style>
<meta charset="UTF-8">
<meta content="text/html">
</head>
<body>
<div class="page-container">
    <div class="text">
        <input type="text" placeholder="请输入关键字" name="searchInfo" id="searchNoticeInfo" style="width:250px" class="input-text"><a class="btn btn-primary"  onclick="searchNoticeInfo() " style="margin-right:30px;">搜索</a>

        <a   onclick="add()" style="text-decoration: none;margin-right: 50px " class="abtn">
            新增<i class="Hui-iconfont">&#xe600;</i>
        </a>
        <a  onclick="edit()" style="text-decoration: none;margin-right:50px "class="abtn">
            编辑<i class="Hui-iconfont">&#xe6df;</i>
        </a>
        <a  onclick="remove()"style="text-decoration: none;margin-right: 50px "class="abtn">
            删除<i class="Hui-iconfont">&#xe6e2;</i>
        </a>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort " id="publishNewsTable">
            <thead>
            <tr class="text-c">
                <th width="10">标题</th>
                <th width="20">发布人</th>
                <th width="100">内容</th>
                <th width="20">时间</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>
<div id="addNewsModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content radius">
            <form action="" method="post" class="form form-horizontal"   id="addNewsForm">
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-2">标题：</label>
                    <div class="formControls col-xs-4 col-sm-8	">
                        <input type="text" class="input-text " id="owner_name"  placeholder="请输入标题" style="width: 100%">
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-3 col-sm-2">内容：</label>
                    <div class="formControls col-xs-4 col-sm-8">
                       <textarea id="editor_id" name="content"></textarea>
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-2">发布人：</label>
                    <div class="formControls col-xs-4 col-sm-4">
                        <select id="houseType" class="input-text "></select>
                    </div>
                </div>
                <div class="modal-footer " style="text-align: center">
                    <button class="btn btn-primary" id="preview">预览</button>
                    <button class="btn btn-primary" id="confirm">发布</button>
                    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div id="editPublishNews" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content radius">
            <form action="" method="post" class="form form-horizontal"   id="editNewsForm">
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-2">标题：</label>
                    <div class="formControls col-xs-4 col-sm-8	">
                        <input type="text" class="input-text " id="newsTitle" style="width: 100%">
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-3 col-sm-2">内容：</label>
                    <div class="formControls col-xs-4 col-sm-8">
                        <textarea id="newsContent" name="content"></textarea>
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-2">发布人：</label>
                    <div class="formControls col-xs-4 col-sm-4">
                        <select id="releaseWorker" class="input-text "></select>
                    </div>
                </div>
                <div class="modal-footer " style="text-align: center">
                    <button class="btn btn-primary" id="editPreview">预览</button>
                    <button class="btn btn-primary" id="editPublish">发布</button>
                    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="../common/footer.jsp" %>
<script type="text/javascript" src="hui/lib/bootstrap-modal/2.2.4/bootstrap-modal.js"></script>
<script type="text/javascript" src="hui/lib/bootstrap-modal/2.2.4/bootstrap-modalmanager.js"></script>
<script type="text/javascript" src="hui/lib/kindeditor/kindeditor-all.js"></script>
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
        $('#publishNewsTable').dataTable({
            destroy: true,
            "data":data,
            searching: false,
            "bAutoWidth": false,
            "columns": [{
                'data': 'title',
            }, {
                'data': 'account',
            }, {
                'data': 'content',
            },{
                'data': 'releaseTime',
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
            url:"newsHall/findNewsInfo",
            type: "post",
            dataType:"JSON",
            data:searchInfo,
            success:function(data) {
                showDataTable(data)
            }
        })
    }
    //--------搜索
    function searchNoticeInfo() {
        var searchNoticeInfo = $('#searchNoticeInfo').val();
        searchInfo.searchNewsInfo = searchNoticeInfo
        SubmitSearchInfo()
    }
    $(document).ready(function() {
        getDataTableInfo()
    });
    //-------新增事件
    function add() {
        $("#addNewsModal").modal("show")
            var editor = KindEditor.create('#editor_id',{
                items: [
                    'forecolor', 'hilitecolor',
                    'bold', 'italic', 'underline', 'hr', 'removeformat', '|', 'justifyleft', 'justifycenter',
                    'justifyright', 'insertorderedlist', 'insertunorderedlist', '|', 'link', 'image',
                    'unlink', 'emoticons'
                ],
                resizeType:0
            });
    }
    //-------获取选择行的数据
    var newsInfo = {}
    function getSelectNodesInfo() {
        var nTrs = messageTable.fnGetNodes();//fnGetNodes获取表格所有行，nTrs[i]表示第i行tr对象
        for(var i = 0; i < nTrs.length; i++){
            if($(nTrs[i]).hasClass('selected')){
                newsInfo.title = messageTable.fnGetData(nTrs[i]).title
                newsInfo.content = messageTable.fnGetData(nTrs[i]).content
                newsInfo.announcementId = messageTable.fnGetData(nTrs[i]).id
            }
        }
    }
    //-------编辑事件
    function edit() {
        getSelectNodesInfo()
        $("#newsTitle").val(newsInfo.title)
        $("#newsContent").val(newsInfo.content)
        $("#editPublishNews").modal("show")
    }
    //-------删除事件
    function remove(){
         getSelectNodesInfo()
        $.ajax({
            url:"publish/removeNews",
            type: "post",
            dataType:"JSON",
            data:newsInfo,
            success:function(data) {
                getDataTableInfo()
            }
        })



    }
    //-----选中一行
    var messageTable = $('#publishNewsTable').dataTable();
    $("#publishNewsTable").on('click','tbody>tr',function (){
        if ($(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        } else {
            messageTable.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    })

</script>

</body>
</html>