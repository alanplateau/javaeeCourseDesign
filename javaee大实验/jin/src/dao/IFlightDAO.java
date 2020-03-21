package dao;

import po.Flight;
import po.TicketInfo;

import java.util.Date;
import java.util.List;

/**
 * @author:jinjiaobo
 * @date:2019/12/26
 * @description:
 */
public interface IFlightDAO {
    public Flight findByFlightId(Flight flight);
    public List getSelectFlight(String hql, Date departureTime);
    public Flight findByFlight1(Flight flight);
}
