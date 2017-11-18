package com.ywqf.entity;

public class Heating {
	private String houseNum;
	private String ownerName;
	private int isStatus;
	private Double paymentAmount;
	private String ownerTel;
	private String ownerStandbyTel;
	private Double heatingPrice;
	private Double heatingArea;
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
	public Double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
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
	public Double getHeatingPrice() {
		return heatingPrice;
	}
	public void setHeatingPrice(Double heatingPrice) {
		this.heatingPrice = heatingPrice;
	}
	public Double getHeatingArea() {
		return heatingArea;
	}
	public void setHeatingArea(Double heatingArea) {
		this.heatingArea = heatingArea;
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
	
	
	

}
