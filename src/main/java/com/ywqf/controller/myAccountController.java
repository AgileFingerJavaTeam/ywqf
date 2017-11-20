package com.ywqf.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ywqf.base.BaseController;
import com.ywqf.base.BaseUIResult;
import com.ywqf.dto.excution.UserExcution;
import com.ywqf.dto.in.UserDto;
import com.ywqf.service.UserService;
@Controller
@RequestMapping(value="/myAccount")
public class myAccountController extends BaseController{
	@Autowired
	private UserService userService;
	/**
	 * 修改密码表
	 * @return
	 */
	@RequestMapping(value="/acountList") 
    public ModelAndView showAddMerchantPage(){
    	 Logger logger= LoggerFactory.getLogger(this.getClass());
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("myAccount/changePassword");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mv;
    }
	
	/**
	 * 修改密码
	 * @param userDto
	 * @return
	 */
	@RequestMapping(value="/changeAcount")
	@ResponseBody
	public Object changeAcount(UserDto userDto){
		Logger logger= LoggerFactory.getLogger(this.getClass());
		Map<String, Object> mav = new HashMap<String, Object>();
		int num = 0;
		try {
			num = userService.changePassword(userDto);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(), e);
		}
		if (num == 0) {
			mav.put("code", 0);
		}else if(num == 1){
			mav.put("code", 1);
		}
		else if(num == 2){
			mav.put("code", 2);
		}else if(num == 3){
			mav.put("code", 3);
		}else {
			mav.put("code", 4);
		}
		return mav;
	}
	
	/**
	 * 修改绑定手机号页面
	 * @param userDto
	 * @return
	 */
	@RequestMapping(value="changePhoneList")
	public ModelAndView changePhoneList(UserDto userDto){
		Logger logger= LoggerFactory.getLogger(this.getClass());
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("myAccount/changePhone");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mv;
	}
	
	/**
	 * 修改绑定手机号
	 * @param userDto
	 * @return
	 */
	@RequestMapping(value="changePhone")
	@ResponseBody
	public Object changePhone(UserDto userDto){
		Logger logger= LoggerFactory.getLogger(this.getClass());
		Map<String, Object> mav = new HashMap<String, Object>();
		int num = 0;
		try {
			num = userService.changePhoneNo(userDto);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		if (num == 0) {
			mav.put("code", 0);
		}else if(num == 1){
			mav.put("code", 1);
		}else{
			mav.put("code", 2);
		}
		return mav;
	}
	
	
	/**
	 * 查询手机号
	 * @param userDto
	 * @return
	 */
	@RequestMapping(value="/searchOldPhone",method=RequestMethod.POST,produces={"text/json;charset=UTF-8"})
	@ResponseBody
	public String searchOldPhone(){
		UserExcution userExcution = userService.getOldPhone();
        return BaseUIResult.returnJson(userExcution);
	}
	
	
}
