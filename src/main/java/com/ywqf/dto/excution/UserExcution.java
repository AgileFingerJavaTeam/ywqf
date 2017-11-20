package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.UserEnum;

public class UserExcution extends BaseAPIExcution{
	public UserExcution(UserEnum eUserEnum,Object data){
		this.code = eUserEnum.getCode();
        this.data = data;
	}
}
