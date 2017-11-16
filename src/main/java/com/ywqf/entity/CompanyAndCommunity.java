package com.ywqf.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class CompanyAndCommunity {

	private  int  id;
	private  int corpId;
	private  String corpName;
	private  String communityName;
	private  int communityId;
	private   int type;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCorpId() {
		return corpId;
	}

	public void setCorpId(int corpId) {
		this.corpId = corpId;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}

	@Override
	public String toString() {
		return "CompanyAndCommunity{" +
				"id=" + id +
				", corpId=" + corpId +
				", corpName='" + corpName + '\'' +
				", communityName='" + communityName + '\'' +
				", communityId=" + communityId +
				", type=" + type +
				'}';
	}
}
