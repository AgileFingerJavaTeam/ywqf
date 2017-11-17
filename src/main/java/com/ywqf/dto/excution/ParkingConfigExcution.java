package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.HouseEnum;
import com.ywqf.enums.ParkingConfigEnum;


public class ParkingConfigExcution extends BaseAPIExcution{
	public ParkingConfigExcution(ParkingConfigEnum parkingConfigEnum, Object data) {
        this.code = parkingConfigEnum.getCode();
        this.data = data;
    }
	public ParkingConfigExcution(ParkingConfigEnum parkingConfigEnum) {
        this.code = parkingConfigEnum.getCode();
      
    }
}
