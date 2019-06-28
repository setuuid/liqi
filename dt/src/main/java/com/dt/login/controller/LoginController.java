package com.dt.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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


    @RequestMapping("/login")
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




}
