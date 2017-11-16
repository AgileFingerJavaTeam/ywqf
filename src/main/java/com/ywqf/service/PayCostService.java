package com.ywqf.service;

import com.ywqf.dto.excution.PayCostExcution;
import com.ywqf.dto.in.PayCostDto;
import com.ywqf.entity.OwnerInfor;

public interface PayCostService {
	/**
	 * 查询物业公司
	 * @return
	 */
	public PayCostExcution findPayCost();

	/**
	 * 查询所属小区
	 * @return
	 */
	public PayCostExcution findListCommunity();

	/**
	 * 查询业主信息和筛选业主查询缴费信息
	 * @param payCostDto
	 * @return
	 */
	public PayCostExcution findOwnerInfor(PayCostDto payCostDto);
}
