package com.ywqf.dao;

import java.util.List;

import com.ywqf.entity.ParkingFeePayment;
import com.ywqf.entity.payMonthType;
import org.apache.ibatis.annotations.Param;

public interface ParkingFeePaymentDao {

	//������
	public List<ParkingFeePayment> findParkingList(@Param("rows") int rows, @Param("offset") int offset, @Param("at_search") String at_search, @Param("status") String status, @Param("okey") String okey, @Param("estateSearchId") int estateSearchId, @Param("comm") int comm);
    //������
	public int findParkingListCount(@Param("at_search") String at_search);
	//������
    public ParkingFeePayment findOver(@Param("id") int id);
    //�޸�����״̬
    public int updateOver(@Param("id") int id,@Param("Rname")String Rname);
    //查询遍历 小区         where 物业公司
    public List<ParkingFeePayment> findVillage(@Param("corp_id") int corp_id);
    //查码表缴纳月数
    public List<payMonthType> findMoneyMonth();
    //查 遍历 收费人员
    public List<ParkingFeePayment> findAccount();
    //查 门牌号是否为空
    public int findHouseNumIsNull(@Param("house_num") String house_num, @Param("community_id") int community_id);
    //查门牌号遍历 车主名 车位单价 车牌号
    public ParkingFeePayment findCarNumberOrMoneyOrName(@Param("house_num") String house_num, @Param("community_id") int community_id);
    //查开始日期 = 上次 结束日期+1   where 小区ID ， 门牌号
    public ParkingFeePayment findStartTime(@Param("community_id") int community_id, @Param("house_num") String house_num);
    //添加方法
    public int insertParking(@Param("parking_pay_num") int parking_pay_num, @Param("parking_space_id") int parking_space_id, @Param("parking_unit_price") double parking_unit_price, @Param("pay_month_type_id") int pay_month_type_id, @Param("owner_name") String owner_name, @Param("service_start_date") String service_start_date, @Param("service_end_date") String service_end_date, @Param("charge_worker_id") int charge_worker_id, @Param("pay_date") String pay_date, @Param("payment_amount") double payment_amount, @Param("operator") String operator);
    //查车位缴费ID
    public ParkingFeePayment findParkingId(@Param("parking_space_id") int parking_space_id, @Param("parking_pay_num") int parking_pay_num);
    //事务 添加 车位汇总表
    public int insertParkingStatist(@Param("parkingPayId") int parkingPayId, @Param("parking_space_id") int parking_space_id, @Param("years") int years, @Param("months") int months);
    //查询 此物业是总部还是物业公司
    public ParkingFeePayment findType(@Param("corp_id") int corp_id);
    //查询 操作人员有权限的小区 遍历出来
    public List<ParkingFeePayment> findRidComm(@Param("rid") int rid);
    //查询遍历 物业公司
    public List<ParkingFeePayment> findEstate();

}
