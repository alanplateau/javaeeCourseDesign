package service;

import com.opensymphony.xwork2.ActionContext;
import dao.IUserDAO;
import po.User;

import java.util.List;
import java.util.Map;

/**
 * @author:jinjiaobo
 * @date:2019/12/24
 * @description:
 */
public class UserService implements IUserService {
    private IUserDAO userDAO = null;
    private Map<String, Object> session;

    public IUserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    //登录逻辑
    @Override
    public boolean login(User user) {
        ActionContext ctx = ActionContext.getContext();
        session = (Map) ctx.getSession();
        String account = user.getAccount();
        String password = user.getPassword();
        int type = user.getType();
        String hql = "from User as u where u.account='" + account + "' and u.password='" + password + "' and u.type='" + type + "'";
        List list = userDAO.findByHQL(hql);
        if (list.isEmpty()) return false;
        else {
//            User temp=new User();
//            temp.setAccount("hell");
//            temp.setPassword("hell");
            user = (User) list.get(0);
            session.put("user", user);
            return true;
        }
    }

    @Override
    public boolean getUser(User user) {
        if (userDAO.getUserByID(user.getAccount()) == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean addUser(User user) {
        try {
            if (user.getAccount() != null) {
                System.out.println(user.getAccount());
            }
            if (user.getPassword() != null){
                System.out.println(user.getPassword());
            }
            userDAO.addUser(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }
}
