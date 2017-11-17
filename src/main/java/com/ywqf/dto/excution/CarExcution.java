package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.PayCarNumEnum;
import com.ywqf.enums.PayYearNumEnum;

public class CarExcution extends BaseAPIExcution{
	public CarExcution(PayCarNumEnum payCarNumEnum,Object data) {
		this.code =payCarNumEnum.getCode();
		this.data =data;
	}
}
