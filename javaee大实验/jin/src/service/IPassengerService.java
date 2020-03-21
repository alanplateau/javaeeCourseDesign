package service;

import po.Passenger;

import java.util.List;

/**
 * @author:jinjiaobo
 * @date:2019/12/24
 * @description:
 */
public interface IPassengerService {
    public void save(Passenger passenger);
    public List findByName(Passenger passenger);
    public List findName(Passenger passenger);
    public void deletePassenger(Passenger passenger);
}
