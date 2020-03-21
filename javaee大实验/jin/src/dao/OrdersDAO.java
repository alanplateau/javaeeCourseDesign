package dao;

import com.opensymphony.xwork2.ActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import po.Orders;
import po.Passenger;
import po.TicketInfo;
import po.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author:jinjiaobo
 * @date:2019/12/26
 * @description:
 */
public class OrdersDAO extends BaseHibernateDAO implements IOrdersDAO {
    @Override
    public void save(Orders orders) {
        orders.setStatus(1);
        orders.setOrderStatus("已购");
        orders.setOrderTime(new Date());
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSession();
            transaction = session.beginTransaction();
            session.save(orders);
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

    @Override
    public List<Orders> findByAccountID() {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSession();
            transaction = session.beginTransaction();
            String hql = "from Orders as o where o.account=:account";
            Query query = session.createQuery(hql);
            ActionContext cxt=ActionContext.getContext();
            Map<String,Object> session1=cxt.getSession();
            User user = (User)session1.get("user");
            query.setParameter("account", user.getAccount());
            List<Orders> result = query.list();
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
    public Orders findByOrderID(Orders orders) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSession();
            transaction = session.beginTransaction();
            String hql = "from Orders as o where o.orderId=:orderId";
            Query query = session.createQuery(hql);
            query.setParameter("orderId", orders.getOrderId());
            List<Orders> result = query.list();
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

    @Override
    public void update(Orders orders) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSession();
            transaction = session.beginTransaction();
            session.update(orders);
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
