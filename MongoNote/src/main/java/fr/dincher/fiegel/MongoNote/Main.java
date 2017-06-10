package fr.dincher.fiegel.MongoNote;

import fr.dincher.fiegel.MongoNote.dao.MongoConnection;
import fr.dincher.fiegel.MongoNote.view.ConnexionView;

public class Main {
	public static void main(String[] args) {
		MongoConnection.startConnection();
		System.out.println("Connexion lancée");
		new ConnexionView();
		System.out.println("Fenètre lancée");
		// MongoConnection.closeConnection();
		// System.out.println("Connexion fermé");
	}
}
