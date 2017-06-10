package fr.dincher.fiegel.MongoNote.view;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import fr.dincher.fiegel.MongoNote.controller.ClosingController;
import fr.dincher.fiegel.MongoNote.controller.RechercheController;
import fr.dincher.fiegel.MongoNote.controller.SwitchViewController;
import fr.dincher.fiegel.MongoNote.modele.Note;
import fr.dincher.fiegel.MongoNote.modele.User;

public class ListeNotesView {

	public ListeNotesView(List<Note> notes, User user) {
		// swing UI components
		JTextField rechercheField = new JTextField(20);
		JButton rechercheButton = new JButton("Rechercher");

		JButton choixButton = new JButton("Choisir une note");
		JButton ajouterButton = new JButton("Ajouter une note");
		// JComboBox tempsComboBox = new JComboBox(TempsListes);
		JFrame frame = new JFrame("Liste des notes");
		JTable table = new JTable();
		String[] columnNames = { "id", "Titre", "contenu", "hashtag" };

		// Init du controller
		SwitchViewController mainViewController = new SwitchViewController(table, frame, user);
		choixButton.addActionListener(mainViewController);
		choixButton.setActionCommand("ToUpdate");
		ajouterButton.addActionListener(mainViewController);
		ajouterButton.setActionCommand("ToInsert");
		RechercheController rechercheController = new RechercheController(rechercheField, user, frame);
		rechercheButton.addActionListener(rechercheController);

		JPanel ctrlPane = new JPanel();
		ctrlPane.add(rechercheField);
		ctrlPane.add(rechercheButton);

		DefaultTableModel model = new DefaultTableModel();
		table.setModel(model);
		model.setColumnIdentifiers(columnNames);
		for (Note note : notes) {
			Object[] o = new Object[4];
			o[0] = note.getId();
			o[1] = note.getTitre();
			o[2] = note.getContenu();
			o[3] = note.getHashtags().toString();
			model.addRow(o);
		}
		table.removeColumn(table.getColumn("id"));

		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setPreferredSize(new Dimension(700, 182));

		JPanel panel2 = new JPanel();
		panel2.add(tableScrollPane);

		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ctrlPane, panel2);
		splitPane.setDividerLocation(35);
		splitPane.setEnabled(false);

		JPanel bottomPanel = new JPanel();
		bottomPanel.add(choixButton);
		bottomPanel.add(ajouterButton);

		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPane, bottomPanel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new ClosingController());
		frame.add(splitPane);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}