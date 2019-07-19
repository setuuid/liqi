package com.dt.login.pojo;

/**
 * @program: dt
 * @description: 用户登陆
 * @author: liqi
 * @create: 2019-07-15 09:27
 */
public class UserInfo {
    private String username;

    private String password;

    private String salt;

    private String  verificationCode;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
