package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.CompanyInforEnum;

public class PayCostExcution extends BaseAPIExcution{

    public PayCostExcution(CompanyInforEnum companyInforEnum, Object data) {
        this.code = companyInforEnum.getCode();
        this.data = data;
    }
    
    public PayCostExcution(CompanyInforEnum companyInforEnum) {
        this.code = companyInforEnum.getCode();
    }
}
