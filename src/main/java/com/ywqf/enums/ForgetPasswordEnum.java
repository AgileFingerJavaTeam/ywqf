package com.ywqf.enums;

public enum ForgetPasswordEnum {
    APPLY_SUCCSEE(7000),//申请重置密码成功
    APPLY_FAIL(-7001);//申请重置密码失败
    private int code;

    ForgetPasswordEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
