package com.ywqf.common;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunzhongyuan on 2017/10/20.
 */
@Getter
@Setter
public class JsonData {

    private boolean success;

    private String msg;

    private Object data;

    public JsonData(boolean success) {
        this.success = success;
    }

    public static JsonData success(Object object, String msg) {
        JsonData jsonData = new JsonData(true);
        jsonData.data = object;
        jsonData.msg = msg;
        return jsonData;
    }

    public static JsonData success(Object object) {
        JsonData jsonData = new JsonData(true);
        jsonData.data = object;
        return jsonData;
    }

    public static JsonData success() {
        return new JsonData(true);
    }

    public static JsonData fail(String msg) {
        JsonData jsonData = new JsonData(false);
        jsonData.msg = msg;
        return jsonData;
    }

    public Map<String,Object> toMap() {
        HashMap<String,Object> ret = new HashMap<String, Object>();
        ret.put("success",success);
        ret.put("msg",msg);
        ret.put("data",data);
        return ret;
    }

}