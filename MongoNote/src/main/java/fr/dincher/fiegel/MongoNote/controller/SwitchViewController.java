package fr.dincher.fiegel.MongoNote.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.bson.types.ObjectId;

import fr.dincher.fiegel.MongoNote.dao.NoteDao;
import fr.dincher.fiegel.MongoNote.modele.Note;
import fr.dincher.fiegel.MongoNote.modele.User;
import fr.dincher.fiegel.MongoNote.view.AddNoteView;
import fr.dincher.fiegel.MongoNote.view.UpdateNoteView;

public class SwitchViewController implements ActionListener {

	private JFrame frame;
	private JTable table;
	private User user;

	public SwitchViewController(JTable table, JFrame frame, User user) {
		super();
		this.table = table;
		this.frame = frame;
		this.user = user;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getActionCommand().equals("ToInsert")) {

				frame.setVisible(false);
				new AddNoteView(user);

			} else if (e.getActionCommand().equals("ToUpdate")) {

				NoteDao dao = new NoteDao();
				Object idNote = null;
				try {
					idNote = table.getModel().getValueAt(table.getSelectedRow(), 0);
				} catch (Exception ex) {
					//ex.printStackTrace();
				}
				if (idNote == null) {
					JOptionPane.showMessageDialog(frame, "Veuillez sélectionner une ligne");
					return;
				}
				Note note = dao.selectNoteById((ObjectId) idNote);
				if (note != null) {
					frame.setVisible(false);
					new UpdateNoteView(note, user);
				}

			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(frame, "Un problème est survenue! Veuillez relancer le programme");
			e1.printStackTrace();
		}

	}
}