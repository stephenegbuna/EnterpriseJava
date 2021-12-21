package jms;

import java.io.IOException;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/posttoqueue")
public class PostToQueue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		ServletOutputStream out = response.getOutputStream();

		String message = request.getParameter("message");
		if (message.equals("")) {
			out.print("Enter a message to post to the queue");
		} else {
			try {
				QueueConnectionFactory qconFactory;
				QueueConnection qcon;
				QueueSession qsession;
				QueueSender qsender;
				Queue queue;
				TextMessage msg;

				InitialContext ic = new InitialContext();

				//qconFactory = (QueueConnectionFactory) ic.lookup("javax.jms.QueueConnectionFactory");
				qconFactory = (QueueConnectionFactory) ic.lookup("java:/ConnectionFactory");
				qcon = qconFactory.createQueueConnection();
				qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

				queue = (Queue) ic.lookup("java:/jms/HRQueue");

				qsender = qsession.createSender(queue);
				msg = qsession.createTextMessage();
				qcon.start();

				msg.setText(message);
				qsender.send(msg);
				System.out.println("The message, " + message + ", has been sent to the HRQueue.");

				out.print("<FONT SIZE='4' COLOR='navy'>");
				out.print("Your message has been posted<BR>");
				out.print("Monitor the message in the Administration Console<BR>");
				out.print("</FONT>");
				qsender.close();
				qsession.close();
				qcon.close();
			} catch (Exception e) {
				System.out.print("error " + e);
			}
		}
		out.print("<BR><A HREF='./welcome.html'>Back To Home Page</A><BR>");
	}

}
