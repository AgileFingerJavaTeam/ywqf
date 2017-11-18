package com.ywqf.entity;

public class Parking {
	private int parkingNum;
	private String licensePlateNumber;
	private String houseNum;
	private String carOwnerName;
	private int gender;
	private String carOwnerTel;
	private String carOwnerStandbyTel;
	private Double previousParkingUnitPrice;
	private int paymentStatus;
	
	private String corpName;
	private int type;
	private String communityName;
	private int corpId;
	private int communityId;
	
	
	
	
	
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
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
	public String getCarOwnerName() {
		return carOwnerName;
	}
	public void setCarOwnerName(String carOwnerName) {
		this.carOwnerName = carOwnerName;
	}
	public Double getPreviousParkingUnitPrice() {
		return previousParkingUnitPrice;
	}
	public void setPreviousParkingUnitPrice(Double previousParkingUnitPrice) {
		this.previousParkingUnitPrice = previousParkingUnitPrice;
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
	public String getHouseNum() {
		return houseNum;
	}
	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}
	
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getCarOwnerTel() {
		return carOwnerTel;
	}
	public void setCarOwnerTel(String carOwnerTel) {
		this.carOwnerTel = carOwnerTel;
	}
	public String getCarOwnerStandbyTel() {
		return carOwnerStandbyTel;
	}
	public void setCarOwnerStandbyTel(String carOwnerStandbyTel) {
		this.carOwnerStandbyTel = carOwnerStandbyTel;
	}

	public int getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	@Override
	public String toString() {
		return "Parking [parkingNum=" + parkingNum + ", licensePlateNumber="
				+ licensePlateNumber + ", houseNum=" + houseNum
				+ ", carOwnerName=" + carOwnerName + ", gender=" + gender
				+ ", carOwnerTel=" + carOwnerTel + ", carOwnerStandbyTel="
				+ carOwnerStandbyTel + ", previousParkingUnitPrice="
				+ previousParkingUnitPrice + ", paymentStatus=" + paymentStatus
				+ "]";
	}
	
	
	
	

}
