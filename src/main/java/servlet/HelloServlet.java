package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
	IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>HelloServlet</title></head>");
		out.println("<body>");
		out.println("This is a servlet");
		out.println("</body></html>");
		out.close();
	}
}
