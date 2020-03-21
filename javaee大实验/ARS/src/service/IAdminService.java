package service;

import po.*;

import java.util.List;

/**
 * @Author 王怡静
 * @Date 2019-12-08 01:10
 * @Version 1.0
 */
public interface IAdminService {
    //------------------------------对飞机信息的操作------------------------------------
    public void addAirplane(Airplane airplane);
    public void deleteAirplane(Airplane airplane);
    public void updateAirplane(Airplane airplane);
    public List loadAirplane();
    public boolean checkAirplaneExist(String id);

    //------------------------------对机场信息的操作------------------------------------
    public void addAirport(Airport airport);
    public void deleteAirport(Airport airport);
    public void updateAirport(Airport airport);
    public List loadAirport();
    public boolean checkAirportExist(String id);

    //------------------------------对航班信息的操作------------------------------------
    public void addFlight(Flight flight);
    public void deleteFlight(Flight flight);
    public void updateFlight(Flight flight);
    public List loadFlight();
    public boolean checkFlightExist(String id);
    public TicketInfo findTicketInfo(String flightId);

    //-----------------------------对经办业务员的操作------------------------------------
    public void addManager(User manager);
    public void deleteManager(User manager);
    public void updateManager(User manager);
    public List loadManager();
    public boolean checkManagerExist(String id);
}
