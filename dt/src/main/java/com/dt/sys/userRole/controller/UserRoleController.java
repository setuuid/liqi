package com.dt.sys.userRole.controller;

import com.dt.sys.userRole.service.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: dt
 * @description: 用户角色控制层
 * @author: liqi
 * @create: 2019-06-26 10:53
 */
@RestController
@RequestMapping("/userRole")
public class UserRoleController {
    private static final Logger logger = LoggerFactory.getLogger(UserRoleController.class);
    @Autowired
    private UserRoleService userRoleService;

}
