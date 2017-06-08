package fr.dincher.fiegel.MongoNote.modele;

import java.util.Map;

import org.bson.BsonObjectId;
import org.bson.Document;
import org.bson.types.ObjectId;

@SuppressWarnings("serial")
public class User extends Document {

	public static final String id="_id";
	public static final String email="email";
	public static final String pseudo="pseudo";
	public static final String mdp="mdp";
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Map<String, Object> map) {
		super(map);
		// TODO Auto-generated constructor stub
	}

	public User(String key, Object value) {
		super(key, value);
		// TODO Auto-generated constructor stub
	}
	
	public User(String email, String pseudo, String mdp){
		setEmail(email);
		setPseudo(pseudo);
		setMdp(mdp);
	}
	
	public ObjectId getId(){
		return getObjectId(id);
	}
	
	public User setId(ObjectId newId){
		put(id, newId);
		return this;
	}
	
	public User setId(BsonObjectId newId){
		setId(newId.getValue());
		return this;
	}
	
	public String getEmail(){
		return getString(email);
	}
	
	public User setEmail(String newEmail){
		put(email,newEmail);
		return this;
	}
	
	public String getPseudo(){
		return getString(pseudo);
	}
	
	public User setPseudo(String newPseudo){
		put(pseudo, newPseudo);
		return this;
	}
	
	public String getMdp(){
		return getString(mdp);
	}
	
	public User setMdp(String newMdp){
		put(mdp, newMdp);
		return this;
	}
	
	@Override
	public String toString() {
		return "User{"+super.toString()+"}";
	}

}
