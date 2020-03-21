/*
 * Copyright(c)2002-2019
 *    项目名称:ARS55version
 *    文件名称:personalInfoFilter.java
 *    Date:2019/12/29 下午2:11
 *    Author:高源
 */

package filter;



import po.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class personalInfoFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String URI = request.getRequestURI();
        if(URI.indexOf("addPassenger")!=-1||URI.indexOf("favoriteContacts")!=-1||
                URI.indexOf("findingUsingFlight")!=-1 ||URI.indexOf("personalInformation")!=-1){
            User user = (User) session.getAttribute("user");
            if(user==null){
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }
        }
        filterChain.doFilter(request,response);
    }
}
