package service;

import com.opensymphony.xwork2.ActionContext;
import dao.*;
import po.Flight;
import po.Orders;
import po.TicketInfo;
import po.User;

import java.util.*;

/**
 * @author:jinjiaobo
 * @date:2019/12/28
 * @description:
 */
public class OrderService implements IOrdersService {
    private IOrdersDAO ordersDAO = null;
    private ITicketinfoDAO ticketinfoDAO = null;
    private IFlightDAO flightDAO = null;

    public IFlightDAO getFlightDAO() {
        return flightDAO;
    }

    public void setFlightDAO(IFlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    public IOrdersDAO getOrdersDAO() {
        return ordersDAO;
    }

    public void setOrdersDAO(IOrdersDAO ordersDAO) {
        this.ordersDAO = ordersDAO;
    }

    public ITicketinfoDAO getTicketinfoDAO() {
        return ticketinfoDAO;
    }

    public void setTicketinfoDAO(ITicketinfoDAO ticketinfoDAO) {
        this.ticketinfoDAO = ticketinfoDAO;
    }

    @Override
    public String save(List<Orders> orders, Flight flight) {
        List<Orders> list = ordersDAO.findByAccountID();
        Set<String> idCards = new HashSet<>();
        for (int i = 0; i < orders.size(); i++) {
            idCards.add(orders.get(i).getIdCard());
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getFlight().getFlightId().equals(flight.getFlightId())) {
                if (idCards.contains(list.get(i).getIdCard())) {
                    return "存在用户已经购买";
                }
            }
        }
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getTicketType() == 1) {
                a++;
            } else if (orders.get(i).getTicketType() == 2) {
                b++;
            } else {
                c++;
            }
        }
        TicketInfo ticketInfo = ticketinfoDAO.findByFlightId(flight);
        int a1 = ticketInfo.getFirstClassTicket();
        int b1 = ticketInfo.getBusinessClassTicket();
        int c1 = ticketInfo.getEconomyClassTicket();
        System.out.println("slakdgldkfjg");
        Flight flight1 = flightDAO.findByFlight1(flight);
        //Flight flight1 = flightDAO.findByFlight1(flight);
        System.out.println(flight1.getArrivalTime());
        if (a1 < a || b1 < b || c1 < c) {
            return "fail";
        } else {
            ticketInfo.setFirstClassTicket(a1-a);
            ticketInfo.setBusinessClassTicket(b1-b);
            ticketInfo.setEconomyClassTicket(c1-c);
            ticketInfo.setFlight(flight1);
            ticketinfoDAO.update(ticketInfo);
        }
        ActionContext cxt=ActionContext.getContext();
        Map<String,Object> session1=cxt.getSession();
        User user = (User)session1.get("user");
        String account = user.getAccount();
        for (int i = 0; i < orders.size(); i++) {
            orders.get(i).setFlight(flight1);
            orders.get(i).setAccount(account);
            ordersDAO.save(orders.get(i));
        }
        return "success";
    }

    @Override
    public List<Orders> findByAccount() {
        List<Orders> list = new ArrayList<>();
        List<Orders> list1 = ordersDAO.findByAccountID();
        for (int i = 0; i <list1.size(); i++) {
            if (list1.get(i).getStatus()== 2) {
                list.add(list1.get(i));
            }
        }
        return list;
    }

    @Override
    public List<Orders> findByAcc() {
        List<Orders> list = new ArrayList<>();
        List<Orders> list1 = ordersDAO.findByAccountID();
        for (int i = 0; i <list1.size(); i++) {
            if (list1.get(i).getStatus()== 1) {
                list.add(list1.get(i));
            }
        }
        return list;
    }

    //退票
    @Override
    public String refundTicket(Orders order) {
        Orders orders = ordersDAO.findByOrderID(order);
        orders.setStatus(3);
        orders.setOrderStatus("已退票");
        ordersDAO.update(orders);
        int i = orders.getTicketType();
        TicketInfo ticketInfo = ticketinfoDAO.findByFlightId(orders.getFlight());
        if (i == 1) {
            ticketInfo.setFirstClassTicket(ticketInfo.getFirstClassTicket()+1);
        } else if (i == 2) {
            ticketInfo.setBusinessClassTicket(ticketInfo.getBusinessClassTicket()+1);
        } else {
            ticketInfo.setEconomyClassTicket(ticketInfo.getEconomyClassTicket()+1);
        }
        ticketinfoDAO.update(ticketInfo);
        return "success";
    }
}
