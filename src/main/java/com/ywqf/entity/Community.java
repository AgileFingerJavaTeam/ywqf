package com.ywqf.entity;

public class Community {
	private String communityId;
	private String communityName;
	public String getCommunityId() {
		return communityId;
	}
	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}
	public String getCommunityName() {
		return communityName;
	}
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	@Override
	public String toString() {
		return "Community [communityId=" + communityId + ", communityName=" + communityName + "]";
	}
	
}
