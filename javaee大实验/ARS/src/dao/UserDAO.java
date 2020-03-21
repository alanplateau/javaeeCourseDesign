package dao;

import org.hibernate.query.Query;
import po.User;

import java.util.List;

/**
 * @Author 王怡静
 * @Date 2019-12-07 22:32
 * @Version 1.0
 */
public class UserDAO extends BaseHibernateDAO implements IUserDAO {

    @Override
    public void save(User user) {
        getSession().clear();
        getSession().save(user);
    }

    @Override
    public void delete(User user) {
        getSession().clear();
        getSession().delete(user);
    }

    @Override
    public void update(User user) {
        getSession().clear();
        getSession().update(user);
    }

    @Override
    public List findByHQL(String hql) {
        Query queryObject= getSession().createQuery(hql);
        return queryObject.list();
    }
}
