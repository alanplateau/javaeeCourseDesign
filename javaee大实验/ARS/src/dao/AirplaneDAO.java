package dao;

import org.hibernate.query.Query;
import po.Airplane;

import java.util.List;

/**
 * @Author 王怡静
 * @Date 2019-12-07 23:48
 * @Version 1.0
 */
public class AirplaneDAO extends BaseHibernateDAO implements IAirplaneDAO{
    @Override
    public void save(Airplane airplane) {
        getSession().clear();
        getSession().save(airplane);
    }

    @Override
    public void delete(Airplane airplane) {
        getSession().clear();
        getSession().delete(airplane);
    }

    @Override
    public void update(Airplane airplane) {
        getSession().clear();
        getSession().update(airplane);
    }

    @Override
    public List findByHQL(String hql) {
        Query queryObject= getSession().createQuery(hql);
        return queryObject.list();
    }
}
