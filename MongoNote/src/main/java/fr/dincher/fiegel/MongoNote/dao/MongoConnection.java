package fr.dincher.fiegel.MongoNote.dao;

import java.util.Properties;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import fr.dincher.fiegel.MongoNote.utils.ConfigLoader;

public class MongoConnection {

	private static MongoClient client;
	private static Properties prop;
	
	public static MongoClient getConnection(){
		if(prop==null){
			prop = ConfigLoader.load("config.properties");
		}
		if(client==null){
			MongoClientURI uri = new MongoClientURI(prop.getProperty("connectionString"));
			client = new MongoClient(uri);
		}
		return client;
	}
	
}
