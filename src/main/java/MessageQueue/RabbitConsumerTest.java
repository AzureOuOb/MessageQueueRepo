package MessageQueue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.rabbitmq.client.AMQP.Queue.DeclareOk;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import Bean.PttPushes;
import Connection.MongoPushDao;


public class RabbitConsumerTest {
	
	private static final String QUEUE_NAME = "test"; // queue的名稱

//	public static void main(String[] args) throws IOException, TimeoutException {
//		ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("localhost");
//        Connection connection = null;
//        Channel channel = null;
//        
//        try {
//            connection = factory.newConnection(QUEUE_NAME);
//            channel = connection.createChannel();
//
//            DeclareOk declareOk = channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
//            
//            System.out.println("Queues :" + declareOk.getMessageCount());
//            
//            PttPushes ptt = new PttPushes();
//                        
//            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
//                String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
//                System.out.println("Received '" + message + "'");
//                JsonObject jsonObject = new Gson().fromJson(message, JsonObject.class);
//                
//                ptt.setPush(jsonObject.get("push").toString());
//                ptt.setUserid(jsonObject.get("userid").toString());
//                ptt.setContent(jsonObject.get("push_content").toString());
//                ptt.setIpdatetime(jsonObject.get("ipdatetime").toString()); 
//                
////                PushDao pushDao = new PushDao();
////                try {
////    				pushDao.insertData(ptt);
////    			} catch (SQLException e) {
////    				e.printStackTrace();
////    			} 
//                
//                MongoPushDao mongoPushDao = new MongoPushDao();
//                try {
//                	mongoPushDao.insertData(ptt);
//                } catch (Exception e) {
//                	e.printStackTrace();
//                }
//            };
//            
//            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//	}
}
