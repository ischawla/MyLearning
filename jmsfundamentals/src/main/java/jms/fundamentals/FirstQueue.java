package jms.fundamentals;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
public class FirstQueue {
	public static void main(String[] args) {
		InitialContext ic = null;
		Connection con = null;
		try {
			ic = new InitialContext();
			ConnectionFactory cf = (ConnectionFactory) ic.lookup("ConnectionFactory");
			con = cf.createConnection("admin", "admin");
			Session sess = con.createSession();
			Queue que = (Queue) ic.lookup("queue/myQueue");
			// sending a Text message
			MessageProducer producer = sess.createProducer(que);
			TextMessage msg = sess.createTextMessage("I am first JMS message");
			producer.send(msg);
			System.out.println("Msg sent: "+ msg.getText());
			
			//Receiving a Text message
			MessageConsumer consumer = sess.createConsumer(que);
			con.start(); // To receive a message, we need to start the connection.
			TextMessage receivedMessage = (TextMessage) consumer.receive();
			System.out.println("Received Msg: " + receivedMessage.getText());
			
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}finally {
			if(ic!=null) {
				try {
					ic.close();
				} catch (NamingException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
