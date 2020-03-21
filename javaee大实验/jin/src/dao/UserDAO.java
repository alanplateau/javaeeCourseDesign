package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import po.User;

import java.util.List;

/**
 * @author:jinjiaobo
 * @date:2019/12/24
 * @description:
 */
public class UserDAO extends BaseHibernateDAO implements IUserDAO {
    @Override
    public void update(User user) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSession();
            transaction = session.beginTransaction();
            user.setType(3);
            session.update(user);
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
    public List findByHQL(String HQL){
        try{
            String queryString=HQL;
            Query queryObject=getSession().createQuery(queryString);
            return queryObject.list();
        }
        catch (RuntimeException re){
            System.out.println("find by hql failed");
            re.printStackTrace();
            throw re;
        }
    }

    @Override
    public void addUser(User userInstance) {
        Transaction transaction=null;
        Session session=null;
        try {
            System.out.println("------------------------");
            if(userInstance.getAccount()!=null) {
                System.out.println(userInstance.getAccount());
            }
            if(userInstance.getPassword()!=null) {
                System.out.println(userInstance.getPassword());
            }
            session=getSession();
            transaction=session.beginTransaction();
            session.persist(userInstance);
            transaction.commit();
        }
        catch (RuntimeException e){
            transaction.rollback();
            System.out.println("save user failed");
            e.printStackTrace();
            throw e;
        }
        finally {
            session.close();
        }
    }

    @Override
    public User getUserByID(String userID){
        return getSession().get(User.class,userID);
    }
}
