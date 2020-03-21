package service;

import po.Flight;

import java.util.Date;

/**
 * @author:jinjiaobo
 * @date:2019/12/26
 * @description:
 */
public interface IFlightService {
    public Flight findByFlightId(Flight flight);
    public boolean searchFlight(String fromCity, String toCity, Date departureTime);
}
