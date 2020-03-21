package service;

import po.Flight;
import po.Orders;

import java.util.List;

/**
 * @author:jinjiaobo
 * @date:2019/12/28
 * @description:
 */
public interface IOrdersService {
    public String save(List<Orders> orders, Flight flight);
    public List<Orders> findByAccount();
    public String refundTicket(Orders order);
    public List<Orders> findByAcc();
}
