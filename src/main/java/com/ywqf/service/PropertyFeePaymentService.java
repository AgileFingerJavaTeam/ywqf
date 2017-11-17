package com.ywqf.service;

import com.ywqf.dto.excution.PropertyFeePaymentExcution;
import com.ywqf.dto.in.PropertyFeePaymentDto;
import org.apache.ibatis.annotations.Param;

public interface PropertyFeePaymentService {
    // ������
	public PropertyFeePaymentExcution findPropertyList(PropertyFeePaymentDto propertyFeePaymentDto);
	// ������״̬
	public PropertyFeePaymentExcution findOver(@Param("id") int id);
	// �޸�����״̬
	public PropertyFeePaymentExcution updateOver(PropertyFeePaymentDto propertyFeePaymentDto);
	// ��С������  where ��ҵID
	public PropertyFeePaymentExcution findVillage(PropertyFeePaymentDto propertyFeePaymentDto);
	// ������շ���Ա
	public PropertyFeePaymentExcution findAccount(PropertyFeePaymentDto propertyFeePaymentDto);
	// ��ӷ���     ����ipû���    �ɷ���������ȷ   �շ�Ա��������ȷ
	public PropertyFeePaymentExcution insertProperty(PropertyFeePaymentDto propertyFeePaymentDto);
	// ������ҵ��˾
	public PropertyFeePaymentExcution findEstate(PropertyFeePaymentDto propertyFeePaymentDto);
	// ������С��
	public PropertyFeePaymentExcution findComm(PropertyFeePaymentDto propertyFeePaymentDto);
	// 查看是否存在 门牌号
	public PropertyFeePaymentExcution findHouseNumIsNull(PropertyFeePaymentDto propertyFeePaymentDto);
	// �������ƺ�
	public PropertyFeePaymentExcution findListHouseNumber(PropertyFeePaymentDto propertyFeePaymentDto);
	// ͨ�����ƺŲ� ҵ��������� ������
	public PropertyFeePaymentExcution findAreaOrMoneyOrName(PropertyFeePaymentDto propertyFeePaymentDto);
	//查码表缴纳月数
	public PropertyFeePaymentExcution findMoneyMonth();
    //查开始日期 = 上次 结束日期+1   where 小区ID ， 门牌号
	public PropertyFeePaymentExcution findStartTime(PropertyFeePaymentDto propertyFeePaymentDto);
	//查询 此物业是总部还是物业公司
	public PropertyFeePaymentExcution findType(PropertyFeePaymentDto propertyFeePaymentDto);
	// 查询 操作人员有权限的小区 遍历出来
	public PropertyFeePaymentExcution findRidComm(@Param("rid") int rid);
}
