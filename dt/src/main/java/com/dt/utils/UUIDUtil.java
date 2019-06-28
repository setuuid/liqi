package com.dt.utils;

import java.util.UUID;

/**
 * @description: 简单的uuid 生成工具
 * @author: liqi
 * @create: 2019-06-24
 */
public class UUIDUtil {
    /**
     * 获取一个uuid
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    /**
     * 获得指定数目的UUID
     * @param number int 需要获得的UUID数量
     * @return String[] UUID数组
     */
    public static String[] getUUID(int number){
        if(number < 1){
            return null;
        }
        String[] ss = new String[number];
        for(int i=0;i<number;i++){
            ss[i] = getUUID();
        }
        return ss;
    }


}
