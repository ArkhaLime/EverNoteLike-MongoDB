package fr.dincher.fiegel.MongoNote.dao;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import fr.dincher.fiegel.MongoNote.modele.User;

public class UserDao {

	private MongoCollection<Document> users;
	
	public UserDao() {
		users=MongoConnection.getUsersCollection();
	}
	
	public User login(String email, String mdp){
		Document doc = users.find(and(eq(User.email,email),eq(User.mdp,mdp))).first();
		return User.fromDocument(doc);
	}
	
	public User select(ObjectId id){
		Document doc = users.find(eq(User.id,id)).first();
		return User.fromDocument(doc);
	}
	
	public void createUser(User newUser){
		users.insertOne(newUser.toDocument());
	}
	
	public void udpateUser(User oldUser){
		UpdateResult res = users.replaceOne(eq(User.id,oldUser.getId()), oldUser.toDocument());
		System.out.println("Mise à jour User => "+oldUser+"\n\tRésultat => "+res);
	}
	
	public void deleteUser(User oldUser){
		DeleteResult res = users.deleteOne(eq(User.id,oldUser.getId()));
		System.out.println("Suppression User => "+oldUser+"\n\tRésultat => "+res);
	}
	
	

}
