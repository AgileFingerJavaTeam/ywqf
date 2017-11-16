package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.PayYearNumEnum;

public class CorpExcution extends BaseAPIExcution {
	public CorpExcution(PayYearNumEnum payYearNumEnum,Object data) {
		this.code =payYearNumEnum.getCode();
		this.data =data;
	}
}
