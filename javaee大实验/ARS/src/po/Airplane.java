package po;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Author 王怡静
 * @Date 2019-12-07 18:48
 * @Version 1.0
 */
public class Airplane {
    private String airplaneId;
    private String airplaneType;
    private Integer firstClassSeats;
    private Integer economyClassSeats;
    private Integer businessClassSeats;
    private Set flights=new HashSet(0);

    public String getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(String airplaneId) {
        this.airplaneId = airplaneId;
    }

    public String getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(String airplaneType) {
        this.airplaneType = airplaneType;
    }

    public Integer getEconomyClassSeats() {
        return economyClassSeats;
    }

    public void setEconomyClassSeats(Integer economyClassSeats) {
        this.economyClassSeats = economyClassSeats;
    }

    public Integer getFirstClassSeats() {
        return firstClassSeats;
    }

    public void setFirstClassSeats(Integer firstClassSeats) {
        this.firstClassSeats = firstClassSeats;
    }

    public Integer getBusinessClassSeats() {
        return businessClassSeats;
    }

    public void setBusinessClassSeats(Integer businessClassSeats) {
        this.businessClassSeats = businessClassSeats;
    }

    public Set getFlights() {
        return flights;
    }

    public void setFlights(Set flights) {
        this.flights = flights;
    }
}
