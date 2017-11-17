package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.PayYearNumEnum;

public class PayYearResultExcution extends BaseAPIExcution {

	public PayYearResultExcution(PayYearNumEnum payYearNumEnum,Object data) {
		this.code =payYearNumEnum.getCode();
		this.data =data;
	}

}
