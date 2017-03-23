package org.li.security.filter;

import com.google.gson.Gson;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.li.common.util.EHCacheUtil;
import org.li.common.vo.Result;
import org.li.module.system.bean.SystemUser;
import org.li.security.realm.LoginToken;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>User: liyanjun
 * <p>Date: 17-3-26
 * <p>Version: 1.0
 */
public class LoginAuthcFilter extends FormAuthenticationFilter {

    /*@Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        onLoginFail(response); //6、登录失败
        return false;
    }*/

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        String token = ((HttpServletRequest)request).getHeader("token");
//        if(token == null) {
            onLoginFail(response);
            return true;
//        } else {
//            try {
//                Subject e = this.getSubject(request, response);
////                e.login(token);
//                return this.onLoginSuccess(token, e, request, response);
//            } catch (AuthenticationException var5) {
//                return this.onLoginFailure(token, var5, request, response);
//            }
//        }
    }

    //登录失败时默认返回401状态码
    private void onLoginFail(ServletResponse response) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpResponse.setContentType("json");
        httpResponse.getWriter().write(new Gson().toJson(Result.fail("用户名或密码不正确")));
    }
}
