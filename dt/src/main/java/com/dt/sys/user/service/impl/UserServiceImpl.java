package com.dt.sys.user.service.impl;


import com.dt.common.Constant;
import com.dt.sys.user.dao.UserDao;
import com.dt.sys.user.pojo.User;
import com.dt.sys.user.service.UserService;
import com.dt.sys.user.vo.UserVo;
import com.dt.utils.PasswordUtil;
import com.dt.utils.UUIDUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户service实现类
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;


    /**
     * 查询分页
     * @param userVo
     * @return
     */
    @Override
    public PageInfo<User> findPage(UserVo userVo) {
        PageHelper.startPage(userVo.getPageNum(), userVo.getPageSize());
        List<User> list = userDao.findPage(userVo);
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        return pageInfo;
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    /**
     * 删除用户根据用户id
     * @param id
     * @return
     */
    @Override
    @Transactional
    public void del(String id) {
        userDao.del(id);
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    @Override
    @Transactional
    public void add(User user) {
        //id
        user.setId(UUIDUtil.getUUID());
        //盐生成
        String salt = RandomStringUtils.randomAlphanumeric(Constant.RANDOM_SALT_NUM);
        user.setSalt(salt);
        //加密后的密码
        String password = PasswordUtil.getPassword(user.getPassword(), ByteSource.Util.bytes(salt));
        user.setPassword(password);
        //保存
        userDao.add(user);
    }

    /**
     * 编辑用户
     * @param user
     * @return
     */
    @Override
    @Transactional
    public void edit(User user) {
        userDao.edit(user);
    }

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    @Override
    public User findById(String id) {
        return userDao.findById(id);
    }

}
