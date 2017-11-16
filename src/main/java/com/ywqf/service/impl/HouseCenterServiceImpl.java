package com.ywqf.service.impl;

import com.ywqf.base.BaseException;
import com.ywqf.dao.HouseCenterDao;
import com.ywqf.dto.excution.HouseCenterExcution;
import com.ywqf.dto.excution.HouseExcution;
import com.ywqf.dto.in.HouseCenterDto;
import com.ywqf.dto.in.HouseDto;
import com.ywqf.entity.HouseAsk;
import com.ywqf.entity.RentAndSale;
import com.ywqf.enums.HouseCenterEnum;
import com.ywqf.exception.db.DeleteInnerErrorException;
import com.ywqf.exception.db.InsertInnerErrorException;
import com.ywqf.exception.db.QueryInnerErrorException;
import com.ywqf.service.HouseCenterService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class HouseCenterServiceImpl implements HouseCenterService {
	 private org.slf4j.Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	public HouseCenterDao houseCenterDao;


	@Override
	public HouseCenterExcution findHouseAsk(HouseCenterDto houseCenterDto) {
		int community_id=Integer.parseInt(houseCenterDto.getCommunity_id());
		int corp_id=Integer.parseInt(houseCenterDto.getCorp_id());
		int type=houseCenterDto.getType();
		try{
			List<HouseAsk> houseAsks=houseCenterDao.findHouseAsk(community_id,corp_id,type);
			HashMap map=new HashMap();
			map.put("rows",houseAsks);
			return new HouseCenterExcution(HouseCenterEnum.FIND_SUCCESS,map);
		}catch (Exception  e){
			logger.error(e.getMessage(),e);
			throw new BaseException(e.getMessage());
		}
	}

	@Override
	public HouseCenterExcution findAskById(HouseCenterDto houseCenterDto) {
		int id=houseCenterDto.getId();
		try{
			HouseAsk houseAsk=houseCenterDao.findAskById(id);
			if(houseAsk!=null){
				return new HouseCenterExcution(HouseCenterEnum.FIND_SUCCESS,houseAsk);
			}else{
				throw new QueryInnerErrorException("查询失败");
			}
		}catch (QueryInnerErrorException  q){
			throw q;
		}catch (Exception  e){
			logger.error(e.getMessage(),e);
			throw new BaseException(e.getMessage());
		}
	}

	/*查询需求*/
	@Override
	public HouseCenterExcution findAskType() {
		try{
			List<HouseAsk> askType=houseCenterDao.findAskType();
			return new HouseCenterExcution(HouseCenterEnum.FIND_SUCCESS,askType);
		}catch (Exception  e){
			logger.error(e.getMessage(),e);
			throw new BaseException(e.getMessage());
		}
	}
	/*查询户型*/
	@Override
	public HouseCenterExcution findHouseType() {
		try{
			List<HouseAsk> houseType=houseCenterDao.findHouseType();
			return new HouseCenterExcution(HouseCenterEnum.FIND_SUCCESS,houseType);
		}catch (Exception  e){
			logger.error(e.getMessage(),e);
			throw new BaseException(e.getMessage());
		}
	}
	/*查询朝向*/
	@Override
	public HouseCenterExcution findDirection() {
		try{
			List<HouseAsk> direction=houseCenterDao.findDirection();
			return new HouseCenterExcution(HouseCenterEnum.FIND_SUCCESS,direction);
		}catch (Exception  e){
			logger.error(e.getMessage(),e);
			throw new BaseException(e.getMessage());
		}
	}
	/*查询面积*/
	@Override
	public HouseCenterExcution findArea() {
		try{
			List<HouseAsk> area=houseCenterDao.findArea();
			return new HouseCenterExcution(HouseCenterEnum.FIND_SUCCESS,area);
		}catch (Exception  e){
			logger.error(e.getMessage(),e);
			throw new BaseException(e.getMessage());
		}
	}
	/*查询装修情况*/
	@Override
	public HouseCenterExcution findFitment() {
		try{
			List<HouseAsk> fitment=houseCenterDao.findFitment();
			return new HouseCenterExcution(HouseCenterEnum.FIND_SUCCESS,fitment);
		}catch (Exception  e){
			logger.error(e.getMessage(),e);
			throw new BaseException(e.getMessage());
		}
	}
	/*查询租价*/
	@Override
	public HouseCenterExcution findRentPrice() {
		try{
			List<HouseAsk> rentPrice=houseCenterDao.findRentPrice();
			return new HouseCenterExcution(HouseCenterEnum.FIND_SUCCESS,rentPrice);
		}catch (Exception  e){
			logger.error(e.getMessage(),e);
			throw new BaseException(e.getMessage());
		}
	}

	/*查询售价*/
	@Override
	public HouseCenterExcution findBuyPrice() {
		try{
			List<HouseAsk> buyPrice=houseCenterDao.findBuyPrice();
			return new HouseCenterExcution(HouseCenterEnum.FIND_SUCCESS,buyPrice);
		}catch (Exception  e){
			logger.error(e.getMessage(),e);
			throw new BaseException(e.getMessage());
		}
	}
	/*新增数据*/
	@Override
	public HouseCenterExcution subAdd(HouseCenterDto houseCenterDto) {
		int community_id=Integer.parseInt(houseCenterDto.getCommunity_id());
		int corp_id=Integer.parseInt(houseCenterDto.getCorp_id());
		String house_need_rent_num=houseCenterDto.getHouse_need_rent_num();
		int type=houseCenterDto.getType();
		int house_type_id=houseCenterDto.getHouse_type_id();
		int	rent_house_price_range_id=houseCenterDto.getRent_house_price_range_id();
		int buy_house_price_range_id=houseCenterDto.getBuy_house_price_range_id();
		int house_direction_type_id=houseCenterDto.getHouse_direction_type_id();
		int  house_fitment_type_id=houseCenterDto.getHouse_fitment_type_id();
		int house_area_type_id=houseCenterDto.getHouse_area_type_id();
		String remark=houseCenterDto.getRemark();
		String customer_name=houseCenterDto.getCustomer_name();
		String phone=houseCenterDto.getPhone();
		try{
			int addData=houseCenterDao.addData(corp_id,community_id,house_need_rent_num,type,house_type_id,rent_house_price_range_id,buy_house_price_range_id,house_direction_type_id,house_fitment_type_id,house_area_type_id,remark,customer_name,phone);
			if (addData>0) {
				return  new HouseCenterExcution(HouseCenterEnum.ADD_SUCCESS);
			}else{
				throw new InsertInnerErrorException("新增失败");
			}
		}catch (InsertInnerErrorException i) {
			throw i;
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BaseException(e.getMessage());
		}
	}

	/*删除数据*/
	@Override
	public HouseCenterExcution deleteHouseInfo(HouseCenterDto houseCenterDto) {
		int id=houseCenterDto.getId();
		try{
			int deleteHouseInfo=houseCenterDao.deleteData(id);
			if (deleteHouseInfo>0) {
				return  new HouseCenterExcution(HouseCenterEnum.DEL_SUCCESS);
			}else{
				throw new InsertInnerErrorException("删除失败");
			}
		}catch (DeleteInnerErrorException d) {
			throw d;
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new BaseException(e.getMessage());
		}
	}




	/*查询小区楼号*/
	@Override
	public HouseCenterExcution findBuildingById(HouseCenterDto houseCenterDto) {
			String building_id=houseCenterDto.getBuilding_id();
			try{
				List<RentAndSale> building=houseCenterDao.findBuildingById(building_id);
				if(building!=null){
					return  new HouseCenterExcution(HouseCenterEnum.FIND_SUCCESS,building);
				}else {
					throw new QueryInnerErrorException("查询失败");
				}
			}catch (QueryInnerErrorException q) {
				throw q;
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				throw new BaseException(e.getMessage());
			}
	}
	/*查询出租出售列表*/
	@Override
	public HouseCenterExcution findRentSale(HouseCenterDto houseCenterDto) {
		try{
			List<RentAndSale> rentAndSales=houseCenterDao.findRentSale();
			HashMap map=new HashMap();
			map.put("rows",rentAndSales);
			return new HouseCenterExcution(HouseCenterEnum.FIND_SUCCESS,map);
		}catch (Exception  e){
			logger.error(e.getMessage(),e);
			throw new BaseException(e.getMessage());
		}
	}



}
