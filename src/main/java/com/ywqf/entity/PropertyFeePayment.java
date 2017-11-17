package com.ywqf.entity;

import java.util.Date;

public class PropertyFeePayment {

	private int estatePayId; //物业缴费ID
	private int id; //ID
	private int userId;
	private String name;
	private int estatePayNum; //
	private String ownerName; //
	private String serviceStartDate; //
	private String serviceEndDate;  //
	private int payMonthTypeId;  //����
	private double paymentAmount; //�
	private String account;   //��
	private String payDate; //�����
	private String operator; //�
	private String operateTime; //
	private String houseNum; //
	private int type;
	private double area; //���
	private double estateUnitPrice; //
	private int status; //  状态
	private int corpId; //  物业ID
	private int communityId; //  小区ID
	private int houseId; //  房间ID
	private double previousEstateUnitPrice; //物业单价  house表
	private String corpName;//物业名
	private String communityName; //小区名
	private int payMonth; //缴费月数
	
	private double nowEstateUnitPrice; //
	
	private String maxInsert; //最大截止日期+1

	public int getEstatePayId() {
		return estatePayId;
	}

	public void setEstatePayId(int estatePayId) {
		this.estatePayId = estatePayId;
	}

	public int getPayMonth() {
		return payMonth;
	}

	public void setPayMonth(int payMonth) {
		this.payMonth = payMonth;
	}

	public double getPreviousEstateUnitPrice() {
		return previousEstateUnitPrice;
	}

	public void setPreviousEstateUnitPrice(double previousEstateUnitPrice) {
		this.previousEstateUnitPrice = previousEstateUnitPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getMaxInsert() {
		return maxInsert;
	}

	public void setMaxInsert(String maxInsert) {
		this.maxInsert = maxInsert;
	}

	public double getNowEstateUnitPrice() {
		return nowEstateUnitPrice;
	}
	public void setNowEstateUnitPrice(double nowEstateUnitPrice) {
		this.nowEstateUnitPrice = nowEstateUnitPrice;
	}
	public int getCorpId() {
		return corpId;
	}
	public void setCorpId(int corpId) {
		this.corpId = corpId;
	}
	public int getCommunityId() {
		return communityId;
	}
	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}
	public int getHouseId() {
		return houseId;
	}
	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEstatePayNum() {
		return estatePayNum;
	}
	public void setEstatePayNum(int estatePayNum) {
		this.estatePayNum = estatePayNum;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public String getServiceStartDate() {
		return serviceStartDate;
	}
	public void setServiceStartDate(String serviceStartDate) {
		this.serviceStartDate = serviceStartDate;
	}
	public String getServiceEndDate() {
		return serviceEndDate;
	}
	public void setServiceEndDate(String serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}
	public int getPayMonthTypeId() {
		return payMonthTypeId;
	}
	public void setPayMonthTypeId(int payMonthTypeId) {
		this.payMonthTypeId = payMonthTypeId;
	}
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}
	public String getHouseNum() {
		return houseNum;
	}
	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public double getEstateUnitPrice() {
		return estateUnitPrice;
	}
	public void setEstateUnitPrice(double estateUnitPrice) {
		this.estateUnitPrice = estateUnitPrice;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PropertyFeePayment{" +
				"id=" + id +
				", estatePayNum=" + estatePayNum +
				", ownerName='" + ownerName + '\'' +
				", serviceStartDate='" + serviceStartDate + '\'' +
				", serviceEndDate='" + serviceEndDate + '\'' +
				", payMonthTypeId=" + payMonthTypeId +
				", paymentAmount=" + paymentAmount +
				", account='" + account + '\'' +
				", payDate='" + payDate + '\'' +
				", operator='" + operator + '\'' +
				", operateTime='" + operateTime + '\'' +
				", houseNum='" + houseNum + '\'' +
				", type=" + type +
				", area=" + area +
				", estateUnitPrice=" + estateUnitPrice +
				", status=" + status +
				", corpId=" + corpId +
				", communityId=" + communityId +
				", houseId=" + houseId +
				", corpName='" + corpName + '\'' +
				", communityName='" + communityName + '\'' +
				", nowEstateUnitPrice=" + nowEstateUnitPrice +
				", maxInsert='" + maxInsert + '\'' +
				'}';
	}
}
