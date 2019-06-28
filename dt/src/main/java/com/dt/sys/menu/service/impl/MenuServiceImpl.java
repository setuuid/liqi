package com.dt.sys.menu.service.impl;

import com.dt.sys.menu.dao.MenuDao;
import com.dt.sys.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: liqi
 * @create: 2019-06-24
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

}
