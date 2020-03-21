package dao;

import org.hibernate.query.Query;
import po.Airport;

import java.util.List;

/**
 * @Author 王怡静
 * @Date 2019-12-21 20:52
 * @Version 1.0
 */
public class AirportDAO extends BaseHibernateDAO implements IAirportDAO {
    @Override
    public void save(Airport airport) {
        getSession().clear();
        getSession().save(airport);
    }

    @Override
    public void delete(Airport airport) {
        getSession().clear();
        getSession().delete(airport);
    }

    @Override
    public void update(Airport airport) {
        getSession().clear();
        getSession().update(airport);
    }

    @Override
    public List findByHQL(String hql) {
        Query queryObject= getSession().createQuery(hql);
        return queryObject.list();
    }
}
