package com.ywqf.entity;

import ch.qos.logback.core.net.SyslogOutputStream;

public class FreeProperty {
	private int houseId;
	private String houseNum;
	private String houseTypeName;
	private double area;
	private double previousEstateUnitPrice;
	private double previousEstateFee;
	public int getHouseId() {
		return houseId;
	}
	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}
	public String getHouseNum() {
		return houseNum;
	}
	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}
	public String getHouseTypeName() {
		return houseTypeName;
	}
	public void setHouseTypeName(String houseTypeName) {
		this.houseTypeName = houseTypeName;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public double getPreviousEstateUnitPrice() {
		return previousEstateUnitPrice;
	}
	public void setPreviousEstateUnitPrice(double previousEstateUnitPrice) {
		this.previousEstateUnitPrice = previousEstateUnitPrice;
	}
	public double getPreviousEstateFee() {
		return previousEstateFee;
	}
	public void setPreviousEstateFee(double previousEstateFee) {
		this.previousEstateFee = previousEstateFee;
	}
	@Override
	public String toString() {
		return "FreeProperty [houseId=" + houseId + ", houseNum=" + houseNum + ", houseTypeName=" + houseTypeName
				+ ", area=" + area + ", previousEstateUnitPrice=" + previousEstateUnitPrice + ", previousEstateFee="
				+ previousEstateFee + "]";
	}
}
