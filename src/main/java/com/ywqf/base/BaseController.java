package com.ywqf.base;


import com.ywqf.util.UuidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by sunzhongyuan on 2017/9/20.
 */
public class BaseController {

    public Logger logger= LoggerFactory.getLogger(this.getClass());


    /**
     * 得到32位的uuid
     * @return
     */
    public String get32UUID(){

        return UuidUtil.get32UUID();
    }

    /**
     * 得到request对象
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        return request;
    }
  


}
