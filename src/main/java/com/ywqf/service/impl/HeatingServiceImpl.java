package com.ywqf.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywqf.base.BaseException;
import com.ywqf.dao.HeatingDao;
import com.ywqf.dto.excution.HeatingExcution;
import com.ywqf.dto.in.HeatingDto;
import com.ywqf.entity.Heating;
import com.ywqf.enums.HeatingEnum;
import com.ywqf.service.HeatingService;
@Service
public class HeatingServiceImpl implements HeatingService {
	
	//日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private HeatingDao heatingDao;

	@Override
	public HeatingExcution getHeatingList(HeatingDto heatingDto) {
		int checked = heatingDto.getChecked();
		int timeYear = heatingDto.getTimeYear();
		int corpsID = heatingDto.getSelectCompanyID();//物业公司ID
		int selectcommunityID = heatingDto.getSelectcommunityID();
		int userID = 12423543;//登录人ID
		int type = 1;//登录人是总公司还是物业公司
		try{
			List<Heating> heatingList = heatingDao.getHeatingList(checked,timeYear);
			
//			List<Heating> heatingCommunityList = heatingDao.getHeatingCommunity(userID);
//			List<Heating> heatingCommunityList = heatingDao.getAllCommunity(corpsID);
			
			int total = heatingDao.findHeatingCount(checked,timeYear);
			HashMap<String, Object> map=new HashMap<String, Object>();
            map.put("rows",heatingList);
            map.put("total",total);
//            map.put("community",heatingCommunityList);
            return  new HeatingExcution(HeatingEnum.SUCCESS,map);
		}catch (Exception  e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
	}

	@Override
	public HeatingExcution getHeatingCoursAndCommunity() {
		int userID = 12423543;
		int corpsType = 1;
		int corpsID=8001;//物业公司ID
		try {
			List<Heating> heatingCorpsList = heatingDao.getHeatingCorps(userID,corpsType);
			List<Heating> heatingCommunityList = null;
			if (corpsType==1) {
				heatingCommunityList = heatingDao.getAllCommunity(corpsID);
			}else {
				heatingCommunityList = heatingDao.getHeatingCommunity(userID);
			}
			
//			List<Heating> heatingCommunityList = heatingDao.getHeatingCommunity(userID);
			HashMap<String, Object> map=new HashMap<String, Object>();
            map.put("rows",heatingCorpsList);
            map.put("total",heatingCommunityList);
            map.put("type", corpsType);
            return  new HeatingExcution(HeatingEnum.SUCCESS,map);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
		}
	}

}
