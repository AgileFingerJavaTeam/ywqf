package com.ywqf.dto.in;

public class HeatingFeePaymentDto {
   
	private int id;
	private String Rname;

	private String house_num;
	private int community_id;

	private String at_search;
	private int page;
	private int rows;

	public int getCommunity_id() {
		return community_id;
	}

	public void setCommunity_id(int community_id) {
		this.community_id = community_id;
	}

	public String getHouse_num() {
		return house_num;
	}

	public void setHouse_num(String house_num) {
		this.house_num = house_num;
	}

	public String getRname() {
		return Rname;
	}

	public void setRname(String rname) {
		Rname = rname;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAt_search() {
		return at_search;
	}
	public void setAt_search(String at_search) {
		this.at_search = at_search;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "HeatingFeePaymentDto{" +
				"id=" + id +
				", Rname='" + Rname + '\'' +
				", house_num='" + house_num + '\'' +
				", community_id=" + community_id +
				", at_search='" + at_search + '\'' +
				", page=" + page +
				", rows=" + rows +
				'}';
	}
}
