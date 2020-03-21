package dao;

import java.util.List;
import po.User;

public interface IUserDAO {
    public void save(User transientInstance);
    public void delete(User transientInstance);
    public void update(User transientInstance);
    public List findByHQL(String hql);
}