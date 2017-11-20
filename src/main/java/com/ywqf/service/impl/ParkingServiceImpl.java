package com.ywqf.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywqf.base.BaseException;
import com.ywqf.dao.ParkingDao;
import com.ywqf.dto.excution.ParkingExcution;
import com.ywqf.dto.in.ParkingDto;
import com.ywqf.entity.Parking;
import com.ywqf.enums.ParkingEnum;
import com.ywqf.service.ParkingService;
@Service
public class ParkingServiceImpl implements ParkingService {

	//日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private ParkingDao parkingDao;



	@Override
	public ParkingExcution getFirstParkList(ParkingDto parkingDto) {
		int checked = parkingDto.getChecked();
		String search = parkingDto.getSearch();
		String TimeYearMonth = parkingDto.getTimeYearMonth();
		String[] string = TimeYearMonth.split("-");
		int year = Integer.parseInt(string[0]);
		int month = Integer.parseInt(string[1]);
		int corpsId = parkingDto.getSelectCompanyID();//物业公司ID
		int communityId = parkingDto.getSelectcommunityID();
		int isSelect = parkingDto.getIsSelect();
		int userId = 333;//登录人ID
		int type = 1;//登录人是总公司还是物业公司
		try{
			List<Parking> parkingCommunityList = parkingDao.getParkingCommunity(userId,type,corpsId);
			if (isSelect==1) {
				communityId=parkingCommunityList.get(0).getCommunityId();
			}
			List<Parking> parkinglist= parkingDao.getFirParkingList(checked,year,month,corpsId,communityId,userId,type,search);
			
			int total=parkingDao.findFirParkingCount(checked,year,month,corpsId,communityId,userId,type,search);
			
			int all = parkingDao.getAll(communityId);
			int pay = parkingDao.getPay(year, month, userId, type, corpsId, communityId);
			int noPay = all-pay;
			int percentage = (int) ((pay/Double.parseDouble(String.valueOf(all)))*100 );
			
			HashMap<String, Object> map=new HashMap<String, Object>();
            map.put("rows",parkinglist);
            map.put("total",total);
            map.put("all",all);
            map.put("pay",pay);
            map.put("noPay",noPay);
            map.put("percentage",percentage);
            map.put("community",parkingCommunityList);
            return  new ParkingExcution(ParkingEnum.SUCCESS,map);
		}catch (Exception  e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
	}



	
	

	
}
