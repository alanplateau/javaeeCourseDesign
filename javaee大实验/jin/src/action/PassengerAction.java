package action;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import dao.IPassengerDAO;
import po.Passenger;
import service.IPassengerService;

import javax.swing.*;
import java.util.List;
/**
 * @author:jinjiaobo
 * @date:2019/12/24
 * @description:
 */
public class PassengerAction {
    private Passenger passenger;
    private IPassengerService passengerService;
    private List<Passenger> passengers;

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public IPassengerService getPassengerService() {
        return passengerService;
    }

    public void setPassengerService(IPassengerService passengerService) {
        this.passengerService = passengerService;
    }

    public String savePassenger() {
        passengerService.save(passenger);
        return "success";
    }

    //通过人名找人
    public String findByName() {
        this.passengers = (List<Passenger>) passengerService.findByName(passenger);
        return "success";
    }

    //找到全部人
    public String findName() {
        this.passengers = (List<Passenger>) passengerService.findName(passenger);
        return "success";
    }

    public String deletePassenger() {
        this.passenger.setAccount("jinjiaobo");
        passengerService.deletePassenger(passenger);
        return "success";
    }
}
