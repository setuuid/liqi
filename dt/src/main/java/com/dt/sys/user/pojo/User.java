package com.dt.sys.user.pojo;

import com.dt.sys.depart.pojo.Depart;
import com.dt.sys.role.pojo.Role;

import java.io.Serializable;
import java.util.List;

/**
 * @description: 用户表 sys_user
 * @author: liqi
 * @create: 2019-06-21 12:31
 */
public class User  implements Serializable {

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

    /**部门*/
    private List<Depart> depart;

    /**角色*/
    private List<Role> role;



    /**********************get set  ************************************************方法*/
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

    public List<Depart> getDepart() {
        return depart;
    }

    public void setDepart(List<Depart> depart) {
        this.depart = depart;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }
}
