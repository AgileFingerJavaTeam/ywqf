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
<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <![endif]-->
    <link rel="stylesheet" type="text/css" href="hui/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="hui/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="hui/lib/Hui-iconfont/1.0.7/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="hui/lib/icheck/icheck.css" />
    <link rel="stylesheet" type="text/css" href="hui/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="hui/static/h-ui.admin/css/style.css" />


</head>



<body>

<!-- 顶部的导航栏 -->
<header class="navbar-wrapper">
    <div class="navbar navbar-fixed-top">
        <div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="/aboutHui.shtml">H-ui.admin</a> <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="/aboutHui.shtml">H-ui</a> <span class="logo navbar-slogan f-l mr-10 hidden-xs">v2.4</span> <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
            <!-- 左侧部分 -->
            <nav class="nav navbar-nav">
                <ul class="cl">
                    <li class="dropDown dropDown_hover"><a href="javascript:;" class="dropDown_A"><i class="Hui-iconfont">&#xe600;</i> 新增 <i class="Hui-iconfont">&#xe6d5;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:;" onclick="article_add('添加资讯','article-add.html')"><i class="Hui-iconfont">&#xe616;</i> 资讯</a></li>
                            <li><a href="javascript:;" onclick="picture_add('添加资讯','picture-add.html')"><i class="Hui-iconfont">&#xe613;</i> 图片</a></li>
                            <li><a href="javascript:;" onclick="product_add('添加资讯','product-add.html')"><i class="Hui-iconfont">&#xe620;</i> 产品</a></li>
                            <li><a href="javascript:;" onclick="member_add('添加用户','member-add.html','','510')"><i class="Hui-iconfont">&#xe60d;</i> 用户</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
            <!-- 右侧部分 -->
            <nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
                <ul class="cl">
                    <li>超级管理员</li>
                    <li class="dropDown dropDown_hover"> <a href="#" class="dropDown_A">admin <i class="Hui-iconfont">&#xe6d5;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="#">个人信息</a></li>
                            <li><a href="#">切换账户</a></li>
                            <li><a href="#">退出</a></li>
                        </ul>
                    </li>
                    <li id="Hui-msg"> <a href="#" title="消息"><span class="badge badge-danger">1</span><i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i></a> </li>
                    <li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
                            <li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
                            <li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
                            <li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
                            <li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
                            <li><a href="javascript:;" data-val="orange" title="绿色">橙色</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header>

<!-- 侧边菜单栏 -->
<aside class="Hui-aside">
    <input runat="server" id="divScrollValue" type="hidden" value="" />
    <div class="menu_dropdown bk_2">
        <dl id="main">
            <dt><a _href="" data-title="首页" href="javascript:void(0)">首页</a></dt>
        </dl>
        <dl id="Property-Config">
            <dt><a _href="" data-title="物业配置" href="javascript:void(0)">物业配置</a></dt>
        </dl>
        <dl id="menu-product">
            <dt>小区配置<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul class="pull-right">
                    <li><a _href="house/housePage" data-title="房屋（业主）配置管理" href="javascript:;">房屋（业主）配置管理</a></li>
                    <li><a _href="parkingConfig/parkingPage" data-title="车位配置管理" href="javascript:void(0)">车位配置管理</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-comments">
            <dt>物业费<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a _href="PropertyFeePayment/showProperty" data-title="缴费" href="javascript:;">缴费</a></li>
                    <li><a _href="estatePay/showEstatePayCheckBillPage" data-title="缴费情况当日对账" href="javascript:void(0)">缴费情况当日对账</a></li>
                    <li><a _href="payCost/showPayCost" data-title="业主缴费查询" href="javascript:void(0)">业主缴费查询</a></li>
                    <li><a _href="estatePay/getEstatePayQueryList" data-title="月度缴费/欠费查询" href="javascript:void(0)">月度缴费/欠费查询</a></li>
                    <li><a _href="payYearNum/list" data-title="年度汇总" href="javascript:void(0)">年度汇总</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-member">
            <dt>车位费<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a _href="PropertyFeePayment/showProperty" data-title="缴费" href="javascript:;">缴费</a></li>
                    <li><a _href="parkingPay/showParkingPayCheckBillPage" data-title="缴费情况当日对账" href="javascript:;">缴费情况当日对账</a></li>
                    <li><a _href="parkingPay/showParkingPay" data-title="车位缴费查询" href="javascript:;">车位缴费查询</a></li>
                    <li><a _href="parking/getParkingList" data-title="月度缴费/欠费查询" href="javascript:void(0)">月度缴费/欠费查询</a></li>
                    <li><a _href="payCarNum/list" data-title="年度汇总" href="javascript:void(0)">年度汇总</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="menu-admin">
            <dt>采暖费<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a _href="heatingPrefeTreat/showHeatingPrefeTreat" data-title="优惠设置" href="javascript:void(0) ">优惠设置</a></li>
                    <li><a _href="PropertyFeePayment/showProperty" data-title="缴费" href="javascript:void(0);">缴费</a></li>
                    <li><a _href="heatingPay/showHeatingPayCheckBillPage" data-title="缴费情况当日对账" href="javascript:void(0)">缴费情况当日对账</a></li>
                    <li><a _href="heating/getHeatintList" data-title="年度缴费/欠费查询汇总" href="javascript:void(0)">年度缴费/欠费查询汇总</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="repair">
            <dt><a _href="newsHall/showNewsHallPage" style = "text-decoration: none" data-title="维修" href=" "> 维修</a></dt>
        </dl>
        <dl id="menu-system">
            <dt><a _href="newsHall/showNewsHallPage" style = "text-decoration: none" data-title="消息大厅" href="javascript:void(0)">消息大厅</a></dt>
        </dl>
        <dl id="hosue-ask">
            <dt><a _href="HouseCenter/AskForPage" style = "text-decoration: none" data-title="房产中心-求租求购" href="javascript:void(0) ">房产中心-求租求购</a></dt>
        </dl>

        <dl id="house-speculative">
            <dt><a _href="HouseCenter/RentSalePage" style = "text-decoration: none" data-title="房产中心-出租出售" href=" javascript:void(0)">房产中心-出租出售</a></dt>
        </dl>
        <dl id="ChargeStandard-manage">
            <dt>收费标准管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a _href="" data-title="物业费" href="javascript:void(0)">物业费</a></li>
                    <li><a _href="" data-title="车位费" href="javascript:void(0)">车位费</a></li>
                    <li><a _href="" data-title="采暖费" href="javascript:void(0)">采暖费</a></li>
                </ul>
            </dd>
        </dl>
        <dl id="company-manager">
            <dt><a _href="CompanyInfor/showCompanyInfor" data-title="公司信息管理" href="javascript:void(0)">公司信息管理</a></dt>
        </dl>
        <dl id="menu-account">
            <dt>我的账户<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a _href="myAccount/acountList" data-title="修改登录密码" href="javascript:void(0)">修改登录密码</a></li>
                    <li><a _href="myAccount/changePhoneList" data-title="修改绑定手机" href="javascript:void(0)">修改绑定手机</a></li>
                </ul>
            </dd>
        </dl>
    </div>
</aside>

<!-- 侧边栏箭头 -->
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>

<section class="Hui-article-box">
    <div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
        <div class="Hui-tabNav-wp">
            <ul id="min_title_list" class="acrossTab cl">
                <li class="active"><span title="我的桌面" data-href="aaa.html">我的桌面</span><em></em></li>
            </ul>
        </div>
        <div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
    </div>
    <div id="iframe_box" class="Hui-article">
        <div class="show_iframe">
            <div style="display:none" class="loading"></div>
            欢迎进入管理系统
            <iframe scrolling="yes" frameborder="0" src=""></iframe>
        </div>
    </div>
</section>
<script type="text/javascript" src="hui/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="hui/lib/layer/2.1/layer.js"></script>
<script type="text/javascript" src="hui/lib/icheck/jquery.icheck.min.js"></script>
<script type="text/javascript" src="hui/lib/jquery.validation/1.14.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="hui/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="hui/lib/jquery.validation/1.14.0/messages_zh.min.js"></script>
<script type="text/javascript" src="hui/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="hui/static/h-ui.admin/js/H-ui.admin.js"></script>

</body>
</html>
