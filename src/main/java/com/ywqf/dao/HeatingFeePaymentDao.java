package com.ywqf.dao;

import java.util.List;

import com.ywqf.entity.HeatingFeePayment;
import org.apache.ibatis.annotations.Param;

public interface HeatingFeePaymentDao {

	//查询数据
	public List<HeatingFeePayment> findHeatingList(@Param("rows") int rows, @Param("offset") int offset, @Param("at_search") String at_search, @Param("comm") int comm, @Param("estateSearchId") int estateSearchId, @Param("status") String status, @Param("okey") String okey);
    //查询总数
	public int findHeatingListCount(@Param("at_search") String at_search);
	//查询作废状态
    public HeatingFeePayment findOver(@Param("heating_pay_id") int heating_pay_id);
    //修改作废状态
    public int updateOver(@Param("id") int id, @Param("Rname") String Rname);
    //查门牌号是否为空
    public int findHouseNumIsNull(@Param("house_num") String house_num, @Param("community_id") int community_id);
    //查 采暖面积  单价 业主名
    public HeatingFeePayment findAreaOrNameOrMoney(@Param("house_num") String house_num, @Param("community_id") int community_id);
    //遍历小区采暖优惠时间段
    public List<HeatingFeePayment> findHeatingDiscount(@Param("community_id") int community_id);
    //添加
    public int insertHeating(@Param("heating_pay_num") int heating_pay_num, @Param("house_id") int house_id, @Param("owner_name") String owner_name, @Param("discount_heating_unit_price") double discount_heating_unit_price, @Param("heating_area") double heating_area, @Param("payment_amount") double payment_amount, @Param("year") int year, @Param("heating_discount") double heating_discount, @Param("payment_date") String payment_date, @Param("charge_worker_id") int charge_worker_id, @Param("operator") String operator);
}
