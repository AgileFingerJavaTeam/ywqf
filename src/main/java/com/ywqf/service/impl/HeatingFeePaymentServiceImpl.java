package com.ywqf.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import com.ywqf.exception.db.InsertInnerErrorException;
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
            int comm = heatingFeePaymentDto.getComm();
            int estateSearchId = heatingFeePaymentDto.getEstateSearchId();
            String at_search = heatingFeePaymentDto.getAt_search();
            String status = heatingFeePaymentDto.getStatus();
            String okey = heatingFeePaymentDto.getOkey();
            int page = (heatingFeePaymentDto.getPage() != 0) ? heatingFeePaymentDto.getPage() :1;
            int rows = (heatingFeePaymentDto.getRows() !=0) ? heatingFeePaymentDto.getRows() :20;
            int offset = (page - 1) * rows;
            List<HeatingFeePayment> info = heatingFeePaymentDao.findHeatingList(rows,offset,at_search,comm,estateSearchId,status,okey);
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
	            int id = heatingFeePaymentDto.getHeating_pay_id();
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
            int id = heatingFeePaymentDto.getHeating_pay_id();
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

    @Override
    public HeatingFeePaymentExcution findHeatingDiscount(HeatingFeePaymentDto heatingFeePaymentDto) {
              int community_id = heatingFeePaymentDto.getCommunity_id();
              String payment_date = heatingFeePaymentDto.getPayment_date();
        try {
            List<HeatingFeePayment> findHeatingDiscount = heatingFeePaymentDao.findHeatingDiscount(community_id);
            if(findHeatingDiscount.size() == 0){
                int Rate = 1;
                return new HeatingFeePaymentExcution(HeatingFeePaymentEnum.SUCCESS,Rate);
            }else{
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
                Date date=sdf.parse(payment_date);

                for (int i = 0; i < findHeatingDiscount.size(); i++){
                    HeatingFeePayment aaa=findHeatingDiscount.get(i);  //循环遍历
                    Date dataStart=sdf.parse(aaa.getDiscountStartDate());
                    Date dataEnd=sdf.parse(aaa.getDiscountEndDate());
                    if(date.getTime() >= dataStart.getTime() && date.getTime() <= dataEnd.getTime()){
                         return new HeatingFeePaymentExcution(HeatingFeePaymentEnum.SUCCESS,aaa.getRate());
                    }
              }
                int Rate = 1;
                return new HeatingFeePaymentExcution(HeatingFeePaymentEnum.SUCCESS,Rate);
            }
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
    }

    @Override
    public HeatingFeePaymentExcution insertHeating(HeatingFeePaymentDto heatingFeePaymentDto) {
             int heating_pay_num = heatingFeePaymentDto.getHeating_pay_num();
             int house_id = heatingFeePaymentDto.getHouse_id();
             String owner_name = heatingFeePaymentDto.getOwner_name();
             double heating_unit_price = heatingFeePaymentDto.getHeating_unit_price();
             double discount_heating_unit_price = heatingFeePaymentDto.getDiscount_heating_unit_price();
             double heating_area = heatingFeePaymentDto.getHeating_area();
             double payment_amount = heatingFeePaymentDto.getPayment_amount();
             int year = heatingFeePaymentDto.getYear();
             double heating_discount = heatingFeePaymentDto.getHeating_discount();
             String payment_date = heatingFeePaymentDto.getPayment_date();
             int charge_worker_id = heatingFeePaymentDto.getCharge_worker_id();
             String operator = heatingFeePaymentDto.getOperator();
        try {
             int result = heatingFeePaymentDao.insertHeating(heating_pay_num,house_id,owner_name,discount_heating_unit_price,heating_area,payment_amount,year,heating_discount,payment_date,charge_worker_id,operator);
                 if(result > 0 ){
                     return new HeatingFeePaymentExcution(HeatingFeePaymentEnum.SUCCESS,null);
                 }else{
                     throw new InsertInnerErrorException("添加失败");
                 }
        }catch (InsertInnerErrorException e1) {
            throw e1;
        }
        catch (Exception e) {
        logger.error(e.getMessage(), e);
        throw new BaseException(e.getMessage());
    }
    }
}
