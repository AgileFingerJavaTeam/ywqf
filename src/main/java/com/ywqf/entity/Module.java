package com.ywqf.entity;

import java.util.List;

public class Module {
    private int moduleId;//权限模块id
    private String moduleName;//名称
    private int parentId;//父级id
    private String level;//层级
    private int status;//状态
    private int seq;//顺序，由小到大
    private List<Acl> Acls;//子级

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

    public List<Acl> getAcls() {
        return Acls;
    }

    public void setAcls(List<Acl> acls) {
        Acls = acls;
    }

    @Override
    public String toString() {
        return "Module{" +
                "moduleId=" + moduleId +
                ", moduleName='" + moduleName + '\'' +
                ", parentId=" + parentId +
                ", level='" + level + '\'' +
                ", status=" + status +
                ", seq=" + seq +
                ", Acls=" + Acls +
                '}';
    }
}
