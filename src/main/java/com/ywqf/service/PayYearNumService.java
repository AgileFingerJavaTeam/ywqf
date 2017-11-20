package com.ywqf.service;

import com.ywqf.dto.excution.CommunityExcution;
import com.ywqf.dto.excution.CorpExcution;
import com.ywqf.dto.excution.PayYearResultExcution;
import com.ywqf.dto.in.CommunityDto;
import com.ywqf.dto.in.PayYearNumDto;

public interface PayYearNumService {
	/**
	 * 查询缴费统计
	 * @param payYearNumDto
	 * @return
	 */
	public PayYearResultExcution PayYearResult(PayYearNumDto payYearNumDto);
	/**
	 * 根据userID查询物业
	 * @param id
	 * @return
	 */
	public CorpExcution CorpList(int id,int type);
	/**
	 * 根据物业id查询小区
	 * @param id
	 * @return
	 */
	public CommunityExcution CommunityList(CommunityDto communityDto);
}
