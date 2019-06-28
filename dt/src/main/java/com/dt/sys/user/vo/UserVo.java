package com.dt.sys.user.vo;

import com.dt.common.BasePageVo;

import java.io.Serializable;

/**
 * 用户的视图类
 */
public class UserVo extends BasePageVo implements Serializable {


    /**主键*/
    private String id;

    /**密码盐*/
    private String salt;

    /**密码*/
    private String password;

    /**用户名字：登陆名*/
    private String username;

    /**真实名字*/
    private String realname;

    /**手机号*/
    private String phone;

    /** 身份证号 */
    private String idcard;

    /**头像 */
    private String headportrait;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getHeadportrait() {
        return headportrait;
    }

    public void setHeadportrait(String headportrait) {
        this.headportrait = headportrait;
    }
}
