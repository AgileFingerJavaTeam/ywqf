package com.ywqf.controller;

import com.ywqf.base.BaseController;
import com.ywqf.base.BaseUIResult;
import com.ywqf.dto.excution.HouseCenterExcution;
import com.ywqf.dto.excution.HouseExcution;
import com.ywqf.dto.in.HouseCenterDto;
import com.ywqf.dto.in.HouseDto;
import com.ywqf.enums.HouseCenterEnum;
import com.ywqf.enums.HouseEnum;
import com.ywqf.exception.db.InsertInnerErrorException;
import com.ywqf.service.HouseCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/HouseCenter")
public class HouseCenterController extends BaseController {
    @Autowired
    private HouseCenterService houseCenterService;
    @RequestMapping("/AskForPage")
    /*显示页面*/
    public ModelAndView AskForPage(){
        ModelAndView mv=new ModelAndView();
        try{
        mv.setViewName("housingcenter/houseAskFor");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return mv;
    }
    /*查询求租求购列表*/
    @RequestMapping(value = "/getHouseAskList",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getHouseList(HouseCenterDto houseCenterDto){
        try {
            HouseCenterExcution houseCenterExcution = houseCenterService.findHouseAsk(houseCenterDto);
            return BaseUIResult.returnJsonEasyUI(houseCenterExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            HouseCenterExcution houseCenterExcution =new HouseCenterExcution(HouseCenterEnum.FIND_FAIL,e.getMessage());

            return  BaseUIResult.returnJsonEasyUI(houseCenterExcution);
        }
    }

    /*查询详细信息*/
    @RequestMapping(value = "/getAskById",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getAskById(HouseCenterDto houseCenterDto){
        try {
            HouseCenterExcution houseCenterExcution = houseCenterService.findAskById(houseCenterDto);
            return BaseUIResult.returnJson(houseCenterExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            HouseCenterExcution houseCenterExcution =new HouseCenterExcution(HouseCenterEnum.FIND_FAIL,e.getMessage());

            return  BaseUIResult.returnJson(houseCenterExcution);
        }
    }


    /*查询需求*/
    @RequestMapping(value = "/findAskType",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findAskType(){
        try {
            HouseCenterExcution houseCenterExcution = houseCenterService.findAskType();
            return BaseUIResult.returnJson(houseCenterExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            HouseExcution houseExcution =new HouseExcution(HouseEnum.FIND_FAIL,e.getMessage());

            return  BaseUIResult.returnJsonEasyUI(houseExcution);
        }
    }


    /*查询户型*/
    @RequestMapping(value = "/findHouseType",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findHouseType(){
        try {
            HouseCenterExcution houseCenterExcution = houseCenterService.findHouseType();
            return BaseUIResult.returnJson(houseCenterExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            HouseExcution houseExcution =new HouseExcution(HouseEnum.FIND_FAIL,e.getMessage());

            return  BaseUIResult.returnJsonEasyUI(houseExcution);
        }
    }


    /*查询朝向*/
    @RequestMapping(value = "/findDirection",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findDirection(){
        try {
            HouseCenterExcution houseCenterExcution = houseCenterService.findDirection();
            return BaseUIResult.returnJson(houseCenterExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            HouseExcution houseExcution =new HouseExcution(HouseEnum.FIND_FAIL,e.getMessage());

            return  BaseUIResult.returnJsonEasyUI(houseExcution);
        }
    }


    /*查询面积*/
    @RequestMapping(value = "/findArea",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findArea(){
        try {
            HouseCenterExcution houseCenterExcution = houseCenterService.findArea();
            return BaseUIResult.returnJson(houseCenterExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            HouseExcution houseExcution =new HouseExcution(HouseEnum.FIND_FAIL,e.getMessage());

            return  BaseUIResult.returnJsonEasyUI(houseExcution);
        }
    }


    /*查询装修情况*/
    @RequestMapping(value = "/findFitment",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findFitment(){
        try {
            HouseCenterExcution houseCenterExcution = houseCenterService.findFitment();
            return BaseUIResult.returnJson(houseCenterExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            HouseExcution houseExcution =new HouseExcution(HouseEnum.FIND_FAIL,e.getMessage());

            return  BaseUIResult.returnJsonEasyUI(houseExcution);
        }
    }


    /*查询租价*/
    @RequestMapping(value = "/findRentPrice",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findRentPrice(){
        try {
            HouseCenterExcution houseCenterExcution = houseCenterService.findRentPrice();
            return BaseUIResult.returnJson(houseCenterExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            HouseExcution houseExcution =new HouseExcution(HouseEnum.FIND_FAIL,e.getMessage());

            return  BaseUIResult.returnJsonEasyUI(houseExcution);
        }
    }

    /*查询售价*/
    @RequestMapping(value = "/findBuyPrice",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findBuyPrice(){
        try {
            HouseCenterExcution houseCenterExcution = houseCenterService.findBuyPrice();
            return BaseUIResult.returnJson(houseCenterExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            HouseExcution houseExcution =new HouseExcution(HouseEnum.FIND_FAIL,e.getMessage());

            return  BaseUIResult.returnJsonEasyUI(houseExcution);
        }
    }

    /**
     * 提交新增信息
     *
     * @return
     */
    @RequestMapping(value = "/subAdd",method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String subAdd(HouseCenterDto houseCenterDto) {
        try {
            HouseCenterExcution houseCenterExcution = houseCenterService.subAdd(houseCenterDto);
            return BaseUIResult.returnJsonMSG(1, houseCenterExcution, "修改成功");
        } catch (InsertInnerErrorException e) {
            logger.error(e.getMessage(), e);
            HouseCenterExcution houseCenterExcution = new HouseCenterExcution(HouseCenterEnum.ADD_FAIL, e.getMessage());
            return BaseUIResult.returnJsonMSG(0,houseCenterExcution,"修改失败");
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            HouseCenterExcution houseCenterExcution= new HouseCenterExcution(HouseCenterEnum.ADD_FAIL, e.getMessage());
            return BaseUIResult.returnJsonMSG(0,houseCenterExcution,"失败");
        }
    }

    /**
     * 提交新增信息
     *
     * @return
     */
    @RequestMapping(value = "/subEdit",method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String subEdit(HouseCenterDto houseCenterDto) {
        try {
            HouseCenterExcution houseCenterExcution = houseCenterService.subEdit(houseCenterDto);
            return BaseUIResult.returnJsonMSG(1, houseCenterExcution, "修改成功");
        } catch (InsertInnerErrorException e) {
            logger.error(e.getMessage(), e);
            HouseCenterExcution houseCenterExcution = new HouseCenterExcution(HouseCenterEnum.ADD_FAIL, e.getMessage());
            return BaseUIResult.returnJsonMSG(0,houseCenterExcution,"修改失败");
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            HouseCenterExcution houseCenterExcution= new HouseCenterExcution(HouseCenterEnum.ADD_FAIL, e.getMessage());
            return BaseUIResult.returnJsonMSG(0,houseCenterExcution,"失败");
        }
    }


    /**
     * 提交删除信息
     *
     * @return
     */
    @RequestMapping(value = "/subDelHouseInfo",method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String subDelHouseInfo(HouseCenterDto houseCenterDto) {
        try {
            HouseCenterExcution houseCenterExcution = houseCenterService.deleteHouseInfo(houseCenterDto);
            return BaseUIResult.returnJsonMSG(1, houseCenterExcution, "修改成功");
        } catch (InsertInnerErrorException e) {
            logger.error(e.getMessage(), e);
            HouseCenterExcution houseCenterExcution = new HouseCenterExcution(HouseCenterEnum.ADD_FAIL, e.getMessage());
            return BaseUIResult.returnJsonMSG(0,houseCenterExcution,"修改失败");
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            HouseCenterExcution houseCenterExcution= new HouseCenterExcution(HouseCenterEnum.ADD_FAIL, e.getMessage());
            return BaseUIResult.returnJsonMSG(0,houseCenterExcution,"失败");
        }
    }



























    @RequestMapping("/RentSalePage")
    /*显示页面*/
    public ModelAndView RentSalePage(){
        ModelAndView mv=new ModelAndView();
        try{
            mv.setViewName("housingcenter/houseRent");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return mv;
    }
   /* *//*查询楼号*//*
    @RequestMapping(value = "/getBuilding",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getBuilding(HouseCenterDto houseCenterDto){
        try {
            HouseCenterExcution houseCenterExcution = houseCenterService.findBuildingById(houseCenterDto);
            return BaseUIResult.returnJson(houseCenterExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            HouseExcution houseExcution =new HouseExcution(HouseEnum.FIND_FAIL,e.getMessage());

            return  BaseUIResult.returnJsonEasyUI(houseExcution);
        }
    }*/

    /*查询出租出售列表*/
    @RequestMapping(value = "/getRentSaleList",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getRentSaleList(HouseCenterDto houseCenterDto){
        try {
            HouseCenterExcution houseCenterExcution = houseCenterService.findRentSale(houseCenterDto);
            return BaseUIResult.returnJsonEasyUI(houseCenterExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            HouseCenterExcution houseCenterExcution =new HouseCenterExcution(HouseCenterEnum.FIND_FAIL,e.getMessage());

            return  BaseUIResult.returnJsonEasyUI(houseCenterExcution);
        }
    }

    /*查询门牌号*/
    @RequestMapping(value = "/getHouseNum",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getHouseNum(HouseCenterDto houseCenterDto){
        try {
            HouseCenterExcution houseCenterExcution = houseCenterService.findHouseNum(houseCenterDto);
            return BaseUIResult.returnJson(houseCenterExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            HouseExcution houseExcution =new HouseExcution(HouseEnum.FIND_FAIL,e.getMessage());

            return  BaseUIResult.returnJsonEasyUI(houseExcution);
        }
    }



}
