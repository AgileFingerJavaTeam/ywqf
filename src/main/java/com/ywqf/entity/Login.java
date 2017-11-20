package com.ywqf.entity;

public class Login {
    private int userId;//用户id
    private String telephone;//账号
    private String password;//密码
    private int corpId;//所属物业公司id

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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
                "userId=" + userId +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", corpId=" + corpId +
                '}';
    }
}
