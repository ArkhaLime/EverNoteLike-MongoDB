package fr.dincher.fiegel.MongoNote.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.dincher.fiegel.MongoNote.controller.ConnexionController;
public class ConnexionView {

	public ConnexionView() {
		// Create views swing UI components
		JTextField loginField = new JTextField(26);
		JTextField mdpField = new JTextField(26);
		JButton signinButton = new JButton("Connexion");
		JFrame frame = new JFrame("Connexion");

		// Create controller
		ConnexionController connexionController = new ConnexionController(loginField, mdpField, frame);
		signinButton.setActionCommand("signin");
		signinButton.addActionListener(connexionController);

		// Set the view layout
		JPanel ctrlPane = new JPanel();
		ctrlPane.add(loginField);
		ctrlPane.add(mdpField);
		ctrlPane.add(signinButton);

		// Display it all in a scrolling window and make the window appear
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(ctrlPane);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}