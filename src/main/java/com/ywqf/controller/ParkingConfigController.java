package com.ywqf.controller;

import com.ywqf.base.BaseController;
import com.ywqf.base.BaseUIResult;
import com.ywqf.dto.excution.HouseExcution;
import com.ywqf.dto.in.HouseDto;
import com.ywqf.enums.HouseEnum;
import com.ywqf.exception.db.InsertInnerErrorException;
import com.ywqf.exception.db.QueryInnerErrorException;
import com.ywqf.service.HouseConfigService;
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
    private HouseConfigService houseConfigService;


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


    /*查询物业*/
    @RequestMapping(value = "/getCompany",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getCompany(){
        try {
            HouseExcution houseExcution = houseConfigService.findCompanyById();
            return BaseUIResult.returnJson(houseExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            HouseExcution houseExcution =new HouseExcution(HouseEnum.FIND_FAIL,e.getMessage());

            return  BaseUIResult.returnJsonEasyUI(houseExcution);
        }
    }

    /*查询总部旗下物业*/
    @RequestMapping(value = "/getLeaderCompany",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getLeaderCompany(){
        try {
            HouseExcution houseExcution = houseConfigService.findCompanyByType();
            return BaseUIResult.returnJson(houseExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            HouseExcution houseExcution =new HouseExcution(HouseEnum.FIND_FAIL,e.getMessage());

            return  BaseUIResult.returnJsonEasyUI(houseExcution);
        }
    }

    /*查询小区*/
    @RequestMapping(value = "/getCommunity",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getCommunity(){
        try {
            HouseExcution houseExcution = houseConfigService.findCommunityById();
            return BaseUIResult.returnJson(houseExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            HouseExcution houseExcution =new HouseExcution(HouseEnum.FIND_FAIL,e.getMessage());

            return  BaseUIResult.returnJsonEasyUI(houseExcution);
        }
    }

    /*查询子小区*/
    @RequestMapping(value = "/getChildCommunity",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getChildCommunity(HouseDto houseDto){
        try {
            HouseExcution houseExcution = houseConfigService.findChildCommunityById(houseDto);
            return BaseUIResult.returnJson(houseExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            HouseExcution houseExcution =new HouseExcution(HouseEnum.FIND_FAIL,e.getMessage());

            return  BaseUIResult.returnJsonEasyUI(houseExcution);
        }
    }



    
    /*查询信息列表*/
   @RequestMapping(value = "/getHouseList",
           method = RequestMethod.POST,
           produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String getHouseList(HouseDto houseDto){
        try {
            HouseExcution houseExcution = houseConfigService.findHouseInfo(houseDto);
            return BaseUIResult.returnJsonEasyUI(houseExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            HouseExcution houseExcution =new HouseExcution(HouseEnum.FIND_FAIL,e.getMessage());

            return  BaseUIResult.returnJsonEasyUI(houseExcution);
        }
   }
   
/*   *//*
    * 
    *添加配置信息
    * 
    * *//*
   @RequestMapping(value = "/addHouseInfo")
   public ModelAndView addHouseInfo(){
   	 ModelAndView mv = new ModelAndView();
        try {
        	int id=1000;
        	String employname="花非花";
        	String corpsname="怪盗基德";
        	 mv.addObject("corp_id", id);
             mv.addObject("name", employname);
             mv.addObject("corpsname",corpsname);
            mv.setViewName("house/addHousePage");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return mv;
   }*/
   /**
    * 获取社区名称
    *
    * @return
    */
   @RequestMapping(value = "/getCommunityName",method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
   @ResponseBody
   public String getCommunityName(HouseDto houseDto) {

       try {
           HouseExcution houseExcution = houseConfigService.findCommunityName(houseDto);
           return BaseUIResult.returnJson(houseExcution);
       } catch (Exception e) {
           logger.error(e.getMessage(), e);
           HouseExcution houseExcution = new HouseExcution(HouseEnum.FIND_FAIL, e.getMessage());
           return BaseUIResult.returnJson(houseExcution);
       }
   }
   
   /**
    * 获取户型
    *
    * @return
    */
   @RequestMapping(value = "/getRoomType",method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
   @ResponseBody
   public String getRoomType(HouseDto houseDto) {

       try {
           HouseExcution houseExcution = houseConfigService.findRoomType(houseDto);
           return BaseUIResult.returnJson(houseExcution);
       } catch (Exception e) {
           logger.error(e.getMessage(), e);
           HouseExcution houseExcution = new HouseExcution(HouseEnum.FIND_FAIL, e.getMessage());
           return BaseUIResult.returnJson(houseExcution);
       }
   }
   
   /**
    * 提交新增配置信息
    *
    * @return
    */
   @RequestMapping(value = "/subHouseInfo",method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
   @ResponseBody
   public String subHouseInfo(HouseDto houseDto) {
       try {
           HouseExcution houseExcution = houseConfigService.saveHouseInfo(houseDto);
           return BaseUIResult.returnJsonMSG(1, houseExcution, "新增成功");
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

    /*
    *
    *修改配置信息
    *
    * */
    @RequestMapping(value = "/editHouseInfo")
    public ModelAndView editHouseInfo(HouseDto houseDto){
        ModelAndView mv = new ModelAndView();
        try {
            HouseExcution houseExcution=houseConfigService.findHouseInfoByID(houseDto);
            mv.addObject("data", houseExcution.getData());
            mv.setViewName("house/editHousePage");
        } catch (QueryInnerErrorException e) {
            HouseExcution houseExcution = new HouseExcution(HouseEnum.FIND_FAIL, e.getMessage());
            logger.error(e.toString(), e);
        }catch (Exception e) {
            HouseExcution houseExcution = new HouseExcution(HouseEnum.FIND_FAIL, e.getMessage());
            logger.error(e.toString(), e);
        }
        return mv;
    }


    /**
     * 提交修改配置信息
     *
     * @return
     */
    @RequestMapping(value = "/subEditHouseInfo",method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String subEditHouseInfo(HouseDto houseDto) {
        try {
            HouseExcution houseExcution = houseConfigService.editHouseInfo(houseDto);
            return BaseUIResult.returnJsonMSG(1, houseExcution, "修改成功");
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


    /*
    *
    *查询信息
    *
    * */
    @RequestMapping(value = "/deleteHouseInfo")
    public ModelAndView deleteHouseInfo(HouseDto houseDto){
        ModelAndView mv = new ModelAndView();
        try {
            HouseExcution houseExcution=houseConfigService.findHouseInfoByID(houseDto);
            mv.addObject("data", houseExcution.getData());
            mv.setViewName("house/deleteHousePage");
        } catch (QueryInnerErrorException e) {
            HouseExcution houseExcution = new HouseExcution(HouseEnum.FIND_FAIL, e.getMessage());
            logger.error(e.toString(), e);
        }catch (Exception e) {
            HouseExcution houseExcution = new HouseExcution(HouseEnum.FIND_FAIL, e.getMessage());
            logger.error(e.toString(), e);
        }
        return mv;
    }

    /**
     * 提交删除信息
     *
     * @return
     */
    @RequestMapping(value = "/subDelHouseInfo",method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String subDelHouseInfo(HouseDto houseDto) {
        try {
            HouseExcution houseExcution = houseConfigService.deleteHouseInfo(houseDto);
            return BaseUIResult.returnJsonMSG(1, houseExcution, "修改成功");
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
