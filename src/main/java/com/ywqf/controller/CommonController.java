package com.ywqf.controller;


import com.ywqf.base.BaseController;
import com.ywqf.dto.excution.AuthRoleExcution;
import com.ywqf.dto.in.AuthRoleDto;
import com.ywqf.entity.AuthRole;
import com.ywqf.enums.AuthRoleEnum;
import com.ywqf.service.AuthRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/10/14 0014.
 */
@Controller
@RequestMapping(value = "/common")
public class CommonController extends BaseController{
    @Autowired
    private AuthRoleService authRoleService;

    @SuppressWarnings("unused")
    @RequestMapping(value = "/getSonMenu",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object getSonMenu(AuthRoleDto authRoleDto){
           HttpSession authSession = this.getRequest().getSession();

        try {
           AuthRoleExcution authRoleExcution = authRoleService.AuthRole(authRoleDto);
           List<AuthRole> list = (List<AuthRole>) authRoleExcution.getData();
           List<AuthRole> authList = (List<AuthRole>) authSession.getAttribute("list");
           for (AuthRole object : list) {
               if ("closed".equals(object.getState())) {
                   if (object.getLevel() == 3) {
                       object.setState("open");
                   } else {
                       object.setState("closed");
                   }
               }
           }
           return  list;
       }catch (Exception e) {
            logger.error(e.getMessage(), e);
            AuthRoleExcution authRoleExcution = new AuthRoleExcution(AuthRoleEnum.FAIL,e.getMessage());            
        }
		return authSession;
    }
}
