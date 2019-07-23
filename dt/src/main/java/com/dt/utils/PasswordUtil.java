package com.dt.utils;

import com.dt.common.Constant;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @program: dt
 * @description:
 * @author: liqi
 * @create: 2019-07-23 15:43
 */
public final class PasswordUtil {

    /**
     * 密码+盐  md5     用shiro 的md5
     * @param password  前端传来的明文密码
     * @param salt  盐值  保存生成出来的随机数
     * @return
     */
    public static String getPassword(String password , ByteSource salt){
        //md5
        String hashAlgorithmName= Constant.HASH_ALGORITHM_NAME;
        //转换盐值格式
        ByteSource bytes = ByteSource.Util.bytes(salt);
        //迭代次数
        int hashInterations= Constant.HASH_INTERATIONS;
        //加密
        Object simpleHash = new SimpleHash(hashAlgorithmName, password, bytes, hashInterations);
        //转换类型
        String getPassword = String.valueOf(simpleHash);
        //返回
        return getPassword;
    }
}
