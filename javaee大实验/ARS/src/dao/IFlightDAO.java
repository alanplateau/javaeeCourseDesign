package dao;

import po.Flight;
import java.util.List;

/**
 * @Author 王怡静
 * @Date 2019-12-07 23:52
 * @Version 1.0
 */
public interface IFlightDAO {
    public void save(Flight flight);
    public void delete(Flight flight);
    public void update(Flight flight);
    public List findByHQL(String hql);

}
