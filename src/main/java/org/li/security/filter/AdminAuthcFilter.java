package org.li.security.filter;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.li.security.realm.AdminToken;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>User: liyanjun
 * <p>Date: 17-3-26
 * <p>Version: 1.0
 */
public class AdminAuthcFilter extends FormAuthenticationFilter {

    /*@Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        onLoginFail(response); //6、登录失败
        return false;
    }*/

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AdminToken token = new AdminToken(username,password);
        if(token == null) {
            String e1 = "createToken method implementation returned null. A valid non-null AuthenticationToken must be created in order to execute a login attempt.";
            throw new IllegalStateException(e1);
        } else {
            try {
                Subject e = this.getSubject(request, response);
                e.login(token);
                return this.onLoginSuccess(token, e, request, response);
            } catch (AuthenticationException var5) {
                return this.onLoginFailure(token, var5, request, response);
            }
        }
    }

    //登录失败时默认返回401状态码
    private void onLoginFail(ServletResponse response) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpResponse.getWriter().write("login error");
    }
}
