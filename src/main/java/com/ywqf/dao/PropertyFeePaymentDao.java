package com.ywqf.dao;

import java.util.List;

import com.ywqf.entity.PropertyFeePayment;
import com.ywqf.entity.payMonthType;
import org.apache.ibatis.annotations.Param;

public interface PropertyFeePaymentDao {
 
	//������
	public List<PropertyFeePayment> findListProperty(@Param("at_search") String at_search, @Param("rows") int rows, @Param("offset") int offset, @Param("status") String status, @Param("estateSearchId") int estateSearchId, @Param("comm") int comm, @Param("at_pay_start") String at_pay_start, @Param("at_pay_end") String at_pay_end, @Param("at_service_start") String at_service_start, @Param("at_service_end") String at_service_end, @Param("okey") String okey);
    //������
	public int findPropertyFeePaymentListCount(@Param("at_search") String at_search, @Param("status") String status, @Param("getEstateSearchId") int getEstateSearchId, @Param("at_pay_start") String at_pay_start, @Param("at_pay_end") String at_pay_end, @Param("at_service_start") String at_service_start, @Param("at_service_end") String at_service_end, @Param("okey") String okey);
	//������״̬  where id
	public PropertyFeePayment findOver(@Param("id") int id);
	//�޸�����״̬
	public int updateOver(@Param("id") int id,@Param("Rname")String Rname);
	//查询门牌号是否为空
	public int findHouseNumIsNull(@Param("house_num") String house_num, @Param("community_id") int community_id);
	//����С��      where  ��ҵID
	public List<PropertyFeePayment> findVillage(@Param("corp_id") int corp_id);
	//�����շ���Ա
	public List<PropertyFeePayment> findAccount();
	//添加
	public int insertProperty(@Param("estate_pay_num") int estate_pay_num, @Param("house_id") int house_id, @Param("owner_name") String owner_name, @Param("area") double area, @Param("estate_unit_price") double estate_unit_price, @Param("pay_month_type_id") int pay_month_type_id, @Param("pay_date") String pay_date, @Param("payment_amount") double payment_amount, @Param("service_start_date") String service_start_date, @Param("service_end_date") String service_end_date, @Param("charge_worker_id") int charge_worker_id, @Param("operator") String operator);
    //求物业缴费单ID
	public PropertyFeePayment findEstateId(@Param("house_id") int house_id, @Param("owner_name") String owner_name, @Param("estate_pay_num") int estate_pay_num);
    //添加汇总表
    public int insertPropertyStatist(@Param("estate_pay_id") int estate_pay_id, @Param("house_id") int house_id, @Param("years") int years, @Param("months") int months);
    //������ҵ��˾
	public List<PropertyFeePayment> findEstate();
	//�������ƺ�
	public List<PropertyFeePayment> findListHouseNumber(@Param("community_id") int community_id);
	// �������ƺŲ� ҵ���� ��� ����
	public PropertyFeePayment findAreaOrMoneyOrName(@Param("house_num") String house_num, @Param("community_id") int community_id);
    //查询码表缴费月数
	public List<payMonthType> findMoneyMonth();
    //查开始日期 = 上次 结束日期+1   where 小区ID ， 门牌号
	public PropertyFeePayment findStartTime(@Param("house_id") int house_id);
	//查询 此物业是总部还是物业公司
	public PropertyFeePayment findType(@Param("corp_id") int corp_id);
	// 查询 操作人员有权限的小区 遍历出来
	public List<PropertyFeePayment>findRidComm(@Param("rid") int rid);
}
