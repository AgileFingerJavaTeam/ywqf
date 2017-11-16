package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.EstatePayEnum;
import com.ywqf.enums.ForgetPasswordEnum;

public class EstatePayExcution extends BaseAPIExcution{
    public EstatePayExcution(EstatePayEnum estatePayEnum, Object data) {
        this.code = estatePayEnum.getCode();
        this.data = data;
    }
    public EstatePayExcution(EstatePayEnum estatePayEnum) {
        this.code = estatePayEnum.getCode();
    }
}
