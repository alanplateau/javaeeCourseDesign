package dao;

import java.util.List;
import po.Flight;

public interface IFlightDAO {
    public void save(Flight transientInstance);
    public void delete(Flight transientInstance);
    public void update(Flight transientInstance);
    public List findByHQL(String hql);
}