package dao;

import po.User;
import java.util.List;

/**
 * @Author 王怡静
 * @Date 2019-12-07 22:32
 * @Version 1.0
 */
public interface IUserDAO {
    public void save(User user);
    public void delete(User user);
    public void update(User user);
    public List findByHQL(String hql);
}
