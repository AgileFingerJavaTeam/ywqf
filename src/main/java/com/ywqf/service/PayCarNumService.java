package com.ywqf.service;

import com.ywqf.dto.excution.CarExcution;
import com.ywqf.dto.excution.PayCarResultExcution;
import com.ywqf.dto.in.CommunityDto;
import com.ywqf.dto.in.PayCarNumDto;

public interface PayCarNumService {
	/**
	 * 根据userID查询物业
	 * @param id
	 * @return
	 */
	public CarExcution CorpList(int id,int type);
	/**
	 * 根据物业id查询小区
	 * @param id
	 * @return
	 */
	public CarExcution CommunityList(CommunityDto communityDto);
	/**
	 * 查询缴费统计
	 * @param payCarNumDto
	 * @return
	 */
	public PayCarResultExcution PayCarResult(PayCarNumDto payCarNumDto);
}
