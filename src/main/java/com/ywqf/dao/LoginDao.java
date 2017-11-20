package com.ywqf.dao;

import com.ywqf.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 查询角色id
     * @param user_id
     * @return
     */
    public List<RoleId> findId(@Param("user_id") int user_id);

    /**
     * 查询权限id
     * @param role_id
     * @return
     */
    public List<AclId> findAclId(@Param("role_id") int role_id);

    /**
     * 查询权限信息
     * @param acl_id
     * @return
     */
    public List<Module> findAcl(@Param("acl_id") int acl_id);
}
