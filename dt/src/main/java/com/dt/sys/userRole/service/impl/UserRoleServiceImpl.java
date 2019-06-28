package com.dt.sys.userRole.service.impl;

import com.dt.sys.userRole.dao.UserRoleDao;
import com.dt.sys.userRole.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: dt
 * @description: 用户角色中间表实现类
 * @author: liqi
 * @create: 2019-06-26 10:57
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleDao userRoleDao;
}
