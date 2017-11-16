package com.ywqf.controller;

import com.ywqf.base.BaseController;
import com.ywqf.base.BaseUIResult;
import com.ywqf.dto.excution.NewsHallExcution;
import com.ywqf.dto.in.NewsHallDto;
import com.ywqf.enums.NewsHallEnum;
import com.ywqf.service.NewsHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("newsHall")
public class NewsHallController extends BaseController{
@Autowired NewsHallService newsHallService;

    /**
     * 显示消息大厅页面
     * @return
     */
    @RequestMapping(value = "/showNewsHallPage",
            produces = {"text/json;charset=UTF-8"})
    public ModelAndView showNewsHallPage(){
        ModelAndView mv = new ModelAndView();
        try{
            mv.setViewName("newsHall/newsHall");
        }catch (Exception e){
          logger.error(e.getMessage(),e);
        }
        return mv;
    }

    /**
     * 查询公告信息
     * @return
     */
    @RequestMapping(value = "/findNewsInfo",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findNewsInfo(NewsHallDto newsHallDto){
        try{
            NewsHallExcution newsHallExcution = newsHallService.findNewsInfo(newsHallDto);
            return BaseUIResult.returnJson(newsHallExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            NewsHallExcution newsHallExcution = new NewsHallExcution(NewsHallEnum.FIND_FAIL, e.getMessage());
            return BaseUIResult.returnJson(newsHallExcution);
        }
    }
}
