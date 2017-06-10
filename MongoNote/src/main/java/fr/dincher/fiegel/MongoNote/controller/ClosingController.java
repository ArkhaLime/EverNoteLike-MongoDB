package fr.dincher.fiegel.MongoNote.controller;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import fr.dincher.fiegel.MongoNote.dao.MongoConnection;

public class ClosingController implements WindowListener {

	public ClosingController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		MongoConnection.closeConnection();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		MongoConnection.closeConnection();
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
