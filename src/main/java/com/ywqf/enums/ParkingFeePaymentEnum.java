package com.ywqf.enums;

public enum ParkingFeePaymentEnum {

    SUCCESS (1000),
    FAIL(1001),
    ERROR(9999);
    
    private int code;

    ParkingFeePaymentEnum(int code) {
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
        return "ParkingFeePaymentEnum{" +
                "code=" + code +
                '}';
    }

}
