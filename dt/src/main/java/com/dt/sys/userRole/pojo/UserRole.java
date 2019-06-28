package com.dt.sys.userRole.pojo;

import java.io.Serializable;

/**
 * @program: dt
 * @description: 中间表 用户角色 sys_user_role
 * @author: liqi
 * @create: 2019-06-26 10:55
 */
public class UserRole implements Serializable {

    private String id;

    private String userId;

    private String roleId;

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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
