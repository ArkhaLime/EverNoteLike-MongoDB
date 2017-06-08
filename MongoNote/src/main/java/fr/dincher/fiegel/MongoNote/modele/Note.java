package fr.dincher.fiegel.MongoNote.modele;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.bson.BsonObjectId;
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
		setDateAjout(new Date());
	}

	public Note(Map<String, Object> map) {
		super(map);
		if(!containsKey(dateAjout)) setDateAjout(new Date());
	}

	public Note(String key, Object value) {
		super(key, value);
		if(!containsKey(dateAjout)) setDateAjout(new Date());
	}
	
	public ObjectId getId(){
		return getObjectId(id);
	}
	
	public Note setId(ObjectId newId){
		put(id, newId);
		return this;
	}
	
	public Note setId(BsonObjectId newId){
		return setId(newId.getValue());
	}
	
	public ObjectId getUserId(){
		return getObjectId(userId);
	}
	
	public Note setUserId(ObjectId newId){
		put(userId, newId);
		return this;
	}
	
	public String getTitre(){
		return getString(titre);
	}
	
	public Note setTitre(String newTitre){
		put(titre, newTitre);
		return this;
	}
	
	public Date getDateAjout(){
		return getDate(dateAjout);
	}
	
	private Note setDateAjout(Date newDateAjout){
		put(dateAjout, newDateAjout);
		return this;
	}

	public String getContenu(){
		return getString(contenu);
	}
	
	public Note setContenu(String newContenu){
		put(contenu, newContenu);
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getHashtags(){
		return (List<String>)get(hashtags);
	}
	
	public Note setHashtags(List<String> newHashtags){
		put(hashtags, newHashtags);
		return this;
	}

	public boolean isArchive(){
		return getBoolean(archive,false);
	}
	
	public Note setArchive(boolean isArchive){
		put(archive, isArchive);
		return this;
	}
	
	@Override
	public String toString() {
		return "Note{"+super.toString()+"}";
	}
}
