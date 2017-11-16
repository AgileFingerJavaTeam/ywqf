package com.ywqf.entity;

public class PropertyCompany {
	private int corpId;//物业公司ID
	private String corpName;//物业公司名称
	private int type;//类型

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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "PropertyCompany{" +
				"corpId=" + corpId +
				", corpName='" + corpName + '\'' +
				", type=" + type +
				'}';
	}
}
