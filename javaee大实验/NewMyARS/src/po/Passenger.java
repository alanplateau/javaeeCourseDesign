package po;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Passenger {
    private Integer passengerId;
    private String name;
    private User user;
    private String idCard;
    private String identifyType;
    private Set orders=new HashSet(0);

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIdentifyType() {
        return identifyType;
    }

    public void setIdentifyType(String identifyType) {
        this.identifyType = identifyType;
    }


    public Set getOrders() {
        return orders;
    }

    public void setOrders(Set orders) {
        this.orders = orders;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
