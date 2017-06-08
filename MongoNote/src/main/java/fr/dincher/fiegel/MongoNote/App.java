package fr.dincher.fiegel.MongoNote;

import org.bson.types.ObjectId;

import fr.dincher.fiegel.MongoNote.dao.MongoConnection;
import fr.dincher.fiegel.MongoNote.dao.UserDao;
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
            User testSelect = dao.select(new ObjectId("593864a9bb060c600b023821"));
            System.out.println(testSelect);
            User testLogin = dao.login("cedric@test.fr", "test");
            System.out.println(testLogin);
            User testCreation = new User("test@test.fr","testCreation","test");
            testCreation.setId(new ObjectId());
            System.out.println(testCreation);
            dao.createUser(testCreation);
            User testCreation2 = dao.login("test@test.fr", "test");
            System.out.println(testCreation2);
		} finally {
			MongoConnection.close();
		}
        
        
    }
}
