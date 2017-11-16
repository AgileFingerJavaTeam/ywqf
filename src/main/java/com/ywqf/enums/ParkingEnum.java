package com.ywqf.enums;

public enum ParkingEnum {
	
	SUCCESS (1), 
    FAIL(2); 
	private int code;
	ParkingEnum(int code) {
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
