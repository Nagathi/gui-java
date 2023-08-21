package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateSQLiteModel {
	
	public CreateSQLiteModel() {
		createTableFuncionarios();
		createTableProdutos();
		createTableCompras();
		createTableDescricao();
	}
	
	public void createTableFuncionarios() {
		try {
            Connection conn = SQLiteConnection.connect();
            if (conn != null) {
                Statement statement = conn.createStatement();
                String createTableSQL = "CREATE TABLE IF NOT EXISTS funcionarios ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "codigo TEXT NOT NULL,"
                        + "nome TEXT NOT NULL,"
                        + "cargo TEXT NOT NULL,"
                        + "tipo TEXT NOT NULL,"
                        + "usuario TEXT NOT NULL,"
                        + "senha TEXT NOT NULL)";
                statement.execute(createTableSQL);
                statement.close();
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void createTableProdutos() {
		try {
            Connection conn = SQLiteConnection.connect();
            if (conn != null) {
                Statement statement = conn.createStatement();
                String createTableSQL = "CREATE TABLE IF NOT EXISTS produtos ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "codigo TEXT NOT NULL,"
                        + "nome TEXT NOT NULL,"
                        + "marca TEXT NOT NULL,"
                        + "preco FLOAT NOT NULL)";
                statement.execute(createTableSQL);
                statement.close();
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void createTableCompras() {
		try {
            Connection conn = SQLiteConnection.connect();
            if (conn != null) {
                Statement statement = conn.createStatement();
                String createTableSQL = "CREATE TABLE IF NOT EXISTS compras ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "total TEXT NOT NULL,"
                        + "funcionario TEXT NOT NULL)";
                statement.execute(createTableSQL);
                statement.close();
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void createTableDescricao() {
		try {
            Connection conn = SQLiteConnection.connect();
            if (conn != null) {
                Statement statement = conn.createStatement();
                String createTableSQL = "CREATE TABLE IF NOT EXISTS descricao ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "compra_id INTEGER NOT NULL,"
                        + "nome_produto TEXT NOT NULL,"
                        + "preco_produto TEXT NOT NULL,"
                        + "FOREIGN KEY (compra_id) REFERENCES compras (id))";
                statement.execute(createTableSQL);
                statement.close();
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
