package com.dt.login.controller;

import com.dt.common.BaseVo;
import com.dt.common.Constant;
import com.dt.login.pojo.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * @program: dt
 * @description:
 * @author: liqi
 * @create: 2019-06-26 13:40
 */
@RestController
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping("/tologin")
    public String userLogin(){
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(){
        return "login-error";
    }

    @PostMapping("/hello")
    @ResponseBody
    public String helloWorld()  {
       String s ="测试中文";
        return "spring security hello world";
    }

    @PostMapping("/login")
    public BaseVo login(@RequestBody UserInfo userInfo){
        BaseVo baseVo = new BaseVo<>();
        if (userInfo.getUsername() ==null){
            baseVo.setData("请输入用户名！");
        }else {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(),userInfo.getPassword());
            try {
                subject.login(token);
            } catch (UnknownAccountException uae) {
                baseVo.setCode(Constant.ERROR);
                baseVo.setMsg("密码不匹配");
                return baseVo;
            } catch (IncorrectCredentialsException ice) {
                baseVo.setCode(Constant.ERROR);
                baseVo.setMsg("密码不匹配");
                return baseVo;
            } catch (LockedAccountException lae) {
                baseVo.setCode(Constant.ERROR);
                baseVo.setMsg("用户被锁");
                logger.info("用户被锁");
                return baseVo;
            } catch (ExcessiveAttemptsException eae) {
                baseVo.setCode(Constant.ERROR);
                baseVo.setMsg("登录失败多次，账户锁定10分钟");
                logger.info("登录失败多次，账户锁定10分钟");
                return baseVo;
            } catch (AuthenticationException ae) {
                baseVo.setCode(Constant.ERROR);
                baseVo.setMsg("没有权限");
                logger.info("没有权限");
                return baseVo;
            }
            baseVo.setMsg("登陆成功");
            baseVo.setCode(Constant.SUCCESS);
            baseVo.setData(userInfo);
        }
        return baseVo;
    }

}
