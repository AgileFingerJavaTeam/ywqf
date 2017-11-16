package com.ywqf.controller;

import com.ywqf.base.BaseController;
import com.ywqf.base.BaseUIResult;
import com.ywqf.dto.excution.EstatePayExcution;
import com.ywqf.dto.in.EstatePayDto;
import com.ywqf.enums.EstatePayEnum;
import com.ywqf.service.EstatePayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/estatePay")
public class EstatePayController extends BaseController{
@Autowired
EstatePayService estatePayService;

    /**
     * 显示当日缴费对账页面
     * @return
     */
    @RequestMapping(value = "/showEstatePayCheckBillPage",
            produces = {"text/json;charset=UTF-8"})
    public ModelAndView showEstatePayCheckBillPage(){
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("estatePay/estatePayCheckBill");
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return mv;
    }

    /**
     * 查询当日物业缴费信息（缴费详细信息和缴费总计）
     * @param estatePayDto
     * @return
     */
    @RequestMapping(value = "/findEstatePayInfo",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findTodayEstatePayInfo(EstatePayDto estatePayDto){
        try {
            EstatePayExcution estatePayExcution = estatePayService.findEstatePayInfo(estatePayDto);
            return BaseUIResult.returnJson(estatePayExcution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            EstatePayExcution estatePayExcution = new EstatePayExcution(EstatePayEnum.FIND_ESTATE_PAY_FAIL,e.getMessage());
            return BaseUIResult.returnJson(estatePayExcution);
        }
    }

    /**
     * 查询当前物业公司管理的所有小区
     * @return
     */
    @RequestMapping(value = "/findCorpManagedCommunity",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findCommunityBycorpId(EstatePayDto estatePayDto){
        try{
            EstatePayExcution estatePayExcution = estatePayService.findCorpManagedCommunity(estatePayDto);
            return BaseUIResult.returnJson(estatePayExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            EstatePayExcution estatePayExcution = new EstatePayExcution(EstatePayEnum.FIND_COMMUNITY_FAIL, e.getMessage());
            return BaseUIResult.returnJson(estatePayExcution);
        }
    }

    /**
     * 查询当前登录员工管理的所有小区
     * @return
     */
    @RequestMapping(value = "/findUserManagedCommunity",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findCommunity(EstatePayDto estatePayDto){
        try{
            EstatePayExcution estatePayExcution = estatePayService.findUserManagedCommunity(estatePayDto);
            return BaseUIResult.returnJson(estatePayExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            EstatePayExcution estatePayExcution = new EstatePayExcution(EstatePayEnum.FIND_COMMUNITY_FAIL, e.getMessage());
            return BaseUIResult.returnJson(estatePayExcution);
        }
    }
    //---查询登录员工所属物业公司
    @RequestMapping(value = "/findUserBelongsCrop",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findUserBelongsCrop(EstatePayDto estatePayDto){
        try{
            EstatePayExcution estatePayExcution = estatePayService.findUserBelongsCrop(estatePayDto);
            return BaseUIResult.returnJson(estatePayExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            EstatePayExcution estatePayExcution = new EstatePayExcution(EstatePayEnum.FIND_CORPS_FAIL, e.getMessage());
            return BaseUIResult.returnJson(estatePayExcution);
        }
    }

    /**
     * 查询所有物业公司信息
     * @param estatePayDto
     * @return
     */
    @RequestMapping(value = "/findCorpsInfo",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findCorpsInfo(EstatePayDto estatePayDto){
        try{
            EstatePayExcution estatePayExcution = estatePayService.findCorpsInfo();
            return BaseUIResult.returnJson(estatePayExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            EstatePayExcution estatePayExcution = new EstatePayExcution(EstatePayEnum.FIND_CORPS_FAIL, e.getMessage());
            return BaseUIResult.returnJson(estatePayExcution);
        }
    }

    /**
     * 查询登录员工类型（属于物业还是总部）
     * @param estatePayDto
     * @return
     */
    @RequestMapping(value = "/findUserType",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findUserType(EstatePayDto estatePayDto){
        try{
            EstatePayExcution estatePayExcution = estatePayService.findUserType(estatePayDto);
            return BaseUIResult.returnJson(estatePayExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            EstatePayExcution estatePayExcution = new EstatePayExcution(EstatePayEnum.FIND_FAIL, e.getMessage());
            return BaseUIResult.returnJson(estatePayExcution);
        }
    }
    /**
     *物业缴费欠费页面
     * @return
     */
    @RequestMapping(value="/getEstatePayQueryList")
    public ModelAndView getEstatePayQueryList(){
        Logger logger = LoggerFactory.getLogger(this.getClass());
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("estatePay/estatePayQueryList");
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return mv;
    }

    /**
     *物业缴费欠费数据查询
     * @return
     */
    @RequestMapping(value = "/getEstatePayQuery",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String EstatePayQuery(EstatePayDto estatePayDto){
        try {
            EstatePayExcution estatePayExcution = estatePayService.queryEstatePay(estatePayDto);
            return BaseUIResult.returnJson(estatePayExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            EstatePayExcution estatePayExcution =new EstatePayExcution(EstatePayEnum.QUERY_FILED,e.getMessage());
            return  BaseUIResult.returnJsonEasyUI(estatePayExcution);
        }
    }
}
