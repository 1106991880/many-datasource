package com.yang.utils.jsonString;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: yang
 * @Date: 2020-06-14 00:03
 * @Description: 返回json字符串类型的数据
 */
public class JsonStringUtils {


    public static String JsonData(boolean result, String desc, Object data) {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("result", result);
        jsonObject.put("desc", desc);
        jsonObject.put("data", data);

        String jsonString = jsonObject.toJSONString();

        return jsonString;
    }

}
