package com.ywqf.entity;

import java.math.BigDecimal;
import java.sql.Date;

public class HeatingPay {
    private String name;
    private String account;
    private String heatingDiscount;//优惠比例
    private String ServiceStartDate;
    private int id;
    private int heatingPayNum;
    private int corpId;
    private int communityId;
    private int houseId;
    private String houseNum;
    private String ownerName;
    private String heatingUnitPrice;
    private String discountHeatingUnitPrice;
    private String heatingArea;
    private String paymentAmount;
    private String year;
    private int heatingDiscountTypeId;
    private String paymentDate;
    private int status;
    private String operator;
    private String operateTime;
    private String operateIp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getHeatingDiscount() {
        return heatingDiscount;
    }

    public void setHeatingDiscount(String heatingDiscount) {
        this.heatingDiscount = heatingDiscount;
    }

    public String getServiceStartDate() {
        return ServiceStartDate;
    }

    public void setServiceStartDate(String serviceStartDate) {
        ServiceStartDate = serviceStartDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeatingPayNum() {
        return heatingPayNum;
    }

    public void setHeatingPayNum(int heatingPayNum) {
        this.heatingPayNum = heatingPayNum;
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

    public String getHeatingUnitPrice() {
        return heatingUnitPrice;
    }

    public void setHeatingUnitPrice(String heatingUnitPrice) {
        this.heatingUnitPrice = heatingUnitPrice;
    }

    public String getDiscountHeatingUnitPrice() {
        return discountHeatingUnitPrice;
    }

    public void setDiscountHeatingUnitPrice(String discountHeatingUnitPrice) {
        this.discountHeatingUnitPrice = discountHeatingUnitPrice;
    }

    public String getHeatingArea() {
        return heatingArea;
    }

    public void setHeatingArea(String heatingArea) {
        this.heatingArea = heatingArea;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getHeatingDiscountTypeId() {
        return heatingDiscountTypeId;
    }

    public void setHeatingDiscountTypeId(int heatingDiscountTypeId) {
        this.heatingDiscountTypeId = heatingDiscountTypeId;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
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
