package dao;

import po.TicketInfo;

import java.util.List;

/**
 * @Author 王怡静
 * @Date 2019-12-26 19:03
 * @Version 1.0
 */
public interface ITicketInfoDAO {
    public void save(TicketInfo ticketInfo);
    public void update(TicketInfo ticketInfo);
    public List findByHQL(String hql);
}
