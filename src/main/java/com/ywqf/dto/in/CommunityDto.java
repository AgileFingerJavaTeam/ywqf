package com.ywqf.dto.in;

public class CommunityDto {
	//userid: "1000", type: "1", corpid: ""}
	private Integer corpid;
	private Integer userid;
	private Integer type;
	public Integer getCorpid() {
		return corpid;
	}
	public void setCorpid(Integer corpid) {
		this.corpid = corpid;
	}
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
	@Override
	public String toString() {
		return "CommunityDto [corpid=" + corpid + ", userid=" + userid + ", type=" + type + "]";
	}
	
}
