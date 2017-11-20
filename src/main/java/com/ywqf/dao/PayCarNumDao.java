package com.ywqf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ywqf.dto.in.CommunityDto;
import com.ywqf.dto.in.PayCarNumDto;
import com.ywqf.entity.Community;
import com.ywqf.entity.Corp;
import com.ywqf.entity.PayCarNum;

public interface PayCarNumDao {
	/**
	 * 根据id权限查询物业
	 * @param id
	 * @return
	 */
	public List<Corp> findCorpName(@Param("id") int id,@Param("type") int type);
	/**
	 * 根据物业id查询小区列表
	 * @param id
	 * @return
	 */
	public List<Community> findCommunityName(CommunityDto communityDto);
	/**
	 * 查询缴费统计
	 * @param payYearNumDto
	 * @return
	 */
	public List<PayCarNum> listCommunity(PayCarNumDto payCarNumDto);
}
