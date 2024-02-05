package jms.fundamentals;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
public class RequestReplyDemo {
	public static void main(String[] args) throws NamingException, JMSException {
		InitialContext ic = new InitialContext();
		Queue que = (Queue) ic.lookup("queue/requestQueue");
		Queue replyQue = (Queue) ic.lookup("queue/replyQueue");
		try(ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
				JMSContext jmsContext = cf.createContext("admin", "admin")){
			
			JMSProducer producer = jmsContext.createProducer();
			TextMessage msg = jmsContext.createTextMessage("Want to subscribe our channel? Reply YES PLEASE ..");
			msg.setJMSReplyTo(replyQue);
			producer.send(que, "Want to subscribe our channel? Reply YES PLEASE ..");
			
			JMSConsumer consumer = jmsContext.createConsumer(que);
			String msgReceived = consumer.receiveBody(String.class);
			System.out.println("Msg received by Consumer from Producer: " + msgReceived);
			
			//Consumer is replying here
			JMSProducer replyProducer = jmsContext.createProducer();
			replyProducer.send(replyQue, "YES PLEASE");
			
			//Producer recieve the msg from Consumer
			JMSConsumer replyConsumer = jmsContext.createConsumer(replyQue);
			System.out.println("Msg recieved by Producer from Consumer: " + replyConsumer.receiveBody(String.class));
		}
	}
}
