package com.ywqf.controller;

import com.ywqf.base.BaseAPIExcution;
import com.ywqf.base.BaseController;
import com.ywqf.base.BaseUIResult;
import com.ywqf.dto.excution.NewsHallExcution;
import com.ywqf.dto.excution.PublishExcution;
import com.ywqf.dto.in.NewsHallDto;
import com.ywqf.dto.in.PublishDto;
import com.ywqf.enums.NewsHallEnum;
import com.ywqf.enums.PublishEnum;
import com.ywqf.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/publish")
public class PublishController extends BaseController {
    @Autowired
    private PublishService publishService;

    /**
     * 显示发布信息页面
     * @return
     */
    @RequestMapping(value = "/showPublishPage",
            produces = {"text/json;charset=UTF-8"})
    public ModelAndView showPublishPage(){
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("publish/publishPage");
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return mv;
    }

    /**
     * 查询发布员工列表
     * @param publishDto
     * @return
     */
    @RequestMapping(value = "/findPublishWorker",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String findPublishWorker(PublishDto publishDto){
        try{
            PublishExcution publishExcution = publishService.findPublishWorker(publishDto);
            return BaseUIResult.returnJson(publishExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            PublishExcution publishExcution = new PublishExcution(PublishEnum.FIND_FAIL, e.getMessage());
            return BaseUIResult.returnJson(publishExcution);
        }
    }

    /**
     * 新增信息
     * @param publishDto
     * @return
     */
    @RequestMapping(value = "/addNews",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String addNews(PublishDto publishDto){
        try {
            PublishExcution publishExcution = publishService.addNews(publishDto);
            return BaseUIResult.returnJson(publishExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            PublishExcution publishExcution = new PublishExcution(PublishEnum.ADD_SUCCESS, e.getMessage());
            return BaseUIResult.returnJson(publishExcution);
        }
    }
    /**
     * 删除信息
     * @param publishDto
     * @return
     */
    @RequestMapping(value = "/removeNews",
            method = RequestMethod.POST,
            produces = {"text/json;charset=UTF-8"})
    @ResponseBody
    public String removeNews(PublishDto publishDto){
        try{
            PublishExcution publishExcution = publishService.removeNews(publishDto);
            return BaseUIResult.returnJson(publishExcution);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            PublishExcution publishExcution = new PublishExcution(PublishEnum.REMOVE_FAIL, e.getMessage());
            return BaseUIResult.returnJson(publishExcution);
        }
    }
}
