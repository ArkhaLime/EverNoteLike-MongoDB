package fr.dincher.fiegel.MongoNote.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import fr.dincher.fiegel.MongoNote.dao.NoteDao;
import fr.dincher.fiegel.MongoNote.dao.UserDao;
import fr.dincher.fiegel.MongoNote.modele.Note;
import fr.dincher.fiegel.MongoNote.modele.User;
import fr.dincher.fiegel.MongoNote.view.ListeNotesView;

public class ConnexionController implements ActionListener {

	private JTextField loginField;
	private JTextField mdpField;
	private JFrame frame;

	public ConnexionController(JTextField loginField, JTextField mdpField, JFrame frame) {
		super();
		this.loginField = loginField;
		this.mdpField = mdpField;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "signin") {
			try {
				UserDao dao = new UserDao();
				User user = dao.login(loginField.getText(), mdpField.getText());
				if (user == null) {
					JOptionPane.showMessageDialog(frame, "Login ou mot de passe �rron�");
				} else {
					frame.setVisible(false);
					NoteDao dao2 = new NoteDao();
					List<Note> notes = dao2.selectAllNotesFromUser(user);
					new ListeNotesView(notes, user);
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(frame, "Error sql server");
				e1.printStackTrace();
			}

		}
	}
}