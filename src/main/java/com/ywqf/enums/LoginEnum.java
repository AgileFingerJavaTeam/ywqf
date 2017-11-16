package com.ywqf.enums;

public enum LoginEnum {
    ACCOUNT_ERROR(1),//账号错误
    PASSWORD_ERROR(-1),//密码错误
    FIND_ERROR(-2), //查询失败
    FIND_SUCCESS(2);//查询成功
    private int code;

    LoginEnum(int code) {
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
        return "CompanyInforEnum{" +
                "code=" + code +
                '}';
    }
}
