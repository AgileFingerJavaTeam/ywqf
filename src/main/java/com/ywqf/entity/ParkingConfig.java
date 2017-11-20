package com.ywqf.entity;

public class ParkingConfig {
	private int parkingSpaceId;
	private int parkingNum;
	private String licensePlateNumber;
	private String locationDescription;
	private double previousParkingUnitPrice;
	private String carOwnerName;
	private String houseNum;
	private String carOwnerTel;
	private String carOwnerStandbyTel;
	private String ownerName;
	private String ownerTel;
	private int houseId;
	private String ownerStandbyTel;
	private int gender;
	private int communityId;
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

	public String getLocationDescription() {
		return locationDescription;
	}

	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}

	public double getPreviousParkingUnitPrice() {
		return previousParkingUnitPrice;
	}

	public void setPreviousParkingUnitPrice(double previousParkingUnitPrice) {
		this.previousParkingUnitPrice = previousParkingUnitPrice;
	}

	public String getCarOwnerName() {
		return carOwnerName;
	}

	public void setCarOwnerName(String carOwnerName) {
		this.carOwnerName = carOwnerName;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
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

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerTel() {
		return ownerTel;
	}

	public void setOwnerTel(String ownerTel) {
		this.ownerTel = ownerTel;
	}

	public int getHouseId() {
		return houseId;
	}

	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}

	public String getOwnerStandbyTel() {
		return ownerStandbyTel;
	}

	public void setOwnerStandbyTel(String ownerStandbyTel) {
		this.ownerStandbyTel = ownerStandbyTel;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}

	@Override
	public String toString() {
		return "ParkingConfig{" +
				"parkingSpaceId=" + parkingSpaceId +
				", parkingNum=" + parkingNum +
				", licensePlateNumber='" + licensePlateNumber + '\'' +
				", locationDescription='" + locationDescription + '\'' +
				", previousParkingUnitPrice=" + previousParkingUnitPrice +
				", carOwnerName='" + carOwnerName + '\'' +
				", houseNum='" + houseNum + '\'' +
				", carOwnerTel='" + carOwnerTel + '\'' +
				", carOwnerStandbyTel='" + carOwnerStandbyTel + '\'' +
				", ownerName='" + ownerName + '\'' +
				", ownerTel='" + ownerTel + '\'' +
				", houseId=" + houseId +
				", ownerStandbyTel='" + ownerStandbyTel + '\'' +
				", gender=" + gender +
				", communityId=" + communityId +
				'}';
	}
}
