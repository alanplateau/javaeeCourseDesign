/*
 * Copyright(c)2002-2019
 *    项目名称:ARS55version
 *    文件名称:CityDAO.java
 *    Date:2019/12/25 下午7:50
 *    Author:高源
 */


package dao;

import org.hibernate.query.Query;

import java.util.List;

public class CityDAO extends BaseHibernateDAO implements ICityDAO{
    @Override
    public List getAllCities() {
        String HQL="select c.cityName from City c";
        try{
            Query queryObject=getSession().createQuery(HQL);
            return queryObject.list();
        }
        catch (RuntimeException re){
            System.out.println("get all City failed");
            re.printStackTrace();
            throw re;
        }
    }
}
