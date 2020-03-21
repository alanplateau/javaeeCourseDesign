package dao;

import java.util.List;
import po.Passenger;

public interface IPassengerDAO {
    public void save(Passenger transientInstance);
    public void delete(Passenger transientInstance);
    public void update(Passenger transientInstance);
    public List findByHQL(String hql);
}