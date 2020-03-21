package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import po.Flight;
import po.TicketInfo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author:jinjiaobo
 * @date:2019/12/26
 * @description:
 */
public class FlightDAO extends BaseHibernateDAO implements IFlightDAO {
    @Override
    public Flight findByFlightId(Flight flight) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSession();
            transaction = session.beginTransaction();
            System.out.println("askjdghfkajdbf");
            System.out.println(flight.getFlightId());
            String hql = "from Flight f where f.flightId=:flight";
            Query query = session.createQuery(hql);
            query.setParameter("flight", flight.getFlightId());
            List<Flight> result = query.list();
            transaction.commit();
            System.out.println(result.get(0).getArrivalTime());
            return result.get(0);
        } catch (RuntimeException re) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw re;
        } finally {
            assert session != null;
            session.close();
        }
    }

    @Override
    public Flight findByFlight1(Flight flight) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = getSession();
            ///transaction = session.beginTransaction();
            System.out.println("123456779");
            //System.out.println(session.get(Flight.class, flight.getFlightId()).getDepartureAirport());
            //transaction.commit();
            Flight flight2=session.get(Flight.class, flight.getFlightId());
            System.out.println(flight2.getArrivalTime());
            return flight2;
        } catch (Exception e) {
            throw e;
        }
    }

//    public Flight findByFlightId1(Flight flight) {
//        Transaction transaction = null;
//        Session session = null;
//        try {
//            session = getSession();
//            transaction = session.beginTransaction();
//            System.out.println("askjdghfkajdbf");
//            System.out.println(flight.getFlightId());
//            String hql = "from Flight";
//            Query query = session.createQuery(hql);
//            query.setParameter("flight", flight.getFlightId());
//            List<Flight> result = query.list();
//            transaction.commit();
//            System.out.println(result.get(0).getArrivalTime());
//            return result.get(0);
//        } catch (RuntimeException re) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            throw re;
//        } finally {
//            assert session != null;
//            session.close();
//        }
//    }

    //判断两个日期年月日是否相同
    private boolean sameDate(Date d1, Date d2) {
        System.out.println(d1.getYear());
        System.out.println(d2.getYear());
        System.out.println(d1.getMonth());
        System.out.println(d2.getMonth());
        System.out.println(d1.getDay());
        System.out.println(d2.getDay());
        return d1.getYear() == d2.getYear() && d1.getMonth() == d2.getMonth() && d1.getDay() == d2.getDay();
    }

    @Override
    public List getSelectFlight(String hql, Date departureTime) {
        try {
            System.out.println(departureTime.getYear());
            System.out.println("__________________-------");
            String queryString = hql;
            Query queryObject = getSession().createQuery(queryString);
            //起始时间为该天的0点
            departureTime.setHours(0);
            departureTime.setMinutes(0);
            departureTime.setSeconds(0);
            //终止时间为明天的0点
            Date endTime = new Date();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(departureTime);
            //把日期往后增加一天.整数往后推,负数往前移动
            calendar.add(Calendar.DATE, 1);
            endTime = calendar.getTime();

            //设置query
            Date currentDate = new Date();
            //如果查询时间和当前日期相同
            if (sameDate(currentDate, departureTime)) {
                System.out.println("时间相同-----------------");
                System.out.println(currentDate.getHours());
                System.out.println(currentDate.getMinutes());
                System.out.println(currentDate.getSeconds());
                queryObject.setTimestamp(0, currentDate);
            } else {
                queryObject.setTimestamp(0, departureTime);
            }
            queryObject.setTimestamp(1, endTime);
            System.out.println(departureTime.toString());
            System.out.println(endTime.toString());
            return queryObject.list();
        } catch (RuntimeException re) {
            System.out.println("find by hql failed");
            re.printStackTrace();
            throw re;
        }
    }
}
