package dao;

import java.util.List;
import po.Order;

public interface IOrderDAO {
    public void save(Order transientInstance);
    public void delete(Order transientInstance);
    public void update(Order transientInstance);
    public void updateStatus(int orderId,String orderStatus);
    public void refund(Order transientInstance);
    public List findByHQL(String hql);
    public void buyTicketFromTI(Order transientInstance);
    public void refresh();
}