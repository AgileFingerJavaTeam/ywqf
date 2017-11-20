package com.ywqf.service.impl;

import com.ywqf.base.BaseException;
import com.ywqf.dao.NewsHallDao;
import com.ywqf.dto.excution.NewsHallExcution;
import com.ywqf.dto.in.NewsHallDto;
import com.ywqf.entity.NewsHall;
import com.ywqf.enums.NewsHallEnum;
import com.ywqf.service.NewsHallService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class NewsHallServiceImpl implements NewsHallService{
    private org.slf4j.Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private NewsHallDao newsHallDao;

    @Override
    public NewsHallExcution findNewsInfo(NewsHallDto newsHallDto) {
        String searchNewsInfo = newsHallDto.getSearchNewsInfo();
        try {
            List<NewsHall> newsList = newsHallDao.findNewsInfo(searchNewsInfo);
            int length = newsHallDao.findNewsInfoRows(searchNewsInfo);
            HashMap map = new HashMap();
            map.put("data", newsList);
            map.put("length",length);
            return new NewsHallExcution(NewsHallEnum.FIND_SUCCESS,map);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
    }
}
