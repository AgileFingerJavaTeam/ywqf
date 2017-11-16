package com.ywqf.entity;

public class OwnerInfor {
	private String houseNum;//门牌号
	private String ownerName;//业主姓名
	private String ownerTel;//联系电话
	private String ownerStandbyTel;//备用联系电话
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
	@Override
	public String toString() {
		return "OwnerInfor [houseNum=" + houseNum + ", ownerName=" + ownerName + ", ownerTel=" + ownerTel
				+ ", ownerStandbyTel=" + ownerStandbyTel + "]";
	}
	
	
}
