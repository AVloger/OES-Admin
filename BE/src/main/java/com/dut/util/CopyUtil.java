package com.dut.util;

import org.springframework.beans.BeanUtils;

public class CopyUtil {
//    https://blog.csdn.net/q610376681/article/details/88542620
    public static <T> T copy(Object source, Class<T> clazz) {
        if (source == null) {
            return null;
        }
        T obj = null;
        try {
            obj = clazz.newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }
        BeanUtils.copyProperties(source, obj);
        return obj;
    }
}
