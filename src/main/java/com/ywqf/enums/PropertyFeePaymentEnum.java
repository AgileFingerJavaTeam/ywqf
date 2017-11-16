package com.ywqf.enums;

public enum PropertyFeePaymentEnum {

	    SUCCESS (1000),
	    FAIL(1001),
	    ERROR(9999);
	    
	    private int code;

	    PropertyFeePaymentEnum(int code) {
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
	        return "PropertyFeePaymentEnum{" +
	                "code=" + code +
	                '}';
	    }
	
}
