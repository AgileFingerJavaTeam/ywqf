package com.ywqf.controller;

import com.ywqf.base.BaseController;
import com.ywqf.base.BaseUIResult;
import com.ywqf.dto.excution.EstatePayExcution;
import com.ywqf.dto.excution.HeatingPayExcution;
import com.ywqf.dto.in.HeatingPayDto;
import com.ywqf.enums.EstatePayEnum;
import com.ywqf.enums.HeatingPayEnum;
import com.ywqf.service.HeatingPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/heatingPay")
public class HeatingPayController extends BaseController{
    @Autowired
    HeatingPayService heatingPayService;
    @RequestMapping(value = "/showHeatingPayCheckBillPage",
            produces = {"text/json;charset=UTF-8"})
    public ModelAndView showHeatingPayCheckBillPage(){
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("heatingPay/checkTodayHeatingPay");
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return mv;
    }

    /**
     * 查询当日采暖缴费信息
     * @param heatingPayDto
     * @return
     */
    @RequestMapping(value = "/findHeatingPayInfo",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findHeatingPayInfo(HeatingPayDto heatingPayDto){
        try {
            HeatingPayExcution heatingPayExcution = heatingPayService.findHeatingPayInfo(heatingPayDto);
            return BaseUIResult.returnJson(heatingPayExcution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            HeatingPayExcution heatingPayExcution = new HeatingPayExcution(HeatingPayEnum.FIND_FAIL,e.getMessage());
            return BaseUIResult.returnJson(heatingPayExcution);
        }
    }
}
