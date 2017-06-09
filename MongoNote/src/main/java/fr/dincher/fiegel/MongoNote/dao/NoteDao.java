package fr.dincher.fiegel.MongoNote.dao;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.Function;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoIterable;

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

	public List<Note> rechercheAllNotesFromUserByContenu(User user, String contenu) {
		MongoIterable<Note> notez = notes.find(and(eq(Note.userId, user.getId()), regex(Note.contenu, ".*"+contenu+".*"))).map(mapper);
		ArrayList<Note> res = notez.into(new ArrayList<Note>());
		return res;
	}

}
