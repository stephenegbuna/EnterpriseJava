package controller_facilities;

import javax.servlet.*;


public class GlobalMessageListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        String message = sc.getInitParameter("globalMessage");
        Messages m = new Messages(message);
        sc.setAttribute("mess", m);
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
