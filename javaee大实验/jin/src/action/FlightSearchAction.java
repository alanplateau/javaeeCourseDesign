/*
 * Copyright(c)2002-2019
 *    项目名称:ARS55version
 *    文件名称:FlightSearchAction.java
 *    Date:2019/12/25 下午7:50
 *    Author:高源
 */



package action;

import service.IFlightService;

import java.text.DecimalFormat;
import java.util.Date;

public class FlightSearchAction {
    private String fromCity;
    private String toCity;
    private Date departureTime;
    private IFlightService flightService=null;

    public String searchFlight(){
        System.out.println(fromCity);
        System.out.println(toCity);
        System.out.println(departureTime);
        System.out.println("--------------以上为传过来的数据------------------------------");
        if (flightService.searchFlight(fromCity, toCity, departureTime)) {
            return "success";
        }
        else {
            return "error";
        }
    }

    //double型的数值若为整数，则格式化为不带小数点，若不为整数，则格式化为小数点后一位
    public String formatDouble(double s){
        if(s-(int)s==0){
            DecimalFormat fmt = new DecimalFormat("#");
            return fmt.format(s);
        }
        DecimalFormat fmt = new DecimalFormat("#.##");
        return fmt.format(s);
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }


    public IFlightService getFlightService() {
        return flightService;
    }

    public void setFlightService(IFlightService flightService) {
        this.flightService = flightService;
    }
}
