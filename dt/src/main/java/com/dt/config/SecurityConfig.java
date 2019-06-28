package com.dt.config;

import com.sun.org.apache.xpath.internal.operations.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsUtils;

import javax.xml.ws.soap.Addressing;

/**
 * @program: dt
 * @description: 安全框架配置类
 * @author: liqi
 * @create: 2019-06-26 09:47
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 通过修改Security的配置来实现
     * 首先 添加一个类 SecurityConfig 继承 WebSecurityConfigurerAdapter ，
     * 重写configure方法。
     * 并加上@Configuration 和@EnableWebSecurity 2个注解。
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        //super.configure(http);
        http
        //loginPage("/login")表示登录时跳转的页面，因为登录页面我们不需要登录认证，所以我们需要添加 permitAll() 方法。
        // 添加一个控制器，对应/login 返回一个登录页面。
        //表单登录，permitAll()表示这个不需要验证 登录页面，登录失败页面
            .formLogin().loginPage("/login").failureUrl("/login-error").permitAll()
            .and()
            .authorizeRequests().antMatchers("/*").permitAll()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll().
                anyRequest().authenticated()
            .and()
            .csrf().disable();
    }
//
//    /**
//     * 自定义用户名和密码
//     * @param auth
//     * @throws Exception
//     */
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin").password("123456").roles("USER");
//    }

    /**
     *  就是 重写 另外一种configure(AuthenticationManagerBuilder auth) 方法，这个和上面那个方法的作用是一样的。选其一就可。
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO Auto-generated method stub
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin").password("123456").roles("USER")
//                .and()
//                .withUser("test").password("123456").roles("ADMIN");
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("user1").password(new BCryptPasswordEncoder().encode("123456")).roles("USER");

    }
}
