package com.ywqf.controller;

import com.ywqf.exception.db.QueryInnerErrorException;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.druid.support.logging.Log;
import com.ywqf.base.BaseController;
import com.ywqf.base.BaseUIResult;
import com.ywqf.dto.excution.PropertyFeePaymentExcution;
import com.ywqf.dto.in.PropertyFeePaymentDto;
import com.ywqf.enums.PropertyFeePaymentEnum;
import com.ywqf.service.PropertyFeePaymentService;


@Controller
@RequestMapping("/PropertyFeePayment")
public class PropertyFeePaymentController extends BaseController{
	Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PropertyFeePaymentService propertyFeePaymentService;
	
	  @RequestMapping(value = "/showProperty")
	    public ModelAndView showCarousePage() {
	        ModelAndView mv = new ModelAndView();
	        try {
				int id = 1000;
				String name = "吴亦凡";
				int corp_id = 1000;
				mv.addObject("corp_id", corp_id);
				mv.addObject("Rid", id);
				mv.addObject("Rname",name);
	            mv.setViewName("PropertyFeePayment/house");
	        } catch (Exception e) {
	        	 logger.error(e.getMessage(),e);
	        }
	        return mv;
	    }
	
	  /**
	     * 查询参数信息
	     *
	     * @return
	     */
	    @RequestMapping(value = "/getPropertyList",
	            method = RequestMethod.POST,
	            produces = "text/json;charset=UTF-8") // select
	    // 用post，其他sql语句用get
	    @ResponseBody
	    public String getParameterList(PropertyFeePaymentDto propertyFeePaymentDto) {
	        //参数验空
	        try {
	            PropertyFeePaymentExcution propertyFeePaymentExcution = propertyFeePaymentService.findPropertyList(propertyFeePaymentDto);
	            return BaseUIResult.returnJsonEasyUI(propertyFeePaymentExcution);
	        } catch (Exception e) {
	            logger.error(e.getMessage(), e);
	            PropertyFeePaymentExcution propertyFeePaymentExcution = new PropertyFeePaymentExcution(PropertyFeePaymentEnum.ERROR,e.getMessage());
	            return BaseUIResult.returnJsonEasyUI(propertyFeePaymentExcution);
	        }
	    }
	    
	    //跳转作废
	    @RequestMapping(value = "/showOver",
	            method = RequestMethod.GET,
	            produces = "text/json;charset=UTF-8")
	    @ResponseBody
	    public ModelAndView showOver(@Param("id")int id) {
	        ModelAndView mv = new ModelAndView();
	        try {
	        	PropertyFeePaymentExcution propertyFeePaymentExcution =  propertyFeePaymentService.findOver(id);
	            mv.addObject("data", propertyFeePaymentExcution.getData());
	        	mv.setViewName("PropertyFeePayment/showOver");
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
	            produces = "text/json;charset=UTF-8") // select
	    // 用post，其他sql语句用get
	    @ResponseBody
	    public String updateOver(PropertyFeePaymentDto propertyFeePaymentDto) {
	        //参数验空
	        try {
	            PropertyFeePaymentExcution propertyFeePaymentExcution = propertyFeePaymentService.updateOver(propertyFeePaymentDto);
	            return BaseUIResult.returnJsonMSG(1, propertyFeePaymentExcution, "更改成功");
	        } catch (Exception e) {
	            logger.error(e.getMessage(), e);
	            PropertyFeePaymentExcution propertyFeePaymentExcution = new PropertyFeePaymentExcution(PropertyFeePaymentEnum.ERROR,e.getMessage());
	            return BaseUIResult.returnJsonMSG(0, propertyFeePaymentExcution, "更改失败");
	        }
	    }
	    
	    //跳转添加页面
	    @RequestMapping(value = "/showInsert",
	            method = RequestMethod.GET,
	            produces = "text/json;charset=UTF-8")
	    @ResponseBody
	    public ModelAndView showInsert(PropertyFeePaymentDto propertyFeePaymentDto) {
	        ModelAndView mv = new ModelAndView();
	        HttpSession session = this.getRequest().getSession();
	        try {
	            //LandFallInfo land = (LandFallInfo)session.getAttribute("user");
	            int id = 20;
	            String name = "克里斯";
	            int corp_id = 1;
	            mv.addObject("corp_id", corp_id);
	            mv.addObject("id", id);
	            mv.addObject("name",name);
	        	mv.setViewName("PropertyFeePayment/showInsert");
	        } catch (Exception e) {
	        	 logger.error(e.getMessage(),e);
	        }
	        return mv;
	    }

	   //查询遍历 小区         where 物业公司
	    @RequestMapping(value = "/findVillage",
	            method = RequestMethod.POST,
	            produces = "text/json;charset=UTF-8")
	    @ResponseBody
	    public String findVillage(PropertyFeePaymentDto propertyFeePaymentDto) {
	        //参数验空
	        try {
	            PropertyFeePaymentExcution propertyFeePaymentExcution = propertyFeePaymentService.findVillage(propertyFeePaymentDto);
	            return BaseUIResult.returnJson(propertyFeePaymentExcution);
	        } catch (Exception e) {
	            logger.error(e.getMessage(), e);
	            PropertyFeePaymentExcution propertyFeePaymentExcution = new PropertyFeePaymentExcution(PropertyFeePaymentEnum.ERROR,e.getMessage());
	            return BaseUIResult.returnJson(propertyFeePaymentExcution);
	        }
	    }
	    
	    //查询遍历  收费人员
	    @RequestMapping(value = "/findAccount",
	            method = RequestMethod.GET,
	            produces = "text/json;charset=UTF-8")
	    @ResponseBody
	    public String findAccount(PropertyFeePaymentDto propertyFeePaymentDto) {
	        //参数验空
	        try {
	            PropertyFeePaymentExcution propertyFeePaymentExcution = propertyFeePaymentService.findAccount(propertyFeePaymentDto);
	            return BaseUIResult.returnJson(propertyFeePaymentExcution);
	        } catch (Exception e) {
	            logger.error(e.getMessage(), e);
	            PropertyFeePaymentExcution propertyFeePaymentExcution = new PropertyFeePaymentExcution(PropertyFeePaymentEnum.ERROR,e.getMessage());
	            return BaseUIResult.returnJson(propertyFeePaymentExcution);
	        }
	    }

	    //添加方法  
	    @RequestMapping(value = "/insertProperty",
	            method = RequestMethod.POST,
	            produces = "text/json;charset=UTF-8")
	    @ResponseBody
	    public String insertProperty(PropertyFeePaymentDto propertyFeePaymentDto) {
	        //参数验空
	        try {
	            PropertyFeePaymentExcution propertyFeePaymentExcution = propertyFeePaymentService.insertProperty(propertyFeePaymentDto);
	            return BaseUIResult.returnJsonMSG(1,propertyFeePaymentExcution,"添加成功");
	        } catch (Exception e) {
	            logger.error(e.getMessage(), e);
	            PropertyFeePaymentExcution propertyFeePaymentExcution = new PropertyFeePaymentExcution(PropertyFeePaymentEnum.ERROR,e.getMessage());
	            return BaseUIResult.returnJsonMSG(0,propertyFeePaymentExcution,"添加失败");
	        }
	    }
	    
	    //查询遍历 物业公司
	    @RequestMapping(value = "/findEstate",
	            method = RequestMethod.POST,
	            produces = "text/json;charset=UTF-8")
	    @ResponseBody
	    public String findEstate(PropertyFeePaymentDto propertyFeePaymentDto) {
	        //参数验空
	        try {
	            PropertyFeePaymentExcution propertyFeePaymentExcution = propertyFeePaymentService.findEstate(propertyFeePaymentDto);
	            return BaseUIResult.returnJson(propertyFeePaymentExcution);
	        } catch (Exception e) {
	            logger.error(e.getMessage(), e);
	            PropertyFeePaymentExcution propertyFeePaymentExcution = new PropertyFeePaymentExcution(PropertyFeePaymentEnum.ERROR,e.getMessage());
	            return BaseUIResult.returnJson(propertyFeePaymentExcution);
	        }
	    }
	    
	    //联动查小区 where 物业公司
	    @RequestMapping(value = "/findComm",
	            method = RequestMethod.POST,
	            produces = "text/json;charset=UTF-8")
	    @ResponseBody
	    public String findComm(PropertyFeePaymentDto propertyFeePaymentDto) {
	        //参数验空
	        try {
	            PropertyFeePaymentExcution propertyFeePaymentExcution = propertyFeePaymentService.findComm(propertyFeePaymentDto);
	            return BaseUIResult.returnJson(propertyFeePaymentExcution);
	        } catch (Exception e) {
	            logger.error(e.getMessage(), e);
	            PropertyFeePaymentExcution propertyFeePaymentExcution = new PropertyFeePaymentExcution(PropertyFeePaymentEnum.ERROR,e.getMessage());
	            return BaseUIResult.returnJson(propertyFeePaymentExcution);
	        }
	    }

	//查门牌号是否存在
	@RequestMapping(value = "/findHouseNumIsNull",
			method = RequestMethod.POST,
			produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String findHouseNumIsNull(PropertyFeePaymentDto propertyFeePaymentDto) {
		//参数验空
		try {
			PropertyFeePaymentExcution propertyFeePaymentExcution = propertyFeePaymentService.findHouseNumIsNull(propertyFeePaymentDto);
			return BaseUIResult.returnJson(propertyFeePaymentExcution);
		}catch(QueryInnerErrorException e) {
			logger.error(e.getMessage(), e);
			PropertyFeePaymentExcution propertyFeePaymentExcution = new PropertyFeePaymentExcution(PropertyFeePaymentEnum.ERROR,e.getMessage());
			return BaseUIResult.returnJson(propertyFeePaymentExcution);
		}
		 catch(Exception e) {
			logger.error(e.getMessage(), e);
			PropertyFeePaymentExcution propertyFeePaymentExcution = new PropertyFeePaymentExcution(PropertyFeePaymentEnum.ERROR,e.getMessage());
			return BaseUIResult.returnJson(propertyFeePaymentExcution);
		}
	}

	//查门牌号遍历
	    @RequestMapping(value = "/findListHouseNumber",
	            method = RequestMethod.POST,
	            produces = "text/json;charset=UTF-8")
	    @ResponseBody
	    public String findListHouseNumber(PropertyFeePaymentDto propertyFeePaymentDto) {
	        //参数验空
	        try {
	            PropertyFeePaymentExcution propertyFeePaymentExcution = propertyFeePaymentService.findListHouseNumber(propertyFeePaymentDto);
	            return BaseUIResult.returnJson(propertyFeePaymentExcution);
	        } catch (Exception e) {
	            logger.error(e.getMessage(), e);
	            PropertyFeePaymentExcution propertyFeePaymentExcution = new PropertyFeePaymentExcution(PropertyFeePaymentEnum.ERROR,e.getMessage());
	            return BaseUIResult.returnJson(propertyFeePaymentExcution);
	        }
	    }   
	    
	    //查门牌号遍历
	    @RequestMapping(value = "/findAreaOrMoneyOrName",
	            method = RequestMethod.POST,
	            produces = "text/json;charset=UTF-8")
	    @ResponseBody
	    public String findAreaOrMoneyOrName(PropertyFeePaymentDto propertyFeePaymentDto) {
	        //参数验空
	        try {
	            PropertyFeePaymentExcution propertyFeePaymentExcution = propertyFeePaymentService.findAreaOrMoneyOrName(propertyFeePaymentDto);
	            return BaseUIResult.returnJson(propertyFeePaymentExcution);
	        } catch (Exception e) {
	            logger.error(e.getMessage(), e);
	            PropertyFeePaymentExcution propertyFeePaymentExcution = new PropertyFeePaymentExcution(PropertyFeePaymentEnum.ERROR,e.getMessage());
	            return BaseUIResult.returnJson(propertyFeePaymentExcution);
	        }
	    }

	//查码表缴纳月数
	@RequestMapping(value = "/findMoneyMonth",
			method = RequestMethod.POST,
			produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String findMoneyMonth() {
		//参数验空
		try {
			PropertyFeePaymentExcution propertyFeePaymentExcution = propertyFeePaymentService.findMoneyMonth();
			return BaseUIResult.returnJson(propertyFeePaymentExcution);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			PropertyFeePaymentExcution propertyFeePaymentExcution = new PropertyFeePaymentExcution(PropertyFeePaymentEnum.ERROR,e.getMessage());
			return BaseUIResult.returnJson(propertyFeePaymentExcution);
		}
	}

	//查开始日期 = 上次 结束日期+1   where 小区ID ， 门牌号
	@RequestMapping(value = "/findStartTime",
			method = RequestMethod.POST,
			produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String findStartTime(PropertyFeePaymentDto propertyFeePaymentDto) {
		//参数验空
		try {
			PropertyFeePaymentExcution propertyFeePaymentExcution = propertyFeePaymentService.findStartTime(propertyFeePaymentDto);
			return BaseUIResult.returnJson(propertyFeePaymentExcution);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			PropertyFeePaymentExcution propertyFeePaymentExcution = new PropertyFeePaymentExcution(PropertyFeePaymentEnum.ERROR,e.getMessage());
			return BaseUIResult.returnJson(propertyFeePaymentExcution);
		}
	}

	//查询 此物业是总部还是物业公司
	@RequestMapping(value = "/findType",
			method = RequestMethod.POST,
			produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String findType(PropertyFeePaymentDto propertyFeePaymentDto) {
		//参数验空
		try {
			PropertyFeePaymentExcution propertyFeePaymentExcution = propertyFeePaymentService.findType(propertyFeePaymentDto);
			return BaseUIResult.returnJson(propertyFeePaymentExcution);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			PropertyFeePaymentExcution propertyFeePaymentExcution = new PropertyFeePaymentExcution(PropertyFeePaymentEnum.ERROR,e.getMessage());
			return BaseUIResult.returnJson(propertyFeePaymentExcution);
		}
	}

	//查询 操作人员有权限的小区 遍历出来
	@RequestMapping(value = "/findRidComm",
			method = RequestMethod.POST,
			produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String findRidComm(@Param("rid")int rid) {
		//参数验空
		try {
			PropertyFeePaymentExcution propertyFeePaymentExcution = propertyFeePaymentService.findRidComm(rid);
			return BaseUIResult.returnJson(propertyFeePaymentExcution);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			PropertyFeePaymentExcution propertyFeePaymentExcution = new PropertyFeePaymentExcution(PropertyFeePaymentEnum.ERROR,e.getMessage());
			return BaseUIResult.returnJson(propertyFeePaymentExcution);
		}
	}
}
