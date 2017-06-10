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
				Note note = dao.selectNoteById((ObjectId) table.getModel().getValueAt(table.getSelectedRow(), 0));
				if (note != null) {
					frame.setVisible(false);
					new UpdateNoteView(note, user);
				}

			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(frame, "Un porbl�me est survenue veuillez relancer le programme");
			e1.printStackTrace();
		}

	}
}