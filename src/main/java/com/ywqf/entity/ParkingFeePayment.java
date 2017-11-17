package com.ywqf.entity;

public class ParkingFeePayment {
	
	private int id;
	private int parkingPayNum; //�ɷѵ���
	private int corpId; //��ҵID
	private int communityId; //С��ID
	private int houseId; //����ID
	private int parkingSpaceId; //
	private int parkingNum; //��λ���
	private String licensePlateNumber; //���ƺ�
	private double parkingUnitPrice; //��λ����(��Ԫ��Ԫ)
	private int payMonthTypeId; //��������
	private String ownerName; //ҵ������
	private String serviceStartDate; //������ʼ����
	private String serviceEndDate; //�����ֹ����
	private int chargeWorkerId; //�շ�Ա��ID
	private String payDate; //�ɷ�����
	private double paymentAmount;//���ɽ���λ:Ԫ��
	private int status; //״̬ 1.���� 2.����
	private String operator;  //������
	private String operateTime;  //������ʱ��
	private String operateIp;  //����IP
    private int type;//物业类型
	private String houseNum; //���ƺ�
	
	private String account; //�շ�Ա��

	private String carOwnerName;

	private String corpName;// 物业名
	private String communityName; //  小区名
    private String maxInsert; //起始日期+1
	private double nowParkingUnitPrice; //新车位单价
	private String carOwnerTel;//车主联系电话
	private int payMonth; //缴纳月数
	private String name; //收费人 名字
	private int parkingPayId; //车位缴费ID
	private int userId;//用户ID
	private double previousParkingUnitPrice; //车位单价

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getPreviousParkingUnitPrice() {
		return previousParkingUnitPrice;
	}

	public void setPreviousParkingUnitPrice(double previousParkingUnitPrice) {
		this.previousParkingUnitPrice = previousParkingUnitPrice;
	}

	public int getParkingPayId() {
		return parkingPayId;
	}

	public void setParkingPayId(int parkingPayId) {
		this.parkingPayId = parkingPayId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPayMonth() {
		return payMonth;
	}

	public void setPayMonth(int payMonth) {
		this.payMonth = payMonth;
	}

	public String getCarOwnerTel() {
		return carOwnerTel;
	}

	public void setCarOwnerTel(String carOwnerTel) {
		this.carOwnerTel = carOwnerTel;
	}

	public String getMaxInsert() {
		return maxInsert;
	}

	public void setMaxInsert(String maxInsert) {
		this.maxInsert = maxInsert;
	}

	public double getNowParkingUnitPrice() {
		return nowParkingUnitPrice;
	}

	public void setNowParkingUnitPrice(double nowParkingUnitPrice) {
		this.nowParkingUnitPrice = nowParkingUnitPrice;
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

	public String getCarOwnerName() {
		return carOwnerName;
	}

	public void setCarOwnerName(String carOwnerName) {
		this.carOwnerName = carOwnerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParkingPayNum() {
		return parkingPayNum;
	}

	public void setParkingPayNum(int parkingPayNum) {
		this.parkingPayNum = parkingPayNum;
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

	public int getParkingSpaceId() {
		return parkingSpaceId;
	}

	public void setParkingSpaceId(int parkingSpaceId) {
		this.parkingSpaceId = parkingSpaceId;
	}

	public int getParkingNum() {
		return parkingNum;
	}

	public void setParkingNum(int parkingNum) {
		this.parkingNum = parkingNum;
	}

	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}

	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}

	public double getParkingUnitPrice() {
		return parkingUnitPrice;
	}

	public void setParkingUnitPrice(double parkingUnitPrice) {
		this.parkingUnitPrice = parkingUnitPrice;
	}

	public int getPayMonthTypeId() {
		return payMonthTypeId;
	}

	public void setPayMonthTypeId(int payMonthTypeId) {
		this.payMonthTypeId = payMonthTypeId;
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

	public int getChargeWorkerId() {
		return chargeWorkerId;
	}

	public void setChargeWorkerId(int chargeWorkerId) {
		this.chargeWorkerId = chargeWorkerId;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public String getOperateIp() {
		return operateIp;
	}

	public void setOperateIp(String operateIp) {
		this.operateIp = operateIp;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "ParkingFeePayment{" +
				"id=" + id +
				", parkingPayNum=" + parkingPayNum +
				", corpId=" + corpId +
				", communityId=" + communityId +
				", houseId=" + houseId +
				", parkingSpaceId=" + parkingSpaceId +
				", parkingNum=" + parkingNum +
				", licensePlateNumber='" + licensePlateNumber + '\'' +
				", parkingUnitPrice=" + parkingUnitPrice +
				", payMonthTypeId=" + payMonthTypeId +
				", ownerName='" + ownerName + '\'' +
				", serviceStartDate='" + serviceStartDate + '\'' +
				", serviceEndDate='" + serviceEndDate + '\'' +
				", chargeWorkerId=" + chargeWorkerId +
				", payDate='" + payDate + '\'' +
				", paymentAmount=" + paymentAmount +
				", status=" + status +
				", operator='" + operator + '\'' +
				", operateTime='" + operateTime + '\'' +
				", operateIp='" + operateIp + '\'' +
				", houseNum='" + houseNum + '\'' +
				", account='" + account + '\'' +
				", carOwnerName='" + carOwnerName + '\'' +
				", corpName='" + corpName + '\'' +
				", communityName='" + communityName + '\'' +
				", maxInsert='" + maxInsert + '\'' +
				", nowParkingUnitPrice=" + nowParkingUnitPrice +
				", carOwnerTel='" + carOwnerTel + '\'' +
				'}';
	}
}
