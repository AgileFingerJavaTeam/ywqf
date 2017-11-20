package com.ywqf.enums;

public enum CorpAndCommunityEnum {
	SUCCESS (1), 
    FAIL(2); 
	private int code;
	CorpAndCommunityEnum(int code) {
        this.code = code;
    }
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	@Override
    public String toString() {
        return "ParkingEnum{" +
                "code=" + code +
                '}';
    }

}

