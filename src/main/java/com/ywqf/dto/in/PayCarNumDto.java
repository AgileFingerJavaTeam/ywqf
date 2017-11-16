package com.ywqf.dto.in;

public class PayCarNumDto {
	private Integer userid;
	private Integer type;
	private String community;
	private String corps;
	private Integer year;//year
	private Integer timeStart;
	private Integer timeEnd;
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
	public String getCommunity() {
		return community;
	}
	public void setCommunity(String community) {
		this.community = community;
	}
	public String getCorps() {
		return corps;
	}
	public void setCorps(String corps) {
		this.corps = corps;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(Integer timeStart) {
		this.timeStart = timeStart;
	}
	public Integer getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(Integer timeEnd) {
		this.timeEnd = timeEnd;
	}
	@Override
	public String toString() {
		return "PayYearNumDto [userid=" + userid + ", type=" + type + ", community=" + community + ", corps=" + corps
				+ ", year=" + year + ", timeStart=" + timeStart + ", timeEnd=" + timeEnd + "]";
	}
}
