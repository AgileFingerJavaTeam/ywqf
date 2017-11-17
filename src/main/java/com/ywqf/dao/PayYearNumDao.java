package com.ywqf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ywqf.dto.in.CommunityDto;
import com.ywqf.dto.in.PayYearNumDto;
import com.ywqf.entity.Community;
import com.ywqf.entity.Corp;
import com.ywqf.entity.PayYearNum;

public interface PayYearNumDao {
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
	//public List<PayYearNum> listCommunity(@Param("company") String company,@Param("community") String community,@Param("year") Integer year,@Param("time1") String time1,@Param("time2") String time2);
	public List<PayYearNum> listCommunity(PayYearNumDto payYearNumDto);

}
