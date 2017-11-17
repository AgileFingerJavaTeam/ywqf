package com.ywqf.controller;

import com.ywqf.base.BaseController;
import com.ywqf.base.BaseUIResult;
import com.ywqf.dto.excution.StaffManagementExcution;
import com.ywqf.dto.in.StaffManagementDto;
import com.ywqf.enums.StaffManagementEnum;
import com.ywqf.service.StaffManagementService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/11/14 0014.
 */
@Controller
@RequestMapping("/StaffManagement")
public class StaffManagementController extends BaseController{
@Autowired
StaffManagementService staffManagementService;

    @RequestMapping(value = "/showStaff")
    public ModelAndView showCarousePage() {
        ModelAndView mv = new ModelAndView();
        try {
            int id = 1000;
            String name = "燚龘";
            int corp_id = 1000;
            mv.addObject("corp_id", corp_id);
            mv.addObject("Rid", id);
            mv.addObject("Rname",name);
            mv.setViewName("StaffManagement/showStaff");
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return mv;
    }

    /**
     * 查询参数信息
     *
     * @return
     */
    @RequestMapping(value = "/getStaffList",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8") // select
    // 用post，其他sql语句用get
    @ResponseBody
    public String getStaffList(StaffManagementDto staffManagementDto) {
        //参数验空
        try {
            StaffManagementExcution staffManagementExcution = staffManagementService.getStaffList(staffManagementDto);
            return BaseUIResult.returnJsonEasyUI(staffManagementExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            StaffManagementExcution staffManagementExcution = new StaffManagementExcution(StaffManagementEnum.ERROR,e.getMessage());
            return BaseUIResult.returnJsonEasyUI(staffManagementExcution);
        }
    }

    /**
     * 查询参数信息
     *
     * @return
     */
    @RequestMapping(value = "/getRoleList",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8") // select
    // 用post，其他sql语句用get
    @ResponseBody
    public String getRoleList() {
        //参数验空
        try {
            StaffManagementExcution staffManagementExcution = staffManagementService.getRoleList();
            return BaseUIResult.returnJson(staffManagementExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            StaffManagementExcution staffManagementExcution = new StaffManagementExcution(StaffManagementEnum.ERROR,e.getMessage());
            return BaseUIResult.returnJson(staffManagementExcution);
        }
    }

    /**
     * 查询参数信息
     *
     * @return
     */
    @RequestMapping(value = "/insertStaff",
            method = RequestMethod.POST,
            produces = "text/json;charset=UTF-8") // select
    // 用post，其他sql语句用get
    @ResponseBody
    public ModelAndView insertStaff(HttpServletRequest request,@Param("name")String name,
                              @Param("telephone")String telephone,
                              @Param("corp_id")Integer corp_id,
                              @Param("status")Integer status,
                              @Param("avater")MultipartFile avater,
                              @Param("operator")String operator,
                              @Param("role_name")Integer role_name) {
            ModelAndView mv = new ModelAndView();
        //参数验空
        try {
            StaffManagementExcution staffManagementExcution = staffManagementService.insertStaff(request,name,telephone,corp_id,status,avater,operator,role_name);
            mv.setViewName("StaffManagement/showStaff");
            return mv;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            StaffManagementExcution staffManagementExcution = new StaffManagementExcution(StaffManagementEnum.ERROR,e.getMessage());
            return mv;
        }
    }

}
