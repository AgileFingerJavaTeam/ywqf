package com.ywqf.dao;

import com.ywqf.entity.StaffManagement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/11/15 0015.
 */
public interface StaffManagementDao {
    //遍历数据
   public List<StaffManagement> findParkingList();
    //遍历角色表
   public List<StaffManagement> findRoleList();

   public int insertStaff(@Param("name") String name,
                          @Param("telephone") String telephone,
                          @Param("corp_id") Integer corp_id,
                          @Param("status") Integer status,
                          @Param("path") String path,
                          @Param("operator") String operator,
                          @Param("role_name") Integer role_name);
}
