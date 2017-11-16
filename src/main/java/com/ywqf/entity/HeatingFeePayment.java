package com.ywqf.entity;

public class HeatingFeePayment {
        private int id;
        private int heatingPayNum;//缴费单号
        private int corpId; //物业ID
        private int communityId; //小区ID
        private int houseId; //房间ID
        private String houseNum; //门牌号
        private String ownerName; //业主名称
        private double heatingUnitPrice; //采暖单价
        private double discountHeatingUnitPrice; //优惠后采暖单价
        private double heatingArea; //采暖面积
        private double paymentAmount; //缴费金额
        private int year;  //采暖季年份
        private String serviceStartDate; //服务起始日期
        private String serviceEndDate; //服务截止日期
        private int heatingDiscountTypeId; //优惠政策
        private String paymentDate; //缴费日期
        private int chargeWorkerId; //收费员工id
        private int status; //状态 1：正常 0：作废
        private String operator; //操作人
        private String operateTime; //最后操作时间
        private String operateIp;//最后操作IP
        private String account; //用户姓名
        private double area; //面积
        private String maxInsert;//之后值+1

        private String discountStartDate; //优惠起始日
        private String discountEndDate;//优惠结束日
        private double rate; //优惠比例

    public String getDiscountStartDate() {
        return discountStartDate;
    }

    public void setDiscountStartDate(String discountStartDate) {
        this.discountStartDate = discountStartDate;
    }

    public String getDiscountEndDate() {
        return discountEndDate;
    }

    public void setDiscountEndDate(String discountEndDate) {
        this.discountEndDate = discountEndDate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getMaxInsert() {
        return maxInsert;
    }

    public void setMaxInsert(String maxInsert) {
        this.maxInsert = maxInsert;
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

    public double getHeatingUnitPrice() {
        return heatingUnitPrice;
    }

    public void setHeatingUnitPrice(double heatingUnitPrice) {
        this.heatingUnitPrice = heatingUnitPrice;
    }

    public double getDiscountHeatingUnitPrice() {
        return discountHeatingUnitPrice;
    }

    public void setDiscountHeatingUnitPrice(double discountHeatingUnitPrice) {
        this.discountHeatingUnitPrice = discountHeatingUnitPrice;
    }

    public double getHeatingArea() {
        return heatingArea;
    }

    public void setHeatingArea(double heatingArea) {
        this.heatingArea = heatingArea;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "HeatingFeePayment{" +
                "id=" + id +
                ", heatingPayNum=" + heatingPayNum +
                ", corpId=" + corpId +
                ", communityId=" + communityId +
                ", houseId=" + houseId +
                ", houseNum='" + houseNum + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", heatingUnitPrice=" + heatingUnitPrice +
                ", discountHeatingUnitPrice=" + discountHeatingUnitPrice +
                ", heatingArea=" + heatingArea +
                ", paymentAmount=" + paymentAmount +
                ", year=" + year +
                ", serviceStartDate='" + serviceStartDate + '\'' +
                ", serviceEndDate='" + serviceEndDate + '\'' +
                ", heatingDiscountTypeId=" + heatingDiscountTypeId +
                ", paymentDate='" + paymentDate + '\'' +
                ", chargeWorkerId=" + chargeWorkerId +
                ", status=" + status +
                ", operator='" + operator + '\'' +
                ", operateTime='" + operateTime + '\'' +
                ", operateIp='" + operateIp + '\'' +
                ", account='" + account + '\'' +
                ", area=" + area +
                ", maxInsert='" + maxInsert + '\'' +
                ", discountStartDate='" + discountStartDate + '\'' +
                ", discountEndDate='" + discountEndDate + '\'' +
                ", rate=" + rate +
                '}';
    }
}
