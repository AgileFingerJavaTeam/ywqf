package com.ywqf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ywqf.base.BaseUIResult;
import com.ywqf.dto.excution.HeatingExcution;
import com.ywqf.dto.in.HeatingDto;
import com.ywqf.enums.HeatingEnum;
import com.ywqf.service.HeatingService;

@Controller
@RequestMapping(value="/heating")
public class HeatingController {
	@Autowired
	private HeatingService heatingService;
	//日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value="/getHeatintList")
	public ModelAndView getHeatintList(){
		Logger logger = LoggerFactory.getLogger(this.getClass());
		ModelAndView mv = new ModelAndView();
		try {
			mv.setViewName("heating/heatingList");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return mv;
	}

	/**
	 * 缴费欠费列表
	 * @param heatingDto
	 * @return
	 */
	@RequestMapping(value="getHeatingDate",method=RequestMethod.POST,produces={"text/json;charset=UTF-8"})
	@ResponseBody
	public String getHeatingDate(HeatingDto heatingDto){
	  try {
		  HeatingExcution heatingExcution = heatingService.getHeatingList(heatingDto);
          return BaseUIResult.returnJson(heatingExcution);
      }catch (Exception e){
          logger.error(e.getMessage(), e);
          HeatingExcution heatingExcution =new HeatingExcution(HeatingEnum.FAIL,e.getMessage());

          return  BaseUIResult.returnJsonEasyUI(heatingExcution);
      }
	}
	

}
