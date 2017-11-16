;(function($){
	$.extend({
        'Admin' : {
            /**
             * [char 定义字符串与数字组合]
             */
            'char' : ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','1','2','3','4','5','6','7','8','9'],
            
            /**
             * [tips 右下角提示框]
             * @param  {string} title    [提示标题]
             * @param  {string} msg      [提示消息]
             * @param  {string} icon     [图标样式]
             * @param  {integer} timeout  [隐藏时间]
             * @param  {string} showType [展现方式]
             * @return null
             */
            "tips": function(title,msg,icon,timeout,showType){
				$.messager.progress('close');
				var text = []
				text.push('<div class="messager-icon messager-');
				text.push(icon || 'info');
				text.push('"></div>');
				text.push('<div>' + msg + '</div>');
				$.messager.show({
					title: title || '提示信息',
					msg: text.join(''),
					timeout: timeout || 2000,
					showType: showType || 'slide'

				});
			},
            
            /**
             * [random_dialog 随机产生Dialog并返回Dialog元素]
             * @return {string} [随机Dialog ID]
             */
            'random_dialog': function(){
                $("#dialog-box").html();
                var randID = [];
                var Temp = [];
                for(i=0;i<5;i++){
                    Temp = [];
                    for(k=0;k<5;k++){
                        Temp.push($.Admin.char[Math.floor(Math.random()*61)]);
                    }
                    randID.push(Temp.join(''));
                }
                $("#dialog-box").append("<div class='dialog-box' id='"+randID.join('-')+"'></div>");
                return '#'+randID.join('-');
            },
            
            /**
             * [session_timeout 登录超时验证]
             * @return null
             */
            'session_timeout' : function(){
                $.post($(".easyui-layout").attr('data-url'),function(data){
                    if(!data.status){
                        location.href = data.url;
                        return false;
                    }
                    setTimeout('$.Admin.sessionTimeOut()',2000);
                });
            },
            
            /**
             * [load_left_menu 加载左侧菜单]
             * @param  {object} e [菜单元素]
             * @return null
             */
            'load_left_menu' : function(e){
                $(".navbar-button").removeClass("active");
                $(e).addClass("active");
                $('#west').panel({title:$(e).text(),iconCls:'fa fa-user'});
                //加载左侧菜单
                $('#left').tree({
                    queryParams : {'id':$(e).attr('data-id')},
                    url : $(e).attr('data-href'),
                    animate : true,
                    onLoadSuccess : function(node,data){
                        //三级菜单判断
                        if(node){
                            $.Admin.check_left_menu_status(node,data,true);
                        } else {
                            $.Admin.check_left_menu_status(node,data,false);
                        }
                    }
                });
            },
            
            /**
             * [reload_all_left_menu 重载左侧菜单]
             * @return null
             */
            'reload_all_left_menu' : function(){
                $("#left").tree('reload');
            },
            
            /**
             * [collapse_all_left_menu 收缩左侧菜单]
             * @return null
             */
            'collapse_all_left_menu' : function(){
                $("#left").tree('collapseAll');
            },
            
            /**
             * [expand_all_left_menu 展开左侧菜单]
             * @return null
             */
            'expand_all_left_menu' : function(){
                $("#left").tree('expandAll');
            },
            
            /**
             * [check_left_menu_status 校验菜单状态、三级菜单采用Tab组件打开]
             * @param  {object} node   [菜单对象]
             * @param  {object} data   [菜单数据]
             * @param  {boolean} status [布尔值]
             * @return null
             */
            'check_left_menu_status' : function(node,data,status){
                for(x in data){
                    var sonNode = data[x];
                    
                    //校验菜单是否禁用
                    if(!parseInt(sonNode.status) || (node && !parseInt(node.status))){
                        $("#"+sonNode.domId).addClass('tree-node-off');   
                    }
                    
                    //二级菜单样式应用
                    if(!status){
                        $("#"+sonNode.domId).addClass('tree-node-second');   
                    }
                    
                    //三级菜单Tab组件打开
                    if(status && parseInt(sonNode.status)){
                        $("#"+sonNode.domId).removeClass('tree-node-off');   
                        $("#"+sonNode.domId).removeClass('tree-node-second');
                         
                        $("#"+sonNode.domId).click(sonNode,function(sonNode) {
                            $.Admin.open_tabs(sonNode.data.text,sonNode.data.url,sonNode.data.iconCls,sonNode.data.open_type);
                        });
                    }
                }
            },
            
            /**
             * [open_tabs 打开新的Tab窗口]
             * @param  {string} title     [Tabs标题]
             * @param  {string} url       [Tabs链接]
             * @param  {string} iconCls   [图标样式]
             * @param  {integer} open_type [打开方式 0 || 1]
             * @return null
             */
            'open_tabs': function(title, url, iconCls, open_type){
                if($('#layout-tabs').tabs('exists', title)){
                    $('#layout-tabs').tabs('close', title);
                }
    
                var option = {title: title, href: url, iconCls: iconCls, closable: true, cache: true, tools:[{iconCls:'icon-mini-refresh',handler:function(){$.Admin.refresh_tabs();}}]};
                
                //新增Tab组件打开方式 iframe
                if(parseInt(open_type)){
                    var html = [];
                    html.push('<div class="panel-loading" style="position: absolute;width:100%;height:100%;">Loading...</div>');
                    html.push('<iframe width="100%" height="100%" allowtransparency="true" src="' + url + '"');
                    html.push(' style="background-color:transparent;border:none;margin-bottom:-5px;"');
                    html.push(' onload="this.previousSibling.remove()"');
                    html.push('></iframe>');
                    option['content'] = html.join('');
                    option['href']    = null;
                }
    
                $('#layout-tabs').tabs('add', option);
            },
            
            /**
             * [refresh_tabs 刷新已选择的Tabs]
             * @return null
             */
            'refresh_tabs' : function(){
                $("#layout-tabs").tabs('getSelected').panel('refresh');
			},
            
            /**
             * [close_tabs 关闭已选择的Tabs]
             * @return null
             */
            'close_tabs' : function(){
                var tab = $('#layout-tabs').tabs('getSelected');
                var index = $('#layout-tabs').tabs('getTabIndex',tab);
                $("#layout-tabs").tabs('close',index);
            },
            
            /**
             * [del_action 执行删除动作 默认Post]
             * @return null
             */
            'del_action' : function(url,param,type){
                if(!url){
                    $.Admin.tips('警告提示信息', '缺少URL参数，无法进行数据删除','error');
                    return false;
                }
                if(!param){
                    $.Admin.tips('警告提示信息', '您要删除时并未传递任何数据参数','error');
                    return false;
                }
                type = type ? type : 'post';
                
                //ajax提交数据处理
                $.ajax({
                    type: type,
                    url: url,
                    data: param,
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
                        }
                    },
                    error: function(data){
                        $.Admin.tips('错误提示信息', data.responseText,'error');
                    }
                });
            },

            'check_auth' : function(data){
                
                for(x in data){
                    if(!data[x].checked){
                        $("#"+data[x].domId).addClass('tree-status-off');
                    }
                    if(data[x].children.length){
                        $.Admin.check_auth(data[x].children);
                    }
                }
            }
            
        }
        //Admin End

    });
})(jQuery);