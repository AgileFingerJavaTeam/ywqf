package com.ywqf.entity;

public class FreeProperty {
	private int houseNum;
	private String houseTypeName;
	private double area;
	private double previousEstateUnitPrice;
	private double previousEstateFee;
	public int getHouseNum() {
		return houseNum;
	}
	public void setHouseNum(int houseNum) {
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
		return "FreeProperty [houseNum=" + houseNum + ", houseTypeName=" + houseTypeName + ", area=" + area
				+ ", previousEstateUnitPrice=" + previousEstateUnitPrice + ", previousEstateFee=" + previousEstateFee
				+ "]";
	}
}