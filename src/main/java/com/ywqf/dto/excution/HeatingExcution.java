package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.HeatingEnum;

public class HeatingExcution extends BaseAPIExcution{
	public HeatingExcution(HeatingEnum heatingEnum,Object data){
		this.code = heatingEnum.getCode();
		this.data = data;
		
	}

}
