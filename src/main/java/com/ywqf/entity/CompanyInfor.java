package com.ywqf.entity;

public class CompanyInfor {
	private String corpName;//公司名称
	private String aptitude;//资质
	private String regAddress;//注册地址
	private String description;//公司简介
	private String serviceTel;//服务电话
	
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
	
	@Override
	public String toString() {
		return "CompanyInfor [corpName=" + corpName + ", aptitude=" + aptitude + ", regAddress=" + regAddress
				+ ", description=" + description + ", serviceTel=" + serviceTel + "]";
	}
	
}
