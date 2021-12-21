package beans;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: MDB1
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
			@ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/HRQueue")
		})
public class MDB1 implements MessageListener {

    public void onMessage(Message message) {
		TextMessage msg = null;
		try {
			if (message instanceof TextMessage) {
				msg = (TextMessage) message;
				System.out.println("Your message is : " + msg.getText());
			} else {
				System.out.println("Invalid message : " +
					message.getClass().getName());
			}
		} catch (JMSException e) {
			System.err.println("BasicMDB.onMessage: " +"JMSException: " + e);
		} catch (Throwable te) {
			System.err.println("BasicMDB.onMessage: " + "Exception: " + te);
		}
    }

}
