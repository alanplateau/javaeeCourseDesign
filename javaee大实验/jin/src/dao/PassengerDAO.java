package dao;

import com.opensymphony.xwork2.ActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import po.Passenger;
import po.User;

import java.util.List;
import java.util.Map;

/**
 * @author:jinjiaobo
 * @date:2019/12/24
 * @description:
 */
public class PassengerDAO extends BaseHibernateDAO implements IPassengerDAO {
    @Override
    public void save(Passenger passenger) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSession();
            transaction = session.beginTransaction();
            ActionContext cxt=ActionContext.getContext();
            Map<String,Object> session1=cxt.getSession();
            User user = (User)session1.get("user");
            passenger.setAccount(user.getAccount());
            session.save(passenger);
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

    //一个账户对应的单个
    @Override
    public List<Passenger> findByName(Passenger passenger) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSession();
            transaction = session.beginTransaction();
            String hql = "from Passenger as p where p.account=:account and p.name=:name";
            Query query = session.createQuery(hql);
            ActionContext cxt=ActionContext.getContext();
            Map<String,Object> session1=cxt.getSession();
            User user = (User)session1.get("user");
            query.setParameter("account", user.getAccount());
            query.setParameter("name", passenger.getName());
            List<Passenger> result = query.list();
            transaction.commit();
            return result;
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

    //某个账户对应的所有
    @Override
    public List<Passenger> findName(Passenger passenger) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSession();
            transaction = session.beginTransaction();
            String hql = "from Passenger as p where p.account=:account";
            Query query = session.createQuery(hql);
            ActionContext cxt=ActionContext.getContext();
            Map<String,Object> session1=cxt.getSession();
            User user = (User)session1.get("user");
            query.setParameter("account", user.getAccount());
            List<Passenger> result = query.list();
            transaction.commit();
            return result;
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
    public void deletePassenger(Passenger passenger) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSession();
            transaction = session.beginTransaction();
            List<Passenger> list = findByName(passenger);
            session.delete(list.get(0));
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
