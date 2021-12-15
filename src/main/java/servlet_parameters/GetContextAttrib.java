package servlet_parameters;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns="/contextAttribute")
public class GetContextAttrib extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) 
                      throws ServletException, IOException
                      {response.setContentType(CONTENT_TYPE);

        ServletContext ctx = getServletContext();
        Double d = (Double)ctx.getAttribute("newRate");
        String message = (String) request.getAttribute("theMessage");
        double rate = d.doubleValue();

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>GetContextAttrib</title></head>");
        out.println("<body>");
        out.println("Someone set the rate to " + rate + message + "!");
        out.println("</body></html>");
        out.close();
    }
}
