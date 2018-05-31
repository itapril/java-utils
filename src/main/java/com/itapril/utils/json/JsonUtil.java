package com.itapril.utils.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by itapril on 2018/5/31 10:08.
 */
public class JsonUtil {

    /**
     *
     * @param object
     * @return 返回json格式的字符串
     */
    public static String toJsonString(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }

}
