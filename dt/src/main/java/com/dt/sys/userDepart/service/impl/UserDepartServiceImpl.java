package com.dt.sys.userDepart.service.impl;

import com.dt.sys.userDepart.dao.UserDepartDao;
import com.dt.sys.userDepart.service.UserDepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: dt
 * @description: 用户部门service实现层
 * @author: liqi
 * @create: 2019-06-26 11:14
 */
@Service("userDepartService")
public class UserDepartServiceImpl implements UserDepartService {
    @Autowired
    private UserDepartDao userDepartDao;
}
