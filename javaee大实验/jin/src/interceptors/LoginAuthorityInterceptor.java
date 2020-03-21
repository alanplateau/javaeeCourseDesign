/*
 * Copyright(c)2002-2019
 *    项目名称:ARS55version
 *    文件名称:LoginAuthorityInterceptor.java
 *    Date:2019/12/25 下午7:50
 *    Author:高源
 */


package interceptors;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import po.User;

import java.util.Map;

public class LoginAuthorityInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        System.out.println("Authority Interceptor executed!");
        ActionContext ctx = invocation.getInvocationContext();
        Map session = ctx.getSession();
        User user = (User) session.get("user");
        if (user != null) {
            return invocation.invoke();
        } else {
            ctx.put("tip", "您还没有登录，请输入用户名和密码登录系统");
            return Action.LOGIN;
        }
    }
}
