package com.ywqf.enums;

public enum ResetPasswordEnum {
    RESET_SUCCESS(6002),
    RESET_FAIL(-6002),
    FIND_SUCCESS(6001),
    FIND_FAIL(-6000);
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    ResetPasswordEnum(int code) {

        this.code = code;
    }
}
