package com.examples.hellodockernet;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class SimpleMongoApp {

	public static void main(String[] args) {
		
		String mongoHost = "localhost";
		if(args.length > 0) {
			mongoHost = args[0];
		}
		
		MongoClient mongoClient = new com.mongodb.MongoClient(mongoHost);
		MongoDatabase db = mongoClient.getDatabase("mydb");
		
		MongoCollection<Document> collection = db.getCollection("examples");
		Document doc = new Document("name", "Greeting").append("type", "Hello World!");
		collection.insertOne(doc);
		
		System.out.println(collection.find().first().get("type"));
		
		mongoClient.close();
		
	}

}
