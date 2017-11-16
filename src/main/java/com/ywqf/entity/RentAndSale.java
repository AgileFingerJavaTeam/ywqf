package com.ywqf.entity;

public class RentAndSale {
	private Integer id;
	private String estateSellRentNum;
	private String releaseTime;
	private Integer type;
	private String houseNum;
	private String houseTypeName;
	private String houseDirectionTypeName;
	private double area;
	private String houseFitmentTypeName;
	private double salePrice;
	private double rentPrice;
	private String url;
	private String ownerName;
	private String ownerTel;
	private  String building;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstateSellRentNum() {
		return estateSellRentNum;
	}

	public void setEstateSellRentNum(String estateSellRentNum) {
		this.estateSellRentNum = estateSellRentNum;
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

	public String getHouseDirectionTypeName() {
		return houseDirectionTypeName;
	}

	public void setHouseDirectionTypeName(String houseDirectionTypeName) {
		this.houseDirectionTypeName = houseDirectionTypeName;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public String getHouseFitmentTypeName() {
		return houseFitmentTypeName;
	}

	public void setHouseFitmentTypeName(String houseFitmentTypeName) {
		this.houseFitmentTypeName = houseFitmentTypeName;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	@Override
	public String toString() {
		return "RentAndSale{" +
				"id=" + id +
				", estateSellRentNum='" + estateSellRentNum + '\'' +
				", releaseTime='" + releaseTime + '\'' +
				", type=" + type +
				", houseNum='" + houseNum + '\'' +
				", houseTypeName='" + houseTypeName + '\'' +
				", houseDirectionTypeName='" + houseDirectionTypeName + '\'' +
				", area=" + area +
				", houseFitmentTypeName='" + houseFitmentTypeName + '\'' +
				", salePrice=" + salePrice +
				", rentPrice=" + rentPrice +
				", url='" + url + '\'' +
				", ownerName='" + ownerName + '\'' +
				", ownerTel='" + ownerTel + '\'' +
				", building='" + building + '\'' +
				'}';
	}
}
