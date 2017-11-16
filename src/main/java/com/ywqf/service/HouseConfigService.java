package com.ywqf.service;

import com.ywqf.dto.excution.HouseExcution;
import com.ywqf.dto.in.HouseDto;

public interface HouseConfigService {

	//查询物业信息
	public HouseExcution findCompanyById();

	//查询总部旗下物业信息
	public HouseExcution findCompanyByType();

	//查询小区信息
	public HouseExcution findCommunityById();

	//查询小区信息
	public HouseExcution findChildCommunityById(HouseDto houseDto);
	
	//查询房屋配置信息
	 public HouseExcution findHouseInfo(HouseDto houseDto);
	 
	 
	 //查询社区名称
	 public HouseExcution findCommunityName(HouseDto houseDto);
	 
	 //查询户型
	 public HouseExcution findRoomType(HouseDto houseDto);
	 
	 
	 //提交新增信息
	 public HouseExcution saveHouseInfo(HouseDto houseDto);

	//通过id查询房屋配置信息
	public HouseExcution findHouseInfoByID(HouseDto houseDto);


	//提交修改信息
	public HouseExcution editHouseInfo(HouseDto houseDto);

	//提交删除信息
	public HouseExcution deleteHouseInfo(HouseDto houseDto);

}
