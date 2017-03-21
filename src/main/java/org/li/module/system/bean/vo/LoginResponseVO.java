package org.li.module.system.bean.vo;

import org.li.module.system.bean.SystemUser;

/**
 * Created by 衍君 on 2017/3/21.
 */
public class LoginResponseVO {
    private SystemUser userInfo;
    private String token;

    public LoginResponseVO(SystemUser userInfo, String token) {
        this.userInfo = userInfo;
        this.token = token;
    }

    public static LoginResponseVO build(SystemUser userInfo, String token){
        return new LoginResponseVO(userInfo,token);
    }

    public SystemUser getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(SystemUser userInfo) {
        this.userInfo = userInfo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
