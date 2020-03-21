package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import po.Airport;
import po.Flight;

import java.util.List;

/**
 * @author:jinjiaobo
 * @date:2019/12/26
 * @description:
 */
public class AirportDAO extends BaseHibernateDAO implements IAirportDAO {
    @Override
    public Airport findByAirportId(String airportId) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSession();
            transaction = session.beginTransaction();
            String hql = "from Airport a where a.airportId=:airportId";
            Query query = session.createQuery(hql);
            query.setParameter("airportId", airportId);
            List<Airport> result = query.list();
            transaction.commit();
            return result.get(0);
        } catch (RuntimeException re) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw re;
        } finally {
            assert session != null;
            session.close();
        }
    }
}
