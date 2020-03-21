package dao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import po.User;
public class UserDAO extends BaseHibernateDAO implements IUserDAO{
    public void save(User transientInstance) {
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
    }
    public void delete(User transientInstance) {
        System.out.println("execute --delete()-- method.");
        Transaction tran = null;
        Session session = null;
        try {
            session = getSession();
            tran = session.beginTransaction();
            getSession().delete(transientInstance);
            tran.commit();

        } catch (RuntimeException re) {
            throw re;
        }
    }
    public void update(User transientInstance) {
        System.out.println("execute --update()-- method.");
        Transaction tran = null;
        Session session = null;
        try {
            session = getSession();
            tran = session.beginTransaction();
            getSession().update(transientInstance);
            tran.commit();

        } catch (RuntimeException re) {
            throw re;
        }
    }
    public List findByHQL(String hql) {
        System.out.println("execute --findByHQL()-- method.");
        Transaction tran = null;
        Session session = null;
        try {

            String queryString = hql;
            session = this.getSession();
            tran = session.beginTransaction();
            Query queryObject = session.createQuery(queryString);
            tran.commit();
            return queryObject.list();
        } catch (RuntimeException re) {
            throw re;
        }
    }
}