package com.ywqf.controller;

import com.ywqf.base.BaseController;
import com.ywqf.base.BaseUIResult;
import com.ywqf.dto.excution.LoginExcution;
import com.ywqf.dto.excution.PayCostExcution;
import com.ywqf.dto.in.LoginDto;
import com.ywqf.dto.in.PayCostDto;
import com.ywqf.enums.CompanyInforEnum;
import com.ywqf.service.LoginService;
import com.ywqf.service.ParkingPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/login")
public class LoginController extends BaseController{
    @Autowired
    private LoginService loginService;

    /**
     * 显示业主车位缴费查询页面
     * @return
     */
    @RequestMapping(value = "/login")
    public ModelAndView showLogin(){
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("login/login");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mv;
    }

    @RequestMapping(value = "/getSession",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getSession(LoginDto loginDto){
        try {
            LoginExcution findSession = loginService.findSession(loginDto);
            return BaseUIResult.returnJson(findSession);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            PayCostExcution payCostExcution =new PayCostExcution(CompanyInforEnum.FIND_ERROR,e.getMessage());
            return  BaseUIResult.returnJson(payCostExcution);
        }
    }
}
