/*
 * Copyright(c)2002-2019
 *    项目名称:ARS55version
 *    文件名称:SpringEnvTest.java
 *    Date:2019/12/27 下午7:44
 *    Author:高源
 */

package app;

import dao.IFlightDAO;
import dao.IUserDAO;
import dao.UserDAO;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import po.Flight;
import po.User;
import service.IUserService;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SpringEnvTest {
    public static void main(String[] args){
        FileSystemResource isr = new
                FileSystemResource("web/WEB-INF/applicationContext.xml");
        XmlBeanFactory factory = new XmlBeanFactory(isr);
        User user=new User();
        user.setAccount("178573421");
        user.setPassword("123456");
        user.setType(3);
        IFlightDAO flightDAO=(IFlightDAO)factory.getBean("flightDAO");
        Flight flight=new Flight();
        flight.setFlightId("GD0002");
        Flight flights=flightDAO.findByFlight1(flight);

        System.out.println(flights.getArrivalTime());
//        User user = userDAO.getUserByID("admin");
//        System.out.println(user.getPassword());
//        System.out.println(user.getType());
//        IUserService userService =(IUserService) factory.getBean("userService");
//        userService.addUser(user);
//        Date date=new Date();
//        Calendar calendar = new GregorianCalendar();
//
//        calendar.setTime(new Date());
//
//        date=calendar.getTime();
//
//        System.out.println(date.getYear());
//        System.out.println(date.getMonth());
//        System.out.println(date.getDay());
//        System.out.println(date.getHours());
//        System.out.println(date.getMinutes());

    }
}
