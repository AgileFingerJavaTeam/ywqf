package com.ywqf.controller;

import com.ywqf.base.BaseController;
import com.ywqf.base.BaseUIResult;
import com.ywqf.dto.excution.EstatePayExcution;
import com.ywqf.dto.excution.ResetPasswordExcution;
import com.ywqf.dto.in.ResetPasswordDto;
import com.ywqf.enums.EstatePayEnum;
import com.ywqf.enums.ResetPasswordEnum;
import com.ywqf.service.UserPasswordResetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/resetPassword")
public class UserPasswordResetController extends BaseController{
    @Autowired
    private UserPasswordResetService userPasswordResetService;

    /**
     * 显示重置密码页面
     * @return
     */
    @RequestMapping(value = "/showResetPasswordPage",
            produces = {"text/json;charset=UTF-8"})
    public ModelAndView showResetPasswordPage(){
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("resetPassword/resetPasswordPage");
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return mv;
    }

    /**
     * 查询申请重置密码信息
     * @param resetPasswordDto
     * @return
     */
    @RequestMapping(value = "/findApplyResetPasswordInfo",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findApplyResetPasswordInfo(ResetPasswordDto resetPasswordDto){
        try {
            ResetPasswordExcution resetPasswordExcution = userPasswordResetService.findApplyResetPasswordInfo(resetPasswordDto);
            return BaseUIResult.returnJson(resetPasswordExcution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            ResetPasswordExcution resetPasswordExcution = new ResetPasswordExcution(ResetPasswordEnum.FIND_FAIL,e.getMessage());
            return BaseUIResult.returnJson(resetPasswordExcution);
        }
    }

    /**
     * 重置密码
     * @param resetPasswordDto
     * @return
     */
    @RequestMapping(value = "/resetPassword",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String resetPassword(ResetPasswordDto resetPasswordDto){
        try{
            ResetPasswordExcution resetPasswordExcution = userPasswordResetService.resetPassword(resetPasswordDto);
            return BaseUIResult.returnJson(resetPasswordExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            ResetPasswordExcution resetPasswordExcution = new ResetPasswordExcution(ResetPasswordEnum.RESET_FAIL, e.getMessage());
            return BaseUIResult.returnJson(resetPasswordExcution);
        }
    }
}
