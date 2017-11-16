package com.ywqf.enums;

public enum EstatePayEnum {
    QUERY_SUCCESS(1),
    QUERY_FILED(-1),
    //---苏瑞涛
    FIND_SUCCESS(7109),//查询成功
    FIND_FAIL(-7109),//查询失败
    FIND_COMMUNITY_FAIL(-7102),//查询物业公司失败
    FIND_COMMUNITY_SUCCESS(7102),//查询物业公司成功
    FIND_CORPS_SUCCESS(7101),//查询物业公司成功
    FIND_CORPS_FAIL(-7101),//查询物业公司失败
    FIND_ESTATE_PAY_FAIL(-7100),//查询当日物业费信息失败
    FIND_ESTATE_PAY_SUCCESS(7100);//查询当日物业费信息成功
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    EstatePayEnum(int code) {

        this.code = code;
    }
}
