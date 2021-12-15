package controller_facilities;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listener")
public class ListenerTester extends HttpServlet {
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListenerTester</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("Test context attributes set by listener<br>");
            out.println("<br>");
            Messages message = (Messages) getServletContext().getAttribute("mess");
            out.println("The global message is " + message.getMessage());
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    } 
}
