package com.dt.sys.roleMenu.controller;

import com.dt.sys.roleMenu.service.RoleMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: dt
 * @description: 角色菜单中间表控制层
 * @author: liqi
 * @create: 2019-06-26 11:05
 */
@RestController
@RequestMapping("roleMenu")
public class RoleMenuController {
    private static final Logger logger = LoggerFactory.getLogger(RoleMenuController.class);
    @Autowired
    private RoleMenuService roleMenuService;


}
