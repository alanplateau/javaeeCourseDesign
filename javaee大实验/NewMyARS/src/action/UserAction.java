package action;
import java.util.Map;

import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import dao.AirplaneDAO;
import po.Airplane;
import service.IUserService;
import service.UserService;
public class UserAction {
    private Airplane loginUser;
    private IUserService userService = null;

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
    public void setLoginUser(Airplane loginUser){this.loginUser = loginUser;}
    public Airplane getLoginUser(){return loginUser;}
    public String register() {
        if (userService.register(loginUser))
            return "success";
        else
            return "fail";
    }
    public String flightsearch() {
        if (userService.register(loginUser))
            return "success";
        else
            return "fail";
    }
}