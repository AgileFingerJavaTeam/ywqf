package com.ywqf.entity;

public class Type {
    private int type;//类型（1总部 0物业公司）

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Type{" +
                "type=" + type +
                '}';
    }
}
