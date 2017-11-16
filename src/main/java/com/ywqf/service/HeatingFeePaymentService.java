package com.ywqf.service;

import com.ywqf.dto.excution.HeatingFeePaymentExcution;
import com.ywqf.dto.excution.ParkingFeePaymentExcution;
import com.ywqf.dto.in.HeatingFeePaymentDto;
import com.ywqf.dto.in.ParkingFeePaymentDto;

public interface HeatingFeePaymentService {
    //查询数据���
	public HeatingFeePaymentExcution findHeatingList(HeatingFeePaymentDto heatingFeePaymentDto);
	//作废状态查询
	public HeatingFeePaymentExcution findOver(HeatingFeePaymentDto heatingFeePaymentDto);
	//修改作废状态
	public HeatingFeePaymentExcution updateOver(HeatingFeePaymentDto heatingFeePaymentDto);
	//查门牌号是否存在
	public HeatingFeePaymentExcution findHouseNumIsNull(HeatingFeePaymentDto heatingFeePaymentDto);
	//查 采暖面积  业主名  单价
	public HeatingFeePaymentExcution findAreaOrNameOrMoney(HeatingFeePaymentDto heatingFeePaymentDto);

}
