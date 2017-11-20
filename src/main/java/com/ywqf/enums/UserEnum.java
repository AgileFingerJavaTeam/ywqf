package com.ywqf.enums;

public enum UserEnum {
	SUCCESS (1), 
    FAIL(2); 
	private int code;
	UserEnum(int code) {
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
        return "UserEnum{" +
                "code=" + code +
                '}';
    }
}
