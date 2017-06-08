package fr.dincher.fiegel.MongoNote.modele;

import java.util.Map;

import org.bson.Document;
import org.bson.types.ObjectId;

@SuppressWarnings("serial")
public class User extends Document {

	public static final String id="_id";
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
	
	public ObjectId getId(){
		return getObjectId(id);
	}
	
	public String getPseudo(){
		return getString(pseudo);
	}
	
	public void setPseudo(String newPseudo){
		put(pseudo, newPseudo);
	}
	
	public String getMdp(){
		return getString(mdp);
	}
	
	public void setMdp(String newMdp){
		put(mdp, newMdp);
	}

}
