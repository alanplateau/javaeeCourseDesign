package dao;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import po.Order;
public class OrderDAO extends BaseHibernateDAO implements IOrderDAO{
    public void save(Order transientInstance) {
        System.out.println("execute --save()-- method.");
        Transaction tran = null;
        Session session = null;
        try {
            session = getSession();
            tran = session.beginTransaction();
            session.save(transientInstance);
            tran.commit();
        } catch (RuntimeException re) {
            throw re;
        }
        finally {
            session.close();
        }
    }
    public void delete(Order transientInstance) {
        System.out.println("execute --delete()-- method.");
        Transaction tran = null;
        Session session = null;
        try {
            session = getSession();
            tran = session.beginTransaction();
            session.delete(transientInstance);
            tran.commit();

        } catch (RuntimeException re) {
            throw re;
        }
        finally {
            session.close();
        }
    }
    public void update(Order transientInstance) {
        System.out.println("execute --update()-- method.");
        Transaction tran = null;
        Session session = null;
        try {
            session = getSession();
            tran = session.beginTransaction();
            session.update(transientInstance);
            tran.commit();


        } catch (RuntimeException re) {
            System.out.println("error");
            throw re;
        }
        finally {
            session.close();
        }
    }
    public List findByHQL(String hql) {
        System.out.println("execute --findByHQL()-- method.");
        Transaction tran = null;
        Session session = null;
        try {

            String queryString = hql;
            session = getSession();
            tran = session.beginTransaction();

            Query queryObject = session.createQuery(queryString);
            tran.commit();
            return queryObject.list();
        } catch (RuntimeException re) {
            throw re;
        }
    }
    public void updateStatus(int orderId,String orderStatus) {
        System.out.println("execute --updateStatus()-- method.");
        Transaction tran = null;
        Session session = null;
        try {
            session = getSession();
            tran = session.beginTransaction();
            String queryString = "update Order o set o.orderStatus = '"+orderStatus+"' where o.orderId=" + orderId;
            Query queryObject = session.createQuery(queryString);
            queryObject.executeUpdate();
            tran.commit();


        } catch (RuntimeException re) {
            System.out.println("error");
            throw re;
        }
        finally {
            session.close();
        }
    }
    public void addOrder(Order transientInstance){
        System.out.println("execute --addOrder()-- method.");
        Transaction tran = null;
        Session session = null;
        try {
            session = getSession();
            tran = session.beginTransaction();
            session.persist(transientInstance);
            tran.commit();


        } catch (RuntimeException re) {
            System.out.println("error");
            throw re;
        }
        finally {
            session.close();
        }
    }
    public void buyTicketFromTI(Order transientInstance){
        System.out.println("execute --buyTicketFromTI()-- method.");
        Transaction tran = null;
        Session session = null;
        try {
            System.out.println(transientInstance.getTicketType());
            if(transientInstance.getTicketType()==1){
                session = getSession();
                tran = session.beginTransaction();

                String flightId = transientInstance.getFlight().getFlightId();

                String queryString1 = "update TicketInfo tf set tf.firstClassTicket = tf.firstClassTicket-1 where tf.flight.flightId='" + flightId+"'";


                Query queryObject = session.createQuery(queryString1);
                queryObject.executeUpdate();

                tran.commit();
            }
            else if(transientInstance.getTicketType()==2){
                session = getSession();
                tran = session.beginTransaction();
                String flightId = transientInstance.getFlight().getFlightId();

                String queryString1 = "update TicketInfo tf set tf.businessClassTicket = tf.businessClassTicket-1 where tf.flight.flightId='" + flightId+"'";


                Query queryObject = session.createQuery(queryString1);
                queryObject.executeUpdate();

                tran.commit();
            }
            else if(transientInstance.getTicketType()==3){
                session = getSession();
                tran = session.beginTransaction();

                String flightId = transientInstance.getFlight().getFlightId();

                String queryString1 = "update TicketInfo tf set tf.economyClassTicket = tf.economyClassTicket-1 where tf.flight.flightId='" + flightId+"'";


                Query queryObject = session.createQuery(queryString1);
                queryObject.executeUpdate();

                tran.commit();
            }


        } catch (RuntimeException re) {
            System.out.println("error");
            throw re;
        }

    }
//    public void refresh(){
//        System.out.println("execute --updateStatus()-- method.");
//        Transaction tran = null;
//        Session session = null;
//
//        try {
//            session = getSession();
//            tran = session.beginTransaction();
//            Date date =new Date();
//            Timestamp ts = new Timestamp(date.getTime());
//            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String tss = sdf.format(ts);
//           String queryString = "update Order o set  o.status = 2 where o.status = 1 and o.flight.departureTime < '"+tss+"'";
////            String queryString = "update Order o set o.status = 2 where o.status = 1 and o.flight.departureTime <?0";
//            //String queryString = "update Order o set o.status = 2 where o.status = 1 and o.flight.departureTime <?0";
//            Query queryObject = session.createQuery(queryString);
//            //queryObject.setTimestamp(0,date);
//            queryObject.executeUpdate();
//
//
//            tran.commit();
//
//
//        } catch (RuntimeException re) {
//            System.out.println("error");
//            throw re;
//        }
//    }
    public void refresh(){
        System.out.println("execute --updateStatus()-- method.");
        Transaction tran = null;
        Session session = null;

        try {
            session = getSession();
            Date date =new Date();
            String queryString="from Order as o where o.flight.departureTime<?1 and o.status = 1";
            Query queryObject = session.createQuery(queryString);
            queryObject.setTimestamp(1,date);
            List<Order> list=queryObject.list();
            for(Order o:list){
                Transaction tran1 = null;
                Session session1 = null;
                session1=getSession();
                queryString="update Order as o set o.status= 2,o.orderStatus = '已过期'  where o.orderId=?1";

                tran1=session1.beginTransaction();
                queryObject=session1.createQuery(queryString);
                queryObject.setInteger(1,o.getOrderId());
                queryObject.executeUpdate();
                tran1.commit();
                session1.close();
            }




        } catch (RuntimeException re) {
            System.out.println("error");
            throw re;
        }
        finally {
            session.close();
        }
    }

    public void refund(Order transientInstance) {
        System.out.println("execute --updateStatus()-- method.");
        Transaction tran = null;
        Session session = null;
        try {
            System.out.println(transientInstance.getTicketType());
            if(transientInstance.getTicketType()==1){
                session = getSession();
                tran = session.beginTransaction();

                int orderId =transientInstance.getOrderId();
                String flightId = transientInstance.getFlight().getFlightId();

                String queryString1 = "update TicketInfo tf set tf.firstClassTicket = tf.firstClassTicket+1 where tf.flight.flightId='" + flightId+"'";
                String queryString2 = "update Order o set o.orderStatus = '"+"已退票"+"' , o.status = 3 where o.orderId=" + orderId;

                Query queryObject = session.createQuery(queryString1);
                queryObject.executeUpdate();
                queryObject = session.createQuery(queryString2);
                queryObject.executeUpdate();

                tran.commit();
            }
            else if(transientInstance.getTicketType()==2){
                session = getSession();
                tran = session.beginTransaction();

                int orderId =transientInstance.getOrderId();
                String flightId = transientInstance.getFlight().getFlightId();

                String queryString1 = "update TicketInfo tf set tf.businessClassTicket = tf.businessClassTicket+1 where tf.flight.flightId='" + flightId+"'";
                String queryString2 = "update Order o set o.orderStatus = '"+"已退票"+"' , o.status = 3 where o.orderId=" + orderId;

                Query queryObject = session.createQuery(queryString1);
                queryObject.executeUpdate();
                queryObject = session.createQuery(queryString2);
                queryObject.executeUpdate();

                tran.commit();
            }
            else if(transientInstance.getTicketType()==3){
                session = getSession();
                tran = session.beginTransaction();

                int orderId =transientInstance.getOrderId();
                String flightId = transientInstance.getFlight().getFlightId();

                String queryString1 = "update TicketInfo tf set tf.economyClassTicket = tf.economyClassTicket+1 where tf.flight.flightId='" + flightId+"'";
                String queryString2 = "update Order o set o.orderStatus = '"+"已退票"+"' , o.status = 3 where o.orderId=" + orderId;

                Query queryObject = session.createQuery(queryString1);
                queryObject.executeUpdate();
                queryObject = session.createQuery(queryString2);
                queryObject.executeUpdate();

                tran.commit();
            }


        } catch (RuntimeException re) {
            System.out.println("error");
            throw re;
        }
        finally {
            session.close();
        }
    }
}