package com.ywqf.entity;

/**
 * Created by Administrator on 2017/11/15 0015.
 */
public class StaffManagement {
    private int userId;
    private int corpId;
    private String name;
    private String telephone;
    private String password;
    private String avater;
    private int status;
    private String operator;
    private String operateTime;
    private String operateIp;

    private int communityId;
    private int deptId;
    private int roleId;
    private String roleName;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCorpId() {
        return corpId;
    }

    public void setCorpId(int corpId) {
        this.corpId = corpId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAvater() {
        return avater;
    }

    public void setAvater(String avater) {
        this.avater = avater;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperateIp() {
        return operateIp;
    }

    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "StaffManagement{" +
                "userId=" + userId +
                ", corpId=" + corpId +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", avater='" + avater + '\'' +
                ", status=" + status +
                ", operator='" + operator + '\'' +
                ", operateTime='" + operateTime + '\'' +
                ", operateIp='" + operateIp + '\'' +
                ", communityId=" + communityId +
                ", deptId=" + deptId +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", type=" + type +
                '}';
    }
}
