package dao;

import po.Orders;

import java.util.List;

/**
 * @author:jinjiaobo
 * @date:2019/12/26
 * @description:
 */
public interface IOrdersDAO {
    public void save(Orders orders);
    public List<Orders> findByAccountID();
    public Orders findByOrderID(Orders orders);
    public void update(Orders orders);
}
