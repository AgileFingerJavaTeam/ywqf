package com.ywqf.service;

import com.ywqf.dto.excution.ParkingConfigExcution;
import com.ywqf.dto.in.ParkingConfigDto;


public interface ParkingConfigService {

	//查询车位配置信息
	 public ParkingConfigExcution findParkingConfig	(ParkingConfigDto parkingConfigDto);
	 
	//新增车位配置信息
	public ParkingConfigExcution addParkingConfig(ParkingConfigDto parkingConfigDto);

	/*门牌号联想*/
	public  ParkingConfigExcution fingHouseNum(ParkingConfigDto parkingConfigDto);

	/*通过id查看详细信息*/
	public  ParkingConfigExcution findParkingById(ParkingConfigDto parkingConfigDto);

	/*修改信息*/
	public ParkingConfigExcution subEditParking(ParkingConfigDto parkingConfigDto);

	/*删除信息*/
	public ParkingConfigExcution deleteParking(ParkingConfigDto parkingConfigDto);
}
