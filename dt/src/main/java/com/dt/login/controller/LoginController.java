package com.dt.login.controller;

import com.dt.common.BaseVo;
import com.dt.common.Constant;
import com.dt.login.pojo.UserInfo;
import com.dt.sys.userRole.controller.UserRoleController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: dt
 * @description:
 * @author: liqi
 * @create: 2019-06-26 13:40
 */
@Controller
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

    @RequestMapping("/login")
    @ResponseBody
    public BaseVo login(@RequestBody UserInfo userInfo){
        BaseVo baseVo = new BaseVo<>();
        if (userInfo.getUsername() !=null){
            baseVo.setData("请输入用户名！");
        }else {
            UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(),userInfo.getPassword());
            Subject currentUser = SecurityUtils.getSubject();
            try {
                currentUser.login(token);
            } catch (UnknownAccountException uae) {
                baseVo.setCode(Constant.ERROR);
                baseVo.setData("用户名和密码不匹配");
                return baseVo;
            } catch (IncorrectCredentialsException ice) {
                baseVo.setCode(Constant.ERROR);
                baseVo.setData("用户名和密码不匹配");
                return baseVo;
            } catch (LockedAccountException lae) {
                baseVo.setCode(Constant.ERROR);
                logger.info("LockedAccountException");
                return baseVo;
            } catch (ExcessiveAttemptsException eae) {
                baseVo.setCode(Constant.ERROR);
                logger.info("ExcessiveAttemptsException");
                return baseVo;
            } catch (AuthenticationException ae) {
                baseVo.setCode(Constant.ERROR);
                logger.info("AuthenticationException");
                return baseVo;
            }
            baseVo.setMsg("登陆成功");
            baseVo.setCode(Constant.SUCCESS);

        }
        return baseVo;
    }

}
