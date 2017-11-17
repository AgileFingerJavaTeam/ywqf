package com.ywqf.dao;

import com.ywqf.dto.in.ForgetPasswordDto;
import com.ywqf.entity.ResetPassword;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ForgetPasswordDao {
    /**
     * 申请重置密码
     * @param corp_name
     * @param real_name
     * @param phone
     * @return
     */
    public int applyResetPassword(@Param("corp_name") String corp_name, @Param("real_name") String real_name, @Param("phone") String phone);

    /**
     * 通过手机号查询用户ID
     * @param phone
     * @return
     */
    public ResetPassword findUserIdByPhone(@Param("phone") String phone);

    /**
     * 通过用户ID物业Id
     * @param userId
     * @return
     */
    public int findCorpIdByUserId(@Param("userId") int userId);
    public int findCorpId(@Param("userId")int userId);

    /**
     * 通过物业ID查询物业名称
     * @param corpId
     * @return
     */
    public String findCorpNameByCorpId(@Param("corpId") int corpId);
}

