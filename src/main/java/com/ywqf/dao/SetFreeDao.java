package com.ywqf.dao;

import java.util.List;

import com.ywqf.dto.in.FreePropertyDto;
import com.ywqf.entity.FreeProperty;

public interface SetFreeDao {
	/**
	 * 按照搜索条件查询包含条件的楼房物业列表
	 * @param freePropertyDto
	 * @return
	 */
	public List<FreeProperty> listFreeProperty(FreePropertyDto freePropertyDto);

}
