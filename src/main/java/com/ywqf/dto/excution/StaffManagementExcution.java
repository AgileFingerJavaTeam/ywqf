package com.ywqf.dto.excution;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.enums.StaffManagementEnum;

/**
 * Created by Administrator on 2017/11/14 0014.
 */
public class StaffManagementExcution extends BaseAPIExcution {
    public StaffManagementExcution(StaffManagementEnum staffManagementEnum ,Object data) {
        this.code = staffManagementEnum.getCode();
        this.data =data;
    }
}
