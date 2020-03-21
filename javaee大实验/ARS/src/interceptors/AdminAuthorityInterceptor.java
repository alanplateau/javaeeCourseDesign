package interceptors;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import po.User;

import java.util.Map;

/**
 * @Author 王怡静
 * @Date 2019-12-22 14:13
 * @Version 1.0
 */
public class AdminAuthorityInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext ctx=actionInvocation.getInvocationContext();
        Map session=ctx.getSession();
        Map request=(Map)ctx.get("request");
        User user =(User)session.get("user");
//        System.out.println("拦截器校验username:"+user.getAccount());
        if(user!=null && user.getType()==1) return actionInvocation.invoke();
        else {
            if(user==null) request.put("tip","您尚未登录管理系统，请重新输入用户名和密码！");
            else if (user.getType()!=1) request.put("tip","当前用户无管理员权限，无法完成相应操作，请确认登录账户！");
            return Action.LOGIN;
        }
    }
}
