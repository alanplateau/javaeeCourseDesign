package service;

import dao.IAirportDAO;
import po.Airport;

/**
 * @author:jinjiaobo
 * @date:2019/12/26
 * @description:
 */
public class AirportService implements IAirportService {
    private IAirportDAO airportDAO = null;

    public IAirportDAO getAirportDAO() {
        return airportDAO;
    }

    public void setAirportDAO(IAirportDAO airportDAO) {
        this.airportDAO = airportDAO;
    }

    @Override
    public Airport findByAirportId(String airportId) {
        return airportDAO.findByAirportId(airportId);
    }
}
