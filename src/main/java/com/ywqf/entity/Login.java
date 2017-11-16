package com.ywqf.entity;

public class Login {
    private String telephone;//账号
    private String password;//密码
    private int corpId;//所属物业公司id

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCorpId() {
        return corpId;
    }

    public void setCorpId(int corpId) {
        this.corpId = corpId;
    }

    @Override
    public String toString() {
        return "Login{" +
                "telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", corpId=" + corpId +
                '}';
    }
}
