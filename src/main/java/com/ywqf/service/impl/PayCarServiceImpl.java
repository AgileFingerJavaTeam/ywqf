package com.ywqf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywqf.dao.PayCarNumDao;
import com.ywqf.dto.excution.CarExcution;
import com.ywqf.dto.excution.CommunityExcution;
import com.ywqf.dto.excution.CorpExcution;
import com.ywqf.dto.excution.PayCarResultExcution;
import com.ywqf.dto.excution.PayYearResultExcution;
import com.ywqf.dto.in.CommunityDto;
import com.ywqf.dto.in.PayCarNumDto;
import com.ywqf.entity.Community;
import com.ywqf.entity.Corp;
import com.ywqf.entity.PayCarNum;
import com.ywqf.entity.PayYearNum;
import com.ywqf.enums.PayCarNumEnum;
import com.ywqf.enums.PayYearNumEnum;
import com.ywqf.service.PayCarNumService;
@Service
public class PayCarServiceImpl implements PayCarNumService {
	
	@Autowired 
	private PayCarNumDao payCarNumDao;
	//日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public CarExcution CorpList(int id, int type) {
		try {
			List<Corp> list =payCarNumDao.findCorpName(id,type);
			if (list == null) {
                list = new ArrayList<Corp>();
            }
			return new CarExcution(PayCarNumEnum.SUCCESS,list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public CarExcution CommunityList(CommunityDto communityDto) {
		try {
			List<Community> list =payCarNumDao.findCommunityName(communityDto);
			if(list == null){
				list = new ArrayList<Community>();
			}
			return new CarExcution(PayCarNumEnum.SUCCESS,list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public PayCarResultExcution PayCarResult(PayCarNumDto payCarNumDto) {
		try {
			List<PayCarNum> list =payCarNumDao.listCommunity(payCarNumDto);
			if (list == null) {
                list = new ArrayList<PayCarNum>();
            }
			List result =new ArrayList<>();
			for(PayCarNum pyn:list){
				List listnew =new ArrayList<>();
				Map map =new HashMap<>();
				map.put("value", pyn.getPayNum());
				map.put("name", "已缴费");
				listnew.add(map);
				Map map1 =new HashMap<>();
				map1.put("value", pyn.getNoPayNum());
				map1.put("name", "未缴费");
				listnew.add(map1);
				Map mapnew = new HashMap<>();
				mapnew.put("name", pyn.getCommunityName());
				mapnew.put("rate", pyn.getRate());
				mapnew.put("reslut", listnew);
				result.add(mapnew);
			}
            return new PayCarResultExcution(PayCarNumEnum.SUCCESS,result);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
    

}
