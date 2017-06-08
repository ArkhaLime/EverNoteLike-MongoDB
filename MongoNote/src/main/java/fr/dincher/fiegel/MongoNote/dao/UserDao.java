package fr.dincher.fiegel.MongoNote.dao;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;

import fr.dincher.fiegel.MongoNote.modele.User;

public class UserDao {

	private MongoCollection<Document> users;
	
	public UserDao() {
		users=MongoConnection.getUsersCollection();
	}
	
	public User login(String email, String mdp){
		Document doc = users.find(and(eq(User.email,email),eq(User.mdp,mdp))).first();
		if(doc!=null) return new User(doc);
		return null;
	}
	
	public User select(ObjectId id){
		Document doc = users.find(eq(User.id,id)).first();
		if(doc!=null) return new User(doc);
		return null;
	}
	
	public void createUser(User newUser){
		users.insertOne(new Document(newUser));
	}

}
