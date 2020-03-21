package po;

import java.util.Date;
import java.util.Objects;

public class Order {
    private Integer orderId;
    private int ticketType;
    private Date orderTime;
    private String orderStatus;
    private int status;

    private String account;
    private String name;
    private String idCard;

    private Passenger passenger;
    private Flight flight;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public int getTicketType() {
        return ticketType;
    }

    public void setTicketType(int ticketType) {
        this.ticketType = ticketType;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setStatus(int status){this.status = status;}

    public int getStatus(){return status;}

    public void setAccount(String account){this.account = account;}	public String getAccount(){return account;}
    public void setName(String name){this.name = name;}	public String getName(){return name;}
    public void setIdCard(String idCard){this.idCard = idCard;}	public String getIdCard(){return idCard;}



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId) &&
                Objects.equals(ticketType, order.ticketType) &&
                Objects.equals(orderTime, order.orderTime) &&
                Objects.equals(orderStatus, order.orderStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, ticketType, orderTime, orderStatus);
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
