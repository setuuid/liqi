package com.dt.sys.depart.service.impl;

import com.dt.sys.depart.dao.DepartDao;
import com.dt.sys.depart.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 部门service实现层
 * @author: liqi
 * @create: 2019-06-24
 */
@Service("departService")
public class DepartServiceImpl implements DepartService {
    @Autowired
    private DepartDao departDao;
}
