package com.ywqf.entity;

public class Corp {
	private String corpId;
	private String corpName;

	@Override
	public String toString() {
		return "Corp{" +
				"corpId='" + corpId + '\'' +
				", corpName='" + corpName + '\'' +
				'}';
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
}
