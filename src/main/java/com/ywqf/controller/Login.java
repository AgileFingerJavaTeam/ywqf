package com.ywqf.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.druid.support.logging.Log;
import com.ywqf.base.BaseController;

@Controller
@RequestMapping("/index")
public class Login extends BaseController {
	 /**
     * ��ʾҳ��
     * @return
     */
    @RequestMapping(value = "/index",           
            produces = {"text/json;charset=UTF-8"})
    public ModelAndView showAddMerchantPage(){
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("index/home");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return mv;
    }
    
    @RequestMapping(value = "/main")
    public ModelAndView main() {

        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("index/main");
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        return mv;
    }
}
