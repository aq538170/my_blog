package top.oujq.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Author: oujq
 * @Date: Create in 2019/7/14 10:49
 */
public class JsonUtil {

    public static String toJson(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
