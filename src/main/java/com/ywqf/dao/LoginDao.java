package com.ywqf.dao;

import com.ywqf.entity.Login;
import com.ywqf.entity.Session;
import org.apache.ibatis.annotations.Param;

public interface LoginDao {
    /**
     * 验证账号密码
     * @param telephone
     * @param password
     * @return
     */
    public Login findUsernamePwd(@Param("telephone") String telephone,
                                 @Param("password") String password);


    /**
     * 查询物业公司信息
     * @param corp_id
     * @return
     */
    public Session findSession(@Param("corp_id") int corp_id);


}
