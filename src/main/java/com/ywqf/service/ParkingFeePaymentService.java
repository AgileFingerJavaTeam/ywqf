package com.ywqf.service;

import com.ywqf.dto.excution.ParkingFeePaymentExcution;
import com.ywqf.dto.in.ParkingFeePaymentDto;
import com.ywqf.dto.in.PropertyFeePaymentDto;
import org.apache.ibatis.annotations.Param;

public interface ParkingFeePaymentService {
    //查询数据
	public ParkingFeePaymentExcution findParkingList(ParkingFeePaymentDto parkingFeePaymentDto);
	//查看作废
	public ParkingFeePaymentExcution findOver(ParkingFeePaymentDto parkingFeePaymentDto);
	//修改作废状态
	public ParkingFeePaymentExcution updateOver(ParkingFeePaymentDto parkingFeePaymentDto);
	//查询遍历 小区         where 物业公司
	public ParkingFeePaymentExcution findVillage(ParkingFeePaymentDto parkingFeePaymentDto);
	//查码表缴纳月数
	public ParkingFeePaymentExcution findMoneyMonth();
	//查询遍历  收费人员
	public ParkingFeePaymentExcution findAccount(ParkingFeePaymentDto parkingFeePaymentDto);
	//查门牌号是否存在
	public ParkingFeePaymentExcution findHouseNumIsNull(ParkingFeePaymentDto parkingFeePaymentDto);
	//查门牌号遍历 车主名 车位单价 车牌号
	public ParkingFeePaymentExcution findCarNumberOrMoneyOrName(ParkingFeePaymentDto parkingFeePaymentDto);
	//查开始日期 = 上次 结束日期+1   where 小区ID ， 门牌号
	public ParkingFeePaymentExcution findStartTime(ParkingFeePaymentDto parkingFeePaymentDto);
	//添加方法
	public ParkingFeePaymentExcution insertParking(ParkingFeePaymentDto parkingFeePaymentDto);
	//查询 此物业是总部还是物业公司
	public ParkingFeePaymentExcution findType(ParkingFeePaymentDto parkingFeePaymentDto);
	//查询 操作人员有权限的小区 遍历出来
	public ParkingFeePaymentExcution findRidComm(@Param("rid") int rid);
	//查询遍历 物业公司
	public ParkingFeePaymentExcution findEstate(ParkingFeePaymentDto parkingFeePaymentDto);
}
