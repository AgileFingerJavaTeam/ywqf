package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.EstatePayEnum;
import com.ywqf.enums.ResetPasswordEnum;

public class ResetPasswordExcution extends BaseAPIExcution{
    public ResetPasswordExcution(ResetPasswordEnum resetPasswordEnum, Object data) {
        this.code = resetPasswordEnum.getCode();
        this.data = data;
    }
    public ResetPasswordExcution(ResetPasswordEnum resetPasswordEnum) {
        this.code = resetPasswordEnum.getCode();
    }
}
