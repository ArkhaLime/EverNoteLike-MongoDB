package fr.dincher.fiegel.MongoNote.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import fr.dincher.fiegel.MongoNote.dao.NoteDao;
import fr.dincher.fiegel.MongoNote.modele.Note;
import fr.dincher.fiegel.MongoNote.modele.User;
import fr.dincher.fiegel.MongoNote.view.ListeNotesView;

public class RetourController implements ActionListener {

	private User user;
	private JFrame frame;

	public RetourController(User user, JFrame frame) {
		super();
		this.user = user;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			frame.setVisible(false);
			NoteDao dao = new NoteDao();
			List<Note> notes = dao.selectAllNotesFromUser(user);
			new ListeNotesView(notes, user);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(frame, "Error sql server");
			e1.printStackTrace();
		}
	}
}