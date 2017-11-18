package com.ywqf.controller;

import com.ywqf.dto.excution.HeatingFeePaymentExcution;
import com.ywqf.dto.in.HeatingFeePaymentDto;
import com.ywqf.exception.db.QueryInnerErrorException;
import com.ywqf.service.HeatingFeePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ywqf.base.BaseController;
import com.ywqf.base.BaseUIResult;
import com.ywqf.enums.HeatingFeePaymentEnum;

@Controller
@RequestMapping("/HeatingFeePayment")
public class HeatingFeePaymentController extends BaseController{

	@Autowired
	private HeatingFeePaymentService heatingFeePaymentService;
	
	  @RequestMapping(value = "/showHeating")
	    public ModelAndView showCarousePage() {
	        ModelAndView mv = new ModelAndView();
	        try {
				int id = 1000;
				String name = "燚龘";
				int corp_id = 1000;
				mv.addObject("corp_id", corp_id);
				mv.addObject("Rid", id);
				mv.addObject("Rname",name);
	            mv.setViewName("HeatingFeePayment/showHeating");
	        } catch (Exception e) {
	        	 logger.error(e.getMessage(),e);
	        }
	        return mv;
	    }
	  
	  /**
	     * 查询数据
	     * @return
	     */
	    @RequestMapping(value = "/getHeatingList",
	            method = RequestMethod.POST,
	            produces = "text/json;charset=UTF-8")
	    @ResponseBody
	    public String getHeatingList(HeatingFeePaymentDto heatingFeePaymentDto) {
	        try {
	        	HeatingFeePaymentExcution heatingFeePaymentExcution = heatingFeePaymentService.findHeatingList(heatingFeePaymentDto);
	            return BaseUIResult.returnJsonEasyUI(heatingFeePaymentExcution);
	        } catch (Exception e) {
	            logger.error(e.getMessage(), e);
	            HeatingFeePaymentExcution heatingFeePaymentExcution = new HeatingFeePaymentExcution(HeatingFeePaymentEnum.ERROR,e.getMessage());
	            return BaseUIResult.returnJsonEasyUI(heatingFeePaymentExcution);
	        }
	    }
	    
	    //查询作废状态
	    @RequestMapping(value = "/showOver",
	            method = RequestMethod.GET,
	            produces = "text/json;charset=UTF-8")
	    @ResponseBody
	    public ModelAndView showOver(HeatingFeePaymentDto heatingFeePaymentDto) {
	        ModelAndView mv = new ModelAndView();
	        try {
	        	HeatingFeePaymentExcution heatingFeePaymentExcution =  heatingFeePaymentService.findOver(heatingFeePaymentDto);
	            mv.addObject("data", heatingFeePaymentExcution.getData());
	        	mv.setViewName("HeatingFeePayment/showOver");
	        } catch (Exception e) {
	        	 logger.error(e.getMessage(),e);
	        }
	        return mv;
	    }
	    
	    /**
	     * 修改作废状态
	     *
	     * @return
	     */
	    @RequestMapping(value = "/updateOver",
	            method = RequestMethod.POST,
	            produces = "text/json;charset=UTF-8")
	    @ResponseBody
	    public String updateOver(HeatingFeePaymentDto heatingFeePaymentDto) {
	        try {
	            HeatingFeePaymentExcution heatingFeePaymentExcution = heatingFeePaymentService.updateOver(heatingFeePaymentDto);
	            return BaseUIResult.returnJsonMSG(1, heatingFeePaymentExcution, "修改成功");
	        } catch (Exception e) {
	            logger.error(e.getMessage(), e);
	            HeatingFeePaymentExcution heatingFeePaymentExcution = new HeatingFeePaymentExcution(HeatingFeePaymentEnum.ERROR,e.getMessage());
	            return BaseUIResult.returnJsonMSG(0, heatingFeePaymentExcution, "修改失败");
	        }
	    }

	//查门牌号是否存在
	@RequestMapping(value = "/findHouseNumIsNull",
			method = RequestMethod.POST,
			produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String findHouseNumIsNull(HeatingFeePaymentDto heatingFeePaymentDto) {
		//参数验空
		try {
			HeatingFeePaymentExcution heatingFeePaymentExcution = heatingFeePaymentService.findHouseNumIsNull(heatingFeePaymentDto);
			return BaseUIResult.returnJson(heatingFeePaymentExcution);
		}catch(QueryInnerErrorException e) {
			logger.error(e.getMessage(), e);
			HeatingFeePaymentExcution heatingFeePaymentExcution = new HeatingFeePaymentExcution(HeatingFeePaymentEnum.ERROR,e.getMessage());
			return BaseUIResult.returnJson(heatingFeePaymentExcution);
		}
		catch(Exception e) {
			logger.error(e.getMessage(), e);
			HeatingFeePaymentExcution heatingFeePaymentExcution = new HeatingFeePaymentExcution(HeatingFeePaymentEnum.ERROR,e.getMessage());
			return BaseUIResult.returnJson(heatingFeePaymentExcution);
		}
	}

	//查门牌号遍历 业主名 采暖面积
	@RequestMapping(value = "/findAreaOrNameOrMoney",
			method = RequestMethod.POST,
			produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String findAreaOrNameOrMoney(HeatingFeePaymentDto heatingFeePaymentDto) {
		//参数验空
		try {
			HeatingFeePaymentExcution heatingFeePaymentExcution = heatingFeePaymentService.findAreaOrNameOrMoney(heatingFeePaymentDto);
			return BaseUIResult.returnJson(heatingFeePaymentExcution);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			HeatingFeePaymentExcution heatingFeePaymentExcution = new HeatingFeePaymentExcution(HeatingFeePaymentEnum.ERROR,e.getMessage());
			return BaseUIResult.returnJson(heatingFeePaymentExcution);
		}
	}


	//遍历小区采暖优惠时间段
	@RequestMapping(value = "/findHeatingDiscount",
			method = RequestMethod.POST,
			produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String findHeatingDiscount(HeatingFeePaymentDto heatingFeePaymentDto) {
		//参数验空
		try {
			HeatingFeePaymentExcution heatingFeePaymentExcution = heatingFeePaymentService.findHeatingDiscount(heatingFeePaymentDto);
			return BaseUIResult.returnJson(heatingFeePaymentExcution);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			HeatingFeePaymentExcution heatingFeePaymentExcution = new HeatingFeePaymentExcution(HeatingFeePaymentEnum.ERROR,e.getMessage());
			return BaseUIResult.returnJson(heatingFeePaymentExcution);
		}
	}

	//新增
	@RequestMapping(value = "/insertHeating",
			method = RequestMethod.POST,
			produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String insertHeating(HeatingFeePaymentDto heatingFeePaymentDto) {
		//参数验空
		try {
			HeatingFeePaymentExcution heatingFeePaymentExcution = heatingFeePaymentService.insertHeating(heatingFeePaymentDto);
			return BaseUIResult.returnJson(heatingFeePaymentExcution);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			HeatingFeePaymentExcution heatingFeePaymentExcution = new HeatingFeePaymentExcution(HeatingFeePaymentEnum.ERROR,e.getMessage());
			return BaseUIResult.returnJson(heatingFeePaymentExcution);
		}
	}

}
