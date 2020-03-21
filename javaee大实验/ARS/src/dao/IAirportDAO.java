package dao;

import po.Airport;
import java.util.List;

/**
 * @Author 王怡静
 * @Date 2019-12-21 20:48
 * @Version 1.0
 */
public interface IAirportDAO {
    public void save(Airport airport);
    public void delete(Airport airport);
    public void update(Airport airport);
    public List findByHQL(String hql);
}
