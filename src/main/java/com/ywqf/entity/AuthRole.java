package com.ywqf.entity;

/**
 * Created by Administrator on 2017/10/14 0014.
 */
public class AuthRole {
    private int id;
    private String name;
    private String title;
    private String condition;
    private int type;
    private int status;
    private int pid;
    private int openType;
    private String iconCls;
    private String state;
    private String url;
    private int sort;
    private int level;
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
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

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getOpenType() {
        return openType;
    }

    public void setOpenType(int openType) {
        this.openType = openType;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "AuthRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", condition='" + condition + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", pid=" + pid +
                ", openType=" + openType +
                ", iconCls='" + iconCls + '\'' +
                ", state='" + state + '\'' +
                ", url='" + url + '\'' +
                ", sort=" + sort +
                ", level=" + level +
                ", text='" + text + '\'' +
                '}';
    }
}
