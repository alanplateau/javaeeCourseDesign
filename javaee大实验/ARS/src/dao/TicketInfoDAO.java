package dao;

import org.hibernate.query.Query;
import po.TicketInfo;

import java.util.List;

/**
 * @Author 王怡静
 * @Date 2019-12-26 19:03
 * @Version 1.0
 */
public class TicketInfoDAO extends BaseHibernateDAO implements ITicketInfoDAO {
    @Override
    public void save(TicketInfo ticketInfo) {
        getSession().clear();
        getSession().save(ticketInfo);
    }

    @Override
    public void update(TicketInfo ticketInfo) {
        getSession().clear();
        getSession().update(ticketInfo);
    }

    @Override
    public List findByHQL(String hql) {
        Query queryObject= getSession().createQuery(hql);
        return queryObject.list();
    }
}
