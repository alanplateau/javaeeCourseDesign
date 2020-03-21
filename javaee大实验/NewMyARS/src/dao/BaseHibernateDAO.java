package dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
public class BaseHibernateDAO{
    private SessionFactory sessionFactory ;
    public Session getSession(){

        return sessionFactory.openSession();
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}