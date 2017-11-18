package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.AuthRoleEnum;
import com.ywqf.enums.CompanyInforEnum;

public class CompanyInforExcution extends BaseAPIExcution{

    public CompanyInforExcution(CompanyInforEnum companyInforEnum, Object data) {
        this.code = companyInforEnum.getCode();
        this.data = data;
    }
    
    public CompanyInforExcution(CompanyInforEnum companyInforEnum) {
        this.code = companyInforEnum.getCode();
    }
}
