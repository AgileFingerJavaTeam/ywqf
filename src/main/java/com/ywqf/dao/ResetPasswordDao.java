package com.ywqf.dao;

import com.ywqf.entity.ResetPassword;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResetPasswordDao {
    /**
     * 查询申请重置密码信息
     * @param searchResetApplyInfo
     * @return
     */
    public List<ResetPassword> findApplyResetPasswordInfo (@Param("searchResetApplyInfo")String searchResetApplyInfo,@Param("checkBoxType")String checkBoxType);

    /**
     * 重置密码
     * @param phone
     * @return
     */
    public int resetPassword (@Param("phone") String phone);

    /**
     * 修改申请重置密码操作状态
     * @return
     */
    public int changeApplyStatus(@Param("phone") String phone);
}
