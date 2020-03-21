package dao;

import java.util.List;
import po.Airplane;

public interface IAirplaneDAO {
    public void save(Airplane transientInstance);
    public void delete(Airplane transientInstance);
    public void update(Airplane transientInstance);
    public List findByHQL(String hql);
}