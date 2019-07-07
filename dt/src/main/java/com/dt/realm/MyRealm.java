package com.dt.realm;

import com.dt.common.Constant;
import com.dt.sys.user.dao.UserDao;
import com.dt.sys.user.pojo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: dt
 * @description:
 * @author: liqi
 * @create: 2019-07-04 15:10
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserDao userDao;
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        System.out.println("————权限认证————");
//        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        //获得该用户角色
//        String role = userDao.getRole(username);
//        Set<String> set = new HashSet<>();
//        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
//        set.add(role);
//        //设置该用户拥有的角色
//        info.setRoles(set);
        return info;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("————身份认证方法————");
        //token 是登陆时页面传进来 包装过来的 usernamePasswordToken 对象
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 从数据库获取对应用户名密码的用户
//        String password = userDao.findPassword(token.getUsername());
        User user=userDao.findUserByUsername(token.getUsername());
        if (null == user) {
            throw new AccountException("用户名不正确");
        } else {
            Md5Hash md5Hash = new Md5Hash(token.getPassword(), user.getSalt(), Constant.IITERATOR_TIMES);
            if (!user.getPassword().equals(md5Hash)) {
                throw new AccountException("密码不正确");
            }
        }
        //表示realm登陆比对信息：参数1：用户信息 2：密码 3：当前realm的名字

        return new SimpleAuthenticationInfo(token.getPrincipal(), user.getPassword(), getName());
    }
}