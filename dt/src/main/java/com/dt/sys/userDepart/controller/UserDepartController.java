package com.dt.sys.userDepart.controller;

import com.dt.sys.userRole.service.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: dt
 * @description: 用户部门中间表控制层
 * @author: liqi
 * @create: 2019-06-26 11:13
 */
@RestController
@RequestMapping("userDepart")
public class UserDepartController {
    private static final Logger logger = LoggerFactory.getLogger(UserDepartController.class);
    @Autowired
    private UserRoleService userRoleService;
}
