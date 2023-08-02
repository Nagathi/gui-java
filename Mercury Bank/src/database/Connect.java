package database;

import java.sql.*;
import javax.swing.JOptionPane;

public class Connect {
	
	public Connection connectDB() {
		Connection con = null;
		
		try {
			
			String url = "jdbc:mysql://localhost:3306/cadastro_clientes?user=root&password=";
			con = DriverManager.getConnection(url);
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro de conexão: " + e);
		}
		
		return con;
	}
	
}
