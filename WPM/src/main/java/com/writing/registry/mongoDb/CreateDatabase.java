package com.writing.registry.mongoDb;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;

public class CreateDatabase {
	
	private static MongoDatabase database;

	public CreateDatabase(String host, int port, String userName, char[] password, String databaseName) {
	//Create a Mongo client
	MongoClient mongo = new MongoClient(host, port);
	//Create credentials
	MongoCredential	credential = MongoCredential.createCredential(userName, databaseName, password);
	database = mongo.getDatabase(databaseName);
	System.out.println("Connected to the Database Successfully");
	}
	
	public void createCollection(String collectionName) {
		System.out.println("Attempting to create collection:  " + collectionName);
			try{
				database.createCollection(collectionName);
				System.out.println(collectionName + " created successfully");
			}catch(Exception e) {
				System.out.println(collectionName + " not created");
				e.printStackTrace();
			}
			
	}
	
	public static MongoDatabase getMongoDatabase() {
		return database;
	}
}
