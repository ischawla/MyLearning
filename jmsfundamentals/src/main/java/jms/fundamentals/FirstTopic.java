package jms.fundamentals;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;
public class FirstTopic {
	public static void main(String[] args) throws Exception {
		InitialContext ic = new InitialContext();
		Topic topic = (Topic) ic.lookup("topic/myTopic");
		ConnectionFactory cf = (ConnectionFactory) ic.lookup("ConnectionFactory");
		Connection con = cf.createConnection("admin","admin");
		Session sess = con.createSession();
		MessageProducer producer = sess.createProducer(topic);

		MessageConsumer consumer1 = sess.createConsumer(topic);
		MessageConsumer consumer2 = sess.createConsumer(topic);
		
		TextMessage smsg = sess.createTextMessage("This is my first TOPIC JMS message....");
		
		producer.send(smsg);
		System.out.println("Message Sent : "+smsg.getText());
		
		con.start();
		
		TextMessage rmsg = (TextMessage) consumer1.receive();
		System.out.println("Consumer 1 - Message Received : "+rmsg.getText());
		
		TextMessage rmsg2 = (TextMessage) consumer2.receive();
		System.out.println("Consumer 2 - Message Received : "+rmsg2.getText());
		
	}

}
