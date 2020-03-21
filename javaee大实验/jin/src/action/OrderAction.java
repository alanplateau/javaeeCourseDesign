package action;

import com.opensymphony.xwork2.ActionContext;
import po.*;
import po.TicketInfo;
import service.*;

import java.util.List;
import java.util.Map;

/**
 * @author:jinjiaobo
 * @date:2019/12/25
 * @description:
 */
public class OrderAction {
    private Orders order;
    private List<Orders> orders;
    private Flight flight;
    private ITicketinfoService ticketinfoService;
    private IFlightService flightService;
    private IAirportService airportService;
    private IPassengerService passengerService;
    private IOrdersService ordersService;
    private Flight flightInfo;
    private TicketInfo ticketInfo;
    private List<Passenger> passengers;
    private Map request;

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public IOrdersService getOrdersService() {
        return ordersService;
    }

    public void setOrdersService(IOrdersService ordersService) {
        this.ordersService = ordersService;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public IPassengerService getPassengerService() {
        return passengerService;
    }

    public void setPassengerService(IPassengerService passengerService) {
        this.passengerService = passengerService;
    }

    public IAirportService getAirportService() {
        return airportService;
    }

    public void setAirportService(IAirportService airportService) {
        this.airportService = airportService;
    }

    public IFlightService getFlightService() {
        return flightService;
    }

    public void setFlightService(IFlightService flightService) {
        this.flightService = flightService;
    }

    public Flight getFlightInfo() {
        return flightInfo;
    }

    public void setFlightInfo(Flight flightInfo) {
        this.flightInfo = flightInfo;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public ITicketinfoService getTicketinfoService() {
        return ticketinfoService;
    }

    public void setTicketinfoService(ITicketinfoService ticketinfoService) {
        this.ticketinfoService = ticketinfoService;
    }

    public TicketInfo getTicketInfo() {
        return ticketInfo;
    }

    public void setTicketInfo(TicketInfo ticketInfo) {
        this.ticketInfo = ticketInfo;
    }

    public String findUsingFlight() {
        ActionContext cxt=ActionContext.getContext();
        Map<String,Object> session=cxt.getSession();
        User user = (User)session.get("user");
        this.ticketInfo = ticketinfoService.findByFlightId(flight);
        this.flightInfo = flightService.findByFlightId(flight);
        this.flightInfo.setDepartureAirport(airportService.findByAirportId(this.flightInfo.getDepartureAirport().getAirportId()));
        this.flightInfo.setArrivalAirport(airportService.findByAirportId(this.flightInfo.getArrivalAirport().getAirportId()));
        Passenger passenger = new Passenger();
        passenger.setAccount(user.getAccount());
        this.passengers = passengerService.findName(passenger);
        if (ticketInfo.getEconomyClassTicket()<=0 && ticketInfo.getBusinessClassTicket()<=0 && ticketInfo.getFirstClassTicket()<= 0) {
            return "failed";
        }
        return "success";
    }

    public String addOrders() {
        ActionContext ctx= ActionContext.getContext();
        request=(Map) ctx.get("request");
        if ("success".equals(ordersService.save(orders,flight))) {
            return "success";
        } else if ("fail".equals(ordersService.save(orders, flight))) {
            request.put("tip1", "存在某些票已买完，请重新购票");
            return "failed";
        } else {
            request.put("tip1", "存在用户已经购买该航班");
            return "failed";
        }
    }

    //找已出行订单
    public String findByAccount() {
        this.orders = ordersService.findByAccount();
        return "success";
    }

    //找未出行订单
    public String findByAcc() {
        this.orders = ordersService.findByAcc();
        return "success";
    }

    public String refundTicket() {
        ordersService.refundTicket(order);
        return "success";
    }
}
