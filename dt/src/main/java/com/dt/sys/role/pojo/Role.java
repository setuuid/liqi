package com.dt.sys.role.pojo;

import java.io.Serializable;

/**
 * @description: 角色表 sys_role
 * @author: liqi
 * @create: 2019-06-24
 */
public class Role  implements Serializable {

    private String id;

    private String roleName;

    private String roleCode;

    private String remark;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
