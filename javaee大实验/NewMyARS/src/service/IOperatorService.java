package service;
import po.Order;
import po.Passenger;
import po.User;
import po.Flight;
public interface IOperatorService{
    public boolean login(User transientInstance);
//    public boolean searchOrders(User transientInstance);
//    public boolean searchOrders(Passenger transientInstance);
    public boolean flightInfo(Flight transientInstance);
//    public boolean alterOrder(int orderId);
    public boolean alterOrder(Order transientInstance);
    public boolean checkTicket();
    public boolean buyTicket(Order transientInstance,String ticketType);
    public boolean refresh1();
}
