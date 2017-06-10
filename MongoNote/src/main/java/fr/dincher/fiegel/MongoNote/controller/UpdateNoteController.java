package fr.dincher.fiegel.MongoNote.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.bson.types.ObjectId;

import fr.dincher.fiegel.MongoNote.dao.NoteDao;
import fr.dincher.fiegel.MongoNote.modele.Note;
import fr.dincher.fiegel.MongoNote.modele.User;
import fr.dincher.fiegel.MongoNote.view.ListeNotesView;

public class UpdateNoteController implements ActionListener {

	private User user;
	private JFrame frame;
	private JTextField idField;
	private JTextField titleField;
	private JTextField contenuField;
	private JTextField hashtagField;

	public UpdateNoteController(JTextField idField,JTextField titleField, JTextField contenuField, JTextField hashtagField, User user, JFrame frame) {
		super();
		this.idField = idField;
		this.titleField = titleField;
		this.contenuField = contenuField;
		this.hashtagField = hashtagField;
		this.user = user;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			frame.setVisible(false);
			NoteDao dao = new NoteDao();
			Note note = new Note(user, titleField.getText(), contenuField.getText(), Arrays.asList(hashtagField.getText().split(" ")));
			note.setId(new ObjectId(idField.getText()));
			dao.udpateNote(note);
			new ListeNotesView(dao.selectAllNotesFromUser(user), user);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(frame, "Error sql server");
			e1.printStackTrace();
		}
	}
}