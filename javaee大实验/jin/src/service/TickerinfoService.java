package service;

import dao.ITicketinfoDAO;
import po.Flight;
import po.TicketInfo;

/**
 * @author:jinjiaobo
 * @date:2019/12/26
 * @description:
 */
public class TickerinfoService implements ITicketinfoService {
    private ITicketinfoDAO ticketinfoDAO = null;

    public ITicketinfoDAO getTicketinfoDAO() {
        return ticketinfoDAO;
    }

    public void setTicketinfoDAO(ITicketinfoDAO ticketinfoDAO) {
        this.ticketinfoDAO = ticketinfoDAO;
    }

    @Override
    public TicketInfo findByFlightId(Flight flight) {
        return ticketinfoDAO.findByFlightId(flight);
    }
}
