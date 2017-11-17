package com.ywqf.service;

import com.ywqf.dto.excution.HouseCenterExcution;
import com.ywqf.dto.excution.HouseExcution;
import com.ywqf.dto.in.HouseCenterDto;
import com.ywqf.dto.in.HouseDto;

public interface HouseCenterService {
/*
	//查询物业信息
	public HouseExcution findCompanyById();

	//查询总部旗下物业信息
	public HouseExcution findCompanyByType();

	//查询小区信息
	public HouseExcution findCommunityById();

	//查询小区信息
	public HouseExcution findChildCommunityById(HouseDto houseDto);*/
	
	//查询求购信息
	 public HouseCenterExcution findHouseAsk(HouseCenterDto houseCenterDto);

	//查询详细信息
	public HouseCenterExcution findAskById(HouseCenterDto houseCenterDto);

	//查询需求
	public  HouseCenterExcution findAskType();

	/*查询户型*/
	public HouseCenterExcution findHouseType();

	/*查询朝向*/
	public HouseCenterExcution findDirection();

	/*查询面积*/
	public HouseCenterExcution findArea();

	/*查询装修情况*/
	public HouseCenterExcution findFitment();

	/*查询租价*/
	public HouseCenterExcution findRentPrice();

	/*查询售价*/
	public HouseCenterExcution findBuyPrice();

	//提交新增信息
	public HouseCenterExcution subAdd(HouseCenterDto houseCenterDto);

	//提交新增信息
	public HouseCenterExcution subEdit(HouseCenterDto houseCenterDto);

	//提交删除信息
	public HouseCenterExcution deleteHouseInfo(HouseCenterDto houseCenterDto);
/*
====================================================
*/
	/*查询小区楼号*/
	public  HouseCenterExcution findBuildingById(HouseCenterDto houseCenterDto);

	//查询租售信息
	public HouseCenterExcution findRentSale(HouseCenterDto houseCenterDto);


	/*房号联想*/
	public  HouseCenterExcution findHouseNum(HouseCenterDto houseCenterDto);
}
