package dao;

import po.Flight;
import po.TicketInfo;

/**
 * @author:jinjiaobo
 * @date:2019/12/26
 * @description:
 */
public interface ITicketinfoDAO {
    public TicketInfo findByFlightId(Flight flight);
    public void update(TicketInfo ticketInfo);
}
