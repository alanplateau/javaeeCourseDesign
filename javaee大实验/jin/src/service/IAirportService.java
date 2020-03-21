package service;

import dao.IAirportDAO;
import po.Airport;

public interface IAirportService {
    public Airport findByAirportId(String airportId);
}
