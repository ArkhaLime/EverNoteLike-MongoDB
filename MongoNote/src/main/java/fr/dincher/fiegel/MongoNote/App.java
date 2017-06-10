package fr.dincher.fiegel.MongoNote;

import java.util.ArrayList;
import java.util.function.Consumer;

import org.bson.types.ObjectId;

import fr.dincher.fiegel.MongoNote.dao.MongoConnection;
import fr.dincher.fiegel.MongoNote.dao.NoteDao;
import fr.dincher.fiegel.MongoNote.dao.UserDao;
import fr.dincher.fiegel.MongoNote.modele.Note;
import fr.dincher.fiegel.MongoNote.modele.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        MongoConnection.startConnection();
        try {
        	UserDao dao = new UserDao();
        	NoteDao dao2 = new NoteDao();
        	
        	Consumer<Note> afficherNote = new Consumer<Note>(){
        		@Override
        		public void accept(Note t) {
        			System.out.println(t);
        		}
        	};
        	
        	//test user
            User testSelect = dao.select(new ObjectId("593864a9bb060c600b023821"));
            System.out.println(testSelect);
            User testLogin = dao.login("cedric@test.fr", "test");
            System.out.println(testLogin);
            User testCreation = new User("test@test.fr","testCreation","test");
            //testCreation.setId(new ObjectId());
            System.out.println(testCreation);
            try {
				dao.createUser(testCreation);
			} catch (Exception ex) {
				System.out.println("Peut être normal si l'utilisateur est dèja créé\n");
				ex.printStackTrace();
			}
            User testCreation2 = dao.login("test@test.fr", "test");
            System.out.println(testCreation2);
            testCreation2.setEmail("test.test@test.fr");
            System.out.println(testCreation2);
            dao.udpateUser(testCreation2);
            dao.deleteUser(testCreation2);
            
            //test Note
            ArrayList<Note> notes = new ArrayList<>(dao2.selectNotesFromUser(testSelect,false));
            System.out.println("\nNotes sans archive");
            notes.stream().forEach(afficherNote);
            System.out.println("\nNotes archivées");
            ArrayList<Note> notesArchives = new ArrayList<>(dao2.selectNotesFromUser(testSelect,true));
            notesArchives.stream().forEach(afficherNote);
            System.out.println("\nToutes les notes");
            ArrayList<Note> notesAll = new ArrayList<>(dao2.selectAllNotesFromUser(testSelect));
            notesAll.stream().forEach(afficherNote);
            System.out.println("\nToutes les notes avec texte");
            ArrayList<Note> notesAllTexte = new ArrayList<>(dao2.rechercheAllNotesFromUserByContenu(testSelect, "truc"));
            notesAllTexte.stream().forEach(afficherNote);
            
		} finally {
			MongoConnection.closeConnection();
		}
        
        
    }
}
