package com.ywqf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ywqf.entity.CorpAndCommunity;

public interface CorpAndCommunityDao {
	
	//总部--获取所有物业
	public List<CorpAndCommunity> getAllCorp();
	
	//总部--获取同一物业下所有小区
	public List<CorpAndCommunity> getAllCommunity(@Param("corpsID") int corpsID);
	
	//获取物业公司管辖的小区
	public List<CorpAndCommunity> getCommunity(@Param("userID") int userID);
	
	//获取物业公司员工所在的物业名称
	public List<CorpAndCommunity> getCorp(@Param("corpId") int corpId);
	
	

}
