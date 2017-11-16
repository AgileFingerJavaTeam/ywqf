package com.ywqf.controller;

import com.ywqf.base.BaseController;
import com.ywqf.base.BaseUIResult;
import com.ywqf.dto.excution.PayCostExcution;
import com.ywqf.dto.in.PayCostDto;
import com.ywqf.enums.CompanyInforEnum;
import com.ywqf.service.PayCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/payCost")
public class PayCostController extends BaseController{

    @Autowired
    private PayCostService payCostService;

    /**
     * 显示业主缴费查询页面
     * @return
     */
    @RequestMapping(value = "/showPayCost")
    public ModelAndView showPayCost(){
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("propertyPay/showPropertyPay");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mv;
    }


    /*查询物业公司*/
    @RequestMapping(value = "/getPayCost",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getPayCost(){
        try {
            PayCostExcution payCostExcution = payCostService.findPayCost();
            return BaseUIResult.returnJson(payCostExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            PayCostExcution payCostExcution =new PayCostExcution(CompanyInforEnum.FIND_ERROR,e.getMessage());
            return  BaseUIResult.returnJsonEasyUI(payCostExcution);
        }
    }

    /*查询小区*/
    @RequestMapping(value = "/getCommunity",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getCommunity(){
        try {
            PayCostExcution findListCommunity = payCostService.findListCommunity();
            return BaseUIResult.returnJson(findListCommunity);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            PayCostExcution payCostExcution =new PayCostExcution(CompanyInforEnum.FIND_ERROR,e.getMessage());
            return  BaseUIResult.returnJsonEasyUI(payCostExcution);
        }
    }


    /**
     * 查询业主信息和条件物业缴费查询
     * @param payCostDto
     * @return
     */
    @RequestMapping(value = "/getOwnerInfor",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getOwnerInfor(PayCostDto payCostDto){
        try {
            PayCostExcution findOwnerInfor = payCostService.findOwnerInfor(payCostDto);
            return BaseUIResult.returnJson(findOwnerInfor);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            PayCostExcution payCostExcution =new PayCostExcution(CompanyInforEnum.FIND_ERROR,e.getMessage());
            return  BaseUIResult.returnJson(payCostExcution);
        }
    }
}
