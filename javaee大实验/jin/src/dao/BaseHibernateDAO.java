package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author:jinjiaobo
 * @date:2019/12/24
 * @description:
 */
public class BaseHibernateDAO {
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
