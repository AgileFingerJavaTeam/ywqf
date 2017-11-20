<<<<<<< HEAD
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
=======
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
>>>>>>> 9c99b64c33e4de793abd5f59e1d05f6f926718dd
