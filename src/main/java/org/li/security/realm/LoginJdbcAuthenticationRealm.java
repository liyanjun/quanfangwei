package org.li.security.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.li.module.system.bean.SystemUser;
import org.li.module.system.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 *
 * 认证（登录）类，用于 apache shiro 在执行认证（登录）时，通过该类对登录信息认证（登录）是否通过。
 *
 */
public class LoginJdbcAuthenticationRealm extends AuthorizingRealm {

    @Autowired
    private SystemUserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        if(token instanceof LoginToken){
            return true;
        }
        return super.supports(token);
    }

    /**
     * 重写授权方法
     *
     * @param principals 当前用户
     *
     * @return 授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Collection collection = principals.fromRealm(getName());

        if (collection.isEmpty()) {
            return null;
        }


        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();


        return simpleAuthorizationInfo;
    }

   /* @Override
    protected Object getAuthorizationCacheKey(PrincipalCollection principals) {
        return principals.oneByType(QueryUserInfoRsp.class).getName();
    }*/

    /**
     * 重写认证方法
     *
     * @param token 票据
     *
     * @return 认证信息
     *
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        LoginToken adminToken = (LoginToken) token;

        String username = adminToken.getUsername();
        SystemUser user = userService.find(1);
      /*  QueryUserInfoRsp user = queryUserInfoService.queryUserEntity(username);
        if (user == null) {
            throw new UnknownAccountException("账户名或密码错误");
        }
        if (!user.getStatus().equals("QY")) {
            throw new DisabledAccountException("账户已经被锁定");
        }*/
        //todo 校验密码
        return new SimpleAuthenticationInfo(adminToken.getPrincipal(), adminToken.getCredentials(), getName());
    }

    /**
     * 重写生成断言密码匹配器
     *
     * @return 密码匹配器
     */
    @Override
    public CredentialsMatcher getCredentialsMatcher() {
        return new SimpleCredentialsMatcher() {
            @Override
            public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
                return true;
            }
        };
    }
}
