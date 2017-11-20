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
                        <input type="text" class="input-text " id="add_title"  placeholder="请输入标题" style="width: 100%">
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-3 col-sm-2">内容：</label>
                    <div class="formControls col-xs-4 col-sm-8">
                       <textarea id="editor_add" name="content"></textarea>
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-2">发布人：</label>
                    <div class="formControls col-xs-4 col-sm-4">
                        <select id="publishWorker" class="input-text "></select>
                    </div>
                </div>
                <div class="modal-footer " style="text-align: center">
                    <button class="btn btn-primary" id="preview">预览</button>
                    <button class="btn btn-primary" id="publish">发布</button>
                    <button class="btn" data-dismiss="modal" >取消</button>
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
                        <select id="edit_publishWorker" class="input-text "></select>
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
            dataType:"data",
            data:searchInfo,
            success:function (data) {
                callback(data)
            }
        })
    }
    //------显示dataTable
    function showDataTable (data) {
        $('#publishNewsTable').dataTable({
            paging:true,
            serverSide:true,
            searching: false,
            lengthChange:true,
            pageLength:20,
            language: { //国际化配置
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
            },
            lengthMenu:[10,20,50,100],
            pagingType: "full_numbers",
            destroy: true,
            info: true,
            ajax:function (data,callback,settings) {
                getDataTableInfo()
            },
//            "data":data,
            autoWidth: false,
            columns: [{
                'data': 'title',
            }, {
                'data': 'name',
            }, {
                'data': 'content',
            },{
                'data': 'releaseTime',
            }],
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

    //--------获取发布人姓名
    function getPublishWorker() {
        $.ajax({
            type:"post",
            url:"publish/findPublishWorker",
            dataType:"json",
            success:function (data) {
                for(var i = 0; i < data.length; i++) {
                    var id = data[i].userId;
                    var name = data[i].name;
                    var opt = "<option value='" + id + "'>" + name + "</option>";
                    $("#publishWorker").append(opt);
                }
            }
        })
    }
    //-------新增事件显示新增模态框
    function add() {
        $("#addNewsModal").modal("show")
        getPublishWorker()
        var editor = KindEditor.create('#editor_add',{
            width : '600px',
            items: [
                'forecolor', 'hilitecolor',
                'bold', 'italic', 'underline', 'hr', 'removeformat', '|', 'justifyleft', 'justifycenter',
                'justifyright', 'insertorderedlist', 'insertunorderedlist', '|', 'link', 'image',
                'unlink', 'emoticons'
            ],
            afterBlur:function () {
                this.sync();
            },
            resizeType:0
        });
    }
    $("#publish").click(function () {
        publish()
    });
    function publish() {
       var title = $("#add_title").val();
       var content = $("#editor_add").val();
       var publishWorker = $("#publishWorker").val();
        searchInfo.title = title;
        searchInfo.content = content;
        searchInfo.publishWorker = publishWorker;
        console.log(searchInfo)

    }
    //--------关闭Dialog前移除编辑器

    $('#addNewsModal').on('hidden.bs.modal', function () {
      location.reload()
    });
    //-------获取选择行的数据
    var newsInfo = {}
    function getSelectNodesInfo() {
        var nTrs = messageTable.fnGetNodes();//fnGetNodes获取表格所有行，nTrs[i]表示第i行tr对象
        for(var i = 0; i < nTrs.length; i++){
            if($(nTrs[i]).hasClass('selected')){
                console.log(messageTable.fnGetData(nTrs[i]))
                newsInfo.title = messageTable.fnGetData(nTrs[i]).title
                newsInfo.content = messageTable.fnGetData(nTrs[i]).content
                newsInfo.announcementId = messageTable.fnGetData(nTrs[i]).announcementId
            }
        }
    }
    //-------编辑事件
    function edit() {
        getSelectNodesInfo()
        $("#newsTitle").val(newsInfo.title)
        $("#newsContent").val(newsInfo.content)
        $("#edit_publishWorker").val()
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
                location.reload()
//                getDataTableInfo()
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