package org.li.security.realm;

import org.apache.shiro.authc.AuthenticationToken;

import java.util.Map;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-26
 * <p>Version: 1.0
 */
public class AdminToken implements AuthenticationToken {

    private String username;
    private String password;

    public AdminToken(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public Object getPrincipal() {
       return username;
    }

    @Override
    public Object getCredentials() {
        return password;
    }

}
