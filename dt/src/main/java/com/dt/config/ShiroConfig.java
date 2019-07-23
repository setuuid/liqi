package com.dt.config;

import com.dt.common.Constant;
import com.dt.realm.MyRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
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

    /*
     * 凭证匹配器 （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
     * 所以我们需要修改下doGetAuthenticationInfo中的代码; )
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName(Constant.HASH_ALGORITHM_NAME);// 散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashSalted(true);//加密码盐值
        hashedCredentialsMatcher.setHashIterations(Constant.HASH_INTERATIONS);// 散列的次数，比如散列两次，相当于md5(md5(""));
        return hashedCredentialsMatcher;
    }


    /**
     *5 开启shiro注解支持 授权
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor=new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return  authorizationAttributeSourceAdvisor;
    }

    /**
     * 4 自定义的realm对象
     */
    @Bean
    public MyRealm myRealm(){
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myRealm;
    }

    /**
     * 3 创建securityManager对象
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(myRealm());
        return  securityManager;
    }

    /**
     * 2 验证 过滤器
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
       //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager());
//        shiroFilterFactoryBean.setLoginUrl("/tologin");
        //未授权的页面  授权不通过
        shiroFilterFactoryBean.setUnauthorizedUrl("/refuse");
        //过滤器有顺序  先匿名  ，登陆的 授权不通过的  这样的顺序
        LinkedHashMap<String,String> linkedHashMap=new LinkedHashMap<>();
        linkedHashMap.put("/images/**","anon");
        linkedHashMap.put("/js/**","anon");
        linkedHashMap.put("/styles/**","anon");
        linkedHashMap.put("/login", "anon");
        linkedHashMap.put("/logout/**","anon");
        linkedHashMap.put("/user/add","anon");
        linkedHashMap.put("/**","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(linkedHashMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 1
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return  defaultAdvisorAutoProxyCreator;
    }
}
