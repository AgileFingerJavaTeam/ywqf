package com.ywqf.enums;

public enum HeatingPayEnum {
    FIND_SUCCESS(9001),//查询成功
    FIND_FAIL(-9000);//查询失败
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    HeatingPayEnum(int code) {

        this.code = code;
    }
}
