package dao;

import po.Airport;

/**
 * @author:jinjiaobo
 * @date:2019/12/26
 * @description:
 */
public interface IAirportDAO {
    public Airport findByAirportId(String airportId);
}
