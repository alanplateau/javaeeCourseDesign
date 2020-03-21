package po;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Author 王怡静
 * @Date 2019-12-07 18:48
 * @Version 1.0
 */
public class Airport {
    private String airportId;
    private String airportName;
    private City city;
    private Set departureflights=new HashSet(0);
    private Set arrivalflights=new HashSet(0);

    public String getAirportId() {
        return airportId;
    }

    public void setAirportId(String airportId) {
        this.airportId = airportId;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set getDepartureflights() {
        return departureflights;
    }

    public void setDepartureflights(Set departureflights) {
        this.departureflights = departureflights;
    }

    public Set getArrivalflights() {
        return arrivalflights;
    }

    public void setArrivalflights(Set arrivalflights) {
        this.arrivalflights = arrivalflights;
    }
}
