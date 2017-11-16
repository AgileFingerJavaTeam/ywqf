package com.ywqf.dao;

import java.util.List;

import com.ywqf.dto.in.CheckCondition;
import com.ywqf.entity.FreeProperty;

public interface SetFreeDao {
	
	/**
	 * 根据查询条件查询符合的物业列表
	 * @param checkConditon
	 * @return
	 */
	public List<FreeProperty> ListFreeProperty(CheckCondition checkConditon);
}
