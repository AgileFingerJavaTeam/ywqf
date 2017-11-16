package com.ywqf.controller;

import com.ywqf.exception.db.QueryInnerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ywqf.base.BaseController;
import com.ywqf.base.BaseUIResult;
import com.ywqf.dto.excution.ParkingFeePaymentExcution;
import com.ywqf.dto.excution.PropertyFeePaymentExcution;
import com.ywqf.dto.in.ParkingFeePaymentDto;
import com.ywqf.dto.in.PropertyFeePaymentDto;
import com.ywqf.enums.ParkingFeePaymentEnum;
import com.ywqf.enums.PropertyFeePaymentEnum;
import com.ywqf.service.ParkingFeePaymentService;

@Controller
@RequestMapping("/ParkingFeePayment")
public class ParkingFeePaymentController extends BaseController{

	@Autowired
	private ParkingFeePaymentService parkingFeePaymentService;
	
	  @RequestMapping(value = "/showParking")
	    public ModelAndView showCarousePage() {
	        ModelAndView mv = new ModelAndView();
	        try {
				int id = 1000;
				String name = "燚龘";
				int corp_id = 1000;
				mv.addObject("corp_id", corp_id);
				mv.addObject("Rid", id);
				mv.addObject("Rname",name);
	            mv.setViewName("ParkingFeePayment/showParking");
	        } catch (Exception e) {
	        	 logger.error(e.getMessage(),e);
	        }
	        return mv;
	    }
	  
	  /**
	     * 查数据
	     * @return
	     */
	    @RequestMapping(value = "/getParkingList",
	            method = RequestMethod.POST,
	            produces = "text/json;charset=UTF-8")
	    @ResponseBody
	    public String getParameterList(ParkingFeePaymentDto parkingFeePaymentDto) {
	        try {
	            ParkingFeePaymentExcution parkingFeePaymentExcution = parkingFeePaymentService.findParkingList(parkingFeePaymentDto);
	            return BaseUIResult.returnJsonEasyUI(parkingFeePaymentExcution);
	        } catch (Exception e) {
	            logger.error(e.getMessage(), e);
	            ParkingFeePaymentExcution parkingFeePaymentExcution = new ParkingFeePaymentExcution(ParkingFeePaymentEnum.ERROR,e.getMessage());
	            return BaseUIResult.returnJsonEasyUI(parkingFeePaymentExcution);
	        }
	    }
	    
	    //查 作废
	    @RequestMapping(value = "/showOver",
	            method = RequestMethod.GET,
	            produces = "text/json;charset=UTF-8")
	    @ResponseBody
	    public ModelAndView showOver(ParkingFeePaymentDto parkingFeePaymentDto) {
	        ModelAndView mv = new ModelAndView();
	        try {
	        	ParkingFeePaymentExcution parkingFeePaymentExcution =  parkingFeePaymentService.findOver(parkingFeePaymentDto);
	            mv.addObject("data", parkingFeePaymentExcution.getData());
	        	mv.setViewName("ParkingFeePayment/showOver");
	        } catch (Exception e) {
	        	 logger.error(e.getMessage(),e);
	        }
	        return mv;
	    }
	    
	    /**
	     * 修改作废
	     * @return
	     */
	    @RequestMapping(value = "/updateOver",
	            method = RequestMethod.POST,
	            produces = "text/json;charset=UTF-8")
	    @ResponseBody
	    public String updateOver(ParkingFeePaymentDto parkingFeePaymentDto) {
	        try {
	            ParkingFeePaymentExcution parkingFeePaymentExcution = parkingFeePaymentService.updateOver(parkingFeePaymentDto);
	            return BaseUIResult.returnJsonMSG(1, parkingFeePaymentExcution, "修改成功");
	        } catch (Exception e) {
	            logger.error(e.getMessage(), e);
	            ParkingFeePaymentExcution parkingFeePaymentExcution = new ParkingFeePaymentExcution(ParkingFeePaymentEnum.ERROR,e.getMessage());
	            return BaseUIResult.returnJsonMSG(0, parkingFeePaymentExcution, "修改失败");
	        }
	    }

	//查询遍历 小区         where 物业公司
	@RequestMapping(value = "/findVillage",
			method = RequestMethod.POST,
			produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String findVillage(ParkingFeePaymentDto parkingFeePaymentDto) {
		//参数验空
		try {
			ParkingFeePaymentExcution parkingFeePaymentExcution = parkingFeePaymentService.findVillage(parkingFeePaymentDto);
			return BaseUIResult.returnJson(parkingFeePaymentExcution);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			ParkingFeePaymentExcution parkingFeePaymentExcution = new ParkingFeePaymentExcution(ParkingFeePaymentEnum.ERROR,e.getMessage());
			return BaseUIResult.returnJson(parkingFeePaymentExcution);
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
			ParkingFeePaymentExcution parkingFeePaymentExcution = parkingFeePaymentService.findMoneyMonth();
			return BaseUIResult.returnJson(parkingFeePaymentExcution);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			ParkingFeePaymentExcution parkingFeePaymentExcution = new ParkingFeePaymentExcution(ParkingFeePaymentEnum.ERROR,e.getMessage());
			return BaseUIResult.returnJson(parkingFeePaymentExcution);
		}
	}

	//查询遍历  收费人员
	@RequestMapping(value = "/findAccount",
			method = RequestMethod.GET,
			produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String findAccount(ParkingFeePaymentDto parkingFeePaymentDto) {
		//参数验空
		try {
			ParkingFeePaymentExcution parkingFeePaymentExcution = parkingFeePaymentService.findAccount(parkingFeePaymentDto);
			return BaseUIResult.returnJson(parkingFeePaymentExcution);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			ParkingFeePaymentExcution parkingFeePaymentExcution = new ParkingFeePaymentExcution(ParkingFeePaymentEnum.ERROR,e.getMessage());
			return BaseUIResult.returnJson(parkingFeePaymentExcution);
		}
	}

	//查门牌号是否存在
	@RequestMapping(value = "/findHouseNumIsNull",
			method = RequestMethod.POST,
			produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String findHouseNumIsNull(ParkingFeePaymentDto parkingFeePaymentDto) {
		//参数验空
		try {
			ParkingFeePaymentExcution parkingFeePaymentExcution = parkingFeePaymentService.findHouseNumIsNull(parkingFeePaymentDto);
			return BaseUIResult.returnJson(parkingFeePaymentExcution);
		}catch(QueryInnerErrorException e) {
			logger.error(e.getMessage(), e);
			ParkingFeePaymentExcution parkingFeePaymentExcution = new ParkingFeePaymentExcution(ParkingFeePaymentEnum.ERROR,e.getMessage());
			return BaseUIResult.returnJson(parkingFeePaymentExcution);
		}
		catch(Exception e) {
			logger.error(e.getMessage(), e);
			ParkingFeePaymentExcution parkingFeePaymentExcution = new ParkingFeePaymentExcution(ParkingFeePaymentEnum.ERROR,e.getMessage());
			return BaseUIResult.returnJson(parkingFeePaymentExcution);
		}
	}

	//查门牌号遍历 车主名 车位单价 车牌号
	@RequestMapping(value = "/findCarNumberOrMoneyOrName",
			method = RequestMethod.POST,
			produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String findCarNumberOrMoneyOrName(ParkingFeePaymentDto parkingFeePaymentDto) {
		//参数验空
		try {
			ParkingFeePaymentExcution parkingFeePaymentExcution = parkingFeePaymentService.findCarNumberOrMoneyOrName(parkingFeePaymentDto);
			return BaseUIResult.returnJson(parkingFeePaymentExcution);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			ParkingFeePaymentExcution parkingFeePaymentExcution = new ParkingFeePaymentExcution(ParkingFeePaymentEnum.ERROR,e.getMessage());
			return BaseUIResult.returnJson(parkingFeePaymentExcution);
		}
	}

	//查开始日期 = 上次 结束日期+1   where 小区ID ， 门牌号
	@RequestMapping(value = "/findStartTime",
			method = RequestMethod.POST,
			produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String findStartTime(ParkingFeePaymentDto parkingFeePaymentDto) {
		//参数验空
		try {
			ParkingFeePaymentExcution parkingFeePaymentExcution = parkingFeePaymentService.findStartTime(parkingFeePaymentDto);
			return BaseUIResult.returnJson(parkingFeePaymentExcution);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			ParkingFeePaymentExcution parkingFeePaymentExcution = new ParkingFeePaymentExcution(ParkingFeePaymentEnum.ERROR,e.getMessage());
			return BaseUIResult.returnJson(parkingFeePaymentExcution);
		}
	}

	//添加方法
	@RequestMapping(value = "/insertParking",
			method = RequestMethod.POST,
			produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String insertParking(ParkingFeePaymentDto parkingFeePaymentDto) {
		//参数验空
		try {
			ParkingFeePaymentExcution parkingFeePaymentExcution = parkingFeePaymentService.insertParking(parkingFeePaymentDto);
			return BaseUIResult.returnJsonMSG(1,parkingFeePaymentExcution,"添加成功");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			ParkingFeePaymentExcution parkingFeePaymentExcution = new ParkingFeePaymentExcution(ParkingFeePaymentEnum.ERROR,e.getMessage());
			return BaseUIResult.returnJsonMSG(0,parkingFeePaymentExcution,"添加失败");
		}
	}
}
