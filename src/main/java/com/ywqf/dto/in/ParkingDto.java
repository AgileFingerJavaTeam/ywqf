package com.ywqf.dto.in;

public class ParkingDto {
	private String at_marchant_search;
	private int checked;
	private String timeYearMonth;//年月
	private int communityId;//小区id
	private int corpId; //物业ID
	private int selectCompanyID;
	private int selectcommunityID;
	private String search;
	private int isSelect;
	
	public int getIsSelect() {
		return isSelect;
	}
	public void setIsSelect(int isSelect) {
		this.isSelect = isSelect;
	}
	public int getSelectCompanyID() {
		return selectCompanyID;
	}
	public void setSelectCompanyID(int selectCompanyID) {
		this.selectCompanyID = selectCompanyID;
	}
	public int getSelectcommunityID() {
		return selectcommunityID;
	}
	public void setSelectcommunityID(int selectcommunityID) {
		this.selectcommunityID = selectcommunityID;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getCommunityId() {
		return communityId;
	}
	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}
	public int getCorpId() {
		return corpId;
	}
	public void setCorpId(int corpId) {
		this.corpId = corpId;
	}
	public String getTimeYearMonth() {
		return timeYearMonth;
	}
	public void setTimeYearMonth(String timeYearMonth) {
		this.timeYearMonth = timeYearMonth;
	}
	
	public String getAt_marchant_search() {
		return at_marchant_search;
	}
	public void setAt_marchant_search(String at_marchant_search) {
		this.at_marchant_search = at_marchant_search;
	}
	public int getChecked() {
		return checked;
	}
	public void setChecked(int checked) {
		this.checked = checked;
	}
	 
	 
	 
}
