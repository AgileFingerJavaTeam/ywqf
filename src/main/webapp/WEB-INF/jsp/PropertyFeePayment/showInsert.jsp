<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../common/meta.jsp" %>
<%-- 自定义css样式 --%>
<meta charset="UTF-8">
<meta content="text/html">

<form action="PropertyFeePayment/insertProperty" class="table_form"
	method="post">
	<table class="table" align="center"  style="width:700px;height: 500px;">
		 <tr>
             <td style="text-align: right;">单号</td>
             <td><input type="text"  name="estate_pay_num"  class="input-text" placeholder="请输入单号" required:true;></td>

             <td style="display: none;"><input type="text" class="easyui-textbox" name="corp_id" id="corp_id" value="${corp_id}" required /></td>
             <td style="display: none;"><input type="text" class="easyui-textbox" name="id" id="id" value="${id}" required /></td>
             <td style="display: none;"><input type="text" class="easyui-textbox" name="operator" id="name" value="${name}" required /></td>
        </tr>
         <tr>
             <td style="text-align: right;">小区</td>
             <td><input type="text" class="easyui-combobox" id="community_name"  name="community_id" required ></td>
        </tr>
		 <tr>
             <td style="text-align: right;">门牌号</td>
             <td><input type="text" class="input-text" id="house_num"  name="house_num" placeholder="请输入门牌号" required /></td>
        </tr>
	 	 <tr>
             <td style="text-align: right;">业主</td>
             <td><input type="text" class="input-text" id="owner_name"  name="owner_name" readonly="readonly" /></td>
        </tr>
         <tr>
             <td style="text-align: right;">面积</td>
             <td><input type="text" class="input-text" id="area" name="area"  readonly="readonly"/></td>
        </tr>
		 <tr>

             <td style="text-align: right;">缴纳月数</td>
             <td><input class="input-text" id="pay_month_type_id" name="pay_month_type_id" style="width:187px;" required>
             </td>
        </tr>
         <tr>
             <td style="text-align: right;">单价</td>
             <td><input type="text" class="input-text" id="estate_unit_price"  name="estate_unit_price"  required /></td>
        </tr>
         <tr>
             <td style="text-align: right;">服务起始日期</td>
             <td><input class= "easyui-datetimebox" id="sd" name="service_start_date"     
        data-options="onSelect:onSelect"  style="width:187px" value="9/1/2017 0:0"/></td>
        </tr>
         <tr>
             <td style="text-align: right;">服务截止日期</td>
             <td><input class= "easyui-datetimebox" id="ed" name="service_end_date"     
        data-options="onSelect:onSelect"  style="width:187px" value="10/1/2017 25:59"/></td>
        </tr>
         <tr>
             <td style="text-align: right;">缴纳金额</td>
             <td><input type="text" class="input-text" id="payment_amount"  name="payment_amount" readonly="readonly" /></td>
        </tr>
         <tr>
             <td style="text-align: right;">收费员工</td>
             <td><input type="text" class="easyui-combobox" id="charge_worker_id"  name="charge_worker_id" required /></td>
        </tr>
         <tr>
             <td style="text-align: right;">缴费日期</td>
             <td><input class="easyui-datetimebox" id="pay_date" name="pay_date"     
        data-options="required:true,showSeconds:false,value:'now()'"  style="width:187px">  </td>
        </tr>
		 <tr>
			 <td colspan="4">
				<button type="button" class="table_form_close_dialog "
					style="float: right">关闭</button>
				<button type="button" class="table_form_submit_dialog"
					style="float: right">确定</button>
			</td>	
		</tr>
	</table>
</form>
<script>
	
	function onSelect(d) {
    var issd = this.id == 'sd', sd = issd ? d : new Date($('#sd').datebox('getValue')), ed = issd ? new Date($('#ed').datebox('getValue')) : d;
        if (ed < sd) {
        	$.messager.show({
                  title:'注意',
                  msg:'截止日期小于起始日期'
              });
            //只要选择了日期，不管是开始或者结束都对比一下，如果结束小于开始，则清空结束日期的值并弹出日历选择框
            $('#ed').datebox('setValue', '').datebox('showPanel');
        }
    }

	
    //遍历小区
	var a = $('#corp_id').val();
	$('#community_name').combobox({
		url:'PropertyFeePayment/findVillage',
		method:'get',
		valueField:'id',
		textField:'communityName',
		queryParams: {'corp_id': a},
		panelHeight:'auto',
		'onChange':function(){
			var comId = $('#community_name').val();
			$('#house_num').combobox({
				url:'PropertyFeePayment/findListHouseNumber',
				method:'POST',
				valueField:'houseNum',
				textField:'houseNum',
				queryParams: {'community_id': comId},
				panelHeight:'auto',
				'onChange':function(){
					var house_nums = $('#house_num').val();
					var house_num = {};
					house_num.house_num = house_nums;
					$.ajax({
						   type:'post',
					       data:house_num,
					       url: "PropertyFeePayment/findAreaOrMoneyOrName",
					       datatype:'json',
					       success:function(data){
					       $('#owner_name').textbox('setValue',data.ownerName);
					       $('#area').textbox('setValue',data.area);
					       $('#estate_unit_price').textbox('setValue',data.nowEstateUnitPrice);
					    }
					})
				}
			})
		}
		
	});
	
	$('#pay_month_type_id').numberspinner({
		'onChange':function(){
		var month = $('#pay_month_type_id').val();
		var price = $('#estate_unit_price').val();
		var premiumReceived = month * price ;
		$('#payment_amount').textbox('setValue',premiumReceived);
		}
	})
/* 	
	 */
	
	$('#charge_worker_id').combobox({
		url:'PropertyFeePayment/findAccount',
		method:'get',
		valueField:'id',
		textField:'account',
		panelHeight:'auto',
		
	});
	
	
	
</script>



