<<<<<<< HEAD
package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.UserEnum;

public class UserExcution extends BaseAPIExcution{
	public UserExcution(UserEnum eUserEnum,Object data){
		this.code = eUserEnum.getCode();
        this.data = data;
	}
}
=======
package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.UserEnum;

public class UserExcution extends BaseAPIExcution{
	public UserExcution(UserEnum eUserEnum,Object data){
		this.code = eUserEnum.getCode();
        this.data = data;
	}
}
>>>>>>> 9c99b64c33e4de793abd5f59e1d05f6f926718dd
