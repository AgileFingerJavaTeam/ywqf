package com.ywqf.service.impl;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.ywqf.entity.payMonthType;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywqf.base.BaseException;
import com.ywqf.dao.PropertyFeePaymentDao;
import com.ywqf.dto.excution.PropertyFeePaymentExcution;
import com.ywqf.dto.in.PropertyFeePaymentDto;
import com.ywqf.entity.PropertyFeePayment;
import com.ywqf.enums.PropertyFeePaymentEnum;
import com.ywqf.exception.db.InsertInnerErrorException;
import com.ywqf.exception.db.QueryInnerErrorException;
import com.ywqf.exception.db.UpdateInnerErrorException;
import com.ywqf.service.PropertyFeePaymentService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PropertyFeePaymentServiceImpl implements PropertyFeePaymentService{

    //日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PropertyFeePaymentDao propertyFeePaymentDao;
	

	@Override
	public PropertyFeePaymentExcution findPropertyList(PropertyFeePaymentDto propertyFeePaymentDto) {
		  try {

			    String at_service_start = propertyFeePaymentDto.getAt_service_start();
			    String at_service_end = propertyFeePaymentDto.getAt_service_end();
			    String at_pay_start = propertyFeePaymentDto.getAt_pay_start();
			    String at_pay_end = propertyFeePaymentDto.getAt_pay_end();
			    int comm = propertyFeePaymentDto.getComm();
			    int estateSearchId = propertyFeePaymentDto.getEstateSearchId();
	            String at_search = propertyFeePaymentDto.getAt_search();
	            String status = propertyFeePaymentDto.getStatus();
			  	String okey = propertyFeePaymentDto.getOkey();
	            int page = (propertyFeePaymentDto.getPage() != 0) ? propertyFeePaymentDto.getPage() :1;
	            int rows = (propertyFeePaymentDto.getRows() !=0) ? propertyFeePaymentDto.getRows() :20;
	            int offset = (page - 1) * rows;
	            List<PropertyFeePayment> info = propertyFeePaymentDao.findListProperty(at_search,rows,offset,status,estateSearchId,comm,at_pay_start,at_pay_end,at_service_start,at_service_end,okey);
/*
	            int total = propertyFeePaymentDao.findPropertyFeePaymentListCount(at_search,status,estateSearchId,at_pay_start,at_pay_end,at_service_start,at_service_end,okey);
*/
	            HashMap map = new HashMap();
	            map.put("rows", info);
	          /*  map.put("total", total);*/
	            return new PropertyFeePaymentExcution(PropertyFeePaymentEnum.SUCCESS, map);
	        } catch (Exception e) {
	            logger.error(e.getMessage(), e);
	            throw new BaseException(e.getMessage());
	        }
	}


	@Override
	public PropertyFeePaymentExcution findOver(@Param("id")int id) {
		 try {
	            PropertyFeePayment info = propertyFeePaymentDao.findOver(id);
	            return new PropertyFeePaymentExcution(PropertyFeePaymentEnum.SUCCESS, info);
	        } catch (Exception e) {
	            logger.error(e.getMessage(), e);
	            throw new BaseException(e.getMessage());
	        }
	}
	
	@Override
	public PropertyFeePaymentExcution updateOver(PropertyFeePaymentDto propertyFeePaymentDto) {
		try {
            int id = propertyFeePaymentDto.getId();
            int over = propertyFeePaymentDao.updateOver(id);
          if(over > 0){
        	  return new PropertyFeePaymentExcution(PropertyFeePaymentEnum.SUCCESS, null);
          }
              throw new UpdateInnerErrorException("更改失败");
        }catch (UpdateInnerErrorException e1) {
            throw e1;
        }
		catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
	}


	@Override
	public PropertyFeePaymentExcution findVillage(PropertyFeePaymentDto propertyFeePaymentDto) {
		try {
          int corp_id = propertyFeePaymentDto.getCorp_id();
        
          List<PropertyFeePayment> findVillage = propertyFeePaymentDao.findVillage(corp_id);
              if(findVillage == null){
            	  throw new QueryInnerErrorException("查询失败");
              }else{
            	  return new PropertyFeePaymentExcution(PropertyFeePaymentEnum.SUCCESS, findVillage);
              }
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BaseException(e.getMessage());
        }
	}


	@Override
	public PropertyFeePaymentExcution findAccount(PropertyFeePaymentDto propertyFeePaymentDto) {
		try {
	          List<PropertyFeePayment> findAccount = propertyFeePaymentDao.findAccount();
	              if(findAccount == null){
	            	  throw new QueryInnerErrorException("查询失败");
	              }else{
	            	  return new PropertyFeePaymentExcution(PropertyFeePaymentEnum.SUCCESS, findAccount);
	              }
	        }catch (Exception e) {
	            logger.error(e.getMessage(), e);
	            throw new BaseException(e.getMessage());
	        }
	}


	@Override
	@Transactional
	public PropertyFeePaymentExcution insertProperty(PropertyFeePaymentDto propertyFeePaymentDto) {
		try {
		       int estate_pay_num = propertyFeePaymentDto.getEstate_pay_num();
               int house_id = propertyFeePaymentDto.getHouse_id();
		       String owner_name = propertyFeePaymentDto.getOwner_name();
		       double area = propertyFeePaymentDto.getArea();
		       double estate_unit_price = propertyFeePaymentDto.getEstate_unit_price();
		       int pay_month_type_id = propertyFeePaymentDto.getPay_month_type_id();
		       String pay_date = propertyFeePaymentDto.getPay_date();
		       double payment_amount = propertyFeePaymentDto.getPayment_amount();
		       String service_start_date = propertyFeePaymentDto.getService_start_date();
		       String service_end_date = propertyFeePaymentDto.getService_end_date();
		       int charge_worker_id = propertyFeePaymentDto.getCharge_worker_id();
		       String operator = propertyFeePaymentDto.getOperator();
	        
	          int findAccount = propertyFeePaymentDao.insertProperty(estate_pay_num,house_id,owner_name,area,estate_unit_price,pay_month_type_id,pay_date,payment_amount,service_start_date,service_end_date,charge_worker_id,operator);
	              if(findAccount > 0){
	                  PropertyFeePayment estateId = propertyFeePaymentDao.findEstateId(house_id,owner_name,estate_pay_num);
	                  int estate_pay_id = estateId.getEstatePayId();
					  //起始日期的月份
					  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					  Date date = sdf.parse(service_start_date); //date型起始日期
					  Calendar cal = Calendar.getInstance();
					  cal.setTime(date);
					  int months = cal.get(Calendar.MONTH); //取出当前起始日期的月份   但是值 -1    如：11月得到是10月
					  int years = cal.get(Calendar.YEAR);  //当前起始日期年份
					  int month = months+1;    //正常当前日期月份
					  int pmont = month+pay_month_type_id; //正常当前月份  +   前台来的缴费月数
					  //
					  if(pmont > 12){      //如果pmont > 12   表示需要跨年新增
						  int Dow = 12-months;
						  for(int o = 1; o<= Dow; o++){
							  months = months+1;
							  int insertTime = propertyFeePaymentDao.insertPropertyStatist(estate_pay_id,house_id,years,months);
							  if(insertTime == 0 ){
							  	break;
							  }
						  }
						  int monthsd = pay_month_type_id - Dow;   //缴费月数 - 跨年前遍历次数 = 跨年后便利次数
						  years = years+1;
						  months=0;
						  for(int i=1;i<= monthsd;i++){
							  months= months+1;
							  int insertTimes = propertyFeePaymentDao.insertPropertyStatist(estate_pay_id,house_id,years,months);
							  if(insertTimes == 0){
							  	break;
							  }
						  }
						  return new PropertyFeePaymentExcution(PropertyFeePaymentEnum.SUCCESS,null);
					  }else{
						  for(int i=1;i<= pay_month_type_id;i++){
							  months= months+1;
							  int insertTimes = propertyFeePaymentDao.insertPropertyStatist(estate_pay_id,house_id,years,months);
							  if(insertTimes == 0){
								  break;
							  }
						  }
						  return new PropertyFeePaymentExcution(PropertyFeePaymentEnum.SUCCESS,null);
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
	public PropertyFeePaymentExcution findEstate(PropertyFeePaymentDto propertyFeePaymentDto) {
		try {
	          List<PropertyFeePayment> findEstate = propertyFeePaymentDao.findEstate();
	              if(findEstate == null){
	            	  throw new QueryInnerErrorException("查询失败");
	              }else{
	            	  return new PropertyFeePaymentExcution(PropertyFeePaymentEnum.SUCCESS, findEstate);
	              }
	        }catch (Exception e) {
	            logger.error(e.getMessage(), e);
	            throw new BaseException(e.getMessage());
	        }
	}


	@Override
	public PropertyFeePaymentExcution findComm(PropertyFeePaymentDto propertyFeePaymentDto) {
		 	int corp_id = propertyFeePaymentDto.getEstateSearchId();
		try {
	          List<PropertyFeePayment> findComm = propertyFeePaymentDao.findVillage(corp_id);
	              if(findComm == null){
	            	  throw new QueryInnerErrorException("查询失败");
	              }else{
	            	  return new PropertyFeePaymentExcution(PropertyFeePaymentEnum.SUCCESS, findComm);
	              }
	        }catch (Exception e) {
	            logger.error(e.getMessage(), e);
	            throw new BaseException(e.getMessage());
	        }
	}

	@Override
	public PropertyFeePaymentExcution findHouseNumIsNull(PropertyFeePaymentDto propertyFeePaymentDto) {
		         String house_num = propertyFeePaymentDto.getHouse_num();
		         int community_id = propertyFeePaymentDto.getCommunity_id();
		try {
			int findHouseNumIsNull = propertyFeePaymentDao.findHouseNumIsNull(house_num,community_id);
			if(findHouseNumIsNull < 0){
				throw new QueryInnerErrorException("查询为空");
			}else{
				return new PropertyFeePaymentExcution(PropertyFeePaymentEnum.SUCCESS, findHouseNumIsNull);
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
	public PropertyFeePaymentExcution findListHouseNumber(PropertyFeePaymentDto propertyFeePaymentDto) {
	 	          int community_id = propertyFeePaymentDto.getCommunity_id();
			try {
		          List<PropertyFeePayment> findListHouseNumber = propertyFeePaymentDao.findListHouseNumber(community_id);
		              if(findListHouseNumber == null){
		            	  throw new QueryInnerErrorException("查询失败");
		              }else{
		            	  return new PropertyFeePaymentExcution(PropertyFeePaymentEnum.SUCCESS, findListHouseNumber);
		              }
		        }catch (Exception e) {
		            logger.error(e.getMessage(), e);
		            throw new BaseException(e.getMessage());
		        }
	}


	@Override
	public PropertyFeePaymentExcution findAreaOrMoneyOrName(PropertyFeePaymentDto propertyFeePaymentDto) {
	        		  String house_num = propertyFeePaymentDto.getHouse_num();
	        		  int community_id = propertyFeePaymentDto.getCommunity_id();
				try {
			          PropertyFeePayment findAreaOrMoneyOrName = propertyFeePaymentDao.findAreaOrMoneyOrName(house_num,community_id);
			              if(findAreaOrMoneyOrName == null){
			            	  throw new QueryInnerErrorException("查询失败");
			              }else{
			            	  return new PropertyFeePaymentExcution(PropertyFeePaymentEnum.SUCCESS, findAreaOrMoneyOrName);
			              }
			        }catch (Exception e) {
			            logger.error(e.getMessage(), e);
			            throw new BaseException(e.getMessage());
			        }
	}

	@Override
	public PropertyFeePaymentExcution findMoneyMonth() {
		try {
			List<payMonthType> findMoneyMonth = propertyFeePaymentDao.findMoneyMonth();
			if(findMoneyMonth == null){
				throw new QueryInnerErrorException("查询失败");
			}else{
				return new PropertyFeePaymentExcution(PropertyFeePaymentEnum.SUCCESS, findMoneyMonth);
			}
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BaseException(e.getMessage());
		}
	}

	@Override
	public PropertyFeePaymentExcution findStartTime(PropertyFeePaymentDto propertyFeePaymentDto) {
		    int house_id = propertyFeePaymentDto.getHouse_id();
		try {
			PropertyFeePayment findStartTime = propertyFeePaymentDao.findStartTime(house_id);
			if(findStartTime == null){
				Date now = new Date();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String MaxInsert = df.format(now);
				return new PropertyFeePaymentExcution(PropertyFeePaymentEnum.SUCCESS, MaxInsert);
			}else{
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String MaxInsert = findStartTime.getMaxInsert();
				System.out.println("MaxInsert="+MaxInsert);
				Date dateStart = df.parse(MaxInsert);
				System.out.println("dateStart="+dateStart);

				Calendar calendar   =   new GregorianCalendar();
				calendar.setTime(dateStart);
				calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
				dateStart=calendar.getTime();   //这个时间就是日期往后推一天的结果
				System.out.println("dateStart="+dateStart);

				MaxInsert=df.format(dateStart);
				return new PropertyFeePaymentExcution(PropertyFeePaymentEnum.SUCCESS, MaxInsert);
			}
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BaseException(e.getMessage());
		}
	}

	@Override
	public PropertyFeePaymentExcution findType(PropertyFeePaymentDto propertyFeePaymentDto) {
		     int corp_id = propertyFeePaymentDto.getCorp_id();
		try {
			PropertyFeePayment findType = propertyFeePaymentDao.findType(corp_id);
			if(findType == null){
				throw new QueryInnerErrorException("查询失败");
			}else{
				return new PropertyFeePaymentExcution(PropertyFeePaymentEnum.SUCCESS, findType);
			}
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BaseException(e.getMessage());
		}
	}

	@Override
	public PropertyFeePaymentExcution findRidComm(@Param("rid") int rid) {
		try {
			List<PropertyFeePayment> findRidComm = propertyFeePaymentDao.findRidComm(rid);
			if(findRidComm == null){
				throw new QueryInnerErrorException("查询失败");
			}else{
				return new PropertyFeePaymentExcution(PropertyFeePaymentEnum.SUCCESS, findRidComm);
			}
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BaseException(e.getMessage());
		}
	}


}
