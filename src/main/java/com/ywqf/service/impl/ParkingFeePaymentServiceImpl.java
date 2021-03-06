package com.ywqf.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import com.ywqf.entity.payMonthType;
import com.ywqf.exception.db.InsertInnerErrorException;
import com.ywqf.exception.db.QueryInnerErrorException;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywqf.base.BaseException;
import com.ywqf.dao.ParkingFeePaymentDao;
import com.ywqf.dao.PropertyFeePaymentDao;
import com.ywqf.dto.excution.ParkingFeePaymentExcution;
import com.ywqf.dto.excution.PropertyFeePaymentExcution;
import com.ywqf.dto.in.ParkingFeePaymentDto;
import com.ywqf.entity.ParkingFeePayment;
import com.ywqf.entity.PropertyFeePayment;
import com.ywqf.enums.ParkingFeePaymentEnum;
import com.ywqf.enums.PropertyFeePaymentEnum;
import com.ywqf.exception.db.UpdateInnerErrorException;
import com.ywqf.service.ParkingFeePaymentService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParkingFeePaymentServiceImpl implements ParkingFeePaymentService{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ParkingFeePaymentDao parkingFeePaymentDao;
	
	@Override
	public ParkingFeePaymentExcution findParkingList(ParkingFeePaymentDto parkingFeePaymentDto) {
		  try {
			/*    String at_service_start = parkingFeePaymentDto.getAt_service_start();
			    String at_service_end = parkingFeePaymentDto.getAt_service_end();
			    String at_pay_start = parkingFeePaymentDto.getAt_pay_start();
			    String at_pay_end = parkingFeePaymentDto.getAt_pay_end();*/
			    int comm = parkingFeePaymentDto.getComm();
			    int estateSearchId = parkingFeePaymentDto.getEstateSearchId();
	            String at_search = parkingFeePaymentDto.getAt_search();
			    String status = parkingFeePaymentDto.getStatus();
			    String okey = parkingFeePaymentDto.getOkey();
	            int page = (parkingFeePaymentDto.getPage() != 0) ? parkingFeePaymentDto.getPage() :1;
	            int rows = (parkingFeePaymentDto.getRows() !=0) ? parkingFeePaymentDto.getRows() :20;
	            int offset = (page - 1) * rows;
	            List<ParkingFeePayment> info = parkingFeePaymentDao.findParkingList(rows,offset,at_search,status,okey,estateSearchId,comm);
/*
	            int total = parkingFeePaymentDao.findParkingListCount(at_search);
*/
	            HashMap map = new HashMap();
	            map.put("rows", info);
/*
	            map.put("total", total);
*/
	            return new ParkingFeePaymentExcution(ParkingFeePaymentEnum.SUCCESS, map);
	        } catch (Exception e) {
	            logger.error(e.getMessage(), e);
	            throw new BaseException(e.getMessage());
	        }
	}

	@Override
	public ParkingFeePaymentExcution findOver(ParkingFeePaymentDto parkingFeePaymentDto) {
		 try {
	            int id = parkingFeePaymentDto.getId();
	            ParkingFeePayment info = parkingFeePaymentDao.findOver(id);
	            return new ParkingFeePaymentExcution(ParkingFeePaymentEnum.SUCCESS, info);
	        } catch (Exception e) {
	            logger.error(e.getMessage(), e);
	            throw new BaseException(e.getMessage());
	        }
	}

	@Override
	public ParkingFeePaymentExcution updateOver(ParkingFeePaymentDto parkingFeePaymentDto) {
		try {
            int id = parkingFeePaymentDto.getId();
            String Rname = parkingFeePaymentDto.getRname();
            int over = parkingFeePaymentDao.updateOver(id,Rname);
          if(over > 0){
        	  return new ParkingFeePaymentExcution(ParkingFeePaymentEnum.SUCCESS, null);
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
	public ParkingFeePaymentExcution findVillage(ParkingFeePaymentDto parkingFeePaymentDto) {
		try {
			int corp_id = parkingFeePaymentDto.getCorp_id();
			List<ParkingFeePayment> findVillage = parkingFeePaymentDao.findVillage(corp_id);
			if (findVillage == null) {
				throw new QueryInnerErrorException("查询失败");
			} else {
				return new ParkingFeePaymentExcution(ParkingFeePaymentEnum.SUCCESS, findVillage);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BaseException(e.getMessage());
		}
	}

	@Override
	public ParkingFeePaymentExcution findMoneyMonth() {
		try {
			List<payMonthType> findMoneyMonth = parkingFeePaymentDao.findMoneyMonth();
			if(findMoneyMonth == null){
				throw new QueryInnerErrorException("查询失败");
			}else{
				return new ParkingFeePaymentExcution(ParkingFeePaymentEnum.SUCCESS, findMoneyMonth);
			}
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BaseException(e.getMessage());
		}
	}

	@Override
	public ParkingFeePaymentExcution findAccount(ParkingFeePaymentDto parkingFeePaymentDto) {
		try {
			List<ParkingFeePayment> findAccount = parkingFeePaymentDao.findAccount();
			if(findAccount == null){
				throw new QueryInnerErrorException("查询失败");
			}else{
				return new ParkingFeePaymentExcution(ParkingFeePaymentEnum.SUCCESS, findAccount);
			}
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BaseException(e.getMessage());
		}
	}

	@Override
	public ParkingFeePaymentExcution findHouseNumIsNull(ParkingFeePaymentDto parkingFeePaymentDto) {
		String house_num = parkingFeePaymentDto.getHouse_num();
		int community_id = parkingFeePaymentDto.getCommunity_id();
		try {
			int findHouseNumIsNull = parkingFeePaymentDao.findHouseNumIsNull(house_num,community_id);
			if(findHouseNumIsNull < 0){
				throw new QueryInnerErrorException("查询为空");
			}else{
				return new ParkingFeePaymentExcution(ParkingFeePaymentEnum.SUCCESS, findHouseNumIsNull);
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
	public ParkingFeePaymentExcution findCarNumberOrMoneyOrName(ParkingFeePaymentDto parkingFeePaymentDto) {
		String house_num = parkingFeePaymentDto.getHouse_num();
		int community_id = parkingFeePaymentDto.getCommunity_id();
		try {
			ParkingFeePayment findCarNumberOrMoneyOrName = parkingFeePaymentDao.findCarNumberOrMoneyOrName(house_num,community_id);
			if(findCarNumberOrMoneyOrName == null){
				throw new QueryInnerErrorException("查询失败");
			}else{
				return new ParkingFeePaymentExcution(ParkingFeePaymentEnum.SUCCESS, findCarNumberOrMoneyOrName);
			}
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BaseException(e.getMessage());
		}
	}

	@Override
	public ParkingFeePaymentExcution findStartTime(ParkingFeePaymentDto parkingFeePaymentDto) {
		int community_id = parkingFeePaymentDto.getCommunity_id();
		String house_num = parkingFeePaymentDto.getHouse_num();
		try {
			ParkingFeePayment findStartTime = parkingFeePaymentDao.findStartTime(community_id,house_num);
			if(findStartTime == null){
				Date now = new Date();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String MaxInsert = df.format(now);
				return new ParkingFeePaymentExcution(ParkingFeePaymentEnum.SUCCESS, MaxInsert);
			}else{
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String MaxInsert = findStartTime.getMaxInsert();
				Date dateStart = df.parse(MaxInsert);

				Calendar calendar   =   new GregorianCalendar();
				calendar.setTime(dateStart);
				calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
				dateStart=calendar.getTime();   //这个时间就是日期往后推一天的结果

				MaxInsert=df.format(dateStart);
				return new ParkingFeePaymentExcution(ParkingFeePaymentEnum.SUCCESS, MaxInsert);
			}
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BaseException(e.getMessage());
		}
	}

	@Override
	@Transactional
	public ParkingFeePaymentExcution insertParking(ParkingFeePaymentDto parkingFeePaymentDto) {
		try {
			int parking_pay_num = parkingFeePaymentDto.getParking_pay_num();
			int parking_space_id = parkingFeePaymentDto.getParking_space_id();
			double parking_unit_price = parkingFeePaymentDto.getParking_unit_price();
			int pay_month_type_id = parkingFeePaymentDto.getPay_month_type_id();
			String owner_name = parkingFeePaymentDto.getOwner_name();
			String service_start_date = parkingFeePaymentDto.getService_start_date();
			String service_end_date = parkingFeePaymentDto.getService_end_date();
			int charge_worker_id = parkingFeePaymentDto.getCharge_worker_id();
			String pay_date = parkingFeePaymentDto.getPay_date();
			double payment_amount = parkingFeePaymentDto.getPayment_amount();
			String operator = parkingFeePaymentDto.getOperator();
			String house_num = parkingFeePaymentDto.getHouse_num();

			int insertAccount = parkingFeePaymentDao.insertParking(parking_pay_num,parking_space_id,parking_unit_price,pay_month_type_id,owner_name,service_start_date,service_end_date,charge_worker_id,pay_date,payment_amount,operator);
			if(insertAccount > 0){
				ParkingFeePayment findId = parkingFeePaymentDao.findParkingId(parking_space_id,parking_pay_num);
				int parkingPayId = findId.getParkingPayId();
			    //起始日期的月份
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = sdf.parse(service_start_date);
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				int months = cal.get(Calendar.MONTH);
			    int years = cal.get(Calendar.YEAR);
				int month = months+1;
				int pmont = month+pay_month_type_id;
			    //
			if(pmont > 12){
              int Dow = 12-months;
              for(int o = 1; o<= Dow; o++){
				  months = months+1;
				  int insertTime = parkingFeePaymentDao.insertParkingStatist(parkingPayId,parking_space_id,years,months);
				  if(insertTime == 0 ){
					  break;
				  }
              }
				int monthsd = pay_month_type_id - Dow;
				years = years+1;
				months=0;
				for(int i=1;i<= monthsd;i++){
					months= months+1;
				int insertTimes = parkingFeePaymentDao.insertParkingStatist(parkingPayId,parking_space_id,years,months);
					if(insertTimes == 0){
						break;
					}
				}
				return new ParkingFeePaymentExcution(ParkingFeePaymentEnum.SUCCESS,null);
			}else{
				for(int i=1;i<= pay_month_type_id;i++){
					months= months+1;
					int insertTimes = parkingFeePaymentDao.insertParkingStatist(parkingPayId,parking_space_id,years,months);
					if(insertTimes == 0){
						break;
					}
				}
				return new ParkingFeePaymentExcution(ParkingFeePaymentEnum.SUCCESS,null);
			}
			}else{
				throw new InsertInnerErrorException("添加失败");
			}
		}catch (InsertInnerErrorException e1) {
			throw e1;
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BaseException(e.getMessage());
		}
	}

	@Override
	public ParkingFeePaymentExcution findType(ParkingFeePaymentDto parkingFeePaymentDto) {
		int corp_id = parkingFeePaymentDto.getCorp_id();
		try {
			ParkingFeePayment findType = parkingFeePaymentDao.findType(corp_id);
			if(findType == null){
				throw new QueryInnerErrorException("查询失败");
			}else{
				return new ParkingFeePaymentExcution(ParkingFeePaymentEnum.SUCCESS, findType);
			}
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BaseException(e.getMessage());
		}
	}

	@Override
	public ParkingFeePaymentExcution findRidComm(@Param("rid") int rid) {
		try {
			List<ParkingFeePayment> findRidComm = parkingFeePaymentDao.findRidComm(rid);
			if(findRidComm == null){
				throw new QueryInnerErrorException("查询失败");
			}else{
				return new ParkingFeePaymentExcution(ParkingFeePaymentEnum.SUCCESS, findRidComm);
			}
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BaseException(e.getMessage());
		}
	}

	@Override
	public ParkingFeePaymentExcution findEstate(ParkingFeePaymentDto parkingFeePaymentDto) {
		try {
			List<ParkingFeePayment> findEstate = parkingFeePaymentDao.findEstate();
			if(findEstate == null){
				throw new QueryInnerErrorException("查询失败");
			}else{
				return new ParkingFeePaymentExcution(ParkingFeePaymentEnum.SUCCESS, findEstate);
			}
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BaseException(e.getMessage());
		}
	}
}
