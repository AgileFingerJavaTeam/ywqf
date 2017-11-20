package com.ywqf.dao;

import java.util.List;

import com.ywqf.entity.*;
import org.apache.ibatis.annotations.Param;

public interface PayCostDao {

	/**
	 * 查询所属物业公司
	 * @param corp_id
	 * @return
	 */
	public PropertyCompany findPropertyCompany(@Param("corp_id") int corp_id);

	/**
	 * 查询所属小区
	 * @return
	 */
	public List<Community> findListCommunity(@Param("corp_id") int corp_id);

	/**
	 * 查询门牌号是否存在
	 * @param house_num
	 * @return
	 */
	public String findHouseNum(@Param("house_num") String house_num,@Param("community_id") int community_id);

	/**
	 * 查询业主信息
	 * @param community_id
	 * @param house_num
	 * @return
	 */
	public OwnerInfor findOwnerInfor(@Param("community_id") int community_id, @Param("house_num") String house_num);

	/**
	 * 查询业主缴费信息
	 * @param corp_id
	 * @param community_id
	 * @param house_num
	 * @param year
	 * @return
	 */
	public List<PaymentInfor> findListPaymentInfor(@Param("corp_id") int corp_id,
												   @Param("community_id") int community_id,
												   @Param("house_num") String house_num,
												   @Param("year") int year);

}
