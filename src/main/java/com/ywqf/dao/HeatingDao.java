package com.ywqf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ywqf.entity.Heating;



public interface HeatingDao {
	/**
	 * 获取列表
	 * @param checked
	 * @param timeYear
	 * @return
	 */
	public List<Heating> getHeatingList(@Param("checked")int checked,@Param("timeYear")int timeYear,@Param("corpsId")int corpsId,@Param("communityId")int communityId,@Param("userId")int userId,@Param("type")int type,@Param("search")String search);
	/**
	 * 获取个数
	 * @param checked
	 * @param timeYear
	 * @return
	 */
	public int findHeatingCount(@Param("checked")int checked,@Param("timeYear")int timeYear,@Param("corpsId")int corpsId,@Param("communityId")int communityId,@Param("userId")int userId,@Param("type")int type,@Param("search")String search);
	
	/**
	 * 获取物业公司
	 * @param userID
	 * @param corpsType
	 * @return
	 */
	public List<Heating> getHeatingCorps(@Param("userID")int userID,@Param("corpsType")int corpsType);
	
	/**
	 * 根据物业搜索小区
	 * @param userID
	 * @return
	 */
	public List<Heating> getHeatingCommunity(@Param("userId")int userId,@Param("type")int type,@Param("corpsId")int corpsId);
	
	/**
	 * 缴费数
	 * @param corpsId
	 * @param communityId
	 * @return
	 */
	public int getPay(@Param("timeYear")int timeYear,@Param("userId")int userId,@Param("type")int type,@Param("corpsId")int corpsId,@Param("communityId")int communityId);
	
	/**
	 * 总数
	 * @param corpsId
	 * @param communityId
	 * @return
	 */
	public int getAll(@Param("communityId")int communityId);
	
	
}
