package com.ywqf.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import com.ywqf.exception.db.QueryInnerErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywqf.base.BaseException;
import com.ywqf.dao.HeatingFeePaymentDao;
import com.ywqf.dao.ParkingFeePaymentDao;
import com.ywqf.dto.excution.HeatingFeePaymentExcution;
import com.ywqf.dto.excution.ParkingFeePaymentExcution;
import com.ywqf.dto.in.HeatingFeePaymentDto;
import com.ywqf.entity.HeatingFeePayment;
import com.ywqf.entity.ParkingFeePayment;
import com.ywqf.enums.HeatingFeePaymentEnum;
import com.ywqf.enums.ParkingFeePaymentEnum;
import com.ywqf.exception.db.UpdateInnerErrorException;
import com.ywqf.service.HeatingFeePaymentService;

@Service
public class HeatingFeePaymentServiceImpl implements HeatingFeePaymentService{
	 //��־����
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HeatingFeePaymentDao heatingFeePaymentDao;
    
    
	@Override
	public HeatingFeePaymentExcution findHeatingList(HeatingFeePaymentDto heatingFeePaymentDto) {
		try {
            String at_search = heatingFeePaymentDto.getAt_search();
            int page = (heatingFeePaymentDto.getPage() != 0) ? heatingFeePaymentDto.getPage() :1;
            int rows = (heatingFeePaymentDto.getRows() !=0) ? heatingFeePaymentDto.getRows() :20;
            int offset = (page - 1) * rows;
            List<HeatingFeePayment> info = heatingFeePaymentDao.findHeatingList(rows,offset,at_search);
/*
            int total = heatingFeePaymentDao.findHeatingListCount(at_search);
*/
            HashMap map = new HashMap();
            map.put("rows", info);
            return new HeatingFeePaymentExcution(HeatingFeePaymentEnum.SUCCESS, map);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
	}

	@Override
	public HeatingFeePaymentExcution findOver(HeatingFeePaymentDto heatingFeePaymentDto) {
		 try {
	            int id = heatingFeePaymentDto.getId();
	            HeatingFeePayment info = heatingFeePaymentDao.findOver(id);
	            return new HeatingFeePaymentExcution(HeatingFeePaymentEnum.SUCCESS, info);
	        } catch (Exception e) {
	            logger.error(e.getMessage(), e);
	            throw new BaseException(e.getMessage());
	        }
	}

	@Override
	public HeatingFeePaymentExcution updateOver(HeatingFeePaymentDto heatingFeePaymentDto) {
		try {
            int id = heatingFeePaymentDto.getId();
            String Rname = heatingFeePaymentDto.getRname();
            int over = heatingFeePaymentDao.updateOver(id,Rname);
          if(over > 0){
        	  return new HeatingFeePaymentExcution(HeatingFeePaymentEnum.SUCCESS, null);
          }
              throw new UpdateInnerErrorException("修改失败");
        }catch (UpdateInnerErrorException e1) {
            throw e1;
        }
		catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
	}

    @Override
    public HeatingFeePaymentExcution findHouseNumIsNull(HeatingFeePaymentDto heatingFeePaymentDto) {
        String house_num = heatingFeePaymentDto.getHouse_num();
        int community_id = heatingFeePaymentDto.getCommunity_id();
        try {
            int findHouseNumIsNull = heatingFeePaymentDao.findHouseNumIsNull(house_num,community_id);
            if(findHouseNumIsNull < 0){
                throw new QueryInnerErrorException("查询为空");
            }else{
                return new HeatingFeePaymentExcution(HeatingFeePaymentEnum.SUCCESS, findHouseNumIsNull);
            }
        }catch (QueryInnerErrorException e1) {
            throw e1;
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    @Override
    public HeatingFeePaymentExcution findAreaOrNameOrMoney(HeatingFeePaymentDto heatingFeePaymentDto) {
            String house_num = heatingFeePaymentDto.getHouse_num();
            int community_id = heatingFeePaymentDto.getCommunity_id();
        try {
            HeatingFeePayment findAreaOrNameOrMoney = heatingFeePaymentDao.findAreaOrNameOrMoney(house_num,community_id);
            if(findAreaOrNameOrMoney == null){
                throw new QueryInnerErrorException("查询失败");
            }else{
                return new HeatingFeePaymentExcution(HeatingFeePaymentEnum.SUCCESS, findAreaOrNameOrMoney);
            }
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }



}
