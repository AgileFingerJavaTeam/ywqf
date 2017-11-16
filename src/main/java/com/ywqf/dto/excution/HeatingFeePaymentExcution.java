package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.HeatingFeePaymentEnum;

public class HeatingFeePaymentExcution extends BaseAPIExcution{

	public HeatingFeePaymentExcution(HeatingFeePaymentEnum heatingFeePaymentEnum,Object data){
		this.code = heatingFeePaymentEnum.getCode();
		this.data = data;
	}
}
