package com.dt.sys.menu.vo;

import com.dt.common.BasePageVo;

import java.io.Serializable;

/**
 * @description: 菜单表 sys_menu
 * @author: liqi
 * @create: 2019-06-24
 */
public class MenuVo extends BasePageVo implements Serializable {
    /**
     * id
     */
    private String id;
    /**
     * 菜单名
     */
    private String menuName;
    /**
     * 父id
     */
    private String menuPid;
    /**
     * 菜单url
     */
    private String menuUrl;
    /**
     * 描述
     */
    private String descritpion;
    /**
     * 菜单code
     */
    private String menuCode;

    /**
     * 菜单等级
     */
    private int menuLevel;
    /**
     *菜单图标
     */
    private String menuIcon;






    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuPid() {
        return menuPid;
    }

    public void setMenuPid(String menuPid) {
        this.menuPid = menuPid;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public int getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(int menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }
}
