package servlet_parameters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns="/session")
public class SessionServlet2 extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) throws ServletException, IOException {response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        /*We're not using the HttpSession object below, but the getSession()
         * method fails to retrieve a session id if cookies are disabled on the
         * browser. The container then tries URL rewriting as well as cookies.
         * If it's commented out the container can't rewrite the URL.
        */
        HttpSession session = request.getSession();
        out.println("<html><body>");
        out.println("<a href=\"" + 
        response.encodeURL("session") + 
        "\">click here to append a jsessionid</a>");
        out.println("</body></html>");
        out.close();
    }
}
