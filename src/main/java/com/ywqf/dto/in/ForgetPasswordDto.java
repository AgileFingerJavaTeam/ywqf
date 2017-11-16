package com.ywqf.dto.in;

public class ForgetPasswordDto {
    private String corp_name;//物业公司名称
    private String account;//员工编号
    private String real_name;//真实姓名
    private String phone;//手机号
    private int page;
    private int rows;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getCorp_name() {
        return corp_name;
    }

    public void setCorp_name(String corp_name) {
        this.corp_name = corp_name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ForgetPasswordDto{" +
                "corp_name='" + corp_name + '\'' +
                ", account='" + account + '\'' +
                ", real_name='" + real_name + '\'' +
                ", phone='" + phone + '\'' +
                ", page=" + page +
                ", rows=" + rows +
                '}';
    }
}
