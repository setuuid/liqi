package com.dt.sys.role.service.impl;

import com.dt.sys.role.dao.RoleDao;
import com.dt.sys.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 角色service实现层
 * @author: liqi
 * @create: 2019-06-24
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
}
