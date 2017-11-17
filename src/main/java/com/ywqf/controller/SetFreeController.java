package com.ywqf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ywqf.base.BaseUIResult;
import com.ywqf.dto.excution.FreePropertyExcution;
import com.ywqf.dto.in.FreePropertyDto;
import com.ywqf.enums.PayCarNumEnum;
import com.ywqf.service.SetFreeService;

@Controller
@RequestMapping("setfree")
public class SetFreeController {
	
	@Autowired
	private SetFreeService setFreeService;
	//日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 跳转缴费标准页面
	 * @return
	 */
	@RequestMapping("property")
	public ModelAndView Property(){
			int type = 1;
			int userid = 1;
			ModelAndView mv = new ModelAndView();
			mv.addObject("type", type);
			mv.addObject("userid", userid);
			mv.setViewName("standardManagement/setPropertyFee");
			return mv;
		}
	/**
	 * 列表显示
	 * @param freePropertyDto
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="freeProperty",method = RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public Object datatable(FreePropertyDto freePropertyDto){
		try {
			FreePropertyExcution freepropertyExcution = setFreeService.ListFreeProperty(freePropertyDto);
			return BaseUIResult.returnJsonEasyUI(freepropertyExcution);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			FreePropertyExcution freePropertyExcution = new FreePropertyExcution(PayCarNumEnum.FAIL,e.getMessage());
			return BaseUIResult.returnJsonEasyUI(freePropertyExcution);
		}
	}
	/**
	 * 预览显示
	 * @param freePropertyDto
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="freePropertyNew",method = RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public Object previewDatatable(FreePropertyDto freePropertyDto){
		try {
			FreePropertyExcution freepropertyExcution = setFreeService.ListpreviewFreeProperty(freePropertyDto);
			return BaseUIResult.returnJsonEasyUI(freepropertyExcution);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			FreePropertyExcution freePropertyExcution = new FreePropertyExcution(PayCarNumEnum.FAIL,e.getMessage());
			return BaseUIResult.returnJsonEasyUI(freePropertyExcution);
		}
	}
}
