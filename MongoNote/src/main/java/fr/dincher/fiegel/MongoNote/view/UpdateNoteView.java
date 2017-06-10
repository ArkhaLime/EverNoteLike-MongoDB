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

import fr.dincher.fiegel.MongoNote.controller.RetourController;
import fr.dincher.fiegel.MongoNote.controller.UpdateNoteController;
import fr.dincher.fiegel.MongoNote.modele.Note;
import fr.dincher.fiegel.MongoNote.modele.User;

/**
 * @author ashraf
 *
 */
public class UpdateNoteView {

	public UpdateNoteView(Note note, User user) {
		// Create views swing UI components
		
		JLabel titleLabel = new JLabel("Titre du spectacle                   ");
		JLabel contenuLabel = new JLabel("Contenu                         ");
		JLabel hashtagLabel = new JLabel("Hashtag                             ");
		JTextField idField = new JTextField(26);
		idField.setText(note.getId().toString());
		JTextField titleField = new JTextField(26);
		titleField.setText(note.getTitre());
		JTextField contenuField = new JTextField(26);
		contenuField.setText(note.getContenu());
		JTextField hashtagField = new JTextField(26);
		hashtagField.setText(getHashtags(note));
		JButton updateButton = new JButton("Editer");
		JButton switchViewButton = new JButton("Retour");
		switchViewButton.setMaximumSize(new Dimension(80, 60));
		JFrame frame = new JFrame(note.getTitre());

		// Create controllers
		UpdateNoteController UpdateNoteController = new UpdateNoteController(idField ,titleField, contenuField, hashtagField, user, frame);
		updateButton.addActionListener(UpdateNoteController);
		RetourController retourController = new RetourController(user, frame);
		switchViewButton.addActionListener(retourController);
		

		// Set the view layout
		JPanel ctrlPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
		// ctrlPane.setSize();
		Dimension dimension = new Dimension(350, 450);
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
		panelButton.add(updateButton);
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

	private String getHashtags(Note note) {
		String hashtags = "";
		for(String hashtag : note.getHashtags()){
			hashtags = hashtags+hashtag+" ";
		}
		return hashtags;
	}

}