package com.ywqf.entity;

import java.math.BigDecimal;

public class EstatePay {
    private String chargeWorkerName;
    private String operateName;
    private String communityName;
    private int id;
    private int estatePayNum;//缴费单号
    private int corpId;//物业ID
    private int communityId;//小区ID
    private int houseId;//房间ID
    private String houseNum;//门牌号
    private String ownerName;//业主姓名
    private String area;//面积
    private String estateUnitPrice;//标准单价
    private int payMonth;//缴纳月数
    private String payDate;//缴费时间
    private String paymentAmount;//缴费金额
    private String serviceStartDate;//服务开始日期
    private String serviceEndDate;//服务结束日期
    private int chargeWorkerId;//收费员工ID
    private int status;//状态
    private String operator;//操作人
    private String operateTime;//最后操作时间
    private String operateIp;//最后操作IP
    private String ownerTel; //联系电话
    private String ownerStandbyTel;//备用联系电话
    private String previousEstateFee;//物业费合计（单位：元）

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

    public String getPreviousEstateFee() {
        return previousEstateFee;
    }

    public void setPreviousEstateFee(String previousEstateFee) {
        this.previousEstateFee = previousEstateFee;
    }

    public String getChargeWorkerName() {
        return chargeWorkerName;
    }

    public void setChargeWorkerName(String chargeWorkerName) {
        this.chargeWorkerName = chargeWorkerName;
    }

    public String getOperateName() {
        return operateName;
    }

    public void setOperateName(String operateName) {
        this.operateName = operateName;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstatePayNum() {
        return estatePayNum;
    }

    public void setEstatePayNum(int estatePayNum) {
        this.estatePayNum = estatePayNum;
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


    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }


	public String getEstateUnitPrice() {
        return estateUnitPrice;
    }

    public void setEstateUnitPrice(String estateUnitPrice) {
        this.estateUnitPrice = estateUnitPrice;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public int getPayMonth() {
        return payMonth;
    }

    public void setPayMonth(int payMonth) {
        this.payMonth = payMonth;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
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


    @Override
    public String toString() {
        return "EstatePay{" +
                "chargeWorkerName='" + chargeWorkerName + '\'' +
                ", operateName='" + operateName + '\'' +
                ", communityName='" + communityName + '\'' +
                ", id=" + id +
                ", estatePayNum=" + estatePayNum +
                ", corpId=" + corpId +
                ", communityId=" + communityId +
                ", houseId=" + houseId +
                ", houseNum='" + houseNum + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", area='" + area + '\'' +
                ", estateUnitPrice='" + estateUnitPrice + '\'' +
                ", payMonth=" + payMonth +
                ", payDate='" + payDate + '\'' +
                ", paymentAmount='" + paymentAmount + '\'' +
                ", serviceStartDate='" + serviceStartDate + '\'' +
                ", serviceEndDate='" + serviceEndDate + '\'' +
                ", chargeWorkerId=" + chargeWorkerId +
                ", status=" + status +
                ", operator='" + operator + '\'' +
                ", operateTime='" + operateTime + '\'' +
                ", operateIp='" + operateIp + '\'' +
                ", ownerTel='" + ownerTel + '\'' +
                ", ownerStandbyTel='" + ownerStandbyTel + '\'' +
                ", previousEstateFee='" + previousEstateFee + '\'' +
                '}';
    }

}
