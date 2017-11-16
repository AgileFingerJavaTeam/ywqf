package com.ywqf.controller;


import com.ywqf.base.BaseController;
import com.ywqf.base.BaseUIResult;
import com.ywqf.dto.excution.ForgetPasswordExcution;
import com.ywqf.dto.in.ForgetPasswordDto;
import com.ywqf.enums.ForgetPasswordEnum;
import com.ywqf.exception.db.InsertInnerErrorException;
import com.ywqf.exception.db.QueryInnerErrorException;
import com.ywqf.service.ForgetPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/ForgetPassword")
public class ForgetPasswordController extends BaseController{
    @Autowired ForgetPasswordService forgetPasswordService;
	 /**
     *显示忘记密码页面
     * @return
     */
    @RequestMapping(value = "/showForgetPasswordPage",           
            produces = {"text/json;charset=UTF-8"})
    public ModelAndView showAddMerchantPage(){
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("forgetPassword/resetPassword");
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return mv;
    }

    /**
     * 申请充值密码
     * @param forgetPasswordDto
     * @return
     */
    @RequestMapping(value = "/applyResetPassword",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String applyResetPassword(ForgetPasswordDto forgetPasswordDto){
        try {
            ForgetPasswordExcution forgetPasswordExcution = forgetPasswordService.applyResetPassword(forgetPasswordDto);
            return BaseUIResult.returnJsonMSG(1,forgetPasswordExcution,"申请重置密码成功");
        }catch (InsertInnerErrorException e){
            ForgetPasswordExcution forgetPasswordExcution = new ForgetPasswordExcution(ForgetPasswordEnum.APPLY_FAIL,e.getMessage());
            return BaseUIResult.returnJsonMSG(-1,forgetPasswordExcution,"您输入的信息与系统录入信息不符");
        }catch (QueryInnerErrorException e){
            ForgetPasswordExcution forgetPasswordExcution = new ForgetPasswordExcution(ForgetPasswordEnum.APPLY_FAIL,e.getMessage());
            return BaseUIResult.returnJsonMSG(-1,forgetPasswordExcution,"您输入的信息与系统录入信息不符");
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            ForgetPasswordExcution forgetPasswordExcution = new ForgetPasswordExcution(ForgetPasswordEnum.APPLY_FAIL,e.getMessage());
            return BaseUIResult.returnJsonMSG(-1,forgetPasswordExcution,"您输入的信息与系统录入信息不符");
        }
    }

    @RequestMapping(value = "/checkUserName",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String checkUserName(ForgetPasswordDto forgetPasswordDto){
        try {
            ForgetPasswordExcution forgetPasswordExcution = forgetPasswordService.checkUserName(forgetPasswordDto);
            return BaseUIResult.returnJsonEasyUI(forgetPasswordExcution);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            ForgetPasswordExcution forgetPasswordExcution = new ForgetPasswordExcution(ForgetPasswordEnum.APPLY_FAIL);
            return BaseUIResult.returnJsonEasyUI(forgetPasswordExcution);
        }
    }
}
