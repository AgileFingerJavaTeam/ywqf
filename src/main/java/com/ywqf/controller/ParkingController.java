package com.ywqf.controller;

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
import com.ywqf.dto.excution.ParkingExcution;
import com.ywqf.dto.in.ParkingDto;
import com.ywqf.enums.ParkingEnum;
import com.ywqf.service.ParkingService;

@Controller
@RequestMapping(value="/parking")
public class ParkingController extends BaseController{
	@Autowired
	private ParkingService parkingService;
	
	@RequestMapping(value="/getParkingList")
	public ModelAndView getParkingList(){
		Logger logger= LoggerFactory.getLogger(this.getClass());
		ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("parking/parkingList");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mv;
	}
	
	@RequestMapping(value="/getParkingDate",method=RequestMethod.POST,produces={"text/json;charset=UTF-8"})
	@ResponseBody
	public String getParkingDate(ParkingDto parkingDto){
		try {
            ParkingExcution parkingExcution = parkingService.getFirstParkList(parkingDto);
            return BaseUIResult.returnJson(parkingExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            ParkingExcution parkingExcution =new ParkingExcution(ParkingEnum.FAIL,e.getMessage());

            return  BaseUIResult.returnJson(parkingExcution);
        }
	}
	

}
