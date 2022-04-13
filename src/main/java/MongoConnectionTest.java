import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoConnectionTest {

	public static void main(String[] args) {
		MongoClient mc = new MongoClient("localhost", 27017);
		
		MongoDatabase md = mc.getDatabase("MessageQueue");
		
		MongoCollection<Document> coll = md.getCollection("test");
		
		System.out.println("Collection created successfully");

        System.out.println("當前數據庫中的所有集合是：");

        for (String name : md.listCollectionNames()) {
            System.out.println(name);
        }
	}

}
