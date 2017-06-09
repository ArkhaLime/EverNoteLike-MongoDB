package fr.dincher.fiegel.MongoNote.dao;

import java.util.Properties;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;

import fr.dincher.fiegel.MongoNote.utils.ConfigLoader;

public class MongoConnection {

	// valeurs par défauts
	private static final String coString = "mongodb://localhost:27017/";
	private static final String collUsers = "users";
	private static final String collNotes = "notes";
	private static final String dbName = "mongonote";

	private static MongoClient client = null;
	private static Properties prop = null;
	private static String connectionString;
	private static String usersCollName;
	private static String notesCollName;
	private static String databaseName;

	private static MongoClient getConnection() {
		if (prop == null) {
			prop = ConfigLoader.load("config.properties");
			connectionString = prop.getProperty("connectionString", coString);
			databaseName = prop.getProperty("database.name", dbName);
			usersCollName = prop.getProperty("collection.users.name", collUsers);
			notesCollName = prop.getProperty("collection.notes.name", collNotes);
		}
		if (client == null) {
			MongoClientURI uri = new MongoClientURI(connectionString);
			client = new MongoClient(uri);
		}
		return client;
	}

	public static void startConnection() {
		getConnection();
	}

	public static MongoCollection<Document> getUsersCollection() {
		return getConnection().getDatabase(databaseName).getCollection(usersCollName);
	}

	public static MongoCollection<Document> getNotesCollection() {
		return getConnection().getDatabase(databaseName).getCollection(notesCollName);
	}

	public static void close() {
		if (client != null)
			client.close();
	}

}
