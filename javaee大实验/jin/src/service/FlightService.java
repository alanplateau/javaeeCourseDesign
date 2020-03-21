package service;

import com.opensymphony.xwork2.ActionContext;
import dao.IFlightDAO;
import po.Flight;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author:jinjiaobo
 * @date:2019/12/26
 * @description:
 */
public class FlightService implements IFlightService {
    private IFlightDAO flightDAO = null;
    ActionContext ctx = null;
    Map<String, Object> session = null;

    public IFlightDAO getFlightDAO() {
        return flightDAO;
    }

    public void setFlightDAO(IFlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    @Override
    public Flight findByFlightId(Flight flight) {
        return flightDAO.findByFlightId(flight);
    }

    @Override
    public boolean searchFlight(String fromCity, String toCity, Date departureTime) {
        ctx = ActionContext.getContext();
        session = ctx.getSession();
        String Hql = "from Flight as f where f.departureAirport.city.cityName='" + fromCity + "'and " +
                "f.arrivalAirport.city.cityName='" + toCity + "' and f.departureTime>?0 and f.departureTime<?1";
        List<Flight> flights = (List<Flight>) flightDAO.getSelectFlight(Hql, departureTime);
        for (Flight flight : flights) {
            System.out.println(flight.getFlightId());
            System.out.println(flight.getDepartureAirport().getAirportName());
            System.out.println(flight.getArrivalAirport().getAirportName());
            System.out.println(flight.getDepartureTime().toString());
            System.out.println(flight.getArrivalTime().toString());
            System.out.println("-------------------------");
        }
        session.put("flights", flights);
        return true;
    }
}
