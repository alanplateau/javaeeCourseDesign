package service;

import com.opensymphony.xwork2.ActionContext;
import dao.IUserDAO;
import po.User;

import java.util.List;
import java.util.Map;

/**
 * @Author 王怡静
 * @Date 2019-12-07 22:46
 * @Version 1.0
 */
public class UserService implements IUserService {
    private IUserDAO userDAO=null;
    private Map<String,Object> session;
    public void setUserDAO(IUserDAO userDAO){
        this.userDAO=userDAO;
    }

    @Override
    //登录逻辑
    public int login(User user) {
        ActionContext ctx=ActionContext.getContext();
        session=(Map)ctx.getSession();
        String account=user.getAccount();
        String password=user.getPassword();
        String hql="from User where account='"+account+"' and password='"+password+"'";
        List list=userDAO.findByHQL(hql);
        if (list.isEmpty()) {
            return -1;
        }
        else{
            user=(User)list.get(0);
            session.put("user",user);
            return user.getType();
        }
    }
}
