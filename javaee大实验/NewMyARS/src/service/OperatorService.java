package service;
import java.util.Date;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import dao.BaseHibernateDAO;
import dao.AirplaneDAO;
import dao.AirportDAO;
import dao.CityDAO;
import dao.FlightDAO;
import dao.OrderDAO;
import dao.PassengerDAO;
import dao.TicketInfoDAO;
import dao.UserDAO;

import dao.IAirplaneDAO;
import dao.IAirportDAO;
import dao.ICityDAO;
import dao.IFlightDAO;
import dao.IOrderDAO;
import dao.IPassengerDAO;
import dao.ITicketInfoDAO;
import dao.IUserDAO;

import po.Airplane;
import po.Airport;
import po.City;
import po.Flight;
import po.Order;
import po.Passenger;
import po.TicketInfo;
import po.User;

public class OperatorService implements IOperatorService{
    private IAirplaneDAO airplaneDAO = null;
    private IAirportDAO airportDAO = null;
    private ICityDAO cityDAO = null;
    private IFlightDAO flightDAO = null;
    private IOrderDAO orderDAO = null;
    private IPassengerDAO passengerDAO = null;
    private ITicketInfoDAO ticketInfoDAO = null;
    private IUserDAO userDAO = null;
    private Map<String, Object> request, session;

    public OperatorService(){
    }
    public void setAirplaneDAO(IAirplaneDAO airplaneDAO) {
        this.airplaneDAO = airplaneDAO;
    }
    public void setAirportDAO(IAirportDAO airportDAO) {
        this.airportDAO = airportDAO;
    }
    public void setCityDAO(ICityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }
    public void setFlightDAO(IFlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }
    public void setOrderDAO(IOrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
    public void setPassengerDAO(IPassengerDAO passengerDAO) {
        this.passengerDAO = passengerDAO;
    }
    public void setTicketInfoDAO(ITicketInfoDAO ticketInfoDAO) {
        this.ticketInfoDAO = ticketInfoDAO;
    }
    public void setUserDAO(IUserDAO userDAO) {this.userDAO = userDAO;}
    public boolean register(Airplane transientInstance){
//        try {
//            this.AirplaneDAO.save(transientInstance);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
        this.airplaneDAO.save(transientInstance);
        return true;
    }
    public boolean refresh1(){
        ActionContext ctx= ActionContext.getContext();
        request=(Map) ctx.get("request");
        session = ctx.getSession();
        orderDAO.refresh();//更新
        String hql2 = "from Flight ";
        List flightList = flightDAO.findByHQL(hql2);
        session.put("flightList", flightList);

        return true;
    }
    public boolean login(User transientInstance){

        ActionContext ctx= ActionContext.getContext();
        request=(Map) ctx.get("request");
        session = ctx.getSession();
        String account = transientInstance.getAccount();
        String password = transientInstance.getPassword();
        int type = 2;
        String hql = "from User where account='" + account + "' and password='" + password +"' and type='" + type + "'";
        System.out.println(hql);
        List list = userDAO.findByHQL(hql);
        if (list.isEmpty()) return false;
        else{
            request.put("tip", "登录成功！");
            User loginUser=(User)list.get(0);
            session.put("loginUser", loginUser);
            String hql2 = "from Flight ";
            List flightList = flightDAO.findByHQL(hql2);
            session.put("flightList", flightList);


            return true;
        }
    }

    public boolean flightInfo(Flight transientInstance){
        ActionContext ctx= ActionContext.getContext();
        request=(Map) ctx.get("request");
        session = ctx.getSession();
        orderDAO.refresh();//更新
        String hiddenFID = transientInstance.getFlightId();
        String hql = "from Order as o where o.flight.flightId='" + hiddenFID + "'";
        String hql2 = "from Flight where flightId='" + hiddenFID + "'";
        System.out.println(hql);
        List orderInfoList = orderDAO.findByHQL(hql);
        List flightList = flightDAO.findByHQL(hql2);

        if (flightList.isEmpty()) return false;
        else{
            Flight flight = (Flight)flightList.get(0);
            long time = 30*60*1000;
            long getdepartureTime = flight.getDepartureTime().getTime()-time;
            Date nowDate = new Date();
            long getnowDate = nowDate.getTime();
            boolean istimeout = false;
            if(getnowDate-getdepartureTime>0)istimeout = true;//超时
            session.put("istimeout",istimeout);
            session.put("flightid",hiddenFID);
            session.put("flight",flight);
            session.put("orderInfoList", orderInfoList);
            return true;
        }
    }



    public boolean alterOrder(Order transientInstance){
        ActionContext ctx= ActionContext.getContext();
        request=(Map) ctx.get("request");
        session = ctx.getSession();
        long time = 30*60*1000;
        long getdepartureTime = transientInstance.getFlight().getDepartureTime().getTime()-time;
        Date nowDate = new Date();
        long getnowDate = nowDate.getTime();
        if(getnowDate-getdepartureTime>0)return false;//超时
        else{
            session.put("nowDate",nowDate);
            orderDAO.refund(transientInstance);
//            Flight flight = (Flight)session.get("flight");
//            String flightId = flight.getFlightId();
            String flightId = (String)session.get("flightid");
            String hql = "from Order as o where o.flight.flightId='" + flightId + "'";
            String hql1 = "from Flight where flightId='" + flightId + "'";
            List flightList = flightDAO.findByHQL(hql1);
            Flight flight = (Flight)flightList.get(0);
            session.put("flight",flight);
            List orderInfoList = orderDAO.findByHQL(hql);
            if (orderInfoList.isEmpty()) return false;
            else{
                session.put("orderInfoList", orderInfoList);
                return true;
            }
        }
    }
    public boolean checkTicket(){
        ActionContext ctx= ActionContext.getContext();
        request=(Map) ctx.get("request");
        session = ctx.getSession();
        Flight flight = (Flight)session.get("flight");
        List list = new ArrayList<>();
        String hql = "from Flight where flightId='" + flight.getFlightId() + "'";
        List flightList = flightDAO.findByHQL(hql);
        Flight nflight = (Flight)flightList.get(0);
        session.put("flight",nflight);

        long mtime = 30*60*1000;
        long getdepartureTime = flight.getDepartureTime().getTime()-mtime;
        Date nowDate = new Date();
        long getnowDate = nowDate.getTime();
        System.out.println(getnowDate-getdepartureTime);
        if(getnowDate-getdepartureTime>0)return false;//超时

        int firstClassTicket = nflight.getTicketInfo().getFirstClassTicket();
        int businessClassTicket = nflight.getTicketInfo().getBusinessClassTicket();
        int economyClassTicket = nflight.getTicketInfo().getEconomyClassTicket();

        if(firstClassTicket == 0 && businessClassTicket == 0 && economyClassTicket == 0) return false;
        else{
            if(firstClassTicket > 0)list.add("头等舱");
            if(businessClassTicket > 0)list.add("商务舱");
            if(economyClassTicket > 0)list.add("经济舱");
            request.put("list",list);
            return true;
        }

    }

    public boolean buyTicket(Order transientInstance,String ticketType){
        ActionContext ctx= ActionContext.getContext();
        request=(Map) ctx.get("request");
        session = ctx.getSession();
        Flight flight = (Flight)session.get("flight");

        long mtime = 30*60*1000;
        long getdepartureTime = flight.getDepartureTime().getTime()-mtime;
        Date nowDate = new Date();
        long getnowDate = nowDate.getTime();
        System.out.println(getnowDate-getdepartureTime);
        if(getnowDate-getdepartureTime>0)return false;//超时

        int IticketType = 0 ;
        String hql = "from Order as o where o.idCard='" + transientInstance.getIdCard() + "' and ( o.status = 1 or o.status = 2 )";
        List orderInfoList = orderDAO.findByHQL(hql);
        if(orderInfoList.isEmpty()){
            if(ticketType.equals("头等舱")){
                IticketType = 1;
            }
            else if(ticketType.equals("商务舱")){
                IticketType = 2;
            }
            else if(ticketType.equals("经济舱")){
                IticketType = 3;
            }
            transientInstance.setOrderStatus("已购");
            transientInstance.setStatus(1);
            transientInstance.setTicketType(IticketType);
            transientInstance.setFlight(flight);
            Date time = new Date();
            transientInstance.setOrderTime(time);
            orderDAO.buyTicketFromTI(transientInstance);
            orderDAO.save(transientInstance);

            String flightId = flight.getFlightId();
            String hql2 = "from Order as o where o.flight.flightId='" + flightId + "'";
            String hql3 = "from Flight where flightId='" + flightId + "'";

            List flightList = flightDAO.findByHQL(hql3);
            Flight nflight = (Flight)flightList.get(0);
            session.put("flight",nflight);
            List orderInfoList2 = orderDAO.findByHQL(hql2);
            session.put("orderInfoList", orderInfoList2);

            return true;
        }
        else{
            return false;
        }
    }
}
