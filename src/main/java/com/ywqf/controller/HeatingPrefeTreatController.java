package com.ywqf.controller;

import com.ywqf.base.BaseController;
import com.ywqf.base.BaseUIResult;
import com.ywqf.dto.excution.HeatingPrefeTreatExcution;
import com.ywqf.dto.in.HeatingPrefeTreatDto;
import com.ywqf.enums.CompanyInforEnum;
import com.ywqf.service.HeatingPrefeTreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/heatingPrefeTreat")
public class HeatingPrefeTreatController extends BaseController{

    @Autowired
    private HeatingPrefeTreatService heatingPrefeTreatService;

    /**
     * 显示业主缴费查询页面
     * @return
     */
    @RequestMapping(value = "/showHeatingPrefeTreat")
    public ModelAndView showHeatingPrefeTreat(){
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("heatingPrefeTreat/showHeatingPrefeTreat");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mv;
    }

    /*查询采暖优惠政策*/
    @RequestMapping(value = "/getHeatingPrefeTreat",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getHeatingPrefeTreat(){
        try {
            HeatingPrefeTreatExcution findHeatingPrefeTreat = heatingPrefeTreatService.findHeatingPrefeTreat();
            return BaseUIResult.returnJson(findHeatingPrefeTreat);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            HeatingPrefeTreatExcution heatingPrefeTreatExcution = new HeatingPrefeTreatExcution(CompanyInforEnum.FIND_ERROR,e.getMessage());
            return  BaseUIResult.returnJson(heatingPrefeTreatExcution);
        }
    }

    /*添加采暖优惠政策*/
    @RequestMapping(value = "/addHeatingPrefeTreat",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String addHeatingPrefeTreat(HeatingPrefeTreatDto heatingPrefeTreatDto){
        try {
            HeatingPrefeTreatExcution addHeatingPrefeTreat = heatingPrefeTreatService.addHeatingPrefeTreat(heatingPrefeTreatDto);
            return BaseUIResult.returnJsonMSG(1,addHeatingPrefeTreat,"添加成功！");
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            HeatingPrefeTreatExcution heatingPrefeTreatExcution = new HeatingPrefeTreatExcution(CompanyInforEnum.FIND_ERROR,e.getMessage());
            return BaseUIResult.returnJsonMSG(1,heatingPrefeTreatExcution,"添加失败！");
        }
    }

}
