package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.HouseCenterEnum;



public class HouseCenterExcution extends BaseAPIExcution{
	public HouseCenterExcution(HouseCenterEnum houseCenterEnum, Object data) {
        this.code = houseCenterEnum.getCode();
        this.data = data;
    }
	public HouseCenterExcution(HouseCenterEnum houseCenterEnum) {
        this.code = houseCenterEnum.getCode();
      
    }
}
