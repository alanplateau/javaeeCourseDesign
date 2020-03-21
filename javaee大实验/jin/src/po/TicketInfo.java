package po;

import java.util.Objects;

/**
 * @Author 王怡静
 * @Date 2019-12-09 01:00
 * @Version 1.0
 */
public class TicketInfo {
    private Integer ticketInfoId;
    private Integer firstClassTicket;
    private Integer businessClassTicket;
    private Integer economyClassTicket;
    private Double firstClassTicketPrice;
    private Double businessClassTicketPrice;
    private Double economyClassTicketPrice;
    private Flight flight;

    public Integer getTicketInfoId() {
        return ticketInfoId;
    }

    public void setTicketInfoId(Integer ticketInfoId) {
        this.ticketInfoId = ticketInfoId;
    }

    public Integer getFirstClassTicket() {
        return firstClassTicket;
    }

    public void setFirstClassTicket(Integer firstClassTicket) {
        this.firstClassTicket = firstClassTicket;
    }

    public Integer getEconomyClassTicket() {
        return economyClassTicket;
    }

    public void setEconomyClassTicket(Integer economyClassTicket) {
        this.economyClassTicket = economyClassTicket;
    }

    public Integer getBusinessClassTicket() {
        return businessClassTicket;
    }

    public void setBusinessClassTicket(Integer businessClassTicket) {
        this.businessClassTicket = businessClassTicket;
    }

    public Double getFirstClassTicketPrice() {
        return firstClassTicketPrice;
    }

    public void setFirstClassTicketPrice(Double firstClassTicketPrice) {
        this.firstClassTicketPrice = firstClassTicketPrice;
    }

    public Double getEconomyClassTicketPrice() {
        return economyClassTicketPrice;
    }

    public void setEconomyClassTicketPrice(Double economyClassTicketPrice) {
        this.economyClassTicketPrice = economyClassTicketPrice;
    }

    public Double getBusinessClassTicketPrice() {
        return businessClassTicketPrice;
    }

    public void setBusinessClassTicketPrice(Double businessClassTicketPrice) {
        this.businessClassTicketPrice = businessClassTicketPrice;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
