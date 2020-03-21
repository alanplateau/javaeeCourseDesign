package service;

import po.User;

/**
 * @author:jinjiaobo
 * @date:2019/12/24
 * @description:
 */
public interface IUserService {
    public boolean login(User user);
    public boolean addUser(User user);
    public boolean getUser(User user);
    public void update(User user);
}
