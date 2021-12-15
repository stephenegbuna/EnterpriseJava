package servlet_parameters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns="/contextparam",
		initParams= {
				@WebInitParam(name="message", value="welcome")
		})
public class ContextParamServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        //looks for <init-param> in WEB.XML entry for this servlet
        String localMessage = getInitParameter("message");
        //looks for <context-param> in WEB.XML for the whole application
        ServletContext ctx = getServletContext();
        String globalMessage = ctx.getInitParameter("globalMessage");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
        "<html>\n" +
        "  <head>\n" +
        "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\"></meta>\n" +
        "    <title>Customer Details</title>\n" +
        "    <style type=\"text/css\">\n" +
        "      body {\n" +
        "      background-image: url(\"formback.gif\"); \n" +
        "}\n" +
        "    </style>\n" +
        "  </head>\n" +
        "  <body>Hello, good evening and " + localMessage + " " + globalMessage +
        "  <img src=dept20.gif height=125 width=133/>" +
        "  </body>\n" +
        "</html>");
    }
}
