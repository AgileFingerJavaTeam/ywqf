package com.ywqf.enums;

public enum PublishEnum {
    ADD_SUCCESS(7721),//新增成功
    ADD_FAIL(-7720),//新增失败
    REMOVE_SUCCESS(7701),//删除成功
    REMOVE_FAIL(-7700),//删除失败
    FIND_SUCCESS(7711),//查询成功
    FIND_FAIL(-7710);//查询失败
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    PublishEnum(int code) {

        this.code = code;
    }
}
