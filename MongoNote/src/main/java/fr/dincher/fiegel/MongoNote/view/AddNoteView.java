package fr.dincher.fiegel.MongoNote.view;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import fr.dincher.fiegel.MongoNote.controller.AddNoteController;
import fr.dincher.fiegel.MongoNote.controller.RetourController;
import fr.dincher.fiegel.MongoNote.modele.User;

/**
 * @author ashraf
 *
 */
public class AddNoteView {

	public AddNoteView(User user) {
		// Create views swing UI components
		JLabel titleLabel = new JLabel("Titre                             ");
		JLabel contenuLabel = new JLabel("Contenu                  ");
		JLabel hashtagLabel = new JLabel("Hashtag            ");
		JTextField titleField = new JTextField(26);
//		titleField.setText(note.getTitre());
		JTextField contenuField = new JTextField(26);
//		contenuField.setText(note.getContenu());
		JTextField hashtagField = new JTextField(26);
//		hashtagField.setText(note.getHashtags().toString());
		JButton ajouterButton = new JButton("Ajouter");
		JButton switchViewButton = new JButton("Retour");
		switchViewButton.setMaximumSize(new Dimension(80, 60));
		JFrame frame = new JFrame("Nouvelle Note");

		// Create controllers
		AddNoteController AddNoteController = new AddNoteController(titleField, contenuField, hashtagField, user, frame);
		ajouterButton.addActionListener(AddNoteController);
		RetourController retourController = new RetourController(user, frame);
		switchViewButton.addActionListener(retourController);
		

		// Set the view layout
		JPanel ctrlPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
		// ctrlPane.setSize();
		Dimension dimension = new Dimension(350, 400);
		ctrlPane.setMinimumSize(dimension);
		ctrlPane.setPreferredSize(dimension);
		ctrlPane.add(titleLabel, BorderLayout.WEST);
		ctrlPane.add(titleField, BorderLayout.WEST);
		ctrlPane.add(contenuLabel, BorderLayout.WEST);
		ctrlPane.add(contenuField, BorderLayout.WEST);
		ctrlPane.add(hashtagLabel, BorderLayout.WEST);
		ctrlPane.add(hashtagField, BorderLayout.WEST);
		
		ctrlPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);



		JPanel panelButton = new JPanel();
		panelButton.add(ajouterButton);
		panelButton.add(switchViewButton);
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ctrlPane, panelButton);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(splitPane);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setMaximumSize(dimension);
		frame.setPreferredSize(dimension);
		frame.setMinimumSize(dimension);
		frame.setVisible(true);
	}

}