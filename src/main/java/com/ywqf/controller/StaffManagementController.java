package com.ywqf.controller;

import com.ywqf.base.BaseController;
import com.ywqf.base.BaseUIResult;
import com.ywqf.dto.excution.StaffManagementExcution;
import com.ywqf.dto.in.StaffManagementDto;
import com.ywqf.enums.StaffManagementEnum;
import com.ywqf.service.StaffManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
}
