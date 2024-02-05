package jms.fundamentals;
import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
public class QueueBrowserDemo {
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
			TextMessage msg1 = sess.createTextMessage("Msg1 : I am first JMS message");
			TextMessage msg2 = sess.createTextMessage("Msg 2: I am second JMS message");
			producer.send(msg1);
			producer.send(msg2);
			QueueBrowser qb = sess.createBrowser(que);
			Enumeration enumMsg = qb.getEnumeration();
			while(enumMsg.hasMoreElements()) {
				TextMessage eachMsg = (TextMessage)enumMsg.nextElement();
				System.out.println("Each Message: "+ eachMsg.getText());
			}
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
