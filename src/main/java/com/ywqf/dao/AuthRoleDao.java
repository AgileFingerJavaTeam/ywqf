package com.ywqf.dao;

import org.apache.ibatis.annotations.Param;

import com.ywqf.entity.AuthRole;

import java.util.List;

/**
 * Created by Administrator on 2017/10/14 0014.
 */
public interface AuthRoleDao {

       public List<AuthRole> findAuthRole(@Param("id") int id);
}
