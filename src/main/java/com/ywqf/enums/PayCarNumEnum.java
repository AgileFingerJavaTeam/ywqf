package com.ywqf.enums;

public enum PayCarNumEnum {

	    SUCCESS (1), //成功
	    FAIL(-1), //失败
	    ERROR(9999); //数据库错误
	    
	    private int code;

	    PayCarNumEnum(int code) {
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
