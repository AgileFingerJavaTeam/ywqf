package com.ywqf.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ywqf.dao.AuthRoleDao;
import com.ywqf.dto.excution.AuthRoleExcution;
import com.ywqf.dto.in.AuthRoleDto;
import com.ywqf.enums.AuthRoleEnum;
import com.ywqf.service.AuthRoleService;
import com.ywqf.entity.AuthRole;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/14 0014.
 */
@Service
public class AuthRoleServiceImpl implements AuthRoleService{

    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public AuthRoleDao authRoleDao;



    public AuthRoleExcution AuthRole(AuthRoleDto authRoleDto) {
              int id = authRoleDto.getId();
              
        try {
            List<AuthRole> list = authRoleDao.findAuthRole(id);
            if (list == null) {
                list = new ArrayList<AuthRole>();
            }
            return new AuthRoleExcution(AuthRoleEnum.SUCCESS,list);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            
        }
		return null;
    }


}
