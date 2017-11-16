package com.ywqf.util;

import com.ywqf.common.JsonData;
import com.ywqf.exception.ParamException;
import com.ywqf.exception.PermissionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by sunzhongyuan on 2017/10/20.
 */
public class SpringExceptionResolver implements HandlerExceptionResolver{

    //日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {
        String url = httpServletRequest.getRequestURL().toString();
        ModelAndView mv;
        String defaultMsg = "system error!";
        if (url.endsWith(".json")) {
            if (e instanceof PermissionException || e instanceof ParamException) {
                JsonData ret = JsonData.fail(e.getMessage());
                mv = new ModelAndView("jsonView",ret.toMap());
            } else {
                logger.error("unknow json exception, url:" + url, e);
                JsonData ret = JsonData.fail(defaultMsg);
                mv = new ModelAndView("jsonView",ret.toMap());
            }
        } else if (url.endsWith(".page")){
            logger.error("unknow page exception, url:" + url, e);
            JsonData ret = JsonData.fail(defaultMsg);
            mv = new ModelAndView("exception",ret.toMap());
        } else {
            logger.error("unknow exception, url:" + url, e);
            JsonData ret = JsonData.fail(defaultMsg);
            mv = new ModelAndView("jsonView",ret.toMap());
        }
        return mv;
    }

}
