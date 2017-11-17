package com.ywqf.service;

import com.ywqf.dto.excution.FreePropertyExcution;
import com.ywqf.dto.in.FreePropertyDto;

public interface SetFreeService {
	/**
	 * 物业列表显示
	 * @param freePropertyDto
	 * @return
	 */
	public FreePropertyExcution ListFreeProperty(FreePropertyDto freePropertyDto);
	/**
	 * 预览修改物业列表对比
	 * @param freePropertyDto
	 * @return
	 */
	public FreePropertyExcution ListpreviewFreeProperty(FreePropertyDto freePropertyDto);
}
