package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.CompanyInforEnum;

public class ParkingPayExcution extends BaseAPIExcution{

    public ParkingPayExcution(CompanyInforEnum companyInforEnum, Object data) {
        this.code = companyInforEnum.getCode();
        this.data = data;
    }

    public ParkingPayExcution(CompanyInforEnum companyInforEnum) {
        this.code = companyInforEnum.getCode();
    }
}
