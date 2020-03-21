package dao;

import po.Airplane;

import java.util.List;

/**
 * @Author 王怡静
 * @Date 2019-12-07 23:46
 * @Version 1.0
 */
public interface IAirplaneDAO {
    public void save(Airplane airplane);
    public void delete(Airplane airplane);
    public void update(Airplane airplane);
    public List findByHQL(String hql);
}
