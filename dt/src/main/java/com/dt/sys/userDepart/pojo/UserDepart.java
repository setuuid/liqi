package com.dt.sys.userDepart.pojo;

import java.io.Serializable;

/**
 * @program: dt
 * @description: 用户部门中间表sys_user_depart
 * @author: liqi
 * @create: 2019-06-26 11:51
 */
public class UserDepart implements Serializable {

    private String id;

    private String userId;

    private String departId;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }
}
