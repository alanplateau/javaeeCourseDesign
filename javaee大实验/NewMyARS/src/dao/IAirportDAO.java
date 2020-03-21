package dao;

import java.util.List;
import po.Airport;

public interface IAirportDAO {
    public void save(Airport transientInstance);
    public void delete(Airport transientInstance);
    public void update(Airport transientInstance);
    public List findByHQL(String hql);
}