package com.ywqf.dto.in;


import javax.validation.constraints.NotNull;

/**
 * Created by Administrator on 2017/10/14 0014.
 */
public class AuthRoleDto {
    @NotNull
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AuthRoleDto{" +
                "id=" + id +
                '}';
    }
}
