package po;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author:jinjiaobo
 * @date:2019/12/28
 * @description:
 */
@Entity
@Table(name = "orders", schema = "ars")
public class Orders {
    private int orderId;
    private Integer passengerId;
    private Flight flight;
    private Integer ticketType;
    private Date orderTime;
    private String orderStatus;
    private String account;
    private String idCard;
    private String name;
    private Integer status;

    @Id
    @Column(name = "orderID")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "passengerID")
    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Basic
    @Column(name = "ticketType")
    public Integer getTicketType() {
        return ticketType;
    }

    public void setTicketType(Integer ticketType) {
        this.ticketType = ticketType;
    }

    @Basic
    @Column(name = "orderTime")
    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    @Basic
    @Column(name = "orderStatus")
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Basic
    @Column(name = "account")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "IDCard")
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Orders that = (Orders) o;
        return orderId == that.orderId &&
                Objects.equals(passengerId, that.passengerId) &&
                Objects.equals(flight, that.flight) &&
                Objects.equals(ticketType, that.ticketType) &&
                Objects.equals(orderTime, that.orderTime) &&
                Objects.equals(orderStatus, that.orderStatus) &&
                Objects.equals(account, that.account) &&
                Objects.equals(idCard, that.idCard) &&
                Objects.equals(name, that.name) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, passengerId, flight, ticketType, orderTime, orderStatus, account, idCard, name, status);
    }
}
