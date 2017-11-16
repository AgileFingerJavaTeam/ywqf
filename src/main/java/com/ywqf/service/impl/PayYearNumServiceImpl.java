package com.ywqf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywqf.dao.PayYearNumDao;
import com.ywqf.dto.excution.CommunityExcution;
import com.ywqf.dto.excution.CorpExcution;
import com.ywqf.dto.excution.PayYearResultExcution;
import com.ywqf.dto.in.CommunityDto;
import com.ywqf.dto.in.PayYearNumDto;
import com.ywqf.entity.Community;
import com.ywqf.entity.PayYearNum;
import com.ywqf.entity.Corp;
import com.ywqf.enums.PayYearNumEnum;
import com.ywqf.service.PayYearNumService;
@Service
public class PayYearNumServiceImpl implements PayYearNumService {

	@Autowired
	private PayYearNumDao payYearNumDao;
	//日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    /**
     * 查询缴费统计
     */
    @Override
    @SuppressWarnings("all")
	public PayYearResultExcution PayYearResult(PayYearNumDto payYearNumDto) {
//		String company =payYearNumDto.getCompany();
//		String community =payYearNumDto.getCommunity();
//		Integer year=payYearNumDto.getYear();
//		String time1 =payYearNumDto.getTime1();
//		String time2 =payYearNumDto.getTime2();
		try {
			List<PayYearNum> list =payYearNumDao.listCommunity(payYearNumDto);
			if (list == null) {
                list = new ArrayList<PayYearNum>();
            }
			List result =new ArrayList<>();
			for(PayYearNum pyn:list){
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
            return new PayYearResultExcution(PayYearNumEnum.SUCCESS,result);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public CorpExcution CorpList(int id,int type) {
		try {
			List<Corp> list =payYearNumDao.findCorpName(id,type);
			if (list == null) {
                list = new ArrayList<Corp>();
            }
			return new CorpExcution(PayYearNumEnum.SUCCESS,list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public CommunityExcution CommunityList(CommunityDto communityDto) {
		try {
			List<Community> list =payYearNumDao.findCommunityName(communityDto);
			if(list == null){
				list = new ArrayList<Community>();
			}
			return new CommunityExcution(PayYearNumEnum.SUCCESS,list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

}
