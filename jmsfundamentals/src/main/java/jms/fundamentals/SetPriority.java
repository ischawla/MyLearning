package jms.fundamentals;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
public class SetPriority {
	public static void main(String[] args) throws NamingException {
		InitialContext ic = new InitialContext();
		Queue que = (Queue) ic.lookup("queue/myQueue");
		try(ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
				JMSContext jmsContext = cf.createContext("admin", "admin")){
					
			JMSProducer producer = jmsContext.createProducer();
			String[] msgArray = new String[3];
			msgArray[0] = "Message 1";
			msgArray[1] = "Message 2";
			msgArray[2] = "Message 3";
			
			producer.setPriority(7);
			producer.send(que, msgArray[0]);
			
			producer.setPriority(8);
			producer.send(que, msgArray[1]);
			
			producer.setPriority(9);
			producer.send(que, msgArray[2]);
			
			JMSConsumer consumer = jmsContext.createConsumer(que);
			for(int i=0;i<3;i++) {
				System.out.println("Received Msg: " + consumer.receiveBody(String.class));	
			}
		}
	}
}
