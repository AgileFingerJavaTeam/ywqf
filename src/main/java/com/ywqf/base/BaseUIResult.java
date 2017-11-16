package com.ywqf.base;

import org.codehaus.jackson.map.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunzhongyuan on 2017/10/16.
 */
public class BaseUIResult {


    public static String returnJson(BaseAPIExcution baseAPIExcution) {
        ObjectMapper mapper = new ObjectMapper();
        String result = "";
        try {
            result=mapper.writeValueAsString(baseAPIExcution.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public static String returnJsonEasyUI(BaseAPIExcution baseAPIExcution) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<String, Object>();
        String result = "";
        Map<String,Object> dataMap;
        if (baseAPIExcution.getData() instanceof Map){
            dataMap = (HashMap<String,Object>)baseAPIExcution.getData();
            try {
                map.put("rows",dataMap.get("rows"));
                map.put("total",dataMap.get("total"));
                result=mapper.writeValueAsString(map);
                System.out.println("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    public static String returnJsonMSG(int status,BaseAPIExcution baseAPIExcution,String info) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<String, Object>();
        String result = "";
        try {
            map.put("status", status);
            map.put("info", info);
            map.put("data", baseAPIExcution.getData());
            result=mapper.writeValueAsString(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
