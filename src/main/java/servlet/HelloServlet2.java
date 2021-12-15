/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class HelloServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
	IOException {
		String message = request.getParameter("message");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>HelloServlet</title></head>");
		out.println("<body>");
		out.println("Hello " + message);
		out.println("</body></html>");
		out.close();
	}
}
