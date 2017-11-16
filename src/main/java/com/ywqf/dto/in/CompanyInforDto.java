package com.ywqf.dto.in;

public class CompanyInforDto {
	private String aptitude;
	private String regAddress;
	private String description;
	private String serviceTel;
	
	public String getAptitude() {
		return aptitude;
	}
	
	public void setAptitude(String aptitude) {
		this.aptitude = aptitude;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getRegAddress() {
		return regAddress;
	}

	public void setRegAddress(String regAddress) {
		this.regAddress = regAddress;
	}

	public String getServiceTel() {
		return serviceTel;
	}

	public void setServiceTel(String serviceTel) {
		this.serviceTel = serviceTel;
	}

	@Override
	public String toString() {
		return "CompanyInforDto [aptitude=" + aptitude + ", regAddress=" + regAddress + ", description=" + description
				+ ", serviceTel=" + serviceTel + "]";
	}
	

}
