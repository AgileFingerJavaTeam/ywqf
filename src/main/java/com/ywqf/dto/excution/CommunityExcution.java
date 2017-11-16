package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.PayYearNumEnum;

public class CommunityExcution extends BaseAPIExcution{
	public CommunityExcution(PayYearNumEnum payYearNumEnum,Object data) {
		this.code =payYearNumEnum.getCode();
		this.data =data;
	}
}
