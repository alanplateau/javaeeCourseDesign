package action;

import com.opensymphony.xwork2.ActionContext;
import po.User;
import service.AdminService;
import service.IUserService;

import java.util.Map;

/**
 * @Author 王怡静
 * @Date 2019-12-07 22:59
 * @Version 1.0
 */
public class UserAction {
    private User user;
    private IUserService userServ=null;
    public void setUserServ(IUserService userServ){
        this.userServ=userServ;
    }
    public User getUser(){return user;}
    public void setUser(User user){this.user=user;}

    //登录
    public String login(){
        if (userServ.login(user)==1){
            return "adminSuccess";
        }
        else if (userServ.login(user)==2){
            return "managerSuccess";
        }
        else if (userServ.login(user)==3){
            return "normalSuccess";
        }
        else {
            ActionContext cxt = ActionContext.getContext();
            Map request=(Map) cxt.get("request");
            request.put("tip", "用户名或密码错误!");
            return "fail";
        }
    }
}
