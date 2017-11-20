package com.ywqf.entity;

public class Heating {
	private String houseNum;
	private String ownerName;
	private int isStatus;
	private String paymentAmount;
	private String ownerTel;
	private String ownerStandbyTel;
	private String heatingPrice;
	private String heatingArea;
	private int year;
	private String corpName;
	private int type;
	private String communityName;
	private int corpId;
	private int communityId;
	
	
	public int getCommunityId() {
		return communityId;
	}
	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}
	
	public int getCorpId() {
		return corpId;
	}
	public void setCorpId(int corpId) {
		this.corpId = corpId;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	public String getHouseNum() {
		return houseNum;
	}
	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public int getIsStatus() {
		return isStatus;
	}
	public void setIsStatus(int isStatus) {
		this.isStatus = isStatus;
	}
	
	public String getOwnerTel() {
		return ownerTel;
	}
	public void setOwnerTel(String ownerTel) {
		this.ownerTel = ownerTel;
	}
	public String getOwnerStandbyTel() {
		return ownerStandbyTel;
	}
	public void setOwnerStandbyTel(String ownerStandbyTel) {
		this.ownerStandbyTel = ownerStandbyTel;
	}
	
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getHeatingPrice() {
		return heatingPrice;
	}
	public void setHeatingPrice(String heatingPrice) {
		this.heatingPrice = heatingPrice;
	}
	public String getHeatingArea() {
		return heatingArea;
	}
	public void setHeatingArea(String heatingArea) {
		this.heatingArea = heatingArea;
	}
	@Override
	public String toString() {
		return "Heating [houseNum=" + houseNum + ", ownerName=" + ownerName
				+ ", isStatus=" + isStatus + ", paymentAmount=" + paymentAmount
				+ ", ownerTel=" + ownerTel + ", ownerStandbyTel="
				+ ownerStandbyTel + ", heatingPrice=" + heatingPrice
				+ ", heatingArea=" + heatingArea + ", year=" + year
				+ ", corpName=" + corpName + ", type=" + type
				+ ", communityName=" + communityName + ", corpId=" + corpId
				+ ", communityId=" + communityId + "]";
	}
	
	
	
	
	

}
