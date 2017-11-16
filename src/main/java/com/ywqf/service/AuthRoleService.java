package com.ywqf.service;

import com.ywqf.dto.excution.AuthRoleExcution;
import com.ywqf.dto.in.AuthRoleDto;

/**
 * Created by Administrator on 2017/10/14 0014.
 */
public interface AuthRoleService {

       public AuthRoleExcution AuthRole (AuthRoleDto authRoleDto);
}
