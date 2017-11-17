package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.PayCarNumEnum;

public class FreePropertyExcution extends BaseAPIExcution{
	public  FreePropertyExcution(PayCarNumEnum payCarNumEnum,Object data) {
		this.code =payCarNumEnum.getCode();
		this.data =data;
	}
}
