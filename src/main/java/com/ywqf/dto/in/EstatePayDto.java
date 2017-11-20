package com.ywqf.dto.in;

public class EstatePayDto {
    private int corpId;
    private int UserId;
    private String search;
    private String date;
    private int corpsId;
    private int communityId;
    private int page;
    private int rows;
    private String estatePaySearch_content;
    private int checked;
    private String timeYearMonth;
	
	//新加的
    private int selectCompanyID;
	private int selectcommunityID;
	private int isSelect;
	//新加的

	public int getSelectCompanyID() {
		return selectCompanyID;
	}

	public int getIsSelect() {
		return isSelect;
	}

	public void setIsSelect(int isSelect) {
		this.isSelect = isSelect;
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
	
    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public String getTimeYearMonth() {
        return timeYearMonth;
    }

    public void setTimeYearMonth(String timeYearMonth) {
        this.timeYearMonth = timeYearMonth;
    }

    public int getCorpId() {
        return corpId;
    }

    public void setCorpId(int corpId) {
        this.corpId = corpId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCorpsId() {
        return corpsId;
    }

    public void setCorpsId(int corpsId) {
        this.corpsId = corpsId;
    }

    public String getEstatePaySearch_content() {
        return estatePaySearch_content;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public void setEstatePaySearch_content(String estatePaySearch_content) {
        this.estatePaySearch_content = estatePaySearch_content;
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
}
