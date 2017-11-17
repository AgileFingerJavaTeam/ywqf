package com.ywqf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ywqf.entity.Parking;

public interface ParkingDao {
	
	public List<Parking> getParkingList(@Param("offset") int offset, @Param("rows") int rows, @Param("likePark") String likePark, @Param("checked") int checked);
	
	public int findParkingCount(@Param("likePark") String likePark, @Param("checked") int checked);
	
	public List<Parking> getFirParkingList(@Param("checked") int checked, @Param("year") int year, @Param("month") int month);
	
	public int findFirParkingCount(@Param("checked") int checked, @Param("year") int year, @Param("month") int month);

}
