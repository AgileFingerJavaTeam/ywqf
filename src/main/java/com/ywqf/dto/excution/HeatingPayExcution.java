package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.HeatingPayEnum;

public class HeatingPayExcution extends BaseAPIExcution{
    public HeatingPayExcution(HeatingPayEnum heatingPayEnum, Object data) {
        this.code = heatingPayEnum.getCode();
        this.data = data;
    }
    public HeatingPayExcution(HeatingPayEnum heatingPayEnum) {
        this.code = heatingPayEnum.getCode();
    }
}
