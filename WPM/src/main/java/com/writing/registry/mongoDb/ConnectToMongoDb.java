package com.writing.registry.mongoDb;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;

public class ConnectToMongoDb {

	public MongoDatabase connect() {
		//Create a Mongo client
		MongoClient mongo = new MongoClient("localhost", 27017);
		//Create credentials
		char[] password = "Operating2017".toCharArray();
		MongoCredential	credential = MongoCredential.createCredential("WPMAdmin", "WPMReg", password);
		System.out.println("Connected to the Database Successfully");
		//Accessing the database
		MongoDatabase database = mongo.getDatabase("WPMReg");
		return database;
	}
}
