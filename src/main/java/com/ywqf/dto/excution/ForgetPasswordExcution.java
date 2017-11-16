package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.base.BaseException;
import com.ywqf.enums.ForgetPasswordEnum;

public class ForgetPasswordExcution extends BaseAPIExcution{
    public ForgetPasswordExcution(ForgetPasswordEnum forgetPasswordEnum, Object data) {
        this.code = forgetPasswordEnum.getCode();
        this.data = data;
    }
    public ForgetPasswordExcution(ForgetPasswordEnum forgetPasswordEnum) {
        this.code = forgetPasswordEnum.getCode();
    }
}
