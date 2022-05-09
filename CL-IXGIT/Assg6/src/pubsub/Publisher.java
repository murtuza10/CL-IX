package pubsub;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.*;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.*;

public class Publisher {
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	
	public static void main(String[] args) throws JMSException{
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic("MI");
		MessageProducer producer = session.createProducer(topic);
		TextMessage message = session.createTextMessage();
		message.setText("MI Won 200/5");
		producer.send(message);
		System.out.println("Sent Message "+ message.getText());
		Topic topic1 = session.createTopic("CSK");
		MessageProducer producer1 = session.createProducer(topic1);
		TextMessage message1 = session.createTextMessage();
		message1.setText("CSK Won 200/5");
		producer1.send(message1);
		connection.close();
		
		
		
		
		
	}
	

}
