package com.ywqf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ywqf.dao.SetFreeDao;
import com.ywqf.dto.in.FreePropertyDto;

@Controller
@RequestMapping("setfree")
public class SetFreeController {
	
	@Autowired
	private SetFreeDao setFreeDao;
	
	/**
	 * 跳转缴费标准页面
	 * @return
	 */
	@RequestMapping("property")
	public ModelAndView Property(){
			ModelAndView mv = new ModelAndView();
			mv.setViewName("standardManagement/setPropertyFee");
			return mv;
		}
	@RequestMapping("datatable")
	public Object datatable(FreePropertyDto freePropertyDto){
		
		return null;
	}
	
}
