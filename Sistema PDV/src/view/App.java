package view;

import javax.swing.SwingUtilities;

import controller.CreateSQLiteModel;

public class App {

	public static void main(String[] args) {
		CreateSQLiteModel create = new CreateSQLiteModel();
		SwingUtilities.invokeLater(() -> new AuthFrame());
	}

}
