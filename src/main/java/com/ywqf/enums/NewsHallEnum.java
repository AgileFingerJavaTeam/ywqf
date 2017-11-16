package com.ywqf.enums;

public enum NewsHallEnum {
    FIND_SUCCESS(8000),//查询成功
    FIND_FAIL(-8000);//查询失败
    private int code;

    NewsHallEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
