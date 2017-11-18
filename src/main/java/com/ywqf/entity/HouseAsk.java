package com.ywqf.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class HouseAsk {
	private Integer id;
	private String houseNeedRentNum;
	private String releaseTime;
	private Integer type;
	private String houseTypeName;
	private String houseDirectionTypeName;
	private Integer floor;
	private double minPrice;
	private double maxPrice;
	private String houseFitmentTypeName;
	private double minArea;
	private double maxArea;
	private String	remark;
	private String customerName;
	private String phone;
	private String houseAreaTypeName;
	private String housePriceRangeName;
	private int housePriceRangeId;
	private int houseFitmentTypeId;
	private int houseDirectionTypeId;
	private int houseTypeId;
	private String rent;
	private String buy;
	private int  rentId;
	private int buyId;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHouseNeedRentNum() {
		return houseNeedRentNum;
	}

	public void setHouseNeedRentNum(String houseNeedRentNum) {
		this.houseNeedRentNum = houseNeedRentNum;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getHouseTypeName() {
		return houseTypeName;
	}

	public void setHouseTypeName(String houseTypeName) {
		this.houseTypeName = houseTypeName;
	}

	public String getHouseDirectionTypeName() {
		return houseDirectionTypeName;
	}

	public void setHouseDirectionTypeName(String houseDirectionTypeName) {
		this.houseDirectionTypeName = houseDirectionTypeName;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getHouseFitmentTypeName() {
		return houseFitmentTypeName;
	}

	public void setHouseFitmentTypeName(String houseFitmentTypeName) {
		this.houseFitmentTypeName = houseFitmentTypeName;
	}

	public double getMinArea() {
		return minArea;
	}

	public void setMinArea(double minArea) {
		this.minArea = minArea;
	}

	public double getMaxArea() {
		return maxArea;
	}

	public void setMaxArea(double maxArea) {
		this.maxArea = maxArea;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHouseAreaTypeName() {
		return houseAreaTypeName;
	}

	public void setHouseAreaTypeName(String houseAreaTypeName) {
		this.houseAreaTypeName = houseAreaTypeName;
	}

	public String getHousePriceRangeName() {
		return housePriceRangeName;
	}

	public void setHousePriceRangeName(String housePriceRangeName) {
		this.housePriceRangeName = housePriceRangeName;
	}

	public int getHousePriceRangeId() {
		return housePriceRangeId;
	}

	public void setHousePriceRangeId(int housePriceRangeId) {
		this.housePriceRangeId = housePriceRangeId;
	}

	public int getHouseFitmentTypeId() {
		return houseFitmentTypeId;
	}

	public void setHouseFitmentTypeId(int houseFitmentTypeId) {
		this.houseFitmentTypeId = houseFitmentTypeId;
	}

	public int getHouseDirectionTypeId() {
		return houseDirectionTypeId;
	}

	public void setHouseDirectionTypeId(int houseDirectionTypeId) {
		this.houseDirectionTypeId = houseDirectionTypeId;
	}

	public int getHouseTypeId() {
		return houseTypeId;
	}

	public void setHouseTypeId(int houseTypeId) {
		this.houseTypeId = houseTypeId;
	}

	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
		this.rent = rent;
	}

	public String getBuy() {
		return buy;
	}

	public void setBuy(String buy) {
		this.buy = buy;
	}

	public int getRentId() {
		return rentId;
	}

	public void setRentId(int rentId) {
		this.rentId = rentId;
	}

	public int getBuyId() {
		return buyId;
	}

	public void setBuyId(int buyId) {
		this.buyId = buyId;
	}

	@Override
	public String toString() {
		return "HouseAsk{" +
				"id=" + id +
				", houseNeedRentNum='" + houseNeedRentNum + '\'' +
				", releaseTime='" + releaseTime + '\'' +
				", type=" + type +
				", houseTypeName='" + houseTypeName + '\'' +
				", houseDirectionTypeName='" + houseDirectionTypeName + '\'' +
				", floor=" + floor +
				", minPrice=" + minPrice +
				", maxPrice=" + maxPrice +
				", houseFitmentTypeName='" + houseFitmentTypeName + '\'' +
				", minArea=" + minArea +
				", maxArea=" + maxArea +
				", remark='" + remark + '\'' +
				", customerName='" + customerName + '\'' +
				", phone='" + phone + '\'' +
				", houseAreaTypeName='" + houseAreaTypeName + '\'' +
				", housePriceRangeName='" + housePriceRangeName + '\'' +
				", housePriceRangeId=" + housePriceRangeId +
				", houseFitmentTypeId=" + houseFitmentTypeId +
				", houseDirectionTypeId=" + houseDirectionTypeId +
				", houseTypeId=" + houseTypeId +
				", rent='" + rent + '\'' +
				", buy='" + buy + '\'' +
				", rentId=" + rentId +
				", buyId=" + buyId +
				'}';
	}
}
