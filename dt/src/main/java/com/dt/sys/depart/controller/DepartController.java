package com.dt.sys.depart.controller;

import com.dt.sys.depart.service.DepartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 部门模块控制层
 * @author: liqi
 * @create: 2019-06-24
 */
@RestController
@RequestMapping("/depart")
public class DepartController {
    private static final Logger logger = LoggerFactory.getLogger(DepartController.class);

    @Autowired
    private DepartService departService;

}
