package com.ywqf.service.impl;

import com.ywqf.base.BaseException;
import com.ywqf.dao.ParkingConfigDao;

import com.ywqf.dto.excution.ParkingConfigExcution;

import com.ywqf.dto.in.ParkingConfigDto;

import com.ywqf.entity.ParkingConfig;

import com.ywqf.enums.ParkingConfigEnum;

import com.ywqf.exception.db.DeleteInnerErrorException;
import com.ywqf.exception.db.InsertInnerErrorException;
import com.ywqf.exception.db.QueryInnerErrorException;
import com.ywqf.service.ParkingConfigService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ParkingConfigServiceImpl implements ParkingConfigService {
	 private org.slf4j.Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ParkingConfigDao parkingConfigDao;

	//查询车位配置信息
	@Override
	public ParkingConfigExcution findParkingConfig(ParkingConfigDto parkingConfigDto) {
		int corp_id=parkingConfigDto.getCorp_id();
		int community_id=parkingConfigDto.getCommunity_id();
		try{
		List<ParkingConfig> findParkingList=parkingConfigDao.findParkingList(community_id,corp_id);
			HashMap map=new HashMap();
			map.put("rows",findParkingList);
		return new ParkingConfigExcution(ParkingConfigEnum.FIND_SUCCESS,map);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BaseException(e.getMessage());
		}
	}
	//新增车位配置信息
	@Override
	public ParkingConfigExcution addParkingConfig(ParkingConfigDto parkingConfigDto) {
		int community_id=parkingConfigDto.getCommunity_id();
		int parking_num=parkingConfigDto.getParking_num();
		String license_plate_number=parkingConfigDto.getLicense_plate_number();
		String location_description=parkingConfigDto.getLocation_description();
		double previous_parking_unit_price=parkingConfigDto.getPrevious_parking_unit_price();
		int house_id=parkingConfigDto.getHouse_id();
		String car_owner_name=parkingConfigDto.getCar_owner_name();
		String car_owner_tel=parkingConfigDto.getCar_owner_tel();
		String car_owner_standby_tel=parkingConfigDto.getCar_owner_standby_tel();
		int gender=parkingConfigDto.getGender();
		try{
			int addParkingConfig=parkingConfigDao.addParkingConfig(community_id,parking_num,license_plate_number,location_description,previous_parking_unit_price,house_id,car_owner_name,car_owner_tel,car_owner_standby_tel,gender);
			if(addParkingConfig>0){
				return new ParkingConfigExcution(ParkingConfigEnum.ADD_SUCCESS);
			}else {
				throw new InsertInnerErrorException("添加失败");
			}
		}catch (InsertInnerErrorException i){
			throw i;
		}catch (Exception e){
			logger.error(e.getMessage(),e);
			throw new BaseException(e.getMessage());
		}
	}
	/*门牌号联想*/
	@Override
	public ParkingConfigExcution fingHouseNum(ParkingConfigDto parkingConfigDto) {
		int community_id=parkingConfigDto.getCommunity_id();
		String house_num=parkingConfigDto.getHouse_num();
		try{
			ParkingConfig findHouseNum=parkingConfigDao.findHouseNum(community_id,house_num);
			return new ParkingConfigExcution(ParkingConfigEnum.FIND_SUCCESS,findHouseNum);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BaseException(e.getMessage());
		}
	}
	/*通过id查看详细信息*/
	@Override
	public ParkingConfigExcution findParkingById(ParkingConfigDto parkingConfigDto) {
		 int row_id=parkingConfigDto.getRow_id();
		 try{
		 	ParkingConfig findParking=parkingConfigDao.findParkingById(row_id);
		 	if (findParking!=null){
		 		return new ParkingConfigExcution(ParkingConfigEnum.FIND_SUCCESS,findParking);
			}else {
		 		throw new QueryInnerErrorException("查询失败");
			}
		 }catch (QueryInnerErrorException q){
		 	throw q;
		 }catch (Exception e){
		 	logger.error(e.getMessage(),e);
		 	throw new BaseException(e.getMessage());
		 }
	}

	//修改车位配置信息
	@Override
	public ParkingConfigExcution subEditParking(ParkingConfigDto parkingConfigDto) {
		int community_id=parkingConfigDto.getCommunity_id();
		int parking_num=parkingConfigDto.getParking_num();
		String license_plate_number=parkingConfigDto.getLicense_plate_number();
		String location_description=parkingConfigDto.getLocation_description();
		double previous_parking_unit_price=parkingConfigDto.getPrevious_parking_unit_price();
		int house_id=parkingConfigDto.getHouse_id();
		String car_owner_name=parkingConfigDto.getCar_owner_name();
		String car_owner_tel=parkingConfigDto.getCar_owner_tel();
		String car_owner_standby_tel=parkingConfigDto.getCar_owner_standby_tel();
		int gender=parkingConfigDto.getGender();
		int row_id=parkingConfigDto.getRow_id();
		try{
			int editParkingConfig=parkingConfigDao.editParkingConfig(community_id,parking_num,license_plate_number,location_description,previous_parking_unit_price,house_id,car_owner_name,car_owner_tel,car_owner_standby_tel,gender,row_id);
			if(editParkingConfig>0){
				return new ParkingConfigExcution(ParkingConfigEnum.UPDATE_SUCCESS);
			}else {
				throw new InsertInnerErrorException("修改失败");
			}
		}catch (InsertInnerErrorException i){
			throw i;
		}catch (Exception e){
			logger.error(e.getMessage(),e);
			throw new BaseException(e.getMessage());
		}
	}

	@Override
	public ParkingConfigExcution deleteParking(ParkingConfigDto parkingConfigDto) {
		int row_id=parkingConfigDto.getRow_id();
		try{
			int deleteParking=parkingConfigDao.deleteParkingConfig(row_id);
			if(deleteParking>0){
				return new ParkingConfigExcution(ParkingConfigEnum.DEL_SUCCESS);
			}else {
				throw new InsertInnerErrorException("删除失败");
			}
		}catch (DeleteInnerErrorException i){
			throw i;
		}catch (Exception e){
			logger.error(e.getMessage(),e);
			throw new BaseException(e.getMessage());
		}
	}


}
