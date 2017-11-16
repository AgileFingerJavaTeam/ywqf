package com.ywqf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ywqf.base.BaseController;
import com.ywqf.base.BaseUIResult;
import com.ywqf.dto.excution.CompanyInforExcution;
import com.ywqf.dto.in.CompanyInforDto;
import com.ywqf.enums.CompanyInforEnum;
import com.ywqf.exception.db.InsertInnerErrorException;
import com.ywqf.service.CompanyInforService;

@Controller
@RequestMapping(value = "/CompanyInfor")
public class CompanyInforController extends BaseController{
	
	@Autowired
    private CompanyInforService companyInfoService;
	
    /**
     * 显示公司信息管理页面
     * @return
     */
    @RequestMapping(value = "/showCompanyInfor",
            method = RequestMethod.GET,
            produces = {"text/json;charset=UTF-8"})
    public ModelAndView showCompanyInfor(){
        ModelAndView mv = new ModelAndView();
        try {
        	CompanyInforExcution companyInforExcution = companyInfoService.findCompanyInfor();
            mv.addObject("data",companyInforExcution);
            mv.setViewName("companyinfor/showComPanyInfor");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mv;
    }
    
    /**
     * 编辑公司信息
     * @return
     */
    @RequestMapping(value = "/editCompanyInfor",method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String editCompanyInfor(CompanyInforDto companyInforDto) {

        try {
            CompanyInforExcution companyInforExcution = companyInfoService.editCompanyInfor(companyInforDto);
            return BaseUIResult.returnJsonMSG(1, companyInforExcution, "修改成功!");
        } catch (InsertInnerErrorException e) {
     	   logger.error(e.getMessage(), e);
     	   CompanyInforExcution companyInforExcution = new CompanyInforExcution(CompanyInforEnum.FIND_ERROR, e.getMessage());
     	   return BaseUIResult.returnJsonMSG(0, companyInforExcution, "修改失败!");
        }
    }
}
