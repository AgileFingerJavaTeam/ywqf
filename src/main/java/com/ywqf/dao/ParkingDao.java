package com.ywqf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ywqf.entity.Parking;

public interface ParkingDao {
	
	public List<Parking> getFirParkingList(@Param("checked")int checked,@Param("year")int year,@Param("month")int month,@Param("corpsId")int corpsId,@Param("communityId")int communityId,@Param("userId")int userId,@Param("type")int type,@Param("search")String search);
	
	public int findFirParkingCount(@Param("checked")int checked,@Param("year")int year,@Param("month")int month,@Param("corpsId")int corpsId,@Param("communityId")int communityId,@Param("userId")int userId,@Param("type")int type,@Param("search")String search);
	
	public List<Parking> getParkingCommunity(@Param("userId")int userId,@Param("type")int type,@Param("corpsId")int corpsId);

	/**
	 * 缴费数
	 * @param corpsId
	 * @param communityId
	 * @return
	 */
	public int getPay(@Param("year")int year,@Param("month")int month,@Param("userId")int userId,@Param("type")int type,@Param("corpsId")int corpsId,@Param("communityId")int communityId);
	
	/**
	 * 总数
	 * @param corpsId
	 * @param communityId
	 * @return
	 */
	public int getAll(@Param("communityId")int communityId);
}
