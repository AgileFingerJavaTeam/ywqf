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
	public List<Heating> getHeatingList(@Param("checked") int checked, @Param("timeYear") int timeYear);
	/**
	 * 获取个数
	 * @param checked
	 * @param timeYear
	 * @return
	 */
	public int findHeatingCount(@Param("checked") int checked, @Param("timeYear") int timeYear);
	
	/**
	 * 获取物业公司
	 * @param userID
	 * @param corpsType
	 * @return
	 */
	public List<Heating> getHeatingCorps(@Param("userID") int userID, @Param("corpsType") int corpsType);
	
	/**
	 * 物业员工搜索小区
	 * @param userID
	 * @return
	 */
	public List<Heating> getHeatingCommunity(@Param("userID") int userID);
	
	/**
	 * 总部搜索小区
	 * @param corpsID
	 * @return
	 */
	public List<Heating> getAllCommunity(@Param("corpsID") int corpsID);
	
}
