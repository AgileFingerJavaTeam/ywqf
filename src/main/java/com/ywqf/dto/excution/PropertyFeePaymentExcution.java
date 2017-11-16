package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.PropertyFeePaymentEnum;

public class PropertyFeePaymentExcution extends BaseAPIExcution{

	public PropertyFeePaymentExcution(PropertyFeePaymentEnum propertyFeePaymentEnum , Object data) {
	    this.code = propertyFeePaymentEnum.getCode();
	    this.data = data ;
	}
	
   
}
