package com.ywqf.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ParkingPay {
    private String parkingUnitPrice;
    private String carOwnerName;
    private String chargeWorkerName;
    private int id;
    private int parkingPayNum;
    private int corpId;
    private int communityId;
    private int houseId;
    private int parkingSpaceId;
    private int payMonth;
    private String serviceStartDate;
    private String serviceEndDate;
    private int chargeWorkerId;
    private String payDate;
    private String paymentAmount;
    private int status;
    private String operator;
    private String operateTime;
    private String operateIp;

    private int parkingNum;//车位编号
    private String licensePlateNumber;//车牌号
    private String houseNum;//门牌号
    private String ownerName;//业主姓名
    private int gender;//性别
    private String carOwnerTel;//车主联系电话
    private String carOwnerStandbyTel;//车主备用联系电话

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

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getParkingUnitPrice() {
        return parkingUnitPrice;
    }

    public void setParkingUnitPrice(String parkingUnitPrice) {
        this.parkingUnitPrice = parkingUnitPrice;
    }

    public String getCarOwnerName() {
        return carOwnerName;
    }

    public void setCarOwnerName(String carOwnerName) {
        this.carOwnerName = carOwnerName;
    }

    public String getChargeWorkerName() {
        return chargeWorkerName;
    }

    public void setChargeWorkerName(String chargeWorkerName) {
        this.chargeWorkerName = chargeWorkerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParkingPayNum() {
        return parkingPayNum;
    }

    public void setParkingPayNum(int parkingPayNum) {
        this.parkingPayNum = parkingPayNum;
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

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

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

    public int getPayMonth() {
        return payMonth;
    }

    public void setPayMonth(int payMonth) {
        this.payMonth = payMonth;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getServiceStartDate() {
        return serviceStartDate;
    }

    public void setServiceStartDate(String serviceStartDate) {
        this.serviceStartDate = serviceStartDate;
    }

    public String getServiceEndDate() {
        return serviceEndDate;
    }

    public void setServiceEndDate(String serviceEndDate) {
        this.serviceEndDate = serviceEndDate;
    }

    public int getChargeWorkerId() {
        return chargeWorkerId;
    }

    public void setChargeWorkerId(int chargeWorkerId) {
        this.chargeWorkerId = chargeWorkerId;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperateIp() {
        return operateIp;
    }

    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp;
    }
}