package jms.fundamentals;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
public class JmsContextDemo {
	public static void main(String[] args) throws NamingException {
		InitialContext ic = new InitialContext();
		Queue que = (Queue) ic.lookup("queue/myQueue");
		try(ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
				JMSContext jmsContext = cf.createContext("admin", "admin")){
			jmsContext.createProducer().send(que, "My first JMS2.0 message...");
			String msgReceived = jmsContext.createConsumer(que).receiveBody(String.class);
			System.out.println("Received Msg: " + msgReceived);
		}
	}
}
