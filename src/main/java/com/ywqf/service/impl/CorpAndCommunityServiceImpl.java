
package com.ywqf.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywqf.base.BaseException;
import com.ywqf.dao.CorpAndCommunityDao;
import com.ywqf.dto.excution.CorpAndCommunityExcution;
import com.ywqf.entity.CorpAndCommunity;
import com.ywqf.enums.CorpAndCommunityEnum;
import com.ywqf.service.CorpAndCommunityService;

@Service
public class CorpAndCommunityServiceImpl implements CorpAndCommunityService{
	
	//日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    
	@Autowired
	private CorpAndCommunityDao corpAndCommunityDao;

	@Override
	public CorpAndCommunityExcution getCorpAndCommunity() {
		int userID = 333;
		int type =1;//类型（1:总部 0:物业公司）
		List<CorpAndCommunity> corpList = null;
		List<CorpAndCommunity> communityList = null;
		HashMap<String, Object> map=new HashMap<String, Object>();
		try {
			if (type == 1) {
				corpList = corpAndCommunityDao.getAllCorp();
				int corpsID = corpList.get(0).getCorpId();
				communityList = corpAndCommunityDao.getAllCommunity(corpsID);
			}else {
				communityList = corpAndCommunityDao.getCommunity(userID);
				int corpId = communityList.get(0).getCorpId();
				corpList = corpAndCommunityDao.getCorp(corpId);
			}
			map.put("rows",corpList);
	        map.put("total",communityList);
	        return  new CorpAndCommunityExcution(CorpAndCommunityEnum.SUCCESS,map);
		} catch (Exception e) {
			 logger.error(e.getMessage(),e);
	            throw new BaseException(e.getMessage());
		}
		
		
       
	}


}

