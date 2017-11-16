package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.LoginEnum;

public class LoginExcution extends BaseAPIExcution{
    public LoginExcution(LoginEnum loginEnum, Object data) {
        this.code = loginEnum.getCode();
        this.data = data;
    }

    public LoginExcution(LoginEnum loginEnum) {
        this.code = loginEnum.getCode();
    }
}
