package com.ywqf.service;

import com.ywqf.dto.excution.StaffManagementExcution;
import com.ywqf.dto.in.StaffManagementDto;

/**
 * Created by Administrator on 2017/11/14 0014.
 */
public interface StaffManagementService {
      //查询数据
      public StaffManagementExcution getStaffList(StaffManagementDto staffManagementDto);
}
