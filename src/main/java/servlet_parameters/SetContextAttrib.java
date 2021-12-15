package servlet_parameters;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/setcontext")
public class SetContextAttrib extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {response.setContentType(CONTENT_TYPE);
        // Dynamically set a context attribute
        ServletContext ctx = getServletContext();
        ctx.setAttribute("newRate", new Double(0.05));

        // Forwarding a request attribute requires a RequestDispatcher object
        // Forwarding passes control to the other Servlet
        /*String message = " so pay up";
        request.setAttribute("theMessage", message);
        RequestDispatcher send = request.getRequestDispatcher("GetContextAttrib");
        send.forward(request, response);*/
        
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>SetContextAttrib</title></head>");
        out.println("<body>");
        out.println("<p>Rate set to 0.05</p>");
        out.println("</body></html>");
        out.close();
    }
}