/**
 * Copyright: Copyright 2016-2020 JD.COM All Right Reserved
 * FileName: com.zoro.mail.utils.FastJsonConvertUtil
 * Author: belicoff
 * Department: 企业站
 * Date: 2018/1/18 1:20
 * Description: JSON工具
 */
package com.zoro.mail.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.List;

/**
 * JSON工具
 * @author belicoff
 * @create 2018/1/18
 * @since 1.0.0
 */
public class FastJsonConvertUtil {

    private static final SerializerFeature[] featuresWithNollValue = { SerializerFeature.WriteMapNullValue,
            SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullStringAsEmpty};

    /**
     *  将JSON字符串转换为实体对象
     * @param data  JSON字符串
     * @param clzss 转换对象
     * @return  T
     */
    public static <T> T convertJSONToObject(String data, Class<T> clzss) {
        try {
            T t = JSON.parseObject(data, clzss);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将JSONObject对象转换为实体对象
     * @param data  JSONObject对象
     * @param clzss 转换对象
     * @return  T
     */
    public static <T> T convertJSONToObject(JSONObject data, Class<T> clzss) {
        try {
            T t = JSONObject.toJavaObject(data, clzss);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将List<JSONObject>转换为List集合对象
     * @param data  List<JSONObject>
     * @param clzss 转换对象
     * @return  List<T>集合对象
     */
    public static <T> List<T> convertJSONToArray(List<JSONObject> data, Class<T> clzss) {
        try {
            List<T> t = new ArrayList<T>();
            for(JSONObject jsonObject : data) {
                t.add(convertJSONToObject(jsonObject, clzss));
            }
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将对象转换为JSONObject对象
     * @param obj   任意对象
     * @return  JSONObject
     */
    public static JSONObject convertObjectToJSONObject(Object obj) {
        try {
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(obj);
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String convertObjectToJSONJSONWithNullValue(Object obj) {
        try {
            String text = JSON.toJSONString(obj, featuresWithNollValue);
            return text;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}