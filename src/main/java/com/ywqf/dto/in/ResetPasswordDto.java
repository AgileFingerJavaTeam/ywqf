package com.ywqf.dto.in;

public class ResetPasswordDto {
    private String checkBoxType;
    private String phone;
    private String searchResetApplyInfo;

    public String getCheckBoxType() {
        return checkBoxType;
    }

    public void setCheckBoxType(String checkBoxType) {
        this.checkBoxType = checkBoxType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSearchResetApplyInfo() {
        return searchResetApplyInfo;
    }

    public void setSearchResetApplyInfo(String searchResetApplyInfo) {
        this.searchResetApplyInfo = searchResetApplyInfo;
    }
}
