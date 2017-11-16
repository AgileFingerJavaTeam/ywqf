package com.ywqf.entity;

/**
 * Created by Administrator on 2017/11/9 0009.
 */
public class payMonthType {

     private int id;
     private String payMonthTypeName;
     private int count; //月数
     private int status; //状态
     private String operator; //操作人
     private String operateTime; //操作时间
     private String operateIp;//最后操作IP



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPayMonthTypeName() {
        return payMonthTypeName;
    }

    public void setPayMonthTypeName(String payMonthTypeName) {
        this.payMonthTypeName = payMonthTypeName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
        return "payMonthType{" +
                "id=" + id +
                ", payMonthTypeName='" + payMonthTypeName + '\'' +
                ", count=" + count +
                ", status=" + status +
                ", operator='" + operator + '\'' +
                ", operateTime='" + operateTime + '\'' +
                ", operateIp='" + operateIp + '\'' +
                '}';
    }
}
