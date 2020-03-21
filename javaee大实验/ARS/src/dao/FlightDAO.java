package dao;

import org.hibernate.query.Query;
import po.Flight;

import java.util.List;

/**
 * @Author 王怡静
 * @Date 2019-12-07 23:54
 * @Version 1.0
 */
public class FlightDAO extends BaseHibernateDAO implements IFlightDAO {
    @Override
    public void save(Flight flight) {
        getSession().clear();
        getSession().save(flight);
    }

    @Override
    public void delete(Flight flight) {
        getSession().clear();
        getSession().delete(flight);
    }

    @Override
    public void update(Flight flight) {
        getSession().clear();
        getSession().update(flight);
    }

    @Override
    public List findByHQL(String hql) {
        Query queryObject= getSession().createQuery(hql);
        return queryObject.list();
    }
}
