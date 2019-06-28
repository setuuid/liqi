package com.dt.sys.roleMenu.pojo;

import java.io.Serializable;

/**
 * @program: dt
 * @description: 角色菜单中间表
 * @author: liqi
 * @create: 2019-06-26 11:08
 */
public class RoleMenu implements Serializable {

    private  String id;
    private String roleId;
    private String menuId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
