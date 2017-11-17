package com.ywqf.service;

import com.ywqf.dto.excution.StaffManagementExcution;
import com.ywqf.dto.in.StaffManagementDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/11/14 0014.
 */
public interface StaffManagementService {
      //查询数据
      public StaffManagementExcution getStaffList(StaffManagementDto staffManagementDto);
      //遍历角色
      public StaffManagementExcution getRoleList();
      //添加
      public StaffManagementExcution insertStaff(HttpServletRequest request, @Param("name") String name,
                                                 @Param("telephone") String telephone,
                                                 @Param("corp_id") Integer corp_id,
                                                 @Param("status") Integer status,
                                                 @Param("avater") MultipartFile avater,
                                                 @Param("operator") String operator,
                                                 @Param("role_name") Integer role_name);
}
