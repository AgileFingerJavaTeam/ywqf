package com.ywqf.entity;

import java.math.BigDecimal;

public class HeatingPrefeTreat {
    private int heatingDiscountTypeId;//优惠政策编号
    private String discountStartDate;//优惠起始日期
    private String discountEndDate;//优惠结束日期
    private double rate;//优惠比例

    public int getHeatingDiscountTypeId() {
        return heatingDiscountTypeId;
    }

    public void setHeatingDiscountTypeId(int heatingDiscountTypeId) {
        this.heatingDiscountTypeId = heatingDiscountTypeId;
    }

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

    @Override
    public String toString() {
        return "HeatingPrefeTreat{" +
                "heatingDiscountTypeId=" + heatingDiscountTypeId +
                ", discountStartDate='" + discountStartDate + '\'' +
                ", discountEndDate='" + discountEndDate + '\'' +
                ", rate=" + rate +
                '}';
    }
}
