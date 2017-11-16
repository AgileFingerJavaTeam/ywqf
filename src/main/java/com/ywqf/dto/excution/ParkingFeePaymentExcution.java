package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.ParkingFeePaymentEnum;

public class ParkingFeePaymentExcution extends BaseAPIExcution{

	public ParkingFeePaymentExcution(ParkingFeePaymentEnum parkingFeePaymentEnum,Object data) {
		 this.code = parkingFeePaymentEnum.getCode();
		 this.data = data;
	}
	
    
}
