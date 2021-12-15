package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class FormServlet extends HttpServlet {
    //private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                      throws ServletException, IOException {
        //response.setContentType(CONTENT_TYPE);
        display (request, response);

    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
                      throws ServletException, IOException {
        display (request, response);
    }

    private void display(HttpServletRequest request,
                      HttpServletResponse response)
                      throws ServletException, IOException {

        String fn = request.getParameter("firstName");
        String ln = request.getParameter("lastName");
        String tel = request.getParameter("tel");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>FormServlet</title></head>");
        out.println("<body>");
        out.println("First Name: " + fn + "<BR>");
        out.println("Last Name: " + ln + "<BR>");
        out.println("Telephone: " + tel + "<BR>");
        out.println("</body></html>");
        out.close();
    }
}
