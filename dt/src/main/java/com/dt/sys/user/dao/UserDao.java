package com.dt.sys.user.dao;

import com.dt.common.BaseVo;
import com.dt.sys.user.pojo.User;
import com.dt.sys.user.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户dao层
 */
@Mapper
public interface UserDao {
    /**
     * 分页查询-用户
     * @param userVo
     * @return
     */
    List<User> findPage(UserVo userVo);

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 删除用户根据用户id
     * @param id
     */
    void del(@Param(value = "id") String id);

    /**
     * 保存用户
     * @param user
     * @return
     */
    void add(User user);

    /**
     * 编辑用户
     * @param user
     */
    void edit(User user);

    /**
     * 根据用户id查询用户对象
     * @param id
     * @return
     */
    User findById(@Param(value = "id")String id);

    /**
     * 根据登陆名查询密码
     * @param username
     * @return
     */
    String findPassword(@Param(value = "username")String username);

    /**
     * 根据登陆名查询user对象
     * @param username
     * @return
     */
    User findUserByUsername(@Param(value = "username")String username);
}
