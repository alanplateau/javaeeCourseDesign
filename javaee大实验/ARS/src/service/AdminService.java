package service;

import dao.*;
import org.hibernate.query.Query;
import po.*;

import java.util.List;

/**
 * @Author 王怡静
 * @Date 2019-12-08 01:10
 * @Version 1.0
 */
public class AdminService implements IAdminService{
    private IUserDAO userDAO=null;
    private IFlightDAO flightDAO=null;
    private IAirplaneDAO airplaneDAO=null;
    private IAirportDAO airportDAO=null;
    private ITicketInfoDAO ticketInfoDAO=null;
    public void setUserDAO(IUserDAO userDAO){
        this.userDAO=userDAO;
    }
    public void setFlightDAO(IFlightDAO flightDAO){this.flightDAO=flightDAO;}
    public void setAirplaneDAO(IAirplaneDAO airplaneDAO) {
        this.airplaneDAO = airplaneDAO;
    }
    public void setAirportDAO(IAirportDAO airportDAO) {
        this.airportDAO = airportDAO;
    }
    public void setTicketInfoDAO(ITicketInfoDAO ticketInfoDAO) {
        this.ticketInfoDAO = ticketInfoDAO;
    }

    //------------------------------对飞机信息的操作------------------------------------
    @Override
    public void addAirplane(Airplane airplane) {
        airplaneDAO.save(airplane);
    }

    @Override
    public void deleteAirplane(Airplane airplane) {
        airplaneDAO.delete(airplane);
    }

    @Override
    public void updateAirplane(Airplane airplane) {
        airplaneDAO.update(airplane);
    }

    @Override
    public List loadAirplane() {
        String hql="from Airplane";
        return(airplaneDAO.findByHQL(hql));
    }

    @Override
    public boolean checkAirplaneExist(String id) {
        String hql="from Airplane where airplaneId='"+id+"'";
        List a=airplaneDAO.findByHQL(hql);
        if(a.isEmpty()) return false;
        else return true;
    }

    //------------------------------对机场信息的操作------------------------------------
    @Override
    public void addAirport(Airport airport) {
        airportDAO.save(airport);
    }

    @Override
    public void deleteAirport(Airport airport) {
        airportDAO.delete(airport);
    }

    @Override
    public void updateAirport(Airport airport) {
        airportDAO.update(airport);
    }

    @Override
    public List loadAirport() {
        String hql="from Airport";
        return(airportDAO.findByHQL(hql));
    }

    @Override
    public boolean checkAirportExist(String id) {
        String hql="from Airport where airportId='"+id+"'";
        List a=airportDAO.findByHQL(hql);
        if(a.isEmpty()) return false;
        else return true;
    }

    //-------------------------------对航班信息的操作------------------------------------
    @Override
    public void addFlight(Flight flight) {
        TicketInfo tt=new TicketInfo();
        tt.setFirstClassTicket(flight.getTicketInfo().getFirstClassTicket());
        tt.setEconomyClassTicket(flight.getTicketInfo().getEconomyClassTicket());
        tt.setBusinessClassTicket(flight.getTicketInfo().getBusinessClassTicket());
        tt.setFirstClassTicketPrice(flight.getTicketInfo().getFirstClassTicketPrice());
        tt.setEconomyClassTicketPrice(flight.getTicketInfo().getEconomyClassTicketPrice());
        tt.setBusinessClassTicketPrice(flight.getTicketInfo().getBusinessClassTicketPrice());
        flight.setTicketInfo(tt);
        tt.setFlight(flight);
        flightDAO.save(flight);
    }

    @Override
    public void deleteFlight(Flight flight) {
        flightDAO.delete(flight);
    }

    @Override
    public void updateFlight(Flight flight) {
        TicketInfo ticketInfo=findTicketInfo(flight.getFlightId());
        ticketInfo.setFirstClassTicket(flight.getTicketInfo().getFirstClassTicket());
        ticketInfo.setEconomyClassTicket(flight.getTicketInfo().getEconomyClassTicket());
        ticketInfo.setBusinessClassTicket(flight.getTicketInfo().getBusinessClassTicket());
        ticketInfo.setFirstClassTicketPrice(flight.getTicketInfo().getFirstClassTicketPrice());
        ticketInfo.setEconomyClassTicketPrice(flight.getTicketInfo().getEconomyClassTicketPrice());
        ticketInfo.setBusinessClassTicketPrice(flight.getTicketInfo().getBusinessClassTicketPrice());
        flight.setTicketInfo(ticketInfo);
        ticketInfo.setFlight(flight);
        flightDAO.update(flight);
    }

    @Override
    public List loadFlight() {
        String hql="from Flight";
        return(flightDAO.findByHQL(hql));
    }

    @Override
    public boolean checkFlightExist(String id) {
        String hql="from Flight where flightId='"+id+"'";
        List a=flightDAO.findByHQL(hql);
        if(a.isEmpty()) return false;
        else return true;
    }

    @Override
    public TicketInfo findTicketInfo(String flightId) {
        String hql="from TicketInfo where flight.flightId='"+flightId+"'";
        List a=ticketInfoDAO.findByHQL(hql);
        return (TicketInfo)a.get(0);
    }

    //-----------------------------对经办业务员的操作------------------------------------
    @Override
    public void addManager(User manager) {
        userDAO.save(manager);
    }

    @Override
    public void deleteManager(User manager) {
        userDAO.delete(manager);
    }

    @Override
    public void updateManager(User manager) {
        userDAO.update(manager);
    }

    @Override
    public List loadManager() {
        String hql="from User where type=2";
        return(userDAO.findByHQL(hql));
    }

    @Override
    public boolean checkManagerExist(String account) {
        String hql="from User where account='"+account+"'";
        List a=userDAO.findByHQL(hql);
        if(a.isEmpty()) return false;
        else return true;
    }
}
