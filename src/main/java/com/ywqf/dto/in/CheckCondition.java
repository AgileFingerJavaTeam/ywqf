package com.ywqf.dto.in;

public class CheckCondition {
	private Integer corp;
	private Integer community;
	private String likes;
	private double money;
	public Integer getCorp() {
		return corp;
	}
	public void setCorp(Integer corp) {
		this.corp = corp;
	}
	public Integer getCommunity() {
		return community;
	}
	public void setCommunity(Integer community) {
		this.community = community;
	}
	public String getLikes() {
		return likes;
	}
	public void setLikes(String likes) {
		this.likes = likes;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "CheckCondition [corp=" + corp + ", community=" + community + ", likes=" + likes + ", money=" + money
				+ "]";
	}
}
