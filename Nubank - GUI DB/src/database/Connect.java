package database;

import java.sql.*;
import javax.swing.JOptionPane;

public class Connect {
	
	public Connection connectDB() {
		Connection con = null;
		
		try {
			
			String mysql = "jdbc:mysql://";
			String localhost = "localhost:3306/";
			String db = "cadastro?user=root&password=";
			String url = mysql+localhost+db;
			con = DriverManager.getConnection(url);
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro de conexão: " + e);
		}
		
		return con;
	}
	
}
