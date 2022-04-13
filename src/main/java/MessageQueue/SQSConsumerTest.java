package MessageQueue;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;

public class SQSConsumerTest {
	
	private static String queueUrl = "https://sqs.ap-northeast-1.amazonaws.com/392164539538/SQSQueue";
	
	static AWSCredentials credentials = new BasicAWSCredentials("AKIAVWTWT7SJNXW6CHNA", "ScGmwajQ2feqouVOMWG6Od5jBIwHeHaG0Ni40NY9");
	
	static Properties props = null;

	public static void main(String[] args) {		
		AmazonSQS sqs = AmazonSQSClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(Regions.AP_NORTHEAST_1)
				.build();
		
		ReceiveMessageRequest rmr = new ReceiveMessageRequest(queueUrl)
									.withWaitTimeSeconds(10)
									.withMaxNumberOfMessages(10)
									.withMessageAttributeNames("All");
		
		List<Message> sqsMessages = sqs.receiveMessage(rmr).getMessages();
				
		for (int i = 0; i < sqsMessages.size(); i++) {
			Map<String, MessageAttributeValue> resultMap = sqsMessages.get(i).getMessageAttributes();
			System.out.println("push = " + resultMap.get("push").getStringValue());
			System.out.println("userid = " + resultMap.get("userid").getStringValue());
			System.out.println("content = " + resultMap.get("content").getStringValue());
			System.out.println("ipdatetime = " + resultMap.get("ipdatetime").getStringValue());
		}
	}
	
	public static void getProperties() {
		try (FileInputStream fis = new FileInputStream("./aws.properties")){
			props.load(fis);
			
			queueUrl = props.getProperty("aws.queueUrl");
			credentials = new BasicAWSCredentials(props.get("aws.key").toString(), props.get("aws.secret").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
