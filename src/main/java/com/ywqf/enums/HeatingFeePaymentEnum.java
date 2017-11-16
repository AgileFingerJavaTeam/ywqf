package com.ywqf.enums;

public enum HeatingFeePaymentEnum {
	SUCCESS (1000),
    FAIL(1001),
    ERROR(9999);
    
    private int code;

    HeatingFeePaymentEnum(int code) {
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
        return "HeatingFeePaymentEnum{" +
                "code=" + code +
                '}';
    }

}
