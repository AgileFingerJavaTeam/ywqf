package com.ywqf.dto.in;

public class HeatingDto {

	private int checked;
	private int timeYear;
	private int selectCompanyID;
	private int selectcommunityID;
	
	public int getSelectcommunityID() {
		return selectcommunityID;
	}

	public void setSelectcommunityID(int selectcommunityID) {
		this.selectcommunityID = selectcommunityID;
	}

	public int getSelectCompanyID() {
		return selectCompanyID;
	}

	public void setSelectCompanyID(int selectCompanyID) {
		this.selectCompanyID = selectCompanyID;
	}

	public int getChecked() {
		return checked;
	}

	public void setChecked(int checked) {
		this.checked = checked;
	}

	public int getTimeYear() {
		return timeYear;
	}

	public void setTimeYear(int timeYear) {
		this.timeYear = timeYear;
	}

	
	
	
}
