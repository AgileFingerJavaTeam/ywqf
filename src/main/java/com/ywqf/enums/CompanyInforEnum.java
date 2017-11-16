package com.ywqf.enums;

public enum CompanyInforEnum {
	FIND_ERROR(-1), //查询失败
	FIND_SUCCESS(1),//查询成功
	UPDATE_SUCCESS(2),//修改成功
	UPDATE_ERROR(-2),//修改失败
    ADD_SUCCESS(3),//添加成功
    ADD_ERROR(-3);//添加失败
    private int code;

    CompanyInforEnum(int code) {
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
