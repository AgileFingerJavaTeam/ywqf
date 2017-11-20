package com.ywqf.entity;

public class Acl{
    private int aclId;//权限id
    private String code;//权限码
    private String aclName;//名称
    private int aclModuleId;//所属权限模块id
    private String url;//路径
    private int type;//权限类型
    private int status;//状态
    private int seq;//当前模块下的顺序，由小到大

    public int getAclId() {
        return aclId;
    }

    public void setAclId(int aclId) {
        this.aclId = aclId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAclName() {
        return aclName;
    }

    public void setAclName(String aclName) {
        this.aclName = aclName;
    }

    public int getAclModuleId() {
        return aclModuleId;
    }

    public void setAclModuleId(int aclModuleId) {
        this.aclModuleId = aclModuleId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return "Acl{" +
                "aclId=" + aclId +
                ", code='" + code + '\'' +
                ", aclName='" + aclName + '\'' +
                ", aclModuleId=" + aclModuleId +
                ", url='" + url + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", seq=" + seq +
                '}';
    }
}
