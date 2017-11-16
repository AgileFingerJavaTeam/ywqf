<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="wu-sidebar" data-options="region:'west',split:true,border:true,title:'导航菜单',width:200"> 
 	<div class="easyui-accordion" data-options="border:false,fit:true"> 
     	 <div title="系统管理" data-options="iconCls:'icon-application-cascade'" style="padding:5px;">  	
 		 	<ul class="easyui-tree wu-side-tree">
             	 <li iconCls="icon-laptop-edit"><a href="javascript:void(0)"   data-link="{:U('Goods/goods_info')}" iframe="1">员工及权限管理</a></li>
                 <li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-link="carouselManage/showCarouselPage" iframe="1">首页轮播图管理</a></li>
            	 <li iconCls="icon-laptop-edit"><a href="javascript:void(0)"  data-link="{:U('Goods/goods_info')}" iframe="1">首页精品推荐管理</a></li>
                 <li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-link="{:U('Goods/goods_category')}" iframe="1">首页明星企业logo管理</a></li>
                 <li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-link="home/recommend" iframe="1">首页精品推荐管理</a></li>            
            </ul>
         </div>
         <div title="审批管理" data-options="iconCls:'icon-application-form-edit'" style="padding:5px;">  	
 			 
         </div>
         <div title="精品职位管理" data-options="iconCls:'icon-tag-orange'" style="padding:5px;">  	
 			<ul class="easyui-tree wu-side-tree">
             	 <li iconCls="icon-laptop-edit"><a href="javascript:void(0)" data-icon="icon-laptop-edit" data-link="{:U('Goods/goods_info')}" iframe="0">商品信息</a></li>
                 <li iconCls="icon-chart-organisation"><a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="{:U('Goods/goods_category')}" iframe="0">菜品分类</a></li>
            </ul>
         </div>
         <div title="企业服务" data-options="iconCls:'icon-cart'" style="padding:5px;">  	
 			 
         </div>
         <div title="企业账期管理" data-options="iconCls:'icon-bricks'" style="padding:5px;">  	
 			 
         </div>
         <div title="系统运行监控" data-options="iconCls:'icon-chart-curve'" style="padding:5px;">  	
 			 
         </div>
         <div title="常用报表" data-options="iconCls:'icon-chart-curve'" style="padding:5px;">  	
 			 
         </div>
     </div>
</div>	  