package dao;

import java.util.List;
import po.TicketInfo;

public interface ITicketInfoDAO {
    public void save(TicketInfo transientInstance);
    public void delete(TicketInfo transientInstance);
    public void update(TicketInfo transientInstance);
    public List findByHQL(String hql);
}