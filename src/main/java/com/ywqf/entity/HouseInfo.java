package com.ywqf.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class HouseInfo {
	private int id;
	private int communityId;
	private String building;
	private String unit;
	private String floor;
	private String roomNum;
	private String houseNum;
	private Integer houseTypeId;
	private String communityName;
	private String houseTypeName;
	private BigDecimal area;
	private BigDecimal previousEstateUnitPrice;
	private BigDecimal previousEstateFee;
	private BigDecimal nowEstateUnitPrice;
	private BigDecimal nowEstateFee;
	private String ownerName;
	private String ownerTel;
	private String ownerStandbyTel;
	private Integer familySize;
	private Integer status;
	private String operator;
	private Timestamp operateTime;
	private String operateIp;
	private String corpName;
	private int corpId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCommunityId() {
		return communityId;
	}
	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public String getHouseNum() {
		return houseNum;
	}
	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}
	public Integer getHouseTypeId() {
		return houseTypeId;
	}
	public void setHouseTypeId(Integer houseTypeId) {
		this.houseTypeId = houseTypeId;
	}

	
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public String getHouseTypeName() {
		return houseTypeName;
	}
	public void setHouseTypeName(String houseTypeName) {
		this.houseTypeName = houseTypeName;
	}
	public BigDecimal getArea() {
		return area;
	}
	public void setArea(BigDecimal area) {
		this.area = area;
	}
	public BigDecimal getPreviousEstateUnitPrice() {
		return previousEstateUnitPrice;
	}
	public void setPreviousEstateUnitPrice(BigDecimal previousEstateUnitPrice) {
		this.previousEstateUnitPrice = previousEstateUnitPrice;
	}
	public BigDecimal getPreviousEstateFee() {
		return previousEstateFee;
	}
	public void setPreviousEstateFee(BigDecimal previousEstateFee) {
		this.previousEstateFee = previousEstateFee;
	}
	public BigDecimal getNowEstateUnitPrice() {
		return nowEstateUnitPrice;
	}
	public void setNowEstateUnitPrice(BigDecimal nowEstateUnitPrice) {
		this.nowEstateUnitPrice = nowEstateUnitPrice;
	}
	public BigDecimal getNowEstateFee() {
		return nowEstateFee;
	}
	public void setNowEstateFee(BigDecimal nowEstateFee) {
		this.nowEstateFee = nowEstateFee;
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
	public Integer getFamilySize() {
		return familySize;
	}
	public void setFamilySize(Integer familySize) {
		this.familySize = familySize;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Timestamp getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(Timestamp operateTime) {
		this.operateTime = operateTime;
	}
	public String getOperateIp() {
		return operateIp;
	}
	public void setOperateIp(String operateIp) {
		this.operateIp = operateIp;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public int getCorpId() {
		return corpId;
	}

	public void setCorpId(int corpId) {
		this.corpId = corpId;
	}

	@Override
	public String toString() {
		return "HouseInfo{" +
				"id=" + id +
				", communityId=" + communityId +
				", building='" + building + '\'' +
				", unit='" + unit + '\'' +
				", floor='" + floor + '\'' +
				", roomNum='" + roomNum + '\'' +
				", houseNum='" + houseNum + '\'' +
				", houseTypeId=" + houseTypeId +
				", communityName='" + communityName + '\'' +
				", houseTypeName='" + houseTypeName + '\'' +
				", area=" + area +
				", previousEstateUnitPrice=" + previousEstateUnitPrice +
				", previousEstateFee=" + previousEstateFee +
				", nowEstateUnitPrice=" + nowEstateUnitPrice +
				", nowEstateFee=" + nowEstateFee +
				", ownerName='" + ownerName + '\'' +
				", ownerTel='" + ownerTel + '\'' +
				", ownerStandbyTel='" + ownerStandbyTel + '\'' +
				", familySize=" + familySize +
				", status=" + status +
				", operator='" + operator + '\'' +
				", operateTime=" + operateTime +
				", operateIp='" + operateIp + '\'' +
				", corpName='" + corpName + '\'' +
				", corpId=" + corpId +
				'}';
	}


}
