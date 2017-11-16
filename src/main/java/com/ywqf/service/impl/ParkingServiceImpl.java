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
		String TimeYearMonth = parkingDto.getTimeYearMonth();
		String[] string = TimeYearMonth.split("-");
		int year = Integer.parseInt(string[0]);
		int month = Integer.parseInt(string[1]);
		try{
			List<Parking> parkinglist= parkingDao.getFirParkingList(checked,year,month);
			int total=parkingDao.findFirParkingCount(checked,year,month);
			HashMap<String, Object> map=new HashMap<String, Object>();
            map.put("rows",parkinglist);
            map.put("total",total);
            return  new ParkingExcution(ParkingEnum.SUCCESS,map);
		}catch (Exception  e){
            logger.error(e.getMessage(),e);
            throw new BaseException(e.getMessage());
        }
	}

	

	
}
