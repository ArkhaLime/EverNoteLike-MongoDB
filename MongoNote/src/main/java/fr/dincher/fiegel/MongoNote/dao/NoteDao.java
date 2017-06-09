package fr.dincher.fiegel.MongoNote.dao;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.elemMatch;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;

import com.mongodb.Function;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import fr.dincher.fiegel.MongoNote.modele.Note;
import fr.dincher.fiegel.MongoNote.modele.User;

public class NoteDao {

	private MongoCollection<Document> notes;

	private static Function<Document, Note> mapper = new Function<Document, Note>() {
		public Note apply(Document t) {
			return Note.fromDocument(t);
		};
	};

	public NoteDao() {
		notes = MongoConnection.getNotesCollection();
	}

	public List<Note> selectNotesFromUser(User user, boolean isArchive) {
		MongoIterable<Note> notez = notes.find(and(eq(Note.userId, user.getId()), eq(Note.archive, isArchive)))
				.map(mapper);
		ArrayList<Note> res = notez.into(new ArrayList<Note>());
		return res;
	}

	public List<Note> selectAllNotesFromUser(User user) {
		MongoIterable<Note> notez = notes.find(eq(Note.userId, user.getId())).map(mapper);
		ArrayList<Note> res = notez.into(new ArrayList<Note>());
		return res;
	}
	
	public List<Note> rechercheAllNotesFromUserByTitre(User user, String titre) {
		MongoIterable<Note> notez = notes.find(and(eq(Note.userId, user.getId()), regex(Note.contenu, ".*"+titre+".*"))).map(mapper);
		ArrayList<Note> res = notez.into(new ArrayList<Note>());
		return res;
	}

	public List<Note> rechercheAllNotesFromUserByContenu(User user, String contenu) {
		MongoIterable<Note> notez = notes.find(and(eq(Note.userId, user.getId()), regex(Note.contenu, ".*"+contenu+".*"))).map(mapper);
		ArrayList<Note> res = notez.into(new ArrayList<Note>());
		return res;
	}
	
	public List<Note> rechercheAllNotesFromUserByHashtag(User user, String hashtag) {
		MongoIterable<Note> notez = notes.find(and(eq(Note.userId, user.getId()), elemMatch(Note.contenu, eq(hashtag)))).map(mapper);
		ArrayList<Note> res = notez.into(new ArrayList<Note>());
		return res;
	}
	
	public List<Note> rechercheAllNotesFromUserByDate(User user, Date date) {
		MongoIterable<Note> notez = notes.find(and(eq(Note.userId, user.getId()), eq(Note.dateAjout,date))).map(mapper);
		ArrayList<Note> res = notez.into(new ArrayList<Note>());
		return res;
	}
	
	public List<Note> rechercheAllNotesFromUserByDates(User user, Date dateDebut, Date dateFin) {
		if(dateDebut.compareTo(dateFin)>0){
			Date temp=dateFin;
			dateFin=dateDebut;
			dateDebut=temp;
		}
		MongoIterable<Note> notez = notes.find(and(eq(Note.userId, user.getId()), gte(Note.dateAjout,dateDebut),lte(Note.dateAjout,dateFin))).map(mapper);
		ArrayList<Note> res = notez.into(new ArrayList<Note>());
		return res;
	}
	
	public void createNote(Note newDoc){
		notes.insertOne(newDoc.toDocument());
	}
	
	public void udpateNote(Note oldDoc){
		UpdateResult res = notes.replaceOne(eq(Note.id,oldDoc.getId()), oldDoc.toDocument());
		System.out.println("Mise à jour User => "+oldDoc+"\n\tRésultat => "+res);
	}
	
	public void deleteUser(Note oldNote){
		DeleteResult res = notes.deleteOne(eq(Note.id,oldNote.getId()));
		System.out.println("Suppression User => "+oldNote+"\n\tRésultat => "+res);
	}

}
