package action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import po.Airplane;
import po.Airport;
import po.Flight;
import po.User;
import service.IAdminService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author 王怡静
 * @Date 2019-12-08 01:17
 * @Version 1.0
 */
public class AdminAction extends ActionSupport {
    private List airplanes;
    private List airports;
    private List flights;
    private List managers;
    private Airplane airplane;
    private Airport airport;
    private Flight flight;
    private User manager;
    private IAdminService adminServ;

    public List getAirplanes() {
        return airplanes;
    }
    public void setAirplanes(List airplanes) {
        this.airplanes = airplanes;
    }
    public List getAirports() {
        return airports;
    }
    public void setAirports(List airports) {
        this.airports = airports;
    }
    public List getFlights() {
        return flights;
    }
    public void setFlights(List flights) {
        this.flights = flights;
    }
    public List getManagers() {
        return managers;
    }
    public void setManagers(List managers) {
        this.managers = managers;
    }
    public Airplane getAirplane() {
        return airplane;
    }
    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }
    public Airport getAirport() {
        return airport;
    }
    public void setAirport(Airport airport) {
        this.airport = airport;
    }
    public Flight getFlight() {
        return flight;
    }
    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    public User getManager() {
        return manager;
    }
    public void setManager(User manager) {
        this.manager = manager;
    }
    public void setAdminServ(IAdminService adminServ) {
        this.adminServ = adminServ;
    }

    public String execute(){
        HttpServletRequest request= ServletActionContext.getRequest();
        String method=request.getParameter("method");
        System.out.println("现在要执行的操作："+method);
        if(method==null){
            return "loadFlight";
        }

        //-------------------------------对飞机信息的操作------------------------------------
        else if(method.equals("loadAirplane")){
            airplanes=adminServ.loadAirplane();
            return "loadAirplane";
        }

        else if(method.equals("delAirplane")){
            if(airplane==null){
                this.addActionMessage("未检测到要删除的飞机信息！");
            }else{
                if(airplane.getAirplaneId().equals("")) {
                    this.addActionMessage("飞机编号不能为空！");
                }else if(!adminServ.checkAirplaneExist(airplane.getAirplaneId())){
                    this.addActionMessage("此飞机编号不存在！");
                }else{
                    adminServ.deleteAirplane(airplane);
                }
                airplane=null;
            }
            return "airplaneSuccess";
        }

        else if (method.equals("altAirplane")){
            if(airplane==null){
                this.addActionMessage("未检测到要修改的飞机信息！");
            }else{
                if(airplane.getAirplaneId().equals("")) {
                    this.addActionMessage("飞机编号不能为空！");
                }else if(!adminServ.checkAirplaneExist(airplane.getAirplaneId())){
                    this.addActionMessage("此飞机编号不存在！");
                }else{
                    adminServ.updateAirplane(airplane);
                }
                airplane=null;
            }
            return "airplaneSuccess";
        }

        else if (method.equals("addAirplane")){
            if (airplane == null) {
                this.addActionMessage("未检测到要增加的飞机信息！");
            }else{
                if(airplane.getAirplaneId().equals("")) {
                    this.addActionMessage("飞机编号不能为空！");
                }else if(adminServ.checkAirplaneExist(airplane.getAirplaneId())){
                    this.addActionMessage("此飞机编号已存在！");
                }else {
                    adminServ.addAirplane(airplane);
                }
                airplane=null;
            }
            return "airplaneSuccess";
        }


        //-------------------------------对机场信息的操作------------------------------------
        else if(method.equals("loadAirport")){
            airports=adminServ.loadAirport();
            return "loadAirport";
        }

        else if(method.equals("delAirport")){
            if(airport==null){
                this.addActionMessage("未检测到要删除的机场信息！");
            }else{
                if(airport.getAirportId().equals("")){
                    this.addActionMessage("机场编号不能为空！");
                }else if(!adminServ.checkAirportExist(airport.getAirportId())){
                    this.addActionMessage("此机场编号不存在！");
                }else{
                    adminServ.deleteAirport(airport);
                }
                airport=null;
            }
            return "airportSuccess";
        }

        else if(method.equals("altAirport")){
            if(airport==null){
                this.addActionMessage("未检测到要修改的机场信息！");
            }else{
                if(airport.getAirportId().equals("")){
                    this.addActionMessage("机场编号不能为空！");
                }else if(!adminServ.checkAirportExist(airport.getAirportId())){
                    this.addActionMessage("此机场编号不存在！");
                }else{
                    adminServ.updateAirport(airport);
                }
                airport=null;
            }
            return "airportSuccess";
        }

        else if (method.equals("addAirport")){
            if(airport==null){
                this.addActionMessage("未检测到要增加的机场信息！");
            }else{
                if(airport.getAirportId().equals("")){
                    this.addActionMessage("机场编号不能为空！");
                }else if(adminServ.checkAirportExist(airport.getAirportId())){
                    this.addActionMessage("此机场编号已存在！");
                }else{
                    adminServ.addAirport(airport);
                }
                airport=null;
            }
            return "airportSuccess";
        }


        //-------------------------------对航班信息的操作------------------------------------
        else if (method.equals("loadFlight")){
            airplanes=adminServ.loadAirplane();
            airports=adminServ.loadAirport();
            flights=adminServ.loadFlight();
            return "loadFlight";
        }

        else if (method.equals("delFlight")){
            if(flight==null){
                this.addActionMessage("未检测到要删除的航班信息！");
            }else{
                if(flight.getFlightId().equals("")){
                    this.addActionMessage("航班编号不能为空！");
                }else if(!adminServ.checkFlightExist(flight.getFlightId())){
                    this.addActionMessage("此航班编号不存在！");
                }else{
                    adminServ.deleteFlight(flight);
                }
                flight=null;
            }
            return "flightSuccess";
        }

        else if (method.equals("altFlight")){
            if(flight==null){
                this.addActionMessage("未检测到要修改的航班信息！");
            }else{
                System.out.println(flight.getDepartureTime());
                System.out.println(flight.getArrivalTime());

                if(flight.getFlightId().equals("")){
                    this.addActionMessage("航班编号不能为空！");
                }else if(!adminServ.checkFlightExist(flight.getFlightId())){
                    this.addActionMessage("此航班编号不存在！");
                }
                if(flight.getAirplane().getAirplaneId().equals("")){
                    this.addActionMessage("飞机编号不能为空！");
                }
                if(flight.getDepartureAirport().getAirportId().equals("")){
                    this.addActionMessage("始发机场名称不能为空！");
                }
                if(flight.getArrivalAirport().getAirportId().equals("")){
                    this.addActionMessage("目的机场名称不能为空！");
                }
                if(!flight.getDepartureAirport().getAirportId().equals("") && !flight.getArrivalAirport().getAirportId().equals("") && flight.getDepartureAirport().getAirportId().equals(flight.getArrivalAirport().getAirportId())){
                    this.addActionMessage("始发机场与目的机场名称不能相同！");
                }
                if(flight.getDepartureTime()!=null && flight.getArrivalTime()!=null && flight.getDepartureTime().compareTo(flight.getArrivalTime())>-1){
                    this.addActionMessage("始发时间应在到达时间之前！");
                }
                if(!this.hasActionMessages()){
                    adminServ.updateFlight(flight);
                }
                flight=null;
            }
            return "flightSuccess";
        }

        else if(method.equals("addFlight")){
            if(flight==null){
                this.addActionMessage("未检测到要增加的航班信息！");
            }else{
                if(flight.getFlightId().equals("")){
                    this.addActionMessage("航班编号不能为空！");
                }else if(adminServ.checkFlightExist(flight.getFlightId())){
                    this.addActionMessage("此航班编号已存在！");
                }
                if(flight.getAirplane().getAirplaneId().equals("")){
                    this.addActionMessage("飞机编号不能为空！");
                }
                if(flight.getDepartureAirport().getAirportId().equals("")){
                    this.addActionMessage("始发机场名称不能为空！");
                }
                if(flight.getArrivalAirport().getAirportId().equals("")){
                    this.addActionMessage("目的机场名称不能为空！");
                }
                if(!flight.getDepartureAirport().getAirportId().equals("") && !flight.getArrivalAirport().getAirportId().equals("") && flight.getDepartureAirport().getAirportId().equals(flight.getArrivalAirport().getAirportId())){
                    this.addActionMessage("始发机场与目的机场名称不能相同！");
                }
                if(flight.getDepartureTime()!=null && flight.getArrivalTime()!=null && flight.getDepartureTime().compareTo(flight.getArrivalTime())>-1){
                    this.addActionMessage("始发时间应在到达时间之前！");
                }
                if(!this.hasActionMessages()){
                    adminServ.addFlight(flight);
                }
                flight=null;
            }
            return "flightSuccess";
        }


        //-----------------------------对经办业务员的操作------------------------------------
        else if (method.equals("loadManager")){
            managers=adminServ.loadManager();
            return "loadManager";
        }

        else if (method.equals("delManager")){
            if(manager==null){
                this.addActionMessage("未检测到要删除的经办业务员信息！");
            }else{
                if(manager.getAccount().equals("")){
                    this.addActionMessage("业务员账号不能为空！");
                }else if(!adminServ.checkManagerExist(manager.getAccount())){
                    this.addActionMessage("此业务员账号不存在！");
                }else {
                    adminServ.deleteManager(manager);
                }
                manager=null;
            }
            return "managerSuccess";
        }

        else if (method.equals("altManager")){
            if(manager==null){
                this.addActionMessage("未检测到要修改的经办业务员信息！");
            }else{
                if (manager.getAccount().equals("")){
                    this.addActionMessage("业务员账号不能为空！");
                }else if (!adminServ.checkManagerExist(manager.getAccount())){
                    this.addActionMessage("此业务员账号不存在！");
                }
                if(manager.getPassword().equals("")){
                    this.addActionMessage("业务员密码不能为空！");
                }else if(manager.getPassword().length()<6 || manager.getPassword().length()>20){
                    this.addActionMessage("密码须在6-20位之间！");
                }
                if(!hasActionMessages()){
                    manager.setType(2);
                    adminServ.updateManager(manager);
                }
                manager=null;
            }
            return "managerSuccess";
        }

        else if (method.equals("addManager")){
            if(manager==null){
                this.addActionMessage("未检测到要增加的经办业务员信息！");
            }else{
                if (manager.getAccount().equals("")){
                    this.addActionMessage("业务员账号不能为空！");
                }else if (adminServ.checkManagerExist(manager.getAccount())){
                    this.addActionMessage("此业务员账号已存在！");
                }
                if(manager.getPassword().equals("")){
                    this.addActionMessage("业务员密码不能为空！");
                }else if(manager.getPassword().length()<6 || manager.getPassword().length()>20){
                    this.addActionMessage("密码须在6-20位之间！");
                }
                if(!hasActionMessages()){
                    manager.setType(2);
                    adminServ.addManager(manager);
                }
                manager=null;
            }
            return "managerSuccess";
        }


        return "fail";
    }
}
