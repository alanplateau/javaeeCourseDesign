package action;

import com.opensymphony.xwork2.ActionContext;
import po.User;
import service.IUserService;

import java.util.Map;

/**
 * @author:jinjiaobo
 * @date:2019/12/24
 * @description:
 */
public class UserAction {
    private User user;
    private IUserService userService;
    private String code;
    private ActionContext cxt = ActionContext.getContext();
    private Map<String, Object> session = cxt.getSession();
    private Map request = (Map) cxt.get("request");

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public String updateUser() {
        userService.update(user);
        return "success";
    }

    //密码登录
    public String loginForUser() {
        System.out.println(user.getType());
        if (userService.login(user)) {
            return "normalSuccess";
        } else {
            request.put("tip", "用户名或密码错误");
            return "normalFail";
        }
    }

    //注册
    public String register() {

        String verificationCode = (String) session.get("verificationCode");
        //session中不存在验证码
        if (verificationCode == null) {
            request.put("tip", "验证码未发送");
            return "error";
        }
        //验证码不相等
        if (!verificationCode.equals(code)) {
            request.put("tip", "验证码错误");
            return "error";
        }
        //注册成功
        if (userService.addUser(user)) {
            request.put("tip", "注册成功");
            return "success";
        } else {
            request.put("tip", "该手机号已经注册过了");
            return "error";
        }

    }

    //验证码登录
    public String loginByCode() {
        String verificationCode = (String) session.get("verificationCode");
        if (!verificationCode.equals(code)) {
            request.put("tip", "验证码错误");
            return "error";
        }
        //验证码成功且该手机号已经注册过
        if (userService.getUser(user)) {
            request.put("tip", "登录成功");
            session.put("user", user);
            return "success";
        } else {
            request.put("tip", "请先注册");
            return "error";
        }
    }

    public String logOut() {
        session.remove("user");
        return "success";
    }
}
