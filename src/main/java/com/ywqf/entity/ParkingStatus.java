package com.ywqf.entity;

public class ParkingStatus {
    private int month;//缴费月份
    private int status;//缴费状态

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ParkingStatus{" +
                "month=" + month +
                ", status=" + status +
                '}';
    }
}
