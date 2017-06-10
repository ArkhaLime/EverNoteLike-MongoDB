package fr.dincher.fiegel.MongoNote.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.dincher.fiegel.MongoNote.controller.ConnexionController;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class ConnexionView {

	public ConnexionView() {
		JFrame frame = new JFrame("Connexion");

		// Set the view layout
		JPanel ctrlPane = new JPanel();

		// Display it all in a scrolling window and make the window appear
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(ctrlPane);
		ctrlPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		ctrlPane.add(panel, BorderLayout.NORTH);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setPreferredSize(new Dimension(70, 14));
		lblEmail.setMinimumSize(new Dimension(70, 14));
		panel.add(lblEmail);
		// Create views swing UI components
		JTextField loginField = new JTextField(26);
		lblEmail.setLabelFor(loginField);
		panel.add(loginField);

		JPanel panel_1 = new JPanel();
		ctrlPane.add(panel_1);

		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setMinimumSize(new Dimension(70, 14));
		lblMotDePasse.setPreferredSize(new Dimension(70, 14));
		panel_1.add(lblMotDePasse);
		JTextField mdpField = new JTextField(26);
		lblMotDePasse.setLabelFor(mdpField);
		panel_1.add(mdpField);

		// Create controller
		ConnexionController connexionController = new ConnexionController(loginField, mdpField, frame);

		JPanel panel_2 = new JPanel();
		ctrlPane.add(panel_2, BorderLayout.SOUTH);
		JButton signinButton = new JButton("Connexion");
		panel_2.add(signinButton);
		signinButton.setActionCommand("signin");
		signinButton.addActionListener(connexionController);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}