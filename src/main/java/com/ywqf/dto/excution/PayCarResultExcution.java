package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.PayCarNumEnum;

public class PayCarResultExcution extends BaseAPIExcution {

	public PayCarResultExcution(PayCarNumEnum payCarNumEnum,Object data) {
		this.code =payCarNumEnum.getCode();
		this.data =data;
	}

}
