package com.ywqf.entity;

public class Session {
    private int corpId;//所属物业公司id
    private String corpName;//公司名称
    private String aptitude;//资质
    private String regAddress;//注册地址
    private String description;//公司简介
    private String serviceTel;//服务电话
    private int type;//公司类型
    private int status;//状态

    public int getCorpId() {
        return corpId;
    }

    public void setCorpId(int corpId) {
        this.corpId = corpId;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public String getAptitude() {
        return aptitude;
    }

    public void setAptitude(String aptitude) {
        this.aptitude = aptitude;
    }

    public String getRegAddress() {
        return regAddress;
    }

    public void setRegAddress(String regAddress) {
        this.regAddress = regAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getServiceTel() {
        return serviceTel;
    }

    public void setServiceTel(String serviceTel) {
        this.serviceTel = serviceTel;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Session{" +
                "corpId=" + corpId +
                ", corpName='" + corpName + '\'' +
                ", aptitude='" + aptitude + '\'' +
                ", regAddress='" + regAddress + '\'' +
                ", description='" + description + '\'' +
                ", serviceTel='" + serviceTel + '\'' +
                ", type=" + type +
                ", status=" + status +
                '}';
    }
}
