package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import po.Flight;
import po.TicketInfo;
import po.User;

import java.util.List;

/**
 * @author:jinjiaobo
 * @date:2019/12/26
 * @description:
 */
public class TicketinfoDAO extends BaseHibernateDAO implements ITicketinfoDAO {
    @Override
    public TicketInfo findByFlightId(Flight flight) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSession();
            transaction = session.beginTransaction();
            String hql = "from TicketInfo as t where t.flight.flightId=:flight";
            Query query = session.createQuery(hql);
            query.setParameter("flight", flight.getFlightId());
            List<TicketInfo> result = query.list();
            transaction.commit();
            System.out.println(result.get(0).getEconomyClassTicket());
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

    @Override
    public void update(TicketInfo ticketInfo) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSession();
            transaction = session.beginTransaction();
            session.update(ticketInfo);
            transaction.commit();
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
