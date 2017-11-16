package com.ywqf.entity;

public class PayCarNum {
	private String communityName;
	private double rate;
	private int payNum;
	private int noPayNum;
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public int getPayNum() {
		return payNum;
	}
	public void setPayNum(int payNum) {
		this.payNum = payNum;
	}
	public int getNoPayNum() {
		return noPayNum;
	}
	public void setNoPayNum(int noPayNum) {
		this.noPayNum = noPayNum;
	}
	@Override
	public String toString() {
		return "PayCarNum [communityName=" + communityName + ", rate=" + rate + ", payNum=" + payNum + ", noPayNum="
				+ noPayNum + "]";
	}
}
