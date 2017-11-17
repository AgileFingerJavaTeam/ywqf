package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.ParkingEnum;

public class ParkingExcution extends BaseAPIExcution{
	
	public ParkingExcution(ParkingEnum parkingEnum,Object data){
		this.code = parkingEnum.getCode();
        this.data = data;
	}

}
