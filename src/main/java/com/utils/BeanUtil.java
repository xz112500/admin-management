package com.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component("BeanUtil")
public class BeanUtil {
    public static  <F,T> T copyTo(F f,Class<T> clazz){
        T t = BeanUtils.instantiateClass(clazz);
        if (null != f){
            BeanUtils.copyProperties(f,t);
            return t;
        }
        return null;
    }
    public static <F,T> List<T> copyTo(List<F> f, Class<T> clazz){
        List<T> ts=new ArrayList<>();
        if (CollectionUtils.isEmpty(f)){
            return Collections.emptyList();
        }
        for (F from: f) {
            T t = copyTo(from, clazz);
            ts.add(t);
        }
        return ts;
    }
    public static <F,T> JSONObject copyToJson(F f, Class<T> clazz){
        T t = copyTo(f, clazz);
        return JSONObject.parseObject(JSON.toJSONString(t));
    }
    public static <F,T> JSONArray copyTOJsonList(List<F> f, Class<T> clazz){
        List<T> ts = copyTo(f, clazz);
        return JSONArray.parseArray(JSON.toJSONString(ts));
    }
    public static  <T> T getBean(@NotNull Class<T> clazz, String Bean){
        ApplicationContext context=new AnnotationConfigApplicationContext(clazz);
        return context.getBean(Bean,clazz);
    }

}