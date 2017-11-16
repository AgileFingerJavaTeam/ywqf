package com.ywqf.dto.in;

public class PayCostDto {
	private String houseNum;//门牌号
	private int corpId;//物业公司ID
	private int communityId;//小区ID
	private int year;//年
	
	public String getHouseNum() {
		return houseNum;
	}
	
	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}
	
	public int getCorpId() {
		return corpId;
	}
	
	public void setCorpId(int corpId) {
		this.corpId = corpId;
	}
	
	public int getCommunityId() {
		return communityId;
	}
	
	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "PayCostDto{" +
				"houseNum='" + houseNum + '\'' +
				", corpId=" + corpId +
				", communityId=" + communityId +
				", year=" + year +
				'}';
	}
}
