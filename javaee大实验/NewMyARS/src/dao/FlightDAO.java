package dao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import po.Flight;
public class FlightDAO extends BaseHibernateDAO implements IFlightDAO{
    public void save(Flight transientInstance) {
        System.out.println("execute --save()-- method.");
        Transaction tran = null;
        Session session = null;
        try {
            session = getSession();
            tran = session.beginTransaction();
            session.save(transientInstance);
            tran.commit();
        } catch (RuntimeException re) {
            throw re;
        }
        finally {
            session.close();
        }
    }
    public void delete(Flight transientInstance) {
        System.out.println("execute --delete()-- method.");
        Transaction tran = null;
        Session session = null;
        try {
            session = getSession();
            tran = session.beginTransaction();
            session.delete(transientInstance);
            tran.commit();

        } catch (RuntimeException re) {
            throw re;
        }
        finally {
            session.close();
        }
    }
    public void update(Flight transientInstance) {
        System.out.println("execute --update()-- method.");
        Transaction tran = null;
        Session session = null;
        try {
            session = getSession();
            tran = session.beginTransaction();
            session.update(transientInstance);
            tran.commit();

        } catch (RuntimeException re) {
            throw re;
        }
        finally {
            session.close();
        }
    }
    public List findByHQL(String hql) {
        System.out.println("execute --findByHQL()-- method.");
        Transaction tran = null;
        Session session = null;
        try {

            String queryString = hql;
            session = getSession();
            tran = session.beginTransaction();
            Query queryObject = session.createQuery(queryString);
            tran.commit();
            return queryObject.list();
        } catch (RuntimeException re) {
            throw re;
        }

    }
}