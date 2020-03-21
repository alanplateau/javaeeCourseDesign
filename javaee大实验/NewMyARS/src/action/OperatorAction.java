package action;
import java.util.Map;

import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;


import dao.UserDAO;
import po.Flight;
import po.Passenger;
import po.Order;
import po.User;
import service.IOperatorService;
import service.OperatorService;
public class OperatorAction {
    private User user;
    private Passenger passenger;
    private Flight flight;
    private Order order;
    private String ticketType;
    private IOperatorService operatorService = null;

    public void setTicketType(String ticketType){this.ticketType = ticketType;}	public String getTicketType(){return ticketType;}

    public void setOperatorService(IOperatorService operatorService) {
        this.operatorService = operatorService;
    }
    public void setUser(User user){this.user = user;}
    public User getUser(){return user;}

    public void setPassenger(Passenger passenger){this.passenger = passenger;}
    public Passenger getPassenger(){return passenger;}

    public void setFlight(Flight flight){this.flight = flight;}
    public Flight getFlight(){return flight;}

    public void setOrder(Order order){this.order = order;}
    public Order getOrder(){return order;}


    public String login() {
        if (operatorService.login(user))
            return "success";
        else
            return "fail";
    }
//    public String searchOrders(){
//        if (operatorService.searchOrders(passenger))
//            return "success";
//        else
//            return "fail";
//    }
    public String flightInfo(){
        if (operatorService.flightInfo(flight))
            return "success";
        else
            return "fail";
    }
    public String alterOrder(){
        if (operatorService.alterOrder(order))
            return "success";
        else
            return "fail";
    }
    public String checkTicket(){
        if (operatorService.checkTicket())
            return "success";
        else
            return "fail";
    }
    public String buyTicket(){
        if (operatorService.buyTicket(order,ticketType))
            return "success";
        else
            return "fail";
    }
//    public String flightsearch() {
//        if (OperatorService.register(loginUser))
//            return "success";
//        else
//            return "fail";
//    }
    public String refresh1(){
        if (operatorService.refresh1())
            return "success";
        else
            return "fail";
    }
}
