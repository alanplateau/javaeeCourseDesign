package dao;

import po.User;

import java.util.List;

/**
 * @author:jinjiaobo
 * @date:2019/12/24
 * @description:
 */
public interface IUserDAO {
    public List findByHQL(String HQL);
    public void addUser(User userInstance);
    public User getUserByID(String userID);
    public void update(User user);
}
