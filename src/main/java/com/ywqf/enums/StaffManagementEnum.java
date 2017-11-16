package com.ywqf.enums;

/**
 * Created by Administrator on 2017/11/14 0014.
 */
public enum  StaffManagementEnum {
    SUCCESS (1000), //成功�
    FAIL(1001), //失败
    ERROR(9999); //内部错误��

    private int code;

    StaffManagementEnum(int code) {
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
        return "StaffManagementEnum{" +
                "code=" + code +
                '}';
    }
}
