package com.dt.sys.roleMenu.service.impl;

import com.dt.sys.roleMenu.dao.RoleMenuDao;
import com.dt.sys.roleMenu.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: dt
 * @description: 角色菜单中间表service实现类
 * @author: liqi
 * @create: 2019-06-26 11:04
 */
@Service("roleMenuService")
public class RoleMenuServiceImpl implements RoleMenuService {
    @Autowired
    private RoleMenuDao roleMenuDao;
}
