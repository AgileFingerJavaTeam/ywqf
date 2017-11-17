package com.ywqf.service.impl;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.ywqf.base.BaseException;
import com.ywqf.dao.PublishDao;
import com.ywqf.dto.excution.PublishExcution;
import com.ywqf.dto.in.PublishDto;
import com.ywqf.entity.PublishWorker;
import com.ywqf.enums.PublishEnum;
import com.ywqf.service.PublishService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublishServiceImpl implements PublishService{
    private org.slf4j.Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PublishDao publishDao;

    @Override
    public PublishExcution addNews(PublishDto publishDto) {
        try {
            int isAdd = publishDao.isAdd();
            return new PublishExcution(PublishEnum.FIND_SUCCESS,isAdd);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }

    /**
     * 删除信息
     * @param publishDto
     * @return
     */
    @Override
    public PublishExcution removeNews(PublishDto publishDto) {
       int announcementId = publishDto.getAnnouncementId();
       try{
           int isRemove = publishDao.isRemove(announcementId);
           return new PublishExcution(PublishEnum.REMOVE_SUCCESS,isRemove);
       }catch (Exception e){
           logger.error(e.getMessage(),e);
           throw new BaseException(e.getMessage());
       }
    }

    /**
     * 查询发布员工列表
     * @return
     */
    @Override
    public PublishExcution findPublishWorker(PublishDto publishDto) {
        int corpId = 9999;
        try {
            List<PublishWorker>  publishWorkerList = publishDao.findPublishWorker(corpId);
            return  new PublishExcution(PublishEnum.FIND_SUCCESS,publishWorkerList);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }
}
