package com.dt.sys.user.controller;

import com.dt.common.BaseVo;
import com.dt.config.RedisUtil;
import com.dt.sys.user.pojo.User;
import com.dt.sys.user.service.UserService;
import com.dt.sys.user.vo.UserVo;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 用户控制层
 * @author liqi
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private UserService userService;

    private BaseVo baseVo = new BaseVo();
    /**
     * 分页查询用户
     * @param userVo
     * @return
     */
    @PostMapping("/findPage")
    public BaseVo<Object> findPage(@RequestBody UserVo userVo){
        PageInfo<User> page = userService.findPage(userVo);
        baseVo.setData(page);
        return baseVo;
    }

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("/findAll")
    public BaseVo finaAll(){
        List<User> all = userService.findAll();
        baseVo.setData(all);
        return baseVo;
    }

    /**
     * 删除用户 根据用户id
     * @param id
     * @return
     */
    @DeleteMapping("/del/{id}")
    public BaseVo del(@PathVariable("id") String id){
        userService.del(id);
        return baseVo;
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    @PostMapping("/add")
    public BaseVo add(@RequestBody User user){
        userService.add(user);
        return baseVo;
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @PutMapping("/edit")
    public BaseVo edit(@RequestBody User user){
        userService.edit(user);
        return baseVo;
    }

    /**
     * 更新用户
     * @param id
     * @return
     */
    @GetMapping("/findById/{id}")
    public BaseVo findById(@PathVariable("id") String id){
        baseVo.setData(userService.findById(id));
        return baseVo;
    }

}
