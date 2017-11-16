package com.ywqf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.ywqf.dto.excution.AuthRoleExcution;
import com.ywqf.dto.excution.CommunityExcution;
import com.ywqf.dto.excution.CorpExcution;
import com.ywqf.dto.excution.PayYearResultExcution;
import com.ywqf.dto.in.CommunityDto;
import com.ywqf.dto.in.PayYearNumDto;
import com.ywqf.enums.AuthRoleEnum;
import com.ywqf.enums.PayYearNumEnum;
import com.ywqf.service.PayYearNumService;

@Controller
@RequestMapping("payYearNum")
public class PayYearNumControlor extends BaseController{
	
	@Autowired
	private PayYearNumService payYearNumService;
	//日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 跳转缴费页面
	 * @return
	 */
	@RequestMapping(value="list",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
	public 	ModelAndView List(){
		HttpSession authSession = this.getRequest().getSession();
		//type 为物业类型  1为总部  0为物业公司
		int userid =1000;
		int type = 1;
		ModelAndView mv =new ModelAndView();
		mv.addObject("userid", userid);
		mv.addObject("type", type);
		mv.setViewName("tableNum/payYearNumnew");
		return mv;
	}
	@RequestMapping(value = "/search",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
    @ResponseBody
    public Object search(PayYearNumDto payYearNumDto){
		HttpSession authSession = this.getRequest().getSession();
		try {
			PayYearResultExcution payYearResultExcution=payYearNumService.PayYearResult(payYearNumDto);
			List<List<PayYearResultExcution>> result =new ArrayList<List<PayYearResultExcution>>();
			return BaseUIResult.returnJson(payYearResultExcution);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            PayYearResultExcution payYearResultExcution =new PayYearResultExcution(PayYearNumEnum.FAIL,e.getMessage());
            return BaseUIResult.returnJsonEasyUI(payYearResultExcution);
		}
	}
	/**
	 * 根据登录id查询物业
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value ="/corpsList",method = RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public Object corpsList(){
		int userid=1000;
		int type=1;
		CorpExcution corpExcution =payYearNumService.CorpList(userid,type);
		return BaseUIResult.returnJson(corpExcution);
	}
	/**
	 * 根据物业id查询小区
	 * @param id
	 * @return
	 */
	
	@RequestMapping(value="/communityList",method = RequestMethod.POST,produces = "text/json;charset=UTF-8")
	@ResponseBody
	public Object communityList(CommunityDto communityDto){
		CommunityExcution communityExcution =payYearNumService.CommunityList(communityDto);
		return BaseUIResult.returnJson(communityExcution);
	}
}
