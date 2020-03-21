/*
 * Copyright(c)2002-2019
 *    项目名称:ARS55version
 *    文件名称:CityFilter.java
 *    Date:2019/12/25 下午7:50
 *    Author:高源
 */


package filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*确保每次有访问index.jsp的请求和访问index2.jsp时，cityMap已经在session中*/
public class CityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String URI = request.getRequestURI();
        //访问的是index.jsp和index2.jsp且city==null
        if (URI.indexOf("index2") != -1 && session.getAttribute("cityMap") == null) {
            response.sendRedirect(request.getContextPath() + "/setCityForIndex2Action.action");
            return;
        }
        if (URI.indexOf("index") != -1 && session.getAttribute("cityMap") == null) {
            response.sendRedirect(request.getContextPath() + "/setCityAction.action");
            return;
        }
        filterChain.doFilter(request, response);
        return;
    }
}
