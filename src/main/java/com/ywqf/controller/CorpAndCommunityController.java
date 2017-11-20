<<<<<<< HEAD
package com.ywqf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ywqf.base.BaseController;
import com.ywqf.base.BaseUIResult;
import com.ywqf.dto.excution.CorpAndCommunityExcution;
import com.ywqf.enums.CorpAndCommunityEnum;
import com.ywqf.service.CorpAndCommunityService;

@Controller
@RequestMapping(value="/corpAndCommunity")
public class CorpAndCommunityController extends BaseController{
	
	@Autowired
	private CorpAndCommunityService corpAndCommunityService;

	@RequestMapping(value="/getCorpAndCommunity",method=RequestMethod.POST,produces={"text/json;charset=UTF-8"})
	@ResponseBody
	public String getCorpAndCommunity(){
		try {
            CorpAndCommunityExcution corpAndCommunityExcution = corpAndCommunityService.getCorpAndCommunity();
            return BaseUIResult.returnJson(corpAndCommunityExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            CorpAndCommunityExcution corpAndCommunityExcution =new CorpAndCommunityExcution(CorpAndCommunityEnum.FAIL,e.getMessage());

            return  BaseUIResult.returnJson(corpAndCommunityExcution);
        }
		
		
	}
}
=======
package com.ywqf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ywqf.base.BaseController;
import com.ywqf.base.BaseUIResult;
import com.ywqf.dto.excution.CorpAndCommunityExcution;
import com.ywqf.enums.CorpAndCommunityEnum;
import com.ywqf.service.CorpAndCommunityService;

@Controller
@RequestMapping(value="/corpAndCommunity")
public class CorpAndCommunityController extends BaseController{
	
	@Autowired
	private CorpAndCommunityService corpAndCommunityService;

	@RequestMapping(value="/getCorpAndCommunity",method=RequestMethod.POST,produces={"text/json;charset=UTF-8"})
	@ResponseBody
	public String getCorpAndCommunity(){
		try {
            CorpAndCommunityExcution corpAndCommunityExcution = corpAndCommunityService.getCorpAndCommunity();
            return BaseUIResult.returnJson(corpAndCommunityExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            CorpAndCommunityExcution corpAndCommunityExcution =new CorpAndCommunityExcution(CorpAndCommunityEnum.FAIL,e.getMessage());

            return  BaseUIResult.returnJson(corpAndCommunityExcution);
        }
		
		
	}
}
>>>>>>> 9c99b64c33e4de793abd5f59e1d05f6f926718dd
