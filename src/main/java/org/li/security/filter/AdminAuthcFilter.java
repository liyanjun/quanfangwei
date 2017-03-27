package org.li.security.filter;

import com.google.gson.Gson;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.li.common.util.EHCacheUtil;
import org.li.common.vo.Result;
import org.li.module.system.bean.SystemUser;
import org.li.security.Constants;
import org.li.security.realm.StatelessToken;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>User: liyanjun
 * <p>Date: 14-2-26
 * <p>Version: 1.0
 */
public class AdminAuthcFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        String token = request.getParameter("token");
        SystemUser systemUser = (SystemUser) EHCacheUtil.getInstance().get(EHCacheUtil.LOGIN_CACHE, token);
        if(systemUser.getRoleId() != 3){
            return false;
        }
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        onLoginFail(response);
        return false;
    }

    //权限验证失败时默认返回401状态码
    private void onLoginFail(ServletResponse response) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpResponse.setContentType("application/json;charset=utf-8");
        httpResponse.getWriter().write(new Gson().toJson(Result.fail("权限不足。")));
    }
}
