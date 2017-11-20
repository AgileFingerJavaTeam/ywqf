package com.ywqf.service;

import com.ywqf.dto.excution.HeatingExcution;
import com.ywqf.dto.in.HeatingDto;

public interface HeatingService {
	/**
	 * 获取取暖列表
	 * @param heatingDto
	 * @return
	 */
	public HeatingExcution getHeatingList(HeatingDto heatingDto);
	
	
	
}
