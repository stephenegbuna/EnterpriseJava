package jms;

import java.io.IOException;

import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostToTopic
 */
@WebServlet("/posttotopic")
public class PostToTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		ServletOutputStream out = response.getOutputStream();

		String message = request.getParameter("message");
		if (message.equals("")) {
			out.print("Enter a message to post to the Topic");
		} else {
			try {
				TopicConnectionFactory tconFactory;
				TopicConnection tcon;
				TopicSession tsession;
				TopicPublisher tpublish;
				Topic topic;
				TextMessage msg;

				InitialContext ic = new InitialContext();

				tconFactory = (TopicConnectionFactory) ic.lookup("java:/ConnectionFactory");
				tcon = tconFactory.createTopicConnection();
				tsession = tcon.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

				topic = (Topic) ic.lookup("java:/jms/HRTopic");

				tpublish = tsession.createPublisher(topic);
				msg = tsession.createTextMessage();
				tcon.start();

				msg.setText(message);
				tpublish.publish(msg);
				System.out.println("The message, " + message + ", has been sent to HRTopic.");

				out.print("<FONT SIZE='4' COLOR='navy'>");
				out.print("Your message has been posted<BR>");
				out.print("Monitor the message in the Administration Console<BR>");
				out.print("</FONT>");

				tpublish.close();
				tsession.close();
				tcon.close();
			} catch (Exception e) {
				out.print("error " + e); 
			}

		}

		out.print("<BR><A HREF='./welcome.html'>Back To Home Page</A><BR>");

	}
}
