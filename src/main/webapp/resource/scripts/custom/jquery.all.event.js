/**
 * [验证码图片 Click 监听]
 */
$(document).on('click', '#getCode', function () {
    if($(this).data('src') == undefined){
        $(this).data('src',$(this).attr('src'));
        $(this).attr('src',$(this).attr('src')+'?'+Math.random());
    } else {
        $(this).attr('src',$(this).data('src')+'?'+Math.random());
    }
});

/**
 * [打开标签页]
 */
$(document).on('click', '.window-location-tabs', function(){
    if($(this).data('href') != undefined){
        var url = $(this).data('href');
        var icon = $(this).data('icon');
        var text = $(this).text();
        $.Admin.open_tabs(text,url,icon);
    }
});

/**
 * [链接确认框]
 */
$(document).on('click', '.window-location-confirm', function(){
    if($(this).data('href') != undefined){
        var href = $(this).data('href');
        var msg  = $(this).data('msg') || '确定要继续吗？';
        $.messager.confirm('系统提示', msg, function (res) {
            if (res) window.location.href = href;
        });
    }
});



/**
 * [加载左侧菜单]
 */
$(document).on('click','.navbar-button',function(){
    $.Admin.load_left_menu(this);
});

/**
 * [Tabs组件Panel页面提交按钮事件监听]
 */
$(document).on('click','.table_form_submit_tabs',function(){
    //获取form元素
    var form = $(this).parents("form");
    //禁止没有URL的进行提交
    if($(form).attr("action") == '' || $(form).attr("action") == 'javascript:void(0);'){
        return false;
    }
    //form表单验证
    var isValid = $(form).form('validate');
    if (!isValid){
        return isValid;	// 返回false，终止表单提交
    }
    var type = $(form).attr("method");
    var url = $(form).attr("action");
    var data = $(form).serialize();
    //ajax提交数据处理
    $.ajax({
        type: type,
        url: url,
        data: data,
        dataType:"json",
        beforeSend: function(){
            $.messager.progress({text:'处理中，请稍候...'});
        },
        success: function(data){
            if(!data.status){
                $.Admin.tips('失败提示信息', data.info,'error');
            } else {
                $.Admin.tips('成功提示信息', data.info,'info');
                $.Admin.close_tabs();
                var tab = $('#layout-tabs').tabs('getSelected');
                tab.panel('refresh');
            }
        },
        error: function(data){
            $.Admin.tips('错误提示信息', data.responseText,'error');
        }
    });
});

// EasyUI Dialog 取消按钮事件监听
$(document).on('click','.table_form_close_dialog',function(){
    $(this).parents(".dialog-box").dialog("close");
});

/**
 * [Dialog弹窗提交按钮事件监听]
 */
$(document).on('click','.table_form_submit_dialog',function(){
    //获取form元素
    var form = $(this).parents("form");
    //禁止没有URL的进行提交
    if($(form).attr("action") == '' || $(form).attr("action") == 'javascript:void(0);'){
        return false;
    }
    //form表单验证
    var isValid = $(form).form('validate');
    if (!isValid){
        return isValid;	// 返回false，终止表单提交
    }
    var type = $(form).attr("method");
    var url = $(form).attr("action");
    var data = $(form).serialize();
    console.log("------------");
    console.log(data);
    console.log("------------");
    //ajax提交数据处理
    $.ajax({
        type: type,
        url: url,
        data: data,
        dataType:"json",
        beforeSend: function(){
            $.messager.progress({text:'处理中，请稍候...'});
        },
        success: function(data){
            if(!data.status){
                $.Admin.tips('失败提示信息', data.info,'error');
            } else {
                $.Admin.tips('成功提示信息', data.info,'info');
                $.Admin.refresh_tabs();
                $(form).parent().dialog('close');
            }
        },
        error: function(data){
            $.Admin.tips('错误提示信息', data.responseText,'error');
        }
    });
});
/**
 * [Dialog弹窗提交按钮事件监听]
 */
$(document).on('click','.table_form_submit_file_dialog',function(){
		
    //获取form元素
    var form = $(this).parents("form");
    //禁止没有URL的进行提交
    if($(form).attr("action") == '' || $(form).attr("action") == 'javascript:void(0);'){
        return false;
    }
    //form表单验证
    var isValid = $(form).form('validate');
    if (!isValid){
        return isValid;	// 返回false，终止表单提交
    }
    var url = $(form).attr("action");
    var formId = $(form).attr("id");
    $.messager.progress({text:'处理中，请稍候...'});
    jquerySubmit2(url,formId,function(data){
        if(!data.status){
            $.Admin.tips('失败提示信息', data.info,'error');
        } else {
            $.Admin.tips('成功提示信息', data.info,'info');
            $.Admin.refresh_tabs();
            $(form).parent().dialog('close');
        }
    }, function(data){
        $.Admin.tips('错误提示信息', data.responseText,'error');
    });
 
});