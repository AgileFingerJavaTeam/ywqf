package com.ywqf.controller;

import com.ywqf.base.BaseController;
import com.ywqf.base.BaseUIResult;
import com.ywqf.dto.excution.ParkingPayExcution;
import com.ywqf.dto.excution.PayCostExcution;
import com.ywqf.dto.in.ParkingPayDto;
import com.ywqf.enums.CompanyInforEnum;
import com.ywqf.service.ParkingPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/parkingPay")
public class ParkingPayController extends BaseController {
    /**
     * 显示车位当日缴费对账页面
     */
    @Autowired
    ParkingPayService parkingPayService;
    @RequestMapping(value = "/showParkingPayCheckBillPage",
            produces = {"text/json;charset=UTF-8"})
    public ModelAndView showParkingPayPage(){
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("parkingPay/checkTodayParkingPay");
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return mv;
    }

    /**
     * 查询当日车位缴费信息（苏瑞涛）
     * @param parkingPayDto
     * @return
     */
    @RequestMapping(value = "/findParkingPayInfo",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findParkingPayInfo(ParkingPayDto parkingPayDto){
        try {
            ParkingPayExcution parkingPayExcution = parkingPayService.findParkingPayInfo(parkingPayDto);
            return BaseUIResult.returnJson(parkingPayExcution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            ParkingPayExcution parkingPayExcution = new ParkingPayExcution(CompanyInforEnum.FIND_ERROR,e.getMessage());
            return BaseUIResult.returnJson(parkingPayExcution);
        }
    }

    //郭阳代码
    /**
     * 显示业主车位缴费查询页面
     * @return
     */
    @RequestMapping(value = "/showParkingPay")
    public ModelAndView showParkingPay(){
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("parkingPayment/showParkingPayment");
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
            ParkingPayExcution payCostExcution = parkingPayService.findPayCost();
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
            ParkingPayExcution findListCommunity = parkingPayService.findListCommunity();
            return BaseUIResult.returnJson(findListCommunity);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            PayCostExcution payCostExcution =new PayCostExcution(CompanyInforEnum.FIND_ERROR,e.getMessage());
            return  BaseUIResult.returnJsonEasyUI(payCostExcution);
        }
    }

    /**
     * 查询业主信息和车位缴费状态
     * @param parkingPayDto
     * @return
     */
    @RequestMapping(value = "/findParkingPay",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findParkingPay(ParkingPayDto parkingPayDto){
        try {
            ParkingPayExcution findParkingPay = parkingPayService.findParkingPay(parkingPayDto);
            return BaseUIResult.returnJson(findParkingPay);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            ParkingPayExcution parkingPayExcution =new ParkingPayExcution(CompanyInforEnum.FIND_ERROR,e.getMessage());
            return  BaseUIResult.returnJson(parkingPayExcution);
        }
    }
}
