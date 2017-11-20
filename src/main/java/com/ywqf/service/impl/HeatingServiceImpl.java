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
		String search = heatingDto.getSearch();
		int corpsId = heatingDto.getSelectCompanyID();//物业公司ID
		int communityId = heatingDto.getSelectcommunityID();
		int isSelect = heatingDto.getIsSelect();
		int userId = 333;//登录人ID
		int type = 1;//登录人是总公司还是物业公司
		try{
			List<Heating> heatingCommunityList = heatingDao.getHeatingCommunity(userId,type,corpsId);
			if (isSelect==1) {
				communityId=heatingCommunityList.get(0).getCommunityId();
			}		
			List<Heating> heatingList = heatingDao.getHeatingList(checked,timeYear,corpsId,communityId,userId,type,search);
			int total = heatingDao.findHeatingCount(checked,timeYear,corpsId,communityId,userId,type,search);

			int all = heatingDao.getAll(communityId);
			int pay = heatingDao.getPay(timeYear, userId, type, corpsId, communityId);
			int noPay = all-pay;
			int percentage = (int) ((pay/Double.parseDouble(String.valueOf(all)))*100 );
			HashMap<String, Object> map=new HashMap<String, Object>();
            map.put("rows",heatingList);
            map.put("total",total);
            map.put("all",all);
            map.put("pay",pay);
            map.put("noPay",noPay);
            map.put("percentage",percentage);
            map.put("community",heatingCommunityList);
            return  new HeatingExcution(HeatingEnum.SUCCESS,map);
		}catch (Exception  e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
	}



}
