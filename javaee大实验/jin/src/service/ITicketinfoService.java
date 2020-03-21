package service;

import po.Flight;
import po.TicketInfo;

/**
 * @author:jinjiaobo
 * @date:2019/12/26
 * @description:
 */
public interface ITicketinfoService {
    public TicketInfo findByFlightId(Flight flight);
}
