package service;

import dao.IPassengerDAO;
import po.Passenger;

import java.util.List;

/**
 * @author:jinjiaobo
 * @date:2019/12/24
 * @description:
 */
public class PassengerService implements IPassengerService {
    private IPassengerDAO passengerDAO = null;

    public IPassengerDAO getPassengerDAO() {
        return passengerDAO;
    }

    public void setPassengerDAO(IPassengerDAO passengerDAO) {
        this.passengerDAO = passengerDAO;
    }

    @Override
    public void save(Passenger passenger) {
        passengerDAO.save(passenger);
    }

    @Override
    public List<Passenger> findByName(Passenger passenger) {
        return passengerDAO.findByName(passenger);
    }

    @Override
    public List<Passenger> findName(Passenger passenger){
        return passengerDAO.findName(passenger);
    }

    @Override
    public void deletePassenger(Passenger passenger){
        passengerDAO.deletePassenger(passenger);
    }
}
