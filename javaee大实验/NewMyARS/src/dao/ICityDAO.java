package dao;

import java.util.List;
import po.City;

public interface ICityDAO {
    public void save(City transientInstance);
    public void delete(City transientInstance);
    public void update(City transientInstance);
    public List findByHQL(String hql);
}