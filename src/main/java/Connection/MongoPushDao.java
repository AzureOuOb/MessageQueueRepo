package Connection;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import Bean.PttPushes;

public class MongoPushDao {

	MongoClient mc = new MongoClient("localhost", 27017);
	MongoDatabase md = mc.getDatabase("MessageQueue");
	
	public void insertData(PttPushes ptt) {
		MongoCollection<Document> collection = md.getCollection("test");
		
		try {		
			Document document = new Document("push", ptt.getPush())
									.append("userid", ptt.getUserid())
									.append("content", ptt.getContent())
									.append("ipdatetime", ptt.getIpdatetime());
			
			collection.insertOne(document);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}