package com.ywqf.dto.in;

public class FreePropertyDto {
	private Integer corp;
	private Integer community;
	private String like;
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
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	@Override
	public String toString() {
		return "FreePropertyDto [corp=" + corp + ", community=" + community + ", like=" + like + "]";
	}
}
