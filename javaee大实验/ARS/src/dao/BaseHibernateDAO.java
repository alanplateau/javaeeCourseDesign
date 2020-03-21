package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @Author 王怡静
 * @Date 2019-12-07 22:38
 * @Version 1.0
 */
public class BaseHibernateDAO {
    private SessionFactory sessionFactory;
    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
}
