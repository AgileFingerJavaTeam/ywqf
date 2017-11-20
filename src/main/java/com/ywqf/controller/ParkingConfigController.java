package com.ywqf.controller;

import com.ywqf.base.BaseController;
import com.ywqf.base.BaseUIResult;
import com.ywqf.dto.excution.HouseExcution;
import com.ywqf.dto.excution.ParkingConfigExcution;
import com.ywqf.dto.in.HouseDto;
import com.ywqf.dto.in.ParkingConfigDto;
import com.ywqf.enums.HouseEnum;
import com.ywqf.enums.ParkingConfigEnum;
import com.ywqf.exception.db.InsertInnerErrorException;
import com.ywqf.exception.db.QueryInnerErrorException;
import com.ywqf.service.HouseConfigService;
import com.ywqf.service.ParkingConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/parkingConfig")
public class ParkingConfigController extends BaseController {
    @Autowired
    private ParkingConfigService parkingConfigService;


    /*显示页面*/
    @RequestMapping(value = "/parkingPage")

    public ModelAndView housePage(){
    	 ModelAndView mv = new ModelAndView();
         try {
             mv.setViewName("parkingConfig/parkingConfig");
         } catch (Exception e) {
             logger.error(e.getMessage(), e);
         }
         return mv;
    }


    /*查询信息列表*/
    @RequestMapping(value = "/getParkingList",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getParkingList(ParkingConfigDto parkingConfigDto){
        try {
            ParkingConfigExcution parkingConfigExcution = parkingConfigService.findParkingConfig(parkingConfigDto);
            return BaseUIResult.returnJsonEasyUI(parkingConfigExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            ParkingConfigExcution parkingConfigExcution =new ParkingConfigExcution(ParkingConfigEnum.FIND_FAIL,e.getMessage());
            return  BaseUIResult.returnJsonEasyUI(parkingConfigExcution);
        }
    }

    /**
     * 户型联想
     *
     * @return
     */
    @RequestMapping(value = "/getHouseNum",method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String getHouseNum(ParkingConfigDto parkingConfigDto) {

        try {
            ParkingConfigExcution parkingConfigExcution = parkingConfigService.fingHouseNum(parkingConfigDto);
            return BaseUIResult.returnJson(parkingConfigExcution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            ParkingConfigExcution parkingConfigExcution = new ParkingConfigExcution(ParkingConfigEnum.FIND_FAIL, e.getMessage());
            return BaseUIResult.returnJson(parkingConfigExcution);
        }
    }


    /*保存信息*/
   @RequestMapping(value = "/subAddParking",method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
   @ResponseBody
   public String subAddParking(ParkingConfigDto parkingConfigDto) {
       try {
           ParkingConfigExcution parkingConfigExcution = parkingConfigService.addParkingConfig(parkingConfigDto);
           return BaseUIResult.returnJsonMSG(1, parkingConfigExcution, "新增成功");
       } catch (InsertInnerErrorException e) {
           logger.error(e.getMessage(), e);
           HouseExcution houseExcution = new HouseExcution(HouseEnum.ADD_FAIL, e.getMessage());
           return BaseUIResult.returnJsonMSG(0,houseExcution,"新增失败");
       }catch (Exception e) {
           logger.error(e.getMessage(), e);
           HouseExcution houseExcution = new HouseExcution(HouseEnum.ADD_FAIL, e.getMessage());
           return BaseUIResult.returnJsonMSG(0,houseExcution,"失败");
       }
   }


    /*查询信息通过id*/
    @RequestMapping(value = "/getParkingById",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getParkingById(ParkingConfigDto parkingConfigDto){
        try {
            ParkingConfigExcution parkingConfigExcution = parkingConfigService.findParkingById(parkingConfigDto);
            return BaseUIResult.returnJson(parkingConfigExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            ParkingConfigExcution parkingConfigExcution =new ParkingConfigExcution(ParkingConfigEnum.FIND_FAIL,e.getMessage());
            return  BaseUIResult.returnJson(parkingConfigExcution);
        }
    }


    /*保存信息*/
    @RequestMapping(value = "/subEditParking",method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String subEditParking(ParkingConfigDto parkingConfigDto) {
        try {

            ParkingConfigExcution parkingConfigExcution = parkingConfigService.subEditParking(parkingConfigDto);
            return BaseUIResult.returnJsonMSG(1, parkingConfigExcution, "新增成功");
        } catch (InsertInnerErrorException e) {
            logger.error(e.getMessage(), e);
            HouseExcution houseExcution = new HouseExcution(HouseEnum.ADD_FAIL, e.getMessage());
            return BaseUIResult.returnJsonMSG(0,houseExcution,"新增失败");
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            HouseExcution houseExcution = new HouseExcution(HouseEnum.ADD_FAIL, e.getMessage());
            return BaseUIResult.returnJsonMSG(0,houseExcution,"失败");
        }
    }


    /*删除信息*/
    @RequestMapping(value = "/subDeleteParking",method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String subDeleteParking(ParkingConfigDto parkingConfigDto) {
        try {
            ParkingConfigExcution parkingConfigExcution = parkingConfigService.deleteParking(parkingConfigDto);
            return BaseUIResult.returnJsonMSG(1, parkingConfigExcution, "修改成功");
        } catch (InsertInnerErrorException e) {
            logger.error(e.getMessage(), e);
            HouseExcution houseExcution = new HouseExcution(HouseEnum.ADD_FAIL, e.getMessage());
            return BaseUIResult.returnJsonMSG(0,houseExcution,"修改失败");
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            HouseExcution houseExcution = new HouseExcution(HouseEnum.ADD_FAIL, e.getMessage());
            return BaseUIResult.returnJsonMSG(0,houseExcution,"失败");
        }
    }

}
