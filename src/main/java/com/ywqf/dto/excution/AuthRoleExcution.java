package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.AuthRoleEnum;

/**
 * Created by Administrator on 2017/10/14 0014.
 */
public class AuthRoleExcution extends BaseAPIExcution{

    public AuthRoleExcution(AuthRoleEnum authRoleEnum, Object data) {
        this.code = authRoleEnum.getCode();
        this.data = data;
    }
}
