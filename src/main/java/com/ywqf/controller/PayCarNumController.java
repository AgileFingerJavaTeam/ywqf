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
import com.ywqf.dto.excution.CarExcution;
import com.ywqf.dto.excution.CommunityExcution;
import com.ywqf.dto.excution.CorpExcution;
import com.ywqf.dto.excution.PayCarResultExcution;
import com.ywqf.dto.in.CommunityDto;
import com.ywqf.dto.in.PayCarNumDto;
import com.ywqf.dto.in.PayYearNumDto;
import com.ywqf.enums.PayCarNumEnum;
import com.ywqf.enums.PayYearNumEnum;
import com.ywqf.service.PayCarNumService;

@Controller
@RequestMapping("payCarNum")
public class PayCarNumController extends BaseController{
	
	@Autowired
	private PayCarNumService payCarNumService;
	//日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    /**
     * 跳转页面
     * @return
     */
    @RequestMapping(value="list",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
    public ModelAndView PayCarNum(){
    	HttpSession authSession = this.getRequest().getSession();
		//type 为物业类型  1为总部  0为物业公司
		int userid =1000;
		int type = 1;
		ModelAndView mv =new ModelAndView();
		mv.addObject("userid", userid);
		mv.addObject("type", type);
		mv.setViewName("tableNum/payCarNum");
		return mv;
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
		CarExcution carExcution =payCarNumService.CorpList(userid,type);
		return BaseUIResult.returnJson(carExcution);
	}
	/**
	 * 根据物业id查询小区
	 * @param
	 * @return
	 */
	
	@RequestMapping(value="/communityList",method = RequestMethod.POST,produces = "text/json;charset=UTF-8")
	@ResponseBody
	public Object communityList(CommunityDto communityDto){
		CarExcution carExcution =payCarNumService.CommunityList(communityDto);
		return BaseUIResult.returnJson(carExcution);
	}
	/**
	 * 车费统计
	 * @param payCarNumDto
	 * @return
	 */
	@RequestMapping(value = "/search",method = RequestMethod.GET,produces = "text/json;charset=UTF-8")
    @ResponseBody
    public Object search(PayCarNumDto payCarNumDto){
		HttpSession authSession = this.getRequest().getSession();
		try {
			PayCarResultExcution payCarResultExcution=payCarNumService.PayCarResult(payCarNumDto);
			List<List<PayCarResultExcution>> result =new ArrayList<List<PayCarResultExcution>>();
			return BaseUIResult.returnJson(payCarResultExcution);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
            PayCarResultExcution payCarResultExcution =new PayCarResultExcution(PayCarNumEnum.FAIL,e.getMessage());
            return BaseUIResult.returnJsonEasyUI(payCarResultExcution);
		}
	}

}
