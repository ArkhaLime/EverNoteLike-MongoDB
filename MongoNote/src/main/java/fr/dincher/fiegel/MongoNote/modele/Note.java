package fr.dincher.fiegel.MongoNote.modele;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.types.ObjectId;

@SuppressWarnings("serial")
public class Note extends Document {

	public static final String id = "_id";
	public static final String userId = "user_id";
	public static final String titre = "titre";
	public static final String dateAjout = "date_ajout";
	public static final String contenu = "contenu";
	public static final String hashtags = "hashtags";
	public static final String archive="archive";
	
	public Note() {
		// TODO Auto-generated constructor stub
	}

	public Note(Map<String, Object> map) {
		super(map);
		// TODO Auto-generated constructor stub
	}

	public Note(String key, Object value) {
		super(key, value);
		// TODO Auto-generated constructor stub
	}
	
	public ObjectId getId(){
		return getObjectId(id);
	}
	
	public ObjectId getUserId(){
		return getObjectId(userId);
	}
	
	public void setUserId(ObjectId newId){
		put(userId, newId);
	}
	
	public String getTitre(){
		return getString(titre);
	}
	
	public void setTitre(String newTitre){
		put(titre, newTitre);
	}
	
	public Date getDateAjout(){
		return getDate(dateAjout);
	}
	
//	public void setDateAjout(Date newDateAjout){
//		put(dateAjout, newDateAjout);
//	}

	public String getContenu(){
		return getString(contenu);
	}
	
	public void setContenu(String newContenu){
		put(contenu, newContenu);
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getHashtags(){
		return (List<String>)get(hashtags);
	}
	
	public void setHashtags(List<String> newHashtags){
		put(hashtags, newHashtags);
	}

	public boolean isArchive(){
		return getBoolean(archive,false);
	}
	
	public void setArchive(boolean isArchive){
		put(archive, isArchive);
	}
}
