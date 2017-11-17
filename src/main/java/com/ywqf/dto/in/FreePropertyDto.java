package com.ywqf.dto.in;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Indenter;

public class FreePropertyDto {
	private Integer userid;
	private Integer type;
	private Integer corp;
	private Integer community;
	private Integer hourse;
	private Integer door;
	private Integer floor;
	private double money;
	private String like;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
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
	public Integer getHourse() {
		return hourse;
	}
	public void setHourse(Integer hourse) {
		this.hourse = hourse;
	}
	public Integer getDoor() {
		return door;
	}
	public void setDoor(Integer door) {
		this.door = door;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	@Override
	public String toString() {
		return "FreePropertyDto [userid=" + userid + ", type=" + type + ", corp=" + corp + ", community=" + community
				+ ", hourse=" + hourse + ", door=" + door + ", floor=" + floor + ", money=" + money + ", like=" + like
				+ "]";
	}
}
