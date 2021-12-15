package servlet_parameters;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/spy")
public class SpyServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {response.setContentType(CONTENT_TYPE);

        HttpSession session = request.getSession();
        String id = session.getId();
        long createTime = session.getCreationTime();
        long lastTime = session.getLastAccessedTime();

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>SpyServlet</title></head>");
        out.println("<body>");
        out.println("We're watching you" + "<BR>");
        out.println("ID "  + id + "<BR>");
        out.println("Created at " + createTime + "<BR>");
        out.println("Last accessed " + lastTime + "<BR>");
        out.println("So behave citizen.");
        out.println("</body></html>");
        out.close();
    }
}