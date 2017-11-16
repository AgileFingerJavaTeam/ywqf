package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.CompanyInforEnum;

public class HeatingPrefeTreatExcution extends BaseAPIExcution{

    public HeatingPrefeTreatExcution(CompanyInforEnum companyInforEnum, Object data) {
        this.code = companyInforEnum.getCode();
        this.data = data;
    }

    public HeatingPrefeTreatExcution(CompanyInforEnum companyInforEnum) {
        this.code = companyInforEnum.getCode();
    }
}
