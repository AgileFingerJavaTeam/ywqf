<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/png" href="i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="Fontawesome/css/amazeui.min.css" />
    <link rel="stylesheet" href="Fontawesome/css/admin.css">
    <link rel="stylesheet" href="Fontawesome/css/app.css">
    <title>申请重置密码界面</title>
</head>
<body data-type="resetPassword">
<div class="am-g myapp-login">
    <div class="myapp-login-logo-block  tpl-login-max">
        <div class="myapp-login-logo-text">
            <div class="myapp-login-logo-text">
               <span> 找回密码</span> <i class="am-icon-skyatlas"></i>
            </div>
        </div>
        <div class="am-u-sm-10 login-am-center ">
            <form class="am-form" id="reset_password_form">
                <fieldset>
                    <div class="am-form-group" >
                        <input type="text" name="corp_name" id="corp_name" style="margin-top:10px;border-radius:6px" placeholder="输入公司名称" required/>
                    </div>
                    <div class="am-form-group" >
                        <input type="text" name="real_name" id="real_name" style="margin-top:10px;border-radius:6px" placeholder="输入姓名" required/>
                    </div>
                    <div class="am-form-group inputPhone">
                        <input type="text" name="phone" id="phone" style="margin-top:10px;border-radius:6px" placeholder="输入手机号" required/>
                    </div>
                    <p>
                        <button type="button" class="am-btn am-btn-default" id="resetPassword">申请重置</button></p>
                </fieldset>
            </form>
        </div>
    </div>
</div>
<div class="am-modal am-modal-confirm" tabindex="-1" id="my-confirm">
    <div class="am-modal-dialog">
        <div class="am-modal-bd">
            您输入的信息与系统录入信息不符
        </div>
        <div class="am-modal-footer">
            <span class="am-modal-btn" data-am-modal-confirm>确定</span>
        </div>
    </div>
</div>
<div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
    <div class="am-modal-dialog">
        <div class="am-modal-bd">
            输入不能为空
        </div>
        <div class="am-modal-footer">
            <span class="am-modal-btn">确定</span>
        </div>
    </div>
</div>
<script type="text/javascript" src="scripts/jquery.min.js"></script>
<script type="text/javascript" src="scripts/amazeui.min.js"></script>
<script type="text/javascript" src="scripts/app.js"></script>
<script type="text/javascript">
    $(function(){
        $('#resetPassword').click(function(){
            var corp_name= $("#corp_name").val();
            var real_name= $("#real_name").val();
            var phone= $("#phone").val();
            if (corp_name ==null||corp_name == ''){
                $('#my-alert').modal({
                    relatedTarget: this,
                    onConfirm: function() {
                     return false
                    },
                });

            }else if(real_name== null||real_name == ''){
                $('#my-alert').modal({
                    relatedTarget: this,
                    onConfirm: function() {
                        return false
                    },
                });
            }else if (phone == null ||phone == ''){
                $('#my-alert').modal({
                    relatedTarget: this,
                    onConfirm: function() {
                        return false
                    },
                });
            }else{
                $.ajax({
                    type:"POST",
                    url:"ForgetPassword/applyResetPassword",
                    dataType:"json",
                    data:{"corp_name":corp_name,"real_name":real_name,"phone":phone},// 你的formid
                    success: function(data) {
//                    console.log(data)
                        if(data.status==-1){
                            //     alert(data.info);
                            $('#my-confirm').modal({
                                relatedTarget: this,
                                onConfirm: function() {
                                    window.location.href="ForgetPassword/showForgetPasswordPage";
                                },
                            });
                            return;
                        }
                        window.location.href="login/login";
                    }
                })
            }


        })
    })
    //---------提示框插件
    $(function() {
        $('#reset_password_form').validator({
            onValid: function(validity) {
                $(validity.field).closest('.am-form-group').find('.am-alert').hide();
            },
            onInValid: function(validity) {
                var $field = $(validity.field);
                var $group = $field.closest('.am-form-group');
                var $alert = $group.find('.am-alert');
                // 使用自定义的提示信息 或 插件内置的提示信息
                var msg = $field.data('validationMessage') || this.getValidationMessage(validity);

                if (!$alert.length) {
                    $alert = $('<div class="am-alert am-alert-danger"></div>').hide().
                    appendTo($group);
                }
                $alert.html(msg).show();
            }
        });
    });
    //-----点击申请时提示不能为空

</script>
</body>
</html>