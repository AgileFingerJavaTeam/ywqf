package com.ywqf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ywqf.entity.HeatingFeePayment;
import com.ywqf.entity.ParkingFeePayment;

public interface HeatingFeePaymentDao {

	//查询数据
	public List<HeatingFeePayment> findHeatingList(@Param("rows") int rows, @Param("offset") int offset, @Param("at_search") String at_search);
    //查询总数
	public int findHeatingListCount(@Param("at_search") String at_search);
	//查询作废状态
    public HeatingFeePayment findOver(@Param("id") int id);
    //修改作废状态
    public int updateOver(@Param("id") int id, @Param("Rname") String Rname);
    //查门牌号是否为空
    public int findHouseNumIsNull(@Param("house_num") String house_num, @Param("community_id") int community_id);
    //查 采暖面积  单价 业主名
    public HeatingFeePayment findAreaOrNameOrMoney(@Param("house_num") String house_num, @Param("community_id") int community_id);
}
