package com.dt.sys.user.service;

import com.dt.sys.user.pojo.User;
import com.dt.sys.user.vo.UserVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
    /**
     * 查询分页用户
     * @param userVo
     * @return
     */
    PageInfo<User> findPage(UserVo userVo);

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 根据id 查询用户
     * @param id
     * @return
     */
    void del(String id);

    /**
     * 保存用户
     * @param user
     * @return
     */
    void add(User user);

    /**
     * 编辑用户
     * @param user
     * @return
     */
    void edit(User user);

    /**
     * 根据用户id 查询
     * @param id
     * @return
     */
    User findById(String id);
}
