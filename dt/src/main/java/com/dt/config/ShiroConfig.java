package com.dt.config;

import com.dt.realm.MyRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @program: dt
 * @description: shiro
 * @author: liqi
 * @create: 2019-07-04 15:03
 */
@Configuration
public class ShiroConfig {


    //自定义的realm对象
    @Bean
    public MyRealm myRealm(){
        MyRealm myRealm = new MyRealm();
        return myRealm;
    }

    //创建securityManager对象
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(myRealm());
        return  securityManager;
    }

    //验证 过滤器
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        shiroFilterFactoryBean.setLoginUrl("/login");
        //未授权的页面  授权不通过
        shiroFilterFactoryBean.setUnauthorizedUrl("/refuse");
        //过滤器有顺序  先匿名  ，登陆的 授权不通过的  这样的顺序
        LinkedHashMap<String,String> linkedHashMap=new LinkedHashMap<>();
        linkedHashMap.put("/images/**","anon");
        linkedHashMap.put("/js/**","anon");
        linkedHashMap.put("/styles/**","anon");
        linkedHashMap.put("/logout/**","anon");
        linkedHashMap.put("/**","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(linkedHashMap);
        return shiroFilterFactoryBean;
    }


    //开启shiro注解支持 授权
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor=new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return  authorizationAttributeSourceAdvisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return  defaultAdvisorAutoProxyCreator;
    }
}
